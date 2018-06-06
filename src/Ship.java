
public abstract class Ship { //Υπερκλάση των AircraftCarrier,Destroyer και Submarine

    protected int length; //Μήκος πλοίου (Θέσεις που καταλαμβάνει)
    protected int points; //πόντοι 
    protected char letter;//αρχικό γράμμα
    int damage = 0; //ζημία που έχει υπωστεί
    protected String start; //πλώρη
    ShipDirection dir;//Κατεύθυνση του πλοίου
    Field field;//Πεδίο
    Location location;//Τοποθεσία του πλοίου

    public Ship(Field f, char c, int len, int point) { //constructor
        field = f;
        letter = c;
        length = len;
        points = point;
    }
    public int damage() { //Συνάρτηση που επιστρέφει τη ζημιά
        return damage;
    }

    public int getlength() { //Συνάρτηση που επιστρέφει το μήκος
        return length;
    }

    public int getpoints() {//Συνάρτηση που επιστρέφει τους πόντους
        return points;
    }

    public char getletter() {//Συνάρτηση που επιστρέφει το αρχικό γράμμα του πλοίου
        return letter;
    }

    public void hit() {//Συνάρτηση που μετράει πόσα φορές έχει χτυπηθεί το πλοίο
        damage = damage + 1;
    }

    public boolean isSinking() {
        return damage == points;
    }

    public String getHitMessage() { //Εμφανίζει μήνυμα αν χτυπηθεί το πλοίο
        return ("You have just hit a ship");
    }

    public abstract String getSinkMessage(); //abstract μέθοδος που επιστρέφει μήνυμα το οποίο αναφέρει ποιο πλοίο βυθίστηκε(Υλοποιείται στις υποκλάσεις)

    public abstract String threaten();

    public void setPoints(int point) {
        points = point;
    }

    public void setLocation(Location l) { 
        location = l;
    }

    public Location getLocation() { //επιστρέφει την τοποθεσία
        return location;
    }

    public void setDirection(ShipDirection d) {
        dir = d;
    }

    public ShipDirection getDirection() { //επιστρέφει την κατεύθυνση
        return dir;
    }
}