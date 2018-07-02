/*
	BallGame.java
	Developer:Saikumar Divvela
	Date:10/03/2008
*/

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Event;
import java.awt.Image;
import java.awt.Font;

import java.util.Random;

class Player{
	private int lives;
	private int score;
	public Player(){
		lives=10;
		score=0;
	}
	public void addScore(int plus){
		score += plus;
	}
	public void looseLife(){
		lives --;
	}

	public int getScore(){
		return score;
	}
	public int getLives(){
		return lives;
	}
}

class Ball{
	private int pos_x;
	private int pos_y;
	private int x_speed;
	private int y_speed;
	private int radius;

	private int first_x;
	private int first_y;

	private int maxSpeed;

	private final int x_left=10;
	private final int x_right =370;;
	private final int y_up =45;
	private final int y_down =370;


	Player player;
	Color color;
	Random rnd = new Random();
	private AudioClip out;

	public Ball(int radius,int x,int y,int vx,int vy,int ms,Color color,AudioClip out,Player player){
		this.radius = radius;
		pos_x =x;
		pos_y= y;
		first_x = x;
		first_y = y;
		x_speed = vx;
		y_speed = vy;
		maxSpeed = ms;
		this.color = color;
		this.player = player;
		this.out = out;

	}
	public void move(){
		pos_x += x_speed;
		pos_y += y_speed;
		isOut();
	}
	private void initialize(){
		pos_x = first_x;
		pos_y = first_y;
		x_speed = (rnd.nextInt())%maxSpeed;
	}
	public void ballWasHit(){
		initialize();
	}
	public boolean isOut(){
		if(pos_x < x_left || pos_x > x_right || pos_y < y_up || pos_y > y_down ){
			initialize();
			out.play();
			player.looseLife();
			return true;
		} else return false;
	}
	public boolean userHit(int mouse_x,int mouse_y){
		double x =  pos_x-mouse_x;
		double y =  pos_y-mouse_y;
		double distance = Math.sqrt((x*x)+(y*y));
		if(distance<radius){
			player.addScore(10*Math.abs(x_speed)+10);
			return true;
		} else {
			return false;
		}
	}
	public void drawBall(Graphics g){
		g.setColor(color);
		g.fillOval(pos_x-radius, pos_y-radius , 2*radius, 2*radius);
	}
}
public class BallGame extends Applet implements  Runnable {
	int speed;
	boolean isStopped = true;

	Player player;
	Ball redBall;
	Ball blueBall;

	Thread th;
	Cursor c;

	Font f = new Font("Serif",Font.BOLD,20);

	private Image dbImage;
	private Graphics dbg;

	AudioClip hitNoise;
	AudioClip outNoise;
	AudioClip shotNoise;

	public void init(){
		c = new Cursor(Cursor.CROSSHAIR_CURSOR);
		this.setCursor(c);

		Color superBlue = new Color(0,0,255);
		setBackground(Color.black);
		setFont(f);
		if(getParameter("speed")!=null){
			speed  = Integer.parseInt(getParameter("speed"));
		} else	speed = 15;

		hitNoise = getAudioClip(getCodeBase(),"gun.au");
		hitNoise.play();
		hitNoise.stop();

		outNoise = getAudioClip(getCodeBase(),"error.au");
		outNoise.play();
		outNoise.stop();

		shotNoise = getAudioClip (getCodeBase() , "miss.au");
		shotNoise.play();
		shotNoise.stop();

		player = new Player();
		redBall = new Ball(10,190,170,1,1,4,Color.red,outNoise,player);
		blueBall = new Ball(10,190,230,1,-1,3,Color.blue,outNoise,player);
		start();
	}

	public void start(){
		th = new Thread(this);
		th.start();
	}

	public void stop(){
		th.stop();
	}

	public void paint(Graphics g){
		if(player.getLives()>0){
			// paint the two balls, score information
			g.setColor(Color.yellow);
			g.drawString("Score: "+player.getScore(),10,40);
			g.drawString("Lives: "+player.getLives(),300,40);
			redBall.drawBall(g);
			blueBall.drawBall(g);
			// if game is stopped
			if(isStopped){
				//paint information double click to start the game
				g.setColor(Color.yellow);
				g.drawString("Double click on applet to start game!",40,200);
			}
		} else if (player.getLives()<0) {
				// paint final score. set isStopped true
			g.setColor(Color.yellow);
			g.drawString ("Game over!", 130, 100);
			g.drawString ("You scored " + player.getScore() + " Points!", 90, 140);
			g.drawString ("Doubleclick on the Applet, to play again!", 20, 220);
			isStopped = true;
		}
	}


	public void update(Graphics g){
		if(dbImage == null) {
			dbImage = createImage(this.getSize().width,this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0,0,this.getSize().width,this.getSize().height);

		dbg.setColor(getForeground());
		paint(dbg);
		g.drawImage(dbImage,0,0,this);
	}

	public void run(){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true){
			if (player.getLives ()>=0 && !isStopped){
				redBall.move();
				blueBall.move();
			}
			repaint();
			try {
				Thread.sleep(speed);
			} catch(InterruptedException iex){
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}

	}

	public boolean mouseDown(Event e, int x,int y){

		if(!isStopped){
			if(redBall.userHit(x,y)){
				hitNoise.play();
				redBall.ballWasHit();
			}
			if(blueBall.userHit(x,y)){
				hitNoise.play();
				blueBall.ballWasHit();
			} else {
				shotNoise.play();
			}
		} else if (isStopped && e.clickCount ==2){
			isStopped = false;
			init();
		}
		return true;
	}
}