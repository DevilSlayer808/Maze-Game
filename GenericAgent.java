//**********************
// Class: CS 225L
// 
// Author: Faheem Khan
//
// Created: 3/31/23
//
// Modified: 3/31/23
//
// Purpose: program will allow the agent to make a random decision on which doors to open and will track each and every move made.
// It will also create tiles based on the unlocked doors the agent passed through
// 
// Attributes: xLocation, yLocation, movesLeft
//
// Methods: move(GenericTile maze[][]), filterNeighbors(GenericTile maze[][]) 
//*********************
import java.util.ArrayList;

public class GenericAgent {
	
	private int xLocation, yLocation;
	private int movesLeft; 
	
	//Constructor
	public GenericAgent( int xPos, int yPos, int left) {
		
		xLocation = xPos;
		yLocation = yPos;
		movesLeft = left;
		
				
	}
	
	// Returns true if the player can move again
	// Returns false if the player has no moves left or is stuck
	public boolean move(GenericTile maze[][]) {
		ArrayList<GenericTile> availableTiles = new ArrayList<>();
		
		availableTiles = filterNeighbors(maze);
		
		if (availableTiles.size() == 0) {
			return false;
		}
		
		int random = (int)(Math.random() * availableTiles.size());
		
		int seekingX = availableTiles.get(random).getX();
		int seekingY = availableTiles.get(random).getY();
		
		movesLeft--;
		if (movesLeft == 0) {
			return false;
		}
		
		if (maze[seekingX][seekingY] instanceof SolidTile) {
			// blocked
			System.out.println("Tile [" + seekingX + " ," + seekingY + "] prevents Agent from entering");
			return true;
		}
		
		xLocation = seekingX;
		yLocation = seekingY;
		
		System.out.print("Agent moved to tile ");
		System.out.println(maze[xLocation][yLocation]);
		
		
		return true;
	}
	
	public ArrayList<GenericTile> filterNeighbors(GenericTile maze[][]) {
		ArrayList<GenericTile> returnMe = new ArrayList<>();
		/* Fill availableTiles with tiles that are in bounds and doors are unlocked */
		if (xLocation + 1 < maze.length && maze[xLocation+1][yLocation].getDoorStatus()[1]) {
			returnMe.add(maze[xLocation+1][yLocation]);
		}
		if (xLocation - 1 >= 0 && maze[xLocation-1][yLocation].getDoorStatus()[3]) {
			returnMe.add(maze[xLocation-1][yLocation]);
		}
		if (yLocation + 1 < maze.length && maze[xLocation][yLocation+1].getDoorStatus()[0]) {
			returnMe.add(maze[xLocation][yLocation+1]);
		}
		if (yLocation - 1 >= 0 && maze[xLocation][yLocation-1].getDoorStatus()[2]) {
			returnMe.add(maze[xLocation][yLocation-1]);
		}
		
		return returnMe;
	}
	
	public int getX() { 
		return xLocation; 
		}
	public int getY() {
		return yLocation; 
		}
	

}
