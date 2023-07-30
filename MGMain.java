//**********************
// Class: CS 225L
// 
// Author: Faheem Khan
//
// Created: 3/31/23
//
// Modified: 3/31/23
//
// Purpose: starting point of the program and calls upon all other classes
// 
// Attributes: none
//
// Methods: main(String[] args)
//*********************
public class MGMain {
	
	public static void main(String[] args) {
		
		GameController Controller = new GameController();
		Controller.startGame(5);
		Controller.printMaze();
		Controller.gameLoop();
	}

}
