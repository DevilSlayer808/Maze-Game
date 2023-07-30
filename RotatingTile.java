//**********************
// Class: CS 225L
// 
// Author: Faheem Khan
//
// Created: 3/31/23
//
// Modified: 3/31/23
//
// Purpose: Rotates 90 degrees in either counterclockwise or clockwise based on the action called upon
// 
// Attributes: none
//
// Methods: exitAction(), enterAction(), specialAction(), toString()
//*********************
public class RotatingTile extends GenericTile {
	
	public RotatingTile(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enterAction() {
		
	}
	
	@Override
	public void exitAction() {
		
		boolean temp[] = new boolean[door_status.length];
		for(int i = 0; i < door_status.length; i++) {
			temp[i] = door_status[i];
		}
		door_status[0] = temp[3];
		door_status[1] = temp[2];
		door_status[2] = temp[1];
		door_status[3] = temp[0];
		
		System.out.println("Tile [" + xlocation + " ," + ylocation + "] rotates 90 degrees clockwise");
			
	}
	
	@Override
	public void specialAction() {

		boolean temp[] = new boolean[door_status.length];
		for(int i = 0; i < door_status.length; i++) {
			temp[i] = door_status[i];
		}
		door_status[0] = temp[1];
		door_status[1] = temp[2];
		door_status[2] = temp[3];
		door_status[3] = temp[0];
		
		System.out.println("Tile [" + xlocation + " ," + ylocation + "] rotates 90 degrees counterclockwise");
		//System.out.println(maze[i][j]);
			
	}

	@Override
	public String toString() {
		return "Rotating Tile at Position (" + xlocation +", " + ylocation + ")";
	}
}
