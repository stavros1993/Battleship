
import java.util.Scanner;

public abstract class Player {

    protected String name;
    protected int score;
    protected Field field;

    
    public Player(String name) {
        name = name;
    }
    public abstract void placeShips(Field otherField);
    public abstract Location selectMove();
    
    
    public Field initField(int r, int c) {
        field = new Field(r, c, this);
        return field;
    }
    public void hasWon() {
        
    }
    public String getName() {
        return name;
    }
}
