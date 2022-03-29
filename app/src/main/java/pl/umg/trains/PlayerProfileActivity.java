package pl.umg.trains;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PlayerProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);

        Player player = new Player("Radek");
        player.setChosenTrain(new Train(100, 50, 20, 10, 8, 0));
        PlayerStore.player = player;

        findViewById(R.id.battleButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BattleActivity.class));
            }
        });
    }
}