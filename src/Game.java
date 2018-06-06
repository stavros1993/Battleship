
import java.util.Random;
import java.util.Scanner;

public class Game {

    Random rnd = new Random();
    Scanner input = new Scanner(System.in);
    Player p1, p2;
    Field f1, f2;

    public int init() {
        System.out.append("Enter your name: ");
        String n1 = input.next();
        p1 = new PlayerHuman(n1);

        int r, c;
        int r2, c2;
        do {
            System.out.println("Enter the number of the rows: ");
            r = input.nextInt();
        } while ((r > 15) || (r < 10));
        do {
            System.out.println("Enter the number of the columns: ");
            c = input.nextInt();
        } while ((c > 15) || (c < 10));
        f1 = p1.initField(r, c);
        System.out.println("Is player 2 a person? If yes,enter 1,otherwise (cpu), press any other number: ");
        int ch1 = input.nextInt();
        if (ch1 == 1) {
            System.out.println("Enter the name of the second player: ");
            String n2 = input.next();
            p2 = new PlayerHuman(n2);

            do {
                System.out.println("Enter the number of the rows: ");
                r2 = input.nextInt();
            } while ((r2 > 15) || (r2 < 10));
            do {
                System.out.println("Enter the number of the columns: ");
                c2 = input.nextInt();

            } while ((c2 > 15) || (c2 < 10));
            f2 = p2.initField(r2, c2);
        } else {
            p2 = new PlayerHuman("Computer");
            r2 = rnd.nextInt(6) + 10;
            c2 = rnd.nextInt(6) + 10;
            f2 = p2.initField(r2, c2);

        }
        System.out.print("Would you like to play the game until the end? If yes,enter 1,otherwise press any other number: ");
        int turns;
        int end = input.nextInt();
        if (end != 1) {
            System.out.print("Enter the number of turns required to complete the game");
            turns = input.nextInt();
        } else {
            turns = 1000000000;
        }
        return turns;
    }

    public void placeShips() {
        p1.placeShips(f2);
        f2.toStringWithShips();
        p2.placeShips(f1);
        f1.toStringWithShips();



        Location loc;
        System.out.println("Player 1 enter your move");

    }

    public void play() {
        Location loc;
    

        while (true) {
            f2.toString();
            loc = p1.selectMove();
            f2.processValidMove(loc);
            p1.hasWon();
            System.out.println("Player 2 enter your move2");
            f1.toString();
            loc = p2.selectMove();
            f2.processValidMove(loc);
            p2.hasWon();
        }
    }
}