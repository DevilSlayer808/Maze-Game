//**********************
// Class: CS 225L
// 
// Author: Faheem Khan
//
// Created: 3/31/23
//
// Modified: 3/31/23
//
// Purpose: behaves exactly like generic class where the tiles will have doors that will randomly be locked or unlocked
// 
// Attributes: none
//
// Methods: enterAction(), exitAction(), specialAction(), toString() 
//*********************
public class StaticTile extends GenericTile{
	
	public StaticTile(int x, int y) {
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
		return "Static Tile at Position (" + xlocation +", " + ylocation + ")";
	}

}
