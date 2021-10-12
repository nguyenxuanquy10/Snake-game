package okebaby;
import java.awt.*; 
import javax.swing.*; 

public class Snakegame1 extends JFrame{
    Snakegame1(){
    	
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	//Start1 start1= new Start1();
	//this.add(start1);
	this.add(new GamePanel());
	this.pack();
    }
}
