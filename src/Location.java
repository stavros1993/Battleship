public class Location {
    private int row,col;
    private boolean marked;
    private Ship ship;
    
    public Location(int r ,int c) {
        row=r;
        col=c;
        marked=false;
        ship = null;
    }
    public void mark() {
        marked=true;
        if (ship != null) ship.hit();
    }
    public boolean isMarked() {
        return marked;
    }
   
    
    public boolean isEmpty() {
        return ship == null;
    }
    public boolean isHit() {
        return ship!=null && marked==true;
    }
 
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return col;
    }
    public void setShip(Ship s){ ship = s;}
    public void removeShip(){ship=null;}
    
    public Ship getShip(){
        return ship;
    }
    
}
    
    
    
    
    
