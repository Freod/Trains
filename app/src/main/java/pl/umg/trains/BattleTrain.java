package pl.umg.trains;

import android.widget.ProgressBar;

import java.util.logging.Logger;

public class BattleTrain extends Train {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    ProgressBar healthPoolProgressBar;
    ProgressBar shieldProgressBar;
    ProgressBar loadingProgressBar;

    int id;
    double actualHealthPool;
    double actualShield;
    double actualLoading;

    public BattleTrain(int id, Train train, ProgressBar healthPoolProgressBar, ProgressBar shieldProgressBar, ProgressBar loadingProgressBar) {
        super(train.getMaxHealthPool(), train.getMaxShield(), train.getArmour(), train.getAttackDamage(), train.getAttackSpeed(), train.getArmourPenetration());
        this.id = id;
        this.healthPoolProgressBar = healthPoolProgressBar;
        this.shieldProgressBar = shieldProgressBar;
        this.loadingProgressBar = loadingProgressBar;
        actualHealthPool = getMaxHealthPool();
        actualShield = getMaxShield();
        actualLoading = 0;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int progress(double actual, int max) {
        return (int) Math.round((actual / max) * 100);
    }

    public void start() {
        healthPoolProgressBar.setProgress(progress(actualHealthPool, getMaxHealthPool()));
        shieldProgressBar.setProgress(progress(actualShield, getMaxShield()));
        loadingProgressBar.setProgress(0);
    }

    public boolean load(){
        boolean isShoting = false;
        actualLoading+=getAttackSpeed();
        if(actualLoading>=100){
            actualLoading-=100;
            isShoting = true;
        }
        updateLoadingProgressBar();
        return isShoting;
    }

    private void updateLoadingProgressBar(){
        loadingProgressBar.setProgress((int) actualLoading);
    }

    public double getOffence(){
        return getAttackDamage();
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
