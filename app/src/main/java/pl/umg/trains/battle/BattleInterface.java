package pl.umg.trains.battle;

public interface BattleInterface {
    void start();

    void load(boolean playerTurn);

    void gameOver(boolean playerWin);
}
