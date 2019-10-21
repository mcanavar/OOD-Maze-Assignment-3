public class Driver
{
    
    public static void main (String[] argv){
        /*
        System.out.println("Testing 5x4 Grid");
        Grid testGrid = new Grid(5, 4);
        
        testGrid.initGrid();
        //testGrid.determineNeighbours();
        //testGrid.testDetermineNeighbours();
        testGrid.determineWallsRandom();
        System.out.println("Draw random walls!");
        testGrid.drawWalls();
        */
       
       System.out.println("Testing 2x3 Grid");
       Grid testGrid = new Grid(2, 3);
       testGrid.initGrid();
       testGrid.determineNeighbours();
       testGrid.determineWallsRandom();
       System.out.println("Draw random walls!");
       testGrid.drawWalls();
       testGrid.printWallInfoAll();
       
    }
}
