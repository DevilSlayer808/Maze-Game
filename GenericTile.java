//**********************
// Class: CS 225L
// 
// Author: Faheem Khan
//
// Created: 3/31/23
//
// Modified: 3/31/23
//
// Purpose: PrintInfo() will display the results of each tile's locked/unlocked status, parent class tthat will be override by the actions of the child classes
// 
// Attributes: xlocation, ylocation, door_status[], isStartNode, isEndNode
//
// Methods: PrintInfo(), enterAction(), exitAction(), specialAction(), toString()
//*********************

public class GenericTile {
	

	protected int xlocation;
	protected int ylocation;
	protected boolean door_status[]; /* N E S W */
	private boolean isStartNode;
	private boolean isEndNode;

	
	public GenericTile(int x, int y) {
		xlocation = x;
		ylocation = y;
		door_status = new boolean[4];
		
		
		
		for(int i=0; i<4; i++) {
			double random = Math.random();
			if(random < 0.5) {
				door_status[i] = true;
			}
			
		}
	}
	
	public int getX() { return xlocation; }
	public int getY() { return ylocation; } 


	public void PrintInfo(){
		
		System.out.printf("Tile (%d, %d)(N, S, E, W) status: (", xlocation, ylocation);
		
		for(int i = 0; i < door_status.length; i++) {
			
			if(door_status[i]) {
				System.out.print("U, ");
				
			}
			else {
				System.out.print("L, ");
			}
		}
		System.out.print(")\n");
		
	}
	public boolean isStartNode() {
		return isStartNode;
	}


	public void setStartNode(boolean isStartNode) {
		this.isStartNode = isStartNode;
	}


	public boolean isEndNode() {
		return isEndNode;
	}


	public void setEndNode(boolean isEndNode) {
		this.isEndNode = isEndNode;
	}
	
	public boolean[] getDoorStatus() {
		return door_status;
	}
	
	public void enterAction() {
		
	}
	
	public void exitAction() {
		
	}
	
	public void specialAction() {
		
	}
	
	@Override
	public String toString() {
		return "Generic Tile at Position (" + xlocation +", " + ylocation + ")";
	}

}
