package okebaby;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class GamePanel extends JPanel implements ActionListener{
//	Graphics g; 
    static final int Screen_Width= 600; 
    static final int Screen_Height= 600; 
    static final int UNIT_SIZE=10; 
    static final int GAME_UNIT=(Screen_Width*Screen_Height)/UNIT_SIZE; 
    static final int DeLay=70; 
    final int x[]= new int[GAME_UNIT]; 
    final int y[]= new int[GAME_UNIT]; 
    int bodyParts= 100;
    int applesEaten; 
    int applex; 
    int appley; 
    char direction='D'; 
    boolean running =false; 
    Timer timer; 
    Random random;
	GamePanel(){
		random= new Random(); 
		this.setPreferredSize(new Dimension(1000,600));
		//this.gette
		this.setBackground(Color.black);
		this.setFocusable(true);
		//this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		newApple();
		this.addKeyListener(new MyKeyAdapter());
		running =true; 
		timer=new Timer(DeLay,this);
	//	timer.setInitialDelay(10000);
		timer.start();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
		
	}
	public void draw(Graphics g) {
		/*for(int i=0; i<Screen_Height/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, Screen_Height);
			g.drawLine(0, i*UNIT_SIZE, Screen_Width,i*UNIT_SIZE);
			//g.drawLine(i, i, i, i)
		}*/
		if(running) {
		g.setColor(Color.blue);
		g.fillOval(applex, appley,UNIT_SIZE, UNIT_SIZE);
		for(int i=0;i<bodyParts;i++) {
			if(i==0) {g.setColor(Color.magenta);
			g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);}
		
		else {
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
		}
		  
			g.setColor(Color.red);
			g.setFont( new Font("Ink Free",Font.BOLD, 75));
			FontMetrics metrics2 = getFontMetrics(g.getFont());
			g.drawString("Score"+ applesEaten, 50, 250);
			
		}
		}
		else {
			gameOver(g);
		}
		//.
	}
	public void newApple() {
		applex = random.nextInt((int)(Screen_Width/UNIT_SIZE))*UNIT_SIZE;
		appley = random.nextInt((int)(Screen_Height/UNIT_SIZE))*UNIT_SIZE;
	}
	public void move() {
		for(int i=bodyParts;i>0;i--){
			x[i]=x[i-1]; 
			y[i]=y[i-1];
		}
		switch(direction) {
		case 'U': 
			y[0]=y[0]-UNIT_SIZE; 
			break;
		case 'D':
			y[0]=y[0]+UNIT_SIZE;  
			break;
		case 'L': 
			x[0]=x[0]-UNIT_SIZE; 
			break;
		case 'R': 
			x[0]=x[0]+UNIT_SIZE;  
			break;
		}
	}
	public void checkApple() {
		if(x[0]==applex && y[0]==appley) {
			bodyParts++; 
			applesEaten++; 
			newApple();
		}
	}
	public void checkCollisions() {
		for(int i=bodyParts;i>0;i--) {
			if(x[0]==x[i]&& y[0]==y[i]) {
				running=false; 
			}
		}
		if(x[0]<0) running=false; 
		if(x[0]>Screen_Width) running=false; 
		if(y[0]<0) running =false; 
		if(y[0]>Screen_Height) running=false; 
	}
	public void gameOver(Graphics g){
		g.setColor(Color.WHITE);
		//g.fillRect(0, 0,Screen_Width,Screen_Height);
		g.setFont( new Font("Ink Free",Font.BOLD, 30));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", ( Screen_Width- metrics2.stringWidth("Game Over"))/2, Screen_Height/2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(running) {
			move(); 
			checkApple(); 
			checkCollisions();
		}
		repaint();
		
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override 
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction!='R') {
					direction='L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction!='L') {
					direction='R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction!='D') {
					direction='U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction!='U') {
					direction='D';
				}
				break;
			}
				
		}
	}
}

