package Palindrome;



import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
/**
* GameOfLife
*
* This class is an implementation of Conway's Game Of Life.
*/
public class GameOfLife extends GraphicsProgram {

/** Delay between generations in ms. */
private static final int DELAY = 100;

/** Random generator instance */
private RandomGenerator rgen = RandomGenerator.getInstance();

@Override
public void run() {
// Set new "random" seed.
rgen.setSeed(System.nanoTime());

// Ask the user for the game size, cell size, and the start probability.
int dimensions = readInt("Set the size of the game field: ", 1, 1024);
int cellSize = readInt("Set the size of the cells: ", 1, 10);
double startProbability = readDouble("Set the start probability of a cell being alive: ", 0.0, 1.0);
setSize(dimensions * cellSize, dimensions * cellSize);

 // Create and draw the game field.
 boolean[][] cells = createNewField(dimensions, startProbability);
 drawField(cells, cellSize);

 // Wait for user input.
 waitForClick();
 while(true) {
 // Calculate the next cycle and display it, then wait.
 cells = calculateNextGeneration(cells);
 drawField(cells, cellSize);
 pause(DELAY);
  }
  }
/**
 * Creates a new game cell field and initializes each cell
 * according to the start probability.
 *
 * @param dimensions of the game field.
 * @param startProbability sets the start probability of a cell being alive.
 * @return the game field array as boolean[][].
 */

//first function created by me
//it will create new field for the first time or say it will fill the initial array
//by taking the boolean values from rgen.nextBoolean(startProbability)
 public boolean[][] createNewField(int dimensions, double startProbability) {
 // Implement me!
//	 This gameField variable id 2d array which contains the boolean values for
//	 each cell
     boolean[][] gameField = new boolean[dimensions][dimensions];
     
//     In this loop the iterate through each cell and put values in it
//     i is for row
     for (int i = 0; i < gameField.length; i++) {
         {
//        	 j is for column
             for (int x = 0; x < gameField.length; x++) {
//            	 rgen.nextBoolean(startProbability) return random boolean value
                 gameField[i][x] = rgen.nextBoolean(startProbability);
             }
         }
     }
     return gameField;
 }

 /**
 * Draws the given cell field using GRects.
 *
 * @param cells the cell array as boolean[][]
 * @param cellSize the individual size of the cell rects.
 */
 public void drawField(boolean[][] cells, int cellSize) {
// Removes all objects from the canvas.
 removeAll();
 
//Complete me!

// this is the gui part

 for (int i = 0; i < cells.length; i++) {
     for (int x = 0; x < cells[i].length; x++) {
         if (cells[i][x]) {
             GRect rect = new GRect(i * cellSize, x * cellSize, cellSize, cellSize);
             rect.setFillColor(Color.green);
             rect.setFilled(true);
             add(rect);
         }
     }

 }

 // Complete me!
 }

 /**
 * Calculates the next generation and returns it.
 * You can create further private methods to split up the task in several sub-tasks.
 *
 * @param cells the cell array as boolean[][]
 * @return TNG as boolean[][]
 */
 public boolean[][] calculateNextGeneration(boolean[][] cells) {
 // Implement me!
//	 nextGenration variable stores the boolean values for next geration
     boolean[][] nextGeneration = new boolean[cells.length][cells.length];
//     calculatEArray is used to count the number alive cell
     int[][] calculateArray = new int[cells.length][cells.length];
//     two loops one for row and the other for column true is changed with 1 and false with 0 to count the neighbours
     
     for (int i = 0; i < cells.length; i++) {
         for (int j = 0; j < cells.length; j++) {
             if (cells[i][j]) {
                 calculateArray[i][j] = 1;
             } else {
                 calculateArray[i][j] = 0;
             }
         }
     }
//     two loops one for row and the other is for column
     for (int i = 0; i < cells.length ; i++) {
         for (int j = 0; j < cells.length; j++) {
//        	 this variable store the alive cell in 3*3 grid
             int trueNeighbours = 0;
//           this loop is used to store the values for 3 rows upper,current and lower
             for (int k = -1; k <= 1; k++) {
//            	 it is used for all the boundries cell because they have only 3(conrner cells) or 5 neighbours
            	 if((i+k)<0 || (i+k)>=cells.length) {
            		 continue;
            	 }
//            	 this loop is used to store the values for 3 columns upper,current and lower
                 for (int l = -1; l <= 1; l++) {
//                	 it is used for all the boundries cell because they have only 3(conrner cells) or 5 neighbours
                	 if((j+l)<0 || (j+l)>=cells.length) {
                		 
                		 continue;
                	 }
//                	 calculate the neighbours
                     trueNeighbours += calculateArray[i + k][j + l];
                	 
                 
                 }
             }
//             subtracting the current sell value from 3*3 grid because it count value itself also
             trueNeighbours -= calculateArray[i][j];
		//these are the conditions given for cells
//             if neighbours are less than 2 and cell is alive it will die
             if ((calculateArray[i][j] == 1) && (trueNeighbours < 2)) {
                 nextGeneration[i][j] = false;
             } 
//             if neighbours are more than 3 and cell is alive then it will die
             else if ((calculateArray[i][j] == 1) && (trueNeighbours > 3)) {
                 nextGeneration[i][j] = false;
             } 
//             if cell is dead and there are three neighbours it will become alive
             else if ((calculateArray[i][j] == 0) && (trueNeighbours == 3)) {
                 nextGeneration[i][j] = true;
             } else {
                 nextGeneration[i][j] = cells[i][j];
             }
         }
     }
     return nextGeneration;

 }

 }

 
 
 