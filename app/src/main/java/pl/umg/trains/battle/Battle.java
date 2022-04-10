package pl.umg.trains.battle;

import android.os.CountDownTimer;

public class Battle implements BattleInterface {
    private BattleTrain playerTrain;
    private BattleTrain enemyTrain;
    private CountDownTimer timer;

    public Battle(BattleTrain playerTrain, BattleTrain enemyTrain) {
        this.playerTrain = playerTrain;
        this.enemyTrain = enemyTrain;
    }

    @Override
    public void start() {
        botAI();
    }

    private void botAI() {
        timer = new CountDownTimer(1000, 200) {
            @Override
            public void onTick(long l) {
                load(false);
            }

            @Override
            public void onFinish() {
                botAI();
            }
        }.start();

    }

    @Override
    public void load(boolean playerTurn) {
        if (playerTurn) {
            if (playerTrain.load()) {
                if (enemyTrain.getShot(playerTrain.getAttackDamage())) {
                    gameOver(true);
                }
            }
        } else {
            if (enemyTrain.load()) {
                if (playerTrain.getShot(enemyTrain.getAttackDamage())) {
                    gameOver(false);
                }
            }
        }
    }

    @Override
    public void gameOver(boolean playerWin) {
        if (playerWin) {
//            Toast.makeText(, "You win", Toast.LENGTH_LONG).show();
        } else {
//            Toast.makeText(, "You lose", Toast.LENGTH_LONG).show();
        }
        timer.cancel();
    }
}
