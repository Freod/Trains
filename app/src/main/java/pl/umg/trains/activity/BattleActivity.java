package pl.umg.trains.activity;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import pl.umg.trains.battle.BattleTrain;
import pl.umg.trains.R;
import pl.umg.trains.Train;
import pl.umg.trains.battle.Battle;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        Train playerTrain = (Train) getIntent().getSerializableExtra("train");

        ProgressBar playerHealthPoolProgressBar = findViewById(R.id.playerHealthPoolProgressBar);
        ProgressBar playerShieldProgressBar = findViewById(R.id.playerShieldProgressBar);
        ProgressBar playerLoadingProgressBar = findViewById(R.id.playerLoadingProgressBar);

        ProgressBar enemyHealthPoolProgressBar = findViewById(R.id.enemyHealthPoolProgressBar);
        ProgressBar enemyShieldProgressBar = findViewById(R.id.enemyShieldProgressBar);
        ProgressBar enemyLoadingProgressBar = findViewById(R.id.enemyLoadingProgressBar);

        BattleTrain playerBattleTrain = new BattleTrain(playerTrain, playerHealthPoolProgressBar, playerShieldProgressBar, playerLoadingProgressBar);
        BattleTrain enemyBattleTrain = new BattleTrain(playerTrain, enemyHealthPoolProgressBar, enemyShieldProgressBar, enemyLoadingProgressBar);

        Battle battle = new Battle(playerBattleTrain, enemyBattleTrain);
        battle.start();

        findViewById(R.id.shotButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                battle.load(true);
            }
        });
    }
}