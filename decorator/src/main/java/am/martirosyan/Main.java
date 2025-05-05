package am.martirosyan;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight();
        knight.attack();
        knight.attack();
        knight.attack();
        System.out.println(knight.getPoints());

        SuperKnight superKnight = new SuperKnight(knight);
        System.out.println(superKnight.getPoints());
        superKnight.attack();
        System.out.println(superKnight.getPoints());
        superKnight.superAttack();
        System.out.println(superKnight.getPoints());

    }
}