package pl.umg.trains.battle;

import android.widget.ProgressBar;
import pl.umg.trains.Train;

import java.util.logging.Logger;

public class BattleTrain extends Train {
    private ProgressBar healthPoolProgressBar;
    private ProgressBar shieldProgressBar;
    private ProgressBar loadingProgressBar;

    private double actualHealthPool;
    private double actualShield;
    private double actualLoading;

    public BattleTrain(Train train, ProgressBar healthPoolProgressBar, ProgressBar shieldProgressBar, ProgressBar loadingProgressBar) {
        super(train.getMaxHealthPool(), train.getMaxShield(), train.getArmour(), train.getAttackDamage(), train.getAttackSpeed(), train.getArmourPenetration());
        this.healthPoolProgressBar = healthPoolProgressBar;
        this.shieldProgressBar = shieldProgressBar;
        this.loadingProgressBar = loadingProgressBar;
        actualHealthPool = this.getMaxHealthPool();
        actualShield = this.getMaxShield();
        actualLoading = 0;
        healthPoolProgressBar.setProgress(progress(actualHealthPool, this.getMaxHealthPool()));
        shieldProgressBar.setProgress(progress(actualShield, this.getMaxShield()));
        loadingProgressBar.setProgress(0);
    }

    public double getActualHealthPool() {
        return actualHealthPool;
    }

    public void setActualHealthPool(double actualHealthPool) {
        this.actualHealthPool = actualHealthPool;
    }

    public double getActualShield() {
        return actualShield;
    }

    public void setActualShield(double actualShield) {
        this.actualShield = actualShield;
    }

    private int progress(double actual, int max) {
        return (int) Math.round((actual / max) * 100);
    }

    public boolean load(){
        boolean shot = false;
        actualLoading+=getAttackSpeed();
        if(actualLoading>=100){
            actualLoading-=100;
            shot = true;
        }
        updateLoadingProgressBar();
        return shot;
    }

    private void updateLoadingProgressBar(){
        loadingProgressBar.setProgress((int) actualLoading);
    }

    public boolean getShot(double damage){
        boolean lose = false;
        if(actualShield>0){
            if(actualShield>damage){
                actualShield-=damage;
            }
            else {
                damage-=actualShield;
                actualShield = 0;
                actualHealthPool-=damage;
            }
            updateShieldProgressBar();
        }
        else {
            actualHealthPool-=damage;
        }
        if(actualHealthPool <= 0){
            lose = true;
        }
        updateHealthPoolProgressBar();
        return lose;
    }

    private void updateHealthPoolProgressBar() {
        healthPoolProgressBar.setProgress(progress(actualHealthPool, getMaxHealthPool()));
    }

    private void updateShieldProgressBar(){
        shieldProgressBar.setProgress(progress(actualShield, getMaxShield()));
    }
}
