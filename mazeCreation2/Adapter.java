import java.util.ArrayList;

public class Adapter implements RectMaze{
    public mazeCreation2 mazeGrid;
    
    public mazeCreation2(int numCols, int numRows){
        System.out.println("New test");
        mazeGrid = new Grid(numCols, numRows);
        mazeGrid.initGrid();
        mazeGrid.determineNeighbours();
        mazeGrid.determineWallsRandom();
        //mazeGrid.determineWallsAll();
        mazeGrid.drawWalls();
        System.out.println("");
        mazeGrid.printWallInfoAll();
    }
    
    public int getMaxX(){
        return mazeGrid.getNumCols();
    }
    
    public int getMaxY(){
        return mazeGrid.getNumRows();
    }
    
    public ArrayList<DirType> getDirections(int x, int y){
        ArrayList<DirType> directions = new ArrayList<DirType>();    
        Square current = mazeGrid.gridArray[y][x];
        
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