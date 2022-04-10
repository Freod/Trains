package pl.umg.trains.battle;

import android.widget.ProgressBar;

public interface BattleTrainInteface {
    void addProgressBarsToBattle(ProgressBar healthPoolProgressBar, ProgressBar shieldProgressBar, ProgressBar loadingProgressBar);

    void load();


}
