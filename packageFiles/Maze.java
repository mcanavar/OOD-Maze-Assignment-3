import java.util.ArrayList;

public interface Maze
{
    int getMaxX();
    int getMaxY();
    ArrayList<DirType> getDirections(int y, int x);
    Integer[] startPoint();
    Integer[] endPoint();
    Integer[] playerPos();
    void setPos(int y, int x);
}
