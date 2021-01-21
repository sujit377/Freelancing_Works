package Palindrome;
import java.util.*;
public class Sudoku extends NumberBoard{
	public Sudoku() {
		super(9,9);
		// TODO Auto-generated constructor stub
	}
	
	  @Override
	  public void setValueAt(int row, int col, int value) {
	    if (value > 0 && value <= 9) { // Considering EMPTY just means 0 as int is primitive
	      super.setValueAt(row, col, value);
	    } else {
	      throw new IllegalArgumentException("Value cannot be negative or greater than 9");
	    }
	  }
	  
	  public boolean isValid() {
		  for (int row = 0 ; row < 9; row = row + 3) {
			    for (int col = 0; col < 9; col = col + 3) {
			      Set<Integer>set = new HashSet<Integer>(); 
			      for(int r = row; r < row+3; r++) {
			        for(int c= col; c < col+3; c++){
			          if (super.getValueAt(r,c) != -1){
			            if (set.add(super.getValueAt(r,c)) == false) {
			            return false;
			            }
			          }
			        }
			      }
			    }   
			  }
		  for(int col=0;col<9;col++) {
			  Set<Integer>set1 = new HashSet<Integer>(); 
			  for (int i =0 ; i< 9; i++) {
			    if (super.getValueAt(i,col) != -1){
			      if (set1.add(super.getValueAt(i,col)) == false) {
			      return false;
			      }
			    }
			  }
		  }
		  for(int row=0;row<9;row++) {
			  Set<Integer>set2 = new HashSet<Integer>(); 
			  for (int i =0 ; i< 9; i++) {

			    // Checking for repeated values.
			    if (super.getValueAt(row,i) != -1){
			      if (set2.add(super.getValueAt(row,i)) == false) {
			      return false;
			      }
			    }
			  }
		  }

		  return true;
	  }
	  public static void main(String[] args) {
		  Sudoku s = new Sudoku();
		  s.setValueAt(1, 2, 4);
		  s.setValueAt(1, 1, 9);
		  if(s.isValid()) {
			  System.out.println("True1");
		  }
		  s.setValueAt(1, 2, 9);
		  if(s.isValid()) {
			  System.out.println("True12");
		  }
		  else {
			  System.out.println("false12");
		  }
	  }
	  
}
