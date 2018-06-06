
import java.util.Random;

public class Submarine extends Ship { //Υποκλάση της ship,Έχει συνολικά 3 πόντους και 1 θέση που αρχικοποιούνται στο super

    public Submarine(Field f) {
        super(f, 'S', 1, 3);
    }

    @Override
    public String getSinkMessage() {
        return ("This submarine has just sunk!");
    }

    @Override
    public String threaten() {
        if (damage == 0) {
            Random rnd = new Random();
            int r = rnd.nextInt((field.getRow()));
            int c = rnd.nextInt((field.getCols()));
            return ("Submarine has been moved away successfully");
        }
        return null;
    }
}
