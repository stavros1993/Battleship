
import java.util.Random;

public class Field {

    private int rows, cols;
    private Player player;
    private Location table[][]; //Ταμπλό

    public Field(int row, int col, Player p) {
        rows = row;
        player = p;
        cols = col;
        table = new Location[rows][cols];

        for (int i = 0; i < rows; i++) { //Δημιουργία πίνακα από location
            for (int j = 0; j < cols; j++) {
                table[i][j] = new Location(i, j);
            }
        }

    }
    public int getRow() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    public Location getLocation(int r, int c) { //επιστρέφει το περιεχόμενο μιας θέσης του πίνακα
        return table[r][c];
    }

    public Location getLocation(String locString) { //επιστρέφει το περιεχόμενο μιας θέσης του πίνακα που είναι στην μορφή με την οποία δίνεται η εντολή
        char r1 = locString.charAt(0); //Χαρακτήρας που ,μέσω αυτής της μεθόδου παίρνει τον χαρακτήρα(γραμμή) που υπάρχει στην πρώτη θέση του String
        int r = Character.getNumericValue(r1) - 10; //Ακέραιος 
        char c2 = ' ';


        char c1 = locString.charAt(1);//Παίρνει το πρώτο από τους μέχρι 2 αριθμούς της γραμμής
        if (locString.length() == 3) { //Ελεγχος σχετικά με το συνολικό μέγεθος της εντολής(το μήκος του είναι είτε 2 ή 3)
            c2 = locString.charAt(2);
        }
        char c[] = new char[2];
        c[0] = c1;
        c[1] = c2;
        String c3 = String.valueOf(c).trim();
        int C = Integer.parseInt(c3);
        System.out.println("getLocation in Field class. Result: " + C);
        return table[r][C];
    }

    boolean placeShipRandomly(Ship s, int maxTries, boolean checkMarked) {
        ShipDirection dirrnd = null;
        int l = s.getlength();
        int r = 0, c = 0;
        //checkMarked = false;
        Random rnd = new Random();
        int direction;
        boolean result = false;

        for (int i = maxTries; i < 1; i--) {
            direction = rnd.nextInt(1);
            if (direction == 0) {
                dirrnd = dirrnd.fromString("H");
                r = rnd.nextInt(rows);
                c = rnd.nextInt(cols - l);
            } else {
                dirrnd = dirrnd.fromString("V");
                r = rnd.nextInt(rows - l);
                c = rnd.nextInt(cols);
            }
            int freePos = 0;
            for (int j = 0; j < l; j++) {
                switch (dirrnd) {
                    case VERTICAL:
                        if (table[r + j][c].isEmpty() == true && table[r + j][c].isMarked() == false) {
                            freePos++;
                        }
                        break;
                    case HORIZONTAL:
                        if (table[r][c + j].isEmpty() == true && table[r][c + j].isMarked() == false) {
                            freePos++;
                        }
                        break;
                }
            }

            if (freePos == l) {
                result = true;
                s.setLocation(table[r][c]);
                s.setDirection(dirrnd);
                for (int j = 0; j < l; j++) {
                    switch (dirrnd) {
                        case VERTICAL:
                            table[r + j][c].setShip(s);
                            break;
                        case HORIZONTAL:
                            table[r][c + j].setShip(s);
                            break;
                    }
                }
                break;
            }

        }
        return result;
    }

    boolean placeShip(Ship s, boolean checkMarked) {
        int r = s.getLocation().getRow(), c = s.getLocation().getColumn(), l = s.getlength();
        ShipDirection dir = s.getDirection();

        int freePos = 0;
        for (int j = 0; j < l; j++) {
            switch (dir) {
                case VERTICAL:
                    if (table[r + j][c].isEmpty() == true && table[r + j][c].isMarked() == false) {
                        freePos++;
                    }
                    break;
                case HORIZONTAL:
                    if (table[r][c + j].isEmpty() == true && table[r][c + j].isMarked() == false) {
                        freePos++;
                    }
                    break;
            }
        }

        if (freePos != l) {
            return false;
        }
        // topothetisi ploiou sto pedio
        for (int j = 0; j < l; j++) {
            switch (dir) {
                case VERTICAL:
                    table[r + j][c].setShip(s);
                    break;
                case HORIZONTAL:
                    table[r][c + j].setShip(s);
                    break;
            }
        }

        return true;
    }

    void removeShip(Ship s) {
        int r = s.getLocation().getRow(), c = s.getLocation().getColumn(), l = s.getlength();
        ShipDirection dir = s.getDirection();

        for (int j = 0; j < l; j++) {
            switch (dir) {
                case VERTICAL:
                    table[r + j][c].removeShip();
                    break;
                case HORIZONTAL:
                    table[r][c + j].removeShip();
                    break;
            }
        }
    }

    public void processValidMove(Location moveLoc) {
        if (moveLoc.isEmpty()) {
            moveLoc.mark();
            System.out.println("There is no ship at the given position.");
        } else {
            moveLoc.mark();
            System.out.println("Player " + player.getName() + " has hit a target!");
            if (moveLoc.getShip().isSinking()) {
                System.out.println(moveLoc.getShip().getSinkMessage());
            }
        }
    }

    @Override
    public String toString() {
        String s = "   ", s1 = s;
        char l = 'A';

        for (int i = 1; i <= cols; i++) {
            s += " " + i + " ";
            s1 += "---";
        }

        s += "\n" + s1 + "\n";

        for (int i = 0; i < rows; i++) {
            s += l++ + "| ";
            for (int j = 0; j < cols; j++) {
                if (table[i][j].isEmpty() && table[i][j].isMarked()) {
                    s += " o ";
                } else if (table[i][j].isEmpty() && table[i][j].isMarked() == false) {
                    s += " . ";
                } else if (table[i][j].isEmpty() == false && table[i][j].getShip().isSinking()) {
                    s += " x" + table[i][j].getShip().getletter();
                } else {
                    s += " x ";
                }
            }
            s += "\n";
        }

        System.out.println(s);

        return s;
    }

    public void toStringWithShips() {
        String s = "   ", s1 = s;
        char l = 'A';

        for (int i = 1; i < cols + 1; i++) {
            s += " " + i + " ";
            s1 += "---";
        }

        s += "\n" + s1 + "\n";

        for (int i = 0; i < rows; i++) {
            s += l++ + "| ";
            for (int j = 0; j < cols; j++) {
                if (table[i][j].isEmpty() && table[i][j].isMarked()) {
                    s += " o ";
                } else if (table[i][j].isEmpty() && table[i][j].isMarked() == false) {
                    s += " . ";
                } else if (table[i][j].isEmpty() == false && table[i][j].getShip().isSinking()) {
                    s += " x" + table[i][j].getShip().getletter();
                } else {
                    s += " " + table[i][j].getShip().getletter() + " ";
                }
            }
            s += "\n";
        }
        System.out.println(s);
    }
}
