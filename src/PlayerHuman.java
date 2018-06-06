
import java.util.Scanner;

public class PlayerHuman extends Player {

    public PlayerHuman(String name) {
        super(name);
    }
    Scanner input = new Scanner(System.in);

    @Override
    public void placeShips(Field otherField) {
        String m;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to insert position of ships manually? (y/n) ");
        m = scanner.nextLine();

        if (m.equalsIgnoreCase("Y")) { //Ο παίχτης τοποθετεί τα πλοία αυτόματα
            String loc, dir; 
            System.out.print("Insert position of first aircraft cariier: ");
            loc = scanner.nextLine();//μεταβλητή που κρατάει τη θέση καθε φορά

            System.out.print("Insert direction of first aircraft carrier (H: horizontal, V: vertical ");
            dir = scanner.nextLine();//κρατάει την κατεύθυνση κάθε φορά

            AircraftCarrier a1 = new AircraftCarrier(otherField);
            a1.setLocation(otherField.getLocation(loc));
            a1.setDirection(ShipDirection.fromString(dir));
            otherField.placeShip(a1, false);

            System.out.print("Insert position of second aircraft cariier: ");
            loc = scanner.nextLine();

            System.out.print("Insert direction of second aircraft carrier (H: horizontal, V: vertical ");
            dir = scanner.nextLine();

            AircraftCarrier a2 = new AircraftCarrier(otherField);
            a2.setLocation(otherField.getLocation(loc));
            a2.setDirection(ShipDirection.fromString(dir));
            otherField.placeShip(a2, false);

            System.out.print("Insert position of the first Destroyer: ");
            loc = scanner.nextLine();

            System.out.print("Insert direction of the first Destroyer (H: horizontal, V: vertical ");
            dir = scanner.nextLine();

            Destroyer d1 = new Destroyer(otherField);
            d1.setLocation(otherField.getLocation(loc));
            d1.setDirection(ShipDirection.fromString(dir));
            otherField.placeShip(d1, false);

            System.out.print("Insert position of the second Destroyer: ");
            loc = scanner.nextLine();

            System.out.print("Insert direction of the second Destroyer (H: horizontal, V: vertical ");
            dir = scanner.nextLine();

            Destroyer d2 = new Destroyer(otherField);
            d2.setLocation(otherField.getLocation(loc));
            d2.setDirection(ShipDirection.fromString(dir));
            otherField.placeShip(d2, false);

            System.out.print("Insert position of the third Destroyer: ");
            loc = scanner.nextLine();

            System.out.print("Insert direction of the third Destroyer (H: horizontal, V: vertical ");
            dir = scanner.nextLine();

            Destroyer d3 = new Destroyer(otherField);
            d3.setLocation(otherField.getLocation(loc));
            d3.setDirection(ShipDirection.fromString(dir));
            otherField.placeShip(d3, false);

            System.out.print("Insert position of the first Submarine: ");
            loc = scanner.nextLine();

            System.out.print("Insert direction of the first Submarine (H: horizontal, V: vertical ");
            dir = scanner.nextLine();

            Submarine s1 = new Submarine(otherField);
            s1.setLocation(otherField.getLocation(loc));
            s1.setDirection(ShipDirection.fromString(dir));
            otherField.placeShip(s1, false);

            System.out.print("Insert position of the second Submarine: ");
            loc = scanner.nextLine();

            System.out.print("Insert direction of the second Submarine (H: horizontal, V: vertical ");
            dir = scanner.nextLine();

            Submarine s2 = new Submarine(otherField);
            s2.setLocation(otherField.getLocation(loc));
            s2.setDirection(ShipDirection.fromString(dir));
            otherField.placeShip(s2, false);

        } else { //Τοποθέτηση πλοίων αυτόματα
            Destroyer d1 = new Destroyer(otherField);
            Destroyer d2 = new Destroyer(otherField);
            Destroyer d3 = new Destroyer(otherField);
            AircraftCarrier a1 = new AircraftCarrier(otherField);
            AircraftCarrier a2 = new AircraftCarrier(otherField);
            Submarine s1 = new Submarine(otherField);
            Submarine s2 = new Submarine(otherField);

            otherField.placeShipRandomly(s2, 0, false);
            otherField.placeShipRandomly(s1, 0, false);
            otherField.placeShipRandomly(a2, 0, false);
            otherField.placeShipRandomly(a1, 0, false);
            otherField.placeShipRandomly(d2, 0, false);
            otherField.placeShipRandomly(d3, 0, false);
            otherField.placeShipRandomly(d1, 0, false);
        }

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getName(String name) { //επιστρέφει το όνομα του παίχτη
        return name;
    }

    @Override
    public Location selectMove() {  //Μέθοδος που ζητάει κίνηση από τον παίχτη και μαρκάρει το επιλεγμένο στοιχείο
        System.out.println("Enter your move");
        String move = input.nextLine();
        Location loc = field.getLocation(move);
        loc.mark();
        return loc;
    }
}
