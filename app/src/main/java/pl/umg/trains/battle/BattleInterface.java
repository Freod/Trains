package pl.umg.trains.battle;

public interface BattleInterface {
    void start();

    void load(int id);

    void end(boolean whoWin);
}
