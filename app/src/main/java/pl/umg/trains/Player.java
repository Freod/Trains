package pl.umg.trains;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {
    private long id;
    private String nickname;
    private int money;
    private List<Train> playerTrains;

    public Player() {
    }

    public Player(Long id, String name) {
        this.id = id;
        this.nickname = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Train> getPlayerTrains() {
        return playerTrains;
    }

    public void setPlayerTrains(List<Train> playerTrains) {
        this.playerTrains = playerTrains;
    }
}
