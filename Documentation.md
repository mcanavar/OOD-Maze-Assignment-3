# Maze Assignment 3: Documentation

## Maze Interface
(implements the rectMaze interface)

### Constructor

<b> Description: </b> Instantiates a maze object
<b> Parameters: </b> int y (number of rows), int x (number of columns)
<b> Returns: </b> maze Object

### getMaxX()

<b> Description: </b> Gets number of columns in maze object
<b> Parameters: </b> None
<b> Returns: </b> int

### getMaxX()

<b> Description: </b> Gets number of rows in maze object
<b> Parameters: </b> None
<b> Returns: </b> int

### getDirections()

<b> Description: </b> Returns a list of directions you can go from a certain position in the maze
<b> Parameters: </b> int y (current position y), int x (current position x)
<b> Returns: </b> list of dirType

### startPoint()
<b> Description: </b> Returns the position of the starting square of the maze
<b> Parameters: </b> None
<b> Returns: </b> int [], int[0] = yPos, int[1] = xPos

### endPoint()
<b> Description: </b> Returns the position of the ending square of the maze
<b> Parameters: </b> None
<b> Returns: </b> int [], int[0] = yPos, int[1] = xPos

### playerPos()
<b> Description: </b> Returns the position the player is currently on
<b> Parameters: </b> None
<b> Returns: </b> int [], int[0] = yPos, int[1] = xPos

### setPos()
<b> Description: </b> Sets player's new position
<b> Parameters: </b> int y (new position y), int x (new position x)
<b> Returns: </b> void

## mazeCreation2

Includes all the methods in the maze interface

### initMaze() [private]
<b> Description: </b> Initializes the array of Square objects
<b> Parameters: </b> none
<b> Returns: </b> void

### determineNeighbours() [private]
<b> Description: </b> This function looks at every square in the grid and assigns its neighbours by looking at squares with nearby indexes.
<b> Parameters: </b> none
<b> Returns: </b> void

### createWalls() [private]
<b> Description: </b> This function creates and determines walls. It works by looping through the Square array. It assigns walls to the squares in the row. If squares share walls, then it assigns a reference to that wall object to the square. So, a square's left wall will be the previous square's right wall. It also marks walls on the border so they get drawn later.
<b> Parameters: </b> none
<b> Returns: </b> void

### setRandomDrawWall() [private]
<b> Description: </b> Randomly determines whether or not to draw a wall
<b> Parameters: </b> Wall w
<b> Returns: </b> void

### findEdgeSquares() [private]
<b> Description: </b> Returns a hashSet of edgeSquares
<b> Parameters: </b> none
<b> Returns: </b> HashSet<Square>

### endAndStartSquares [private]
<b> Description </b>: Selects a random end and start square from the HashSet of edgeSquares. HashSets store objects in random order, so this method grabs the first two Squares.
<b> Parameters: </b> HashSet<Square> edgeSquares
<b> Returns: </b> ArrayList<Square>

### getPath() [private]
<b> Description: </b> Returns a path from the startSquare to endSquare using dfs
<b> Parameters: </b> Square start, Square end
<b> Returns: </b> ArrayList<Square>

### determineIsPath() [private]
<b> Description: </b> Looks at Squares in the path. Determines which of those walls shouldn't be drawn so that the maze is solvable
<b> Parameters: </b> none
<b> Returns: </b> void

### determineDrawWalls() [private]
<b> Description: </b> Determines whether or not to draw Walls. If a wall is a edge, draw it. If a wall is part of the path, don't draw it. Else, draw walls randomly.
<b> Parameters: </b> none
<b> Returns: </b> void

## Square (private class in mazeCreation2)

### isVisited()
<b> Description: </b> Returns boolean isVisited() - used for dfs
<b> Parameters: </b> none
<b> Returns: </b> boolean

### setIsVisited()
<b> Description: Set boolean isVisited()
<b> Parameters: </b> boolean b
<b> Returns: </b> none

### isPath()
<b> Description: </b> Returns boolean isPath
<b> Parameters: </b> none
<b> Returns: </b> boolean

### setIsVisited()
<b> Description: Set boolean isPath()
<b> Parameters: </b> boolean b
<b> Returns: </b> none

### hasPlayer()
<b> Description: </b> Returns boolean hasPlayer
<b> Parameters: </b> none
<b> Returns: </b> boolean

### setHasPlayer()
<b> Description: </b> Set boolean hasPlayer()
<b> Parameters: </b> boolean b
<b> Returns: </b> none

### setX()
<b> Description: </b> Set Square's x position
<b> Parameters: </b> int x
<b> Returns: </b> none

### setX()
<b> Description: </b> Set Square's y position
<b> Parameters: </b> int y
<b> Returns: </b> none

### getX()
<b> Description: </b> Get Square's x position
<b> Parameters: </b> none
<b> Returns: </b> int

### getY()
<b> Description: </b> Get Square's y position
<b> Parameters: </b> none
<b> Returns: </b> int

### setUpSquare()
<b> Description: </b> Set a Square's up neighbor
<b> Parameters: </b> Square s
<b> Returns: </b> void

### setDownSquare()
<b> Description: </b> Set a Square's down neighbor
<b> Parameters: </b> Square s
<b> Returns: </b> void

### setLeftSquare()
<b> Description: </b> Set a Square's left neighbor
<b> Parameters: </b> Square s
<b> Returns: </b> void

### setRightSquare()
<b> Description: </b> Set a Square's right neighbor
<b> Parameters: </b> Square s
<b> Returns: </b> void

### getWalls()
<b> Description: </b> Get a Square's Walls. Pos[0] is up, pos[1] is down, pos[2] is left, pos[3] is right.
<b> Parameters: </b> None
<b> Returns: </b> Wall[]

### getUpSquare()
<b> Description: </b> Get a Square's up neighbour
<b> Parameters: </b> None
<b> Returns: </b> Square

### getDownSquare()
<b> Description: </b> Get a Square's down neighbour
<b> Parameters: </b> None
<b> Returns: </b> Square

### getLeftSquare()
<b> Description: </b> Get a Square's left neighbour
<b> Parameters: </b> None
<b> Returns: </b> Square

### getRightSquare()
<b> Description: </b> Get a Square's right neighbour
<b> Parameters: </b> None
<b> Returns: </b> Square

### setUpWall()
<b> Description: </b> Set a square's up wall
<b> Parameters: </b> Wall w
<b> Returns: </b> None

### setDownWall()
<b> Description: </b> Set a square's down wall
<b> Parameters: </b> Wall w
<b> Returns: </b> None

### setLeftWall()
<b> Description: </b> Set a square's left wall
<b> Parameters: </b> Wall w
<b> Returns: </b> None

### setRightWall()
<b> Description: </b> Set a square's right wall
<b> Parameters: </b> Wall w
<b> Returns: </b> None

### getUpWall()
<b> Description: </b> Get a Square's up wall
<b> Parameters: </b> none
<b> Returns: </b> Wall

### getDownWall()
<b> Description: </b> Get a Square's down wall
<b> Parameters: </b> none
<b> Returns: </b> Wall

### getLeftWall()
<b> Description: </b> Get a Square's left wall
<b> Parameters: </b> none
<b> Returns: </b> Wall

### getRightWall()
<b> Description: </b> Get a Square's right wall
<b> Parameters: </b> none
<b> Returns: </b> Wall

<b> Description: </b> Get a Square's neighbours. Pos[0] is up, pos[1] is down, pos[2] is left, pos[3] is right.
<b> Parameters: </b> none
<b> Returns: </b> Square[]

## Wall (private class in mazeCreation2)

### wallType()
<b> Description: </b> Get a wall's wall type
<b> Parameteres: </b> none
<b> Returns: </b> String

### isEdge()
<b> Description: </b> Get boolean isEdge
<b> Parameteres: </b> none
<b> Returns: </b> boolean

### setIsEdge()
<b> Description: </b> Set boolean isEdge
<b> Parameteres: </b> boolean b
<b> Returns: </b> void

### drawWall()
<b> Description: </b> Get boolean drawWall
<b> Parameteres: </b> none
<b> Returns: </b> boolean

### setDrawWall()
<b> Description: </b> Set boolean drawWall
<b> Parameteres: </b> boolean b
<b> Returns: </b> void

### drawDetermined()
<b> Description: </b> Get boolean drawDetermined
<b> Parameteres: </b> none
<b> Returns: </b> boolean

### setDrawWall()
<b> Description: </b> Set boolean drawDetermined
<b> Parameteres: </b> boolean b
<b> Returns: </b> void

### isPath()
<b> Description: </b> Get boolean isPath
<b> Parameteres: </b> none
<b> Returns: </b> boolean

### setisPath()
<b> Description: </b> Set boolean isPath
<b> Parameteres: </b> boolean b
<b> Returns: </b> void



