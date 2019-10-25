public class Wall
{
    boolean isEdge;
    boolean drawWall;
    boolean isPath;
    boolean drawDetermined;
    String wallType;
    
    public Wall(String s)
    {
        /* Booleans default to false if they haven't been set. Is this ideal? */ 
        
        this.isEdge = false;
        this.drawWall = false;
        this.drawDetermined = false;
        this.wallType = s;
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
    /*
    public void setNextSquare (Square s){
        this.nextSquare = s;
    }
   
    public Square getNextSquare (){
       return nextSquare;
    } */
}
