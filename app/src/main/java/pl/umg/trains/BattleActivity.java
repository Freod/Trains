package pl.umg.trains;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import pl.umg.trains.battle.Battle;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        ProgressBar playerHealthPoolProgressBar = findViewById(R.id.playerHealthPoolProgressBar);
        ProgressBar playerShieldProgressBar = findViewById(R.id.playerShieldProgressBar);
        ProgressBar playerLoadingProgressBar = findViewById(R.id.playerLoadingProgressBar);

        ProgressBar enemyHealthPoolProgressBar = findViewById(R.id.enemyHealthPoolProgressBar);
        ProgressBar enemyShieldProgressBar = findViewById(R.id.enemyShieldProgressBar);
        ProgressBar enemyLoadingProgressBar = findViewById(R.id.enemyLoadingProgressBar);

        BattleTrain playerTrain = new BattleTrain(PlayerStore.player.getId(), PlayerStore.player.getChosenTrain(), playerHealthPoolProgressBar, playerShieldProgressBar, playerLoadingProgressBar);
        BattleTrain enemyTrain = new BattleTrain(0, PlayerStore.player.getChosenTrain(), enemyHealthPoolProgressBar, enemyShieldProgressBar, enemyLoadingProgressBar);

        final Battle battle = new Battle(playerTrain, enemyTrain);
        battle.start();

        findViewById(R.id.shotButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                battle.load(PlayerStore.player.getId());
            }
        });
    }
}