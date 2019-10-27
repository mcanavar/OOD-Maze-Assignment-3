public class Wall
{
    boolean isEdge;
    boolean drawWall; // Determines if you should draw the wall
    boolean isPath;
    boolean drawDetermined; // Determines if you've assigned drawWall or if it still defaults to False
    String wallType;
    
    public Wall(String s)
    {
        
        isEdge = false;
        drawWall = false;
        drawDetermined = false;
        wallType = s;
        isPath = false;
        
    }
    
    public String wallType(){
        return wallType;
    }
    
    public boolean isEdge(){
        return isEdge;
    }
    
    public void setIsEdge(boolean b){
        this.isEdge = b;
    }
    
    public boolean drawWall(){
        return drawWall;
    }
    
    public void setDrawWall(boolean b){
        this.drawWall = b;
    }
    
    public boolean drawDetermined(){
        return drawDetermined;
    }
    
    public void setDrawDetermined(boolean b){
        this.drawDetermined = b;
    }
    
    public boolean isPath(){
        return isPath;
    }
    
    public void setIsPath(boolean b){
        this.isPath = b;
    }
}
