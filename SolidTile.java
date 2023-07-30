//**********************
// Class: CS 225L
// 
// Author: Faheem Khan
//
// Created: 3/31/23
//
// Modified: 3/31/23
//
// Purpose: child class doesn't allow entry to the agent
// 
// Attributes: none
//
// Methods: enterAction(), exitAction(), specialAction(), toString() 
//*********************
public class SolidTile extends GenericTile {
	
	public SolidTile(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enterAction() {
		
	}
	
	@Override
	public void exitAction() {
		
	}
	
	@Override
	public void specialAction() {
		
	}
	
	@Override
	public String toString() {
		return "Solid Tile at Position (" + xlocation +", " + ylocation + ")";
	}

}
