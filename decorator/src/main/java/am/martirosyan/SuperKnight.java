package am.martirosyan;

public class SuperKnight extends Knight {
    private final Knight knight;

    public SuperKnight(Knight knight) {
        this.knight = knight;
    }

    public void attack() {
        knight.attack();
    }

    public void superAttack() {
        knight.points += 2;
    }

    public int getPoints() {
        return knight.points;
    }
}
