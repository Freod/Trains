package pl.umg.trains.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;
import pl.umg.trains.R;
import pl.umg.trains.database.PlayerEntry;
import pl.umg.trains.database.PlayerReaderDbHelper;

public class SetPlayerNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_player_name);

        if(isPlayer()){
            moveToPlayerProfile();
        }

        findViewById(R.id.setPlayerActivityButton).setOnClickListener((View view) ->{
            TextInputLayout textInputLayout = findViewById(R.id.setPlayerActivityTextInputLayout);
            if(textInputLayout.getEditText().getText().toString().matches("")) {
                Toast.makeText(this, "You didn't enter nickname", Toast.LENGTH_SHORT).show();
            }
            else {
                String nickname = textInputLayout.getEditText().getText().toString();
                savePlayerToDatabase(nickname);
                moveToPlayerProfile();
            }
        });
    }

    @Override
    protected void onResume() {
        if (isPlayer()) {
            this.finishAffinity();
        }
        super.onResume();
    }

    private void moveToPlayerProfile(){
        Intent intent = new Intent(getApplicationContext(), PlayerProfileActivity.class);
        startActivity(intent);
    }

    private boolean isPlayer(){
        PlayerReaderDbHelper dbHelper = new PlayerReaderDbHelper(getApplicationContext());
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        long entriesNum = DatabaseUtils.queryNumEntries(database, PlayerEntry.TABLE_NAME);

        if(entriesNum > 0){
            return true;
        }
        return false;
    }

    private void savePlayerToDatabase(String nickname){
        PlayerReaderDbHelper dbHelper = new PlayerReaderDbHelper(getApplicationContext());
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PlayerEntry.COLUMN_NAME_NICKNAME, nickname);
        values.put(PlayerEntry.COLUMN_NAME_MONEY, 100);

        database.insert(PlayerEntry.TABLE_NAME, null, values);
    }
}