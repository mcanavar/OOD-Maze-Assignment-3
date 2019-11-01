import java.util.List;

public interface Maze
{
    int getMaxX();
    int getMaxY();
    List<DirType> getDirections(int y, int x);
    Integer[] startPoint();
    Integer[] endPoint();
    Integer[] playerPos();
    void setPos(int y, int x);
}
