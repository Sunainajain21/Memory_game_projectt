import java.util.Random;
import java.util.Scanner;
public class Main {
    static int[][] cards = new int[4][4];
    static boolean upDown[][] = new boolean[4][4];
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the memory matching game!");
        System.out.println("Enter the card coordinate for each card when promted to.");
        System.out.println("For Example, 11 = Card 1 and 12 = Card 2.\n");
        setup();
        Game.game(upDown, cards);
    }
    public static void setup() {
        for (int i = 0; i < 4; i++) {
            for (int a = 0; a < 4; a++) {
                upDown[i][a]=false;
            }
        }
        cards = Randomizer.randomizer();
    }
}
class DisplayBoard extends Main{
    public static void displayBoard(boolean[][] upDown, int[][] cards) {

        System.out.println(" 1 2 3 4 ");
        System.out.println("---+---------");
        for (int i = 0; i < 4; i++) {
            System.out.print(" " + (i + 1) + " | ");
            for (int a = 0; a < 4; a++) {
                if (upDown[i][a]) {
                    System.out.print(cards[i][a]);
                    System.out.print(" ");
                }
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
class Game extends DisplayBoard{
    public static void game(boolean[][] upDown, int[][] cards) {
        int noDownCards = 16;
        while (noDownCards > 0) {
            displayBoard(upDown, cards);
            System.out.println("Enter co-oridinate 1");
            String g1 = s.next();
            Integer ch = Integer.valueOf(g1);
            int g1x=0, g1y=0;

            g1x = Integer.valueOf(g1.substring(0, 1)) - 1;
            g1y = Integer.valueOf(g1.substring(1, 2)) - 1;
            System.out.println(cards[g1x][g1y]);



            System.out.println("Enter co-oridinate 2");
            String g2 = s.next();
            ch = Integer.valueOf(g2);
            int g2x=0,g2y=0;

            g2x = Integer.valueOf(g2.substring(0, 1)) - 1;
            g2y = Integer.valueOf(g2.substring(1, 2)) - 1;

            System.out.println(cards[g2x][g2y]);


            if ((cards[g1x][g1y] == cards[g2x][g2y])) {
                System.out.println("Hurray...! You found a match :) ");
                upDown[g1x][g1y] = true;
                upDown[g2x][g2y] = true;
                noDownCards -= 2;

            }
            displayBoard(upDown, cards);
            System.out.println("You win");
        }
    }
}


class Randomizer extends Main{
    public static int[][] randomizer() {
        int num[] = {1, 2, 3, 4, 5, 8, 8, 8, 1, 2, 3, 4, 5, 6, 7, 8};
        int cards[][] = new int[4][4];
        Random random = new Random();
        int temp, t;
        for (int j = 0; j <= 20; j++) {
            for (int x = 0; x < 16; x++) {
                t = random.nextInt(1000) % 15;
                temp = num[x];
                num[x] = num[t];
                num[t] = temp;

            }
            t = 0;
            for (int r = 0; r < 4; r++)
            {
                for (int s = 0; s < 4; s++) {
                    cards[r][s] = num[t];
                    t = t + 1;
                }
            }

        }
        return cards;
    }
}