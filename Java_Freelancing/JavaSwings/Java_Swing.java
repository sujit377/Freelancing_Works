package Palindrome;


import java.awt.event.*; 
import javax.swing.*; 



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
class JTextFieldLimit extends PlainDocument {
	  private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
	}
public class Java_Swing extends JFrame implements ActionListener { 
	static JTextField t1,t2; 
	static JRadioButton rb1,rb2;
	
	static JFrame f; 

	static JButton b; 

	static JLabel l1,l2,l3; 
 
	Java_Swing() 
	{ 
		
	} 


	public static void main(String[] args) 
	{  
		f = new JFrame("Assignment"); 
		f.setBounds(100, 100, 500, 400);
		l1 = new JLabel("Paragraph"); 
		l1.setBounds(100,0,100,30);
		l2 = new JLabel("# of Reps");
		l2.setBounds(100,30,100,30);
		l3 = new JLabel("Result : ");
		l3.setVerticalAlignment(JLabel.TOP);
		l3.setBounds(100,150,300,190);
		rb1=new JRadioButton("Analysis",true); 
		rb1.setBounds(0,0,100,30);
		rb2=new JRadioButton("Repeat"); 
		rb2.setBounds(0,30,100,30);
		// create a new button 
		b = new JButton("Action"); 
		b.setBounds(100,120,100,25);
		// create a object of the text class 
		Java_Swing te = new Java_Swing(); 

		// addActionListener to button 
		b.addActionListener(te); 

		// create a object of JTextField with 16 columns 
		t1 = new JTextField(20); 
		t1.setBounds(100,60,150,25);
		t2 = new JTextField(1);
		t2.setBounds(100,90,150,25);


		JPanel p = new JPanel(); 
		f.add(rb1); 
		f.add(l1);
		f.add(rb2);
		f.add(l2);
		f.add(l3);
		f.add(t1); 
		t1.setDocument(new JTextFieldLimit(20));
		f.add(t2);
		t2.setDocument(new JTextFieldLimit(1));
		
		f.add(b); 


		f.setSize(500, 500); 
		f.setLayout(null);    
		f.setVisible(true);
		f.show(); 
	} 


	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 
		if (s.equals("Action")) { 
			String s2 = t1.getText();
			if(rb1.isSelected() && rb2.isSelected() ) {
				int letter=0;
				char[] ch = s2.toCharArray();
				for(int i = 0; i < s2.length(); i++){
					if(Character.isLetter(ch[i])){
						letter++ ;
					}
				}
				String res="<html>Result : "+Integer.toString(letter)+"<br>";
				for(int i=0;i<Integer.parseInt(t2.getText());i++) {
					res=res+s2+" <br>";
				}
				res=res+"</html>";
				l3.setText(res);
			}
			
			
			else if(rb1.isSelected()) {
				int letter=0;
				char[] ch = s2.toCharArray();
				for(int i = 0; i < s2.length(); i++){
					if(Character.isLetter(ch[i])){
						letter++ ;
					}
				}
				l3.setText("Result : "+Integer.toString(letter));
			}
			else if(rb2.isSelected()) {
				String res="<html>Result : <br>";
				for(int i=0;i<Integer.parseInt(t2.getText());i++) {
					res=res+s2+" <br>";
				}
				res=res+"</html>";
				l3.setText(res);
			}
			
		} 
	} 
} 

