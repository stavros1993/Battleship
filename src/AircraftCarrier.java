
public class AircraftCarrier extends Ship { //Υποκλάση της ship,Έχει συνολικά 5 πόντους και 5 θέσεις που αρχικοποιούνται στο super

    public AircraftCarrier( Field f) {
        super(f, 'A', 5, 5);
    }
    @Override
    public String getSinkMessage() {
        return ("This aircraft carrier has just sunk!");
    }

    @Override
    public String threaten() {
        return("Aircraft carriers don't move away when they're threatened");
    }
    
}
