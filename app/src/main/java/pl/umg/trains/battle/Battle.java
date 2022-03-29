package pl.umg.trains.battle;

import pl.umg.trains.BattleTrain;

import java.util.logging.Logger;

public class Battle implements BattleInterface {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private BattleTrain playerTrain;
    private BattleTrain enemyTrain;

    public Battle(BattleTrain playerTrain, BattleTrain enemyTrain) {
        this.playerTrain = playerTrain;
        this.enemyTrain = enemyTrain;
    }

    @Override
    public void start() {
        playerTrain.start();
        enemyTrain.start();
        logger.info("start");
    }

    @Override
    public void load(int id) {
        if(id == playerTrain.getId()){
            if(playerTrain.load()){
                if(enemyTrain.getShot(playerTrain.getOffence()))
                    end(true);
            }
        }
        else {
            if(enemyTrain.load()){
                if(playerTrain.getShot(enemyTrain.getOffence()))
                    end(false);
            }
        }
    }


    @Override
    public void end(boolean whoWin) {
        if(whoWin){
            logger.info("player WIN");
        }
        else {
            logger.info("BOT WIN");
        }
    }
}
