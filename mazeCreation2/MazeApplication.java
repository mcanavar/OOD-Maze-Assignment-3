import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MazeApplication extends Application{
    RectMaze the_maze;
    Canvas maze_canvas;
    
    //The start function just sets up the main window for the application
    //We will discuss JavaFx later in the term
    public void start(Stage primaryStage){
        primaryStage.setTitle("A Maze");
        Group root = new Group();
        maze_canvas = new Canvas(1200, 800);
 
        root.getChildren().add(maze_canvas);
        primaryStage.setScene(new Scene(root, 1200, 800, Color.WHITE));
        primaryStage.show();

	displayTheMaze();
    }

    //Here is where the maze is created
    //... Replace TestMaze with a class you have created!
    void displayTheMaze(){
	the_maze = new mazeCreation2(6, 4);
	

        //You can un-comment these two lines to change the scale of the maze
        //The MazeDisplayGraphics class  will scale your RectMaze 
        //... to fit inside a square whose side length is SIDE

	MazeDisplayGraphics.SIZE=400;
        MazeDisplayGraphics.MARGIN=20;

	MazeDisplayGraphics.display(the_maze, maze_canvas);
    }

}
	