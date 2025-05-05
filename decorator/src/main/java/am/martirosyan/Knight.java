package am.martirosyan;

public class Knight {
    int points;

    public Knight() {
        points = 0;
    }

    public void attack() {
        points++;
    }

    public int getPoints() {
        return points;
    }
}
