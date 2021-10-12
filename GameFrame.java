package okebaby;
import java.awt.*; 
import javax.swing.*; 
public class GameFrame extends JFrame{

	GameFrame(){
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	Start1 start1= new Start1();
    	this.add(start1);
    	//this.add(new GamePanel());
    	this.pack();
    }
}
