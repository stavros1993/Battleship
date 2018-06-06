
import java.util.Random;

public class Destroyer extends Ship { ////Υποκλάση της ship,Έχει συνολικά 2 πόντους και 3 θέσεις που αρχικοποιούνται στο super

    public Destroyer(Field f) {
        super(f, 'D', 3, 2);
    }

    @Override
    public String getSinkMessage() {
        return ("This destroyer has just sunk!");
    }

    @Override
    public String threaten() {
        return "";
    }
}
