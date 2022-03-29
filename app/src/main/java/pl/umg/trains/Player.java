package pl.umg.trains;

import java.util.List;

public class Player {
    private int id;
    private String name;
    private List<Train> playerTrains;
    private Train chosenTrain;

    public Player(String name) {
        this.id = 1;
        this.name = name;
    }

    public Player(int id, String name, Train chosenTrain) {
        this.id = id;
        this.name = name;
        this.chosenTrain = chosenTrain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Train> getPlayerTrains() {
        return playerTrains;
    }

    public void setPlayerTrains(List<Train> playerTrains) {
        this.playerTrains = playerTrains;
    }

    public Train getChosenTrain() {
        return chosenTrain;
    }

    public void setChosenTrain(Train chosenTrain) {
        this.chosenTrain = chosenTrain;
    }
}
