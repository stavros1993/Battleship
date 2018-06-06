
public class PlayerComputer extends Player {

    public PlayerComputer(String name) {
        super(name);
        name="pc";
    }

    @Override
    public void placeShips(Field otherField) { //Επειδή ο παίκτης ελέγχεται από τον υπολογιστή,προφανώς πρέπει να τοποθετηθούν αυτόματα τα πλοία
        Destroyer d1=new Destroyer(otherField);
        Destroyer d2=new Destroyer(otherField);
        Destroyer d3=new Destroyer(otherField);
        AircraftCarrier a1=new AircraftCarrier(otherField);
        AircraftCarrier a2=new AircraftCarrier(otherField);
        Submarine s1=new Submarine(otherField);
        Submarine s2=new Submarine(otherField); 
        
        otherField.placeShipRandomly(s2, 0, false);
        otherField.placeShipRandomly(s1, 0, false);
        otherField.placeShipRandomly(a2, 0, false);
        otherField.placeShipRandomly(a1, 0, false);
        otherField.placeShipRandomly(d2, 0, false);
        otherField.placeShipRandomly(d3, 0, false);
        otherField.placeShipRandomly(d1, 0, false);
    }
    public void setName(String name) {
        name=name;
    }
    
    @Override
    public Location selectMove(){
       return null;
    }
}
