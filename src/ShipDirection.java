import java.util.InputMismatchException;

public enum ShipDirection {

    HORIZONTAL, VERTICAL;

    public static ShipDirection fromString(String dirString) { //Συνάρτηση που χρησιμοποιείται για την επιλογή της κατεύθυνσης των πλοίων από τον χρήστη
        ShipDirection dir=VERTICAL; //αρχικοποίηση
        if ("H".equals(dirString)) { 
            dir = HORIZONTAL;
        } else if ("V".equals(dirString)) {
            dir = VERTICAL;
        } else {
            try {
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException");
            }
        }
        return dir;
    }
}