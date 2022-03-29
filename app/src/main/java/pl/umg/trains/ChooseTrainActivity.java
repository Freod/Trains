package pl.umg.trains;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.logging.Logger;

public class ChooseTrainActivity extends AppCompatActivity {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_train);

//        Train train = new Train(100, 50, 20, 10, 0.6, 0);
//        logger.info(train.toString());
//        PlayerStore.player.setChosenTrain(train);

        startActivity(new Intent(getApplicationContext(), BattleActivity.class));
    }
}