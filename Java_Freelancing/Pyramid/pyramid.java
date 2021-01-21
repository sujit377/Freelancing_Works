package Palindrome;
import java.util.*; 
import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int WIDTH = 30;

/** Width of each brick in pixels */
	int height = 12;

/** Number of bricks in the base of the pyramid */
	
	
	public Color layerColor(int layerIndex, int numberOfLayers) {
		int a = 220/(numberOfLayers-1);
		Color m = new Color (255, a*layerIndex, a*layerIndex);
		return m;
	}
	
	
	
	public void drawLayer(int layerIndex, int numberOfLayer,Color layerColor) {
		int bricksInRow =  numberOfLayer-layerIndex ;
		for( int brickNum = 0; brickNum < bricksInRow; brickNum++ ) {
			//1. Calculate the center
			//2. Calculate the starting point based on the center
			//3. Add the number of bricks * brick width to find this brick's location
		
			int x = ( getWidth() ) - (WIDTH * bricksInRow) / 2 + brickNum * WIDTH;
			
			// Calculate the vertical location of the brick based on the row
			
			int y = getHeight() - height * (layerIndex+1);
			
			// Draw the brick
			
			GRect brick = new GRect( x+(10*numberOfLayer) , y+(10*numberOfLayer) , WIDTH , height );
			brick.setFillColor(layerColor);
			brick.setFilled(true);
			brick.setColor(Color.black);
			add(brick);
		}
	}
	public void run() {
		//row - 0-based index of the row 
		//row+1 - The 1-based index of the row
		//brickNum - 0-based index of the brick
		
		//Loop through the 0-based index of the rows
		Scanner sc= new Scanner(System.in);
		int base=sc.nextInt();
		sc.close();
		for( int row = 0; row < base; row++ )
		{
			
			Color l = layerColor(row,base);
			drawLayer(row,base,l);
			
		}
	}
	
	
}