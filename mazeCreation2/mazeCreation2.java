import java.util.Random;
import java.util.ArrayList;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;

public class mazeCreation2 implements RectMaze{

    int x; // Number of columns
    int y; // Number of rows
    //HashSet<Square> edgeSquares;
    //Not currently used: may be useful later?

    Square [][] gridArray;

    //constructor takes in from square class the square object, number of rows in maze array, number of columns in maze array, 
    //width and length of edge squares.
    public mazeCreation2(int y, int x){
        this.x = x;
        this.y = y;
        //edgeSquares = new HashSet<Square>();
        gridArray = new Square[y][x];
        initMaze();
        determineNeighbours();
        determineWallsAll();
        
        HashSet<Square> edgeSquares = findEdgeSquares();
        determineEdgeSquares(edgeSquares);
        
        
    }

    /*
    public void createMaze(int y, int x){
        
    }
    */
    public int getMaxX(){
        return x;
    }
    
    public int getMaxY(){
        return y;
    }
    //this method initializes the squareArray
    public void initMaze(){
        
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                gridArray[i][j] = new Square();
                gridArray[i][j].setY(i);
                gridArray[i][j].setX(j);
                gridArray[i][j].setHasPlayer(false);
                }
            }
        }
    
    private void determineNeighbours(){
    /* This function looks at every square in the grid and assigns its neighbours
     * by looking at squares with nearby indexes. */ 
        for(int i=0; i<y; i++){
            for(int j=0; j<x ; j++){
                
                Square current = gridArray[i][j];
                
                if (i-1 >= 0){
                    current.setUpSquare(gridArray[i-1][j]);
                } 
                
                if (i+1 < y){
                    current.setDownSquare(gridArray[i+1][j]);
                } 
                
                if (j-1 >= 0){
                    current.setLeftSquare(this.gridArray[i][j-1]);
                } 
                
                if (j+1 < x){
                    current.setRightSquare(this.gridArray[i][j+1]);
                } 

            }
    }
}

private void determineWallsAll(){
    /*This function creates and determines walls
       It works by looping through each row, then each square in the row
       It assigns walls to the squares in the row
       If squares share walls, then it assigns a reference to that wall object to the square
       So, a square's left wall will be the previous square's right wall
       It also makes sure you always draw walls that are on the border
       */
    for(int i=0; i<y; i++){
            for(int j=0; j<x ; j++){
                Square s = gridArray[i][j];
                boolean leftSquareB = false;
                boolean upSquareB = false;
                Square leftSquare = new Square();
                Square upSquare = new Square();
                
                if (j-1 >= 0){
                    leftSquare = gridArray[i][j-1];
                    leftSquareB = true;
                }
                
                if (i-1 >= 0){
                    upSquare = gridArray[i-1][j];
                    upSquareB = true;
                }
                //The first square is the only square that needs 4 unique walls
                if (j == 0 && i == 0){
                    s.setUpWall(new Wall("Horizontal"));
                    s.setDownWall(new Wall("Horizontal"));
                    s.setLeftWall(new Wall("Vertical"));
                    s.setRightWall(new Wall("Vertical"));
                }
                
                if (leftSquareB && upSquareB){
                    s.setUpWall(upSquare.getDownWall());
                    s.setLeftWall(leftSquare.getRightWall());
                    s.setDownWall(new Wall("Horizontal"));
                    s.setRightWall(new Wall("Vertical"));
                }
                
                if (leftSquareB && !upSquareB){
                    s.setLeftWall(leftSquare.getRightWall());
                    s.setUpWall(new Wall("Horizontal"));
                    s.setDownWall(new Wall("Horizontal"));
                    s.setRightWall(new Wall("Vertical"));
                }
                
                if (!leftSquareB && upSquareB){
                    s.setUpWall(upSquare.getDownWall());
                    s.setDownWall(new Wall("Horizontal"));
                    s.setLeftWall(new Wall("Vertical"));
                    s.setRightWall(new Wall("Vertical"));  
                }
                
                //Only set drawWall for up wall if upSquare doesn't exist
                if (!upSquareB){  
                    s.getUpWall().setDrawWall(true);  
                }
                
                s.getDownWall().setDrawWall(true);
                
                //Only set drawWall for left wall if left square doesn't exist
                if (!leftSquareB){
                     s.getLeftWall().setDrawWall(true);
               }
                
               //Always set drawWall for right wall
                s.getRightWall().setDrawWall(true);
            }
    }
}

private void determineWallsRandom(){
    /*This function creates and determines walls
       It works by looping through each row, then each square in the row
       It assigns walls to the squares in the row
       If squares share walls, then it assigns a reference to that wall object to the square
       So, a square's left wall will be the previous square's right wall
       It also makes sure you always draw walls that are on the border
       */
    for(int i=0; i<y; i++){
            for(int j=0; j<x ; j++){
                Square s = gridArray[i][j];
                boolean leftSquareB = false;
                boolean upSquareB = false;
                Square leftSquare = new Square();
                Square upSquare = new Square();
                
                if (j-1 >= 0){
                    leftSquare = gridArray[i][j-1];
                    leftSquareB = true;
                }
                
                if (i-1 >= 0){
                    upSquare = gridArray[i-1][j];
                    upSquareB = true;
                }
                //The first square is the only square that needs 4 unique walls
                if (j == 0 && i == 0){
                    s.setUpWall(new Wall("Horizontal"));
                    s.setDownWall(new Wall("Horizontal"));
                    s.setLeftWall(new Wall("Vertical"));
                    s.setRightWall(new Wall("Vertical"));
                }
                
                if (leftSquareB && upSquareB){
                    s.setUpWall(upSquare.getDownWall());
                    s.setLeftWall(leftSquare.getRightWall());
                    s.setDownWall(new Wall("Horizontal"));
                    s.setRightWall(new Wall("Vertical"));
                }
                
                if (leftSquareB && !upSquareB){
                    s.setLeftWall(leftSquare.getRightWall());
                    s.setUpWall(new Wall("Horizontal"));
                    s.setDownWall(new Wall("Horizontal"));
                    s.setRightWall(new Wall("Vertical"));
                }
                
                if (!leftSquareB && upSquareB){
                    s.setUpWall(upSquare.getDownWall());
                    s.setDownWall(new Wall("Horizontal"));
                    s.setLeftWall(new Wall("Vertical"));
                    s.setRightWall(new Wall("Vertical"));  
                }
                
                //Only set drawWall for up wall if upSquare doesn't exist
                if (!upSquareB){
                    if (i == 0){
                        s.getUpWall().setDrawWall(true);
                    } else {
                        setRandomDrawWall(s.getUpWall());
                    }
                }
                
                //Always set drawWall for down wall
                if (i == y-1){
                    s.getDownWall().setDrawWall(true);
                } else {
                    setRandomDrawWall(s.getDownWall());
                }
                
                //Only set drawWall for left wall if left square doesn't exist
                if (!leftSquareB){
                    if (j == 0) {
                        s.getLeftWall().setDrawWall(true);
                    } else {
                        setRandomDrawWall(s.getLeftWall());
                    }
               }
                
               //Always set drawWall for right wall
                if (j == x-1){
                    s.getRightWall().setDrawWall(true);
                } else {
                    setRandomDrawWall(s.getRightWall());
                }
            }
    }
}

private void setRandomDrawWall(Wall w){
Random rand = new Random();
int randomNum = rand.nextInt(2);
if (randomNum == 1){
    w.setDrawWall(true);
} else {
    w.setDrawWall(false);
       }
}

private void determineEdgeSquares(HashSet<Square> edgeSquares){
    for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                Square thisSquare = gridArray[i][j];
                Wall[] thisSquareWalls = thisSquare.getWalls();
                
                if(!edgeSquares.contains(thisSquare)){
                    for (Wall w: thisSquareWalls){
                        w.setDrawWall(false);
                    }
                }
    }
}
}

private HashSet<Square> findEdgeSquares() {
        // x is number of rows and y is number of columns. 
        // x-1 and y-1 should correspond with the indexes for the grid, since indexes start at 0
        // i.e., there may be three columns, but squares in the last column are accessed as Square[2][i]
        HashSet<Square> edgeSquares = new HashSet<Square>();
        
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                Square thisSquare = gridArray[i][j];
                int squareX = thisSquare.getX();
                int squareY = thisSquare.getY();
                if ((squareX == 0) || (squareY == 0) || (squareX == x-1) || (squareY == y-1)){
                    edgeSquares.add(thisSquare);
                }
            }
    }
    return edgeSquares;
}
private ArrayList<Square> endAndStartSquares(HashSet<Square> edgeSquares){
    ArrayList endAndStartSquares = new ArrayList();
    
    Iterator<Square> iterateEdgeSquares = edgeSquares.iterator();
    
    Square startSquare = iterateEdgeSquares.next();
    Square endSquare = iterateEdgeSquares.next();
    
    endAndStartSquares.add(startSquare);
    endAndStartSquares.add(endSquare);
    
    return endAndStartSquares;
    
}
    
public ArrayList<DirType> getDirections(int x, int y){
        ArrayList<DirType> directions = new ArrayList<DirType>();    
        Square current = gridArray[y][x];
        
        if (current.getUpWall().drawWall() == false){
            directions.add(DirType.North);
        }
        
        if (current.getDownWall().drawWall() == false){
            directions.add(DirType.South);
        }
        
        if (current.getLeftWall().drawWall() == false){
            directions.add(DirType.West);
        }
        
        if (current.getRightWall().drawWall() == false){
            directions.add(DirType.East);
        }
        
        return directions;
    }
   
}