import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class MazeCreationOne implements RectMaze{
    int x;
    int y;
    public String[][] CreateMaze(int x, int y){
        this.x = x;
        this.y = y;
        String[][] arraze = new String[x][y];
        Random ran = new Random();
        Random rantwo = new Random();
        int rowval = 1;
        int colval = 1;
        for (int row=0; row < arraze.length; row++ ) { //loop through rows
            System.out.println();
            for (int col=0; col < arraze[row].length; col++){ //loop through columns
                int ranint = ran.nextInt();
                int raninttwo = rantwo.nextInt();
                if (row != 0 && col != 0){
                    arraze[row][col] = "_|";}
                else if (row > 0 && col == 0){
                    arraze[row][col] = "|";}
                else if (row == 0 && col < y - 1){
                    arraze[row][col] = " _";}
                if (row == 1 && col == 0 || row == 0 && col == y-1){
                    arraze[row][col] = " ";}
                //Path Finding
                if (row != x - 1 && col != y-1 && row != 0 && col != 0){
                    if (raninttwo%2 != 0){
                        arraze[row][col] = "_ ";}
                    if (raninttwo%2 == 0){
                        arraze[row][col] = " |";}
                ;}
                else if (row != 0 && col != 0 && row == x-1 && col != y-1){
                    if (raninttwo%2 != 0){
                        arraze[row][col] = "_ ";}
                    if (raninttwo%2 == 0){
                        arraze[row][col] = "_|";}
                ;}
                else if (row != 0 && col != 0 && row != x-1 && col == y-1){
                    if (raninttwo%2 != 0){
                        arraze[row][col] = "_|";}
                    if (raninttwo%2 == 0){
                        arraze[row][col] = " |";}
                ;}
                if (row == rowval && col == colval && ranint%2 == 0){
                    if (raninttwo%2 != 0){
                        arraze[row][col] = "  ";}
                    if (raninttwo%2 == 0){
                        arraze[row][col] = " |";}
                    rowval = rowval + 1;
                ;}
                else if (row == rowval && col == colval && ranint%2 != 0){
                    if (raninttwo%2 != 0){
                        arraze[row][col] = "_ ";}
                    if (raninttwo%2 == 0){
                        arraze[row][col] = "  ";}
                    colval = colval + 1;
                ;}
                System.out.print(arraze[row][col]);
            }
        }
        return arraze;
    }
    public int StartPoint(){
        return 1;
    }
    public int EndPoint(){
        return x;
    }
    public int getMaxX(){
        return x;
    }
    public int getMaxY(){
        return y;
    }
    MazeCreationOne newmaze;
    public List<DirType> getDirections(int x, int y){
        this.newmaze = new MazeCreationOne();
        newmaze.CreateMaze(int x, int y);
        String[][] Maze = newmaze.CreateMaze(int x, int y);
        List<DirType> listo = new ArrayList<DirType>();
        for (int row = 1; row < Maze.length; row++) {
            for (int col = 1; col < Maze[row].length; col++) {
                if (Maze[row][col] == " |")
                {listo.add(DirType.South);}
                if (Maze[row][col] == "_ ")
                {listo.add(DirType.East);}
            }
        }
        return listo;
    }
}