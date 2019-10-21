

public class Player implements Maze{
    
    //Creates a maze using the y and x values passed through. 
    //The maze must be created before the other methods can work.
    public void createMaze(int y, int x){
        super(numRows, numCols);
        
        initGrid();
        
        determineNeighbours();
        
        determineWallsPrintAll();
        
    }
    
    //Returns a list of directions you can go from the square at pos y,pos x 
    public dirType getDirections(int y,int x){
        
        return list();
    }
    
    //Returns the maze’s start point, position on the 2d backing array
    public int startPoint(){
        
        return coords();
    }
    //Return’s the maze’s end point, position on the 2d backing array
    public int endPoint(){
        
        return coords();
    }
    //Returns the position the player is currently on
    public int playerPos(){
        
        return coords;     
    }
    //Tracks where the player is going
    //If boolean is true, player will be printed in that coord
    public int setPos(int y, int x){
    for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                 if (isPrinted==true){
                    
                    //JavaFX code that prints player(black circle)
                    //three numbers are x and y coord of circle center, radius
                    Circle c1 = new Circle(100, 300, 75);
                    //makes the outline of the circle black
                    c1.setStroke(Color.BLACK);
                    //makes the fill of the circle black
                    c1.setFill(Color.BLACK);
                    //thickness of perimeter
                    c1.setStrokeWidth(3);
                    
                    return newCoords;
                }       
            }
        }
    }
    
    
}  