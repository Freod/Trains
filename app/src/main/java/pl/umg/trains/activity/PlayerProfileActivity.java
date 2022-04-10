package pl.umg.trains.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import pl.umg.trains.Player;
import pl.umg.trains.R;
import pl.umg.trains.database.PlayerEntry;
import pl.umg.trains.database.PlayerReaderDbHelper;

public class PlayerProfileActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityResultLauncher;
    String filename = "userProfilePhoto.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);

        Player player = readFromDataBase();
        TextView nameField = findViewById(R.id.playerProfileNicknameTextView);
        nameField.setText(player.getNickname());
        TextView moneyField = findViewById(R.id.playerProfileMoneyTextView);
        moneyField.setText(String.valueOf(player.getMoney()));

        Toast.makeText(this, "Welcome " + player.getNickname(), Toast.LENGTH_SHORT).show();

        ImageView playerProfileImageView = findViewById(R.id.playerProfileImageView);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent resultData = result.getData();
                            if (resultData != null) {
                                Bitmap bitmap = (Bitmap) resultData.getExtras().get("data");

                                playerProfileImageView.setImageBitmap(bitmap);
                            }
                        }
                    }
                });

        findViewById(R.id.battleButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChooseTrainActivity.class));
            }
        });

        findViewById(R.id.shopButton).setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ShopActivity.class));
        });


    }

    public Player readFromDataBase() {
        PlayerReaderDbHelper dbHelper = new PlayerReaderDbHelper(getApplicationContext());
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                PlayerEntry.COLUMN_NAME_NICKNAME,
                PlayerEntry.COLUMN_NAME_MONEY
        };

        Cursor cursor = database.query(
                PlayerEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        Player player = new Player();

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(PlayerEntry._ID));
            String nickname = cursor.getString(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_NAME_NICKNAME));
            int money = cursor.getInt(cursor.getColumnIndexOrThrow(PlayerEntry.COLUMN_NAME_MONEY));
            player = new Player(id, nickname);
            player.setMoney(money);
        }
        cursor.close();

        return player;
    }

    public void changeProfilePhoto(View view) {
        if (ContextCompat.checkSelfPermission(PlayerProfileActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PlayerProfileActivity.this, new String[]{Manifest.permission.CAMERA}, 100);
        }
        else {
            activityResultLauncher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
        }
    }
}