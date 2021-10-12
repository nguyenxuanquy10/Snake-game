package okebaby;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
public class Start1 extends JPanel implements ActionListener{
	 JButton button1= new JButton("Start");
	 JButton button2=new JButton("Exit");
     Start1(){
    	  JLabel label = new JLabel("Snake Game");
    	  //label.setFont((new Font("Dialog", Font.PLAIN, 25)));
   	   label.setBounds(430, 50, 400, 100);
   	 label.setFont((new Font("Dialog", Font.PLAIN, 25)));
    	 button1.setFont((new Font("Dialog", Font.PLAIN, 35)));
         button1.setBackground(Color.orange);
         button2.setBackground(Color.orange);
    	 button2.setFont((new Font("Dialog", Font.PLAIN, 35)));
    	 button1.setBounds(400, 200,200 ,100 );
    	 button2.setBounds(400,400,200,100);
    	 button1.addActionListener(this);
    	 button2.addActionListener(this);
    	 ImageIcon image= new ImageIcon(); 
    	 this.setBackground(Color.GRAY);
    	 this.setLayout(null);
    	 this.add(button2);
    	 this.add(button1);
    	  this.add(label);
    	 this.setPreferredSize(new Dimension(1000,600));
     }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			new Snakegame1();
			
		}
		else if(e.getSource()==button2){
			System.exit(0);
		}
	}
}
