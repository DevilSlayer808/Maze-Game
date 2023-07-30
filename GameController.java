//**********************
// Class: CS 225L
// 
// Author: Faheem Khan
//
// Created: 4/10/23
//
// Modified: 4/10/23
//
// Purpose: Will display all of the output. This will include the quantity of rows and columns, start and goal tiles, and determine if the agent won or lost, update of each tile on their action and status and their door status 
// 
// Attributes: maze[][], Mazesize, agent, xEnd, yEnd, rotatingTiles
//
// Methods: gameLoop(), startGame(), populateMaze(), printMaze() 
//*********************
import java.util.ArrayList;

public class GameController {
	

	private GenericTile maze[][]; 
	private int MazeSize;
	private GenericAgent agent;
	private int xEnd;
	private int yEnd;
	private ArrayList<RotatingTile> rotatingTiles;
	
	public void gameLoop() {
		boolean running = true;
		
		while (running) {
			running = agent.move(maze);
			
			if (agent.getX() == xEnd && agent.getY() == yEnd) {
				// player won
				System.out.println("won");
				return;
			}
			
			if (Math.random() <= 0.01) {
				int rindex = (int)(Math.random() * rotatingTiles.size());
				rotatingTiles.get(rindex).specialAction();
			}
		}
		
		// player lost
		System.out.println("Lost");
		
	}
	
	public void startGame(int n){
		
		
		if(n%2 == 0) {
			System.out.println("Error");
			System.exit(1);
		}
		MazeSize = n;
		maze = new GenericTile[n][n];
		
		rotatingTiles = new ArrayList<>();
		
		populateMaze(maze);
		
		
		maze[0][(n-1)/2].setStartNode(true);
		maze[n-1][(n-1)/2].setEndNode(true);
		
		xEnd = n-1;
		yEnd = (n-1)/2;
		
		agent = new GenericAgent(0, (n-1)/2, 50);
	}
	
	public void populateMaze(GenericTile maze[][]) {

		for(int i = 0; i < maze.length; i++){
			
			for(int j = 0; j < maze[i].length; j++) {
				
				int r = (int)(Math.random() * 3);
				switch(r) {
				case 0:
					RotatingTile rt = new RotatingTile(i, j);
					rotatingTiles.add(rt);
					maze[i][j] = rt;
					break;
				case 1:
					maze[i][j] = new StaticTile(i, j);
					break;
				case 2:
					maze[i][j] = new SolidTile(i, j);
					break;
				}
			}
		}
		
		int randomX = (int)(Math.random() * maze.length);
		int randomY = (int)(Math.random() * maze[randomX].length);
		RotatingTile newRT = new RotatingTile(randomX, randomY);
		rotatingTiles.add(newRT);
		maze[randomX][randomY] = newRT;
		
		randomX = (int)(Math.random() * maze.length);
		randomY = (int)(Math.random() * maze[randomX].length);
		maze[randomX][randomY] = new SolidTile(randomX, randomY);
		
		randomX = (int)(Math.random() * maze.length);
		randomY = (int)(Math.random() * maze[randomX].length);
		maze[randomX][randomY] = new StaticTile(randomX, randomY);
		
	}
	
	public void printMaze(){
		
		for(int i = 0; i < maze.length; i++){
			
			for(int j = 0; j < maze[i].length; j++) {
				
				maze[i][j].PrintInfo();
			}
			
		}
		System.out.printf("There are %d rows and columns in the Maze. Start is at (0, %d), and Goal is at (%d, %d). \n",
				MazeSize, (MazeSize-1)/2, (MazeSize-1), (MazeSize-1)/2);
	}



}
