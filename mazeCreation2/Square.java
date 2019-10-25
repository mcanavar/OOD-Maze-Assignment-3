import java.util.*;

public class Square
{
    boolean isVisited;
    boolean isPath;
    boolean hasPlayer;
    int xPos;
    int yPos;
    Square[] neighbours;
    /* Pos 0 is up, 1 is down, 2 is left, 3 is right */
    Wall[] walls;
    /* Pos 0 is up, 1 is down, 2 is left, 3 is right */
    
    public Square()
    {
        this.isVisited = false;
        this.isPath = false;
        this.xPos = -1;
        this.yPos = -1;
        this.neighbours = new Square[4];
        this.walls = new Wall[4];

    }
    
    public boolean isVisited(){
        return isVisited;
    }
    
    public void setIsVisited(boolean b){
        this.isVisited = b;
    }
    
    public boolean isPath(){
        return isPath;
    }
    
    public void setIsPath(boolean b){
        this.isPath = b;
    }
    
    public boolean hasPlayer(){
        return hasPlayer;
    }
    
    public void setHasPlayer(boolean b){
        this.hasPlayer = b;
    }
    
    public void setX(int x) {
        this.xPos = x;   
    }
    
    public void setY(int y) {
        this.yPos = y;   
    }
    
    public int getX() {
        return xPos;   
    }
    
    public int getY() {
        return yPos;   
    }
    
    public void setUpSquare(Square s){
        neighbours[0] = s;
    }
    
    public void setDownSquare(Square s){
        neighbours[1] = s;
    }
    
    public void setLeftSquare(Square s){
        neighbours[2] = s;
    }
    
    public void setRightSquare(Square s){
        neighbours[3] = s;
    }
    
    public void setNeighbourSquareIndex(int i, Square s){
        neighbours[i] = s;
    }
    
    public Square getNeighbourSquareIndex(int i){
        return neighbours[i];
    }
    
    public Wall[] getWalls(){
        return walls;
    }
    
    public Square getUpSquare(){
        return neighbours[0];
    }
    
    public Square getDownSquare(){
        return neighbours[1];
    }
    
    public Square getLeftSquare(){
        return neighbours[2];
    }
    
    public Square getRightSquare(){
        return neighbours[3];
    }
    
    public void setUpWall(Wall w){
        walls[0] = w;
    }
    
    public void setDownWall(Wall w){
        walls[1] = w;
    }
    
    public void setLeftWall(Wall w){
        walls[2] = w;
    }
    
    public void setRightWall(Wall w){
        walls[3] = w;
    }
    
    public Wall getUpWall(){
        return walls[0];
    }
    
    public Wall getDownWall(){
        return walls[1];
    }
    
    public Wall getLeftWall(){
        return walls[2];
    }
    
    public Wall getRightWall(){
        return walls[3];
    }
    
    public void setWallIndex(int i, Wall w){
        walls[i] = w;
    }
    
    public Square[] getNeighbours(){
       return neighbours;
    }
        
    public Wall getWallIndex(int i){
        return walls[i];
    }
    
    public void printWallInfo(){
        //Used for debugging to see how the walls are behaving
        System.out.println("This is square [" + this.getY() + "][" + this.getX() + "]");
        System.out.println("Up wall: " + this.getUpWall() + " drawWall " +this.getUpWall().drawWall() );
        System.out.println("Down wall: " + this.getDownWall() + " drawWall " +this.getDownWall().drawWall());
        System.out.println("Left wall: " + this.getLeftWall() +  " drawWall " +this.getLeftWall().drawWall());
        System.out.println("Right Wall: " + this.getRightWall()  + " drawWall " +this.getRightWall().drawWall() );
    }
}
