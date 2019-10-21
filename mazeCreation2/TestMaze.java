import java.util.List;
import java.util.ArrayList;

public class TestMaze implements RectMaze{
    public List<DirType> getDirections(int x, int y){
	List<DirType> lst = new ArrayList<DirType>();
	if (x==0 && y==0){
	    lst.add(DirType.South);
	    lst.add(DirType.East);
	}
	if (x==0 && y==1){
	    lst.add(DirType.North);
	    lst.add(DirType.East);
	}
	if (x==1){
	    lst.add(DirType.West);
	}
	return lst;
    }
	    
    public int getMaxX(){
	return 2;
    }

    public int getMaxY(){
	return 2;
    }
}