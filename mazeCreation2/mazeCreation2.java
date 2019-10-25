import java.util.Random;
import java.util.ArrayList;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class mazeCreation2 implements RectMaze{

    int x; // Number of columns
    int y; // Number of rows

    Square [][] gridArray;
    Square startSquare;
    Square endSquare;
    Square playerSquare;
    ArrayList<Square> path;

    //constructor takes in from square class the square object, number of rows in maze array, number of columns in maze array, 
    //width and length of edge squares.
    public mazeCreation2(int y, int x){
        this.x = x;
        this.y = y;
        gridArray = new Square[y][x];
        initMaze();
        determineNeighbours();
        createWalls();
        
        HashSet<Square> edgeSquares = findEdgeSquares();
        ArrayList<Square> importantSquares = endAndStartSquares(edgeSquares);
        startSquare = importantSquares.get(0);
        endSquare = importantSquares.get(1);
        
        System.out.println("Start square: " + startSquare.getY() + ", " + startSquare.getX());
        System.out.println("End square: " + endSquare.getY() + ", " + endSquare.getX());
        
        playerSquare = null;
        
        path = getPath(startSquare, endSquare);
        
        System.out.println("Path");
        for (Square s: path){
            System.out.println(s.getY() + ", " + s.getX());
        }
        
        determineIsPath();
        determineDrawWalls();
        
    }
    
    void setPos(int y, int x){
        Square formerPlayerSquare = playerSquare;
        formerPlayerSquare.setHasPlayer(false);
        playerSquare = gridArray[y][x];
        playerSquare.setHasPlayer(true);
    }
    
    public Integer[] startPoint(){
        Integer[] startPoint = new Integer[2];
        startPoint[0] = startSquare.getY();
        startPoint[1] = startSquare.getX();
        return startPoint;
    }
    
    public Integer[] endPoint(){
        Integer[] endPoint = new Integer[2];
        endPoint[0] = endSquare.getY();
        endPoint[1] = endSquare.getX();
        return endPoint;
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


    private void createWalls(){
        /*This function creates and determines walls
           It works by looping through each row, then each square in the row
           It assigns walls to the squares in the row
           If squares share walls, then it assigns a reference to that wall object to the square
           So, a square's left wall will be the previous square's right wall
           It also marks walls on the border so you draw them later
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
                    
                    if (i == 0){
                        s.getUpWall().setIsEdge(true);
                    }
                    
                    
                    if (i == y-1){
                        s.getDownWall().setIsEdge(true);
                    } 
                    
                    if (j == 0) {
                            s.getLeftWall().setIsEdge(true);
                        }

                    if (!leftSquareB){
                        
                    }
                    
                    if (j == x-1){
                        s.getRightWall().setIsEdge(true);
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
   
    private ArrayList<Square> getPath(Square start, Square end){
        ArrayList<Square> path = new ArrayList();
        Stack<Square> stack = new Stack<Square>();
        stack.add(start);
        
        while (!stack.isEmpty()){
            Square current = stack.pop() ;
            if (!current.isVisited()){
                current.setIsVisited(true);
                path.add(current);
                //Break out of dfs if the square you visit is the end
                if (current == end){
                    break;
                }
            }
            
            Square[] neighbours = current.getNeighbours();
            for (int i=0; i<4; i++){
                Square n = neighbours[i];
                if (n!=null && !n.isVisited()){
                    stack.add(n);
                }
            }
        }
        
        return path;
    }
    
    private void determineIsPath(){
        
        for (int i = 0; i < path.size(); i++){   
            Square current = path.get(i);
            
            // Make one of the edges for the start and end square isPath so it doesn't get drawn later
            if (i == 0){
                System.out.println("Reached i == 0");
                for (Wall w: current.getWalls()){
                    if (w.isEdge()){
                        w.setIsPath(true);
                    }
                }
            }
            
            //Break out of loop if you've reached the end square
            if (i == path.size() - 1){
                System.out.println("Reached i == path.size() - 1");
                for (Wall w: current.getWalls()){
                    if (w.isEdge()){
                        w.setIsPath(true);
                    }
                }
                break;
            }
            
            Square next = path.get(i+1);
            if (current.getUpSquare() == next){
                current.getUpWall().setIsPath(true);
            }
            
            if (current.getDownSquare() == next){
                current.getDownWall().setIsPath(true);
            }
            
            if (current.getLeftSquare() == next){
                current.getLeftWall().setIsPath(true);
            }
            
            if (current.getRightSquare() == next){
                current.getRightWall().setIsPath(true);
            }
        }
    }
    
    private void determineDrawWalls(){
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                Square current = gridArray[i][j];
                for (Wall w: current.getWalls()){
                    if (!w.drawDetermined){
                        if (w.isEdge()){
                            w.setDrawWall(true);
                        }
                        if (w.isPath()){
                            w.setDrawWall(false);
                        }
                        if (!w.isPath() && !w.isEdge()){
                            setRandomDrawWall(w);
                        }
                        w.setDrawDetermined(true);
                    }
                }
            }
        }
        
    }
}