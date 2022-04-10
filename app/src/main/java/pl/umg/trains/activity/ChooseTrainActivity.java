package pl.umg.trains.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import pl.umg.trains.R;
import pl.umg.trains.Train;

import java.util.logging.Logger;

public class ChooseTrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_train);

        Train train = new Train(100, 50, 20, 20, 10, 0);
        Intent intent = new Intent(getApplicationContext(), BattleActivity.class);
        intent.putExtra("train",  train);
        startActivity(intent);
    }
}