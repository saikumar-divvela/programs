/*
	Move a Ball Applet
*/
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Event;
public class BallApplet extends Applet implements Runnable {
	int x_pos = 10;
	int y_pos = 100;
	int radius = 20;
	int x_speed = 1;
	int appletsize_x = 300;
	int appletsize_y = 300;
	private Image dbImage;
	private Graphics dbg;
	private Thread th;
	public void init(){
		setBackground (Color.blue);
	}
	public void start(){
		th = new Thread(this);
		th.start();
	}
	public void stop(){
		th.stop();
		th = null;
	}

	public void destroy(){
	}
	/*
		This way of handling mouse events are deprecated since java 1.2
		other mouse events are
			mouseDown(Event,int,int);
			mouseUp(Event,int,int);
			mouseMove(Event,int,int);
			mouseDrag(Event,int,int);
			mouseEnter(Event,int,int);
			mouseExit(Event,int,int);
	*/
	public boolean mouseDown(Event e,int x,int y){
		x_speed = - (x_speed);
		return true;
	}
	/*
		Key events are similar to mouse events
		boolean keyDown(Event e,int key)
		boolean keyUp(Event e,int key)
	*/
	public boolean keyDown(Event e,int key) {
		if(key == e.LEFT) x_speed = -1;
		else if (key == e.RIGHT) x_speed = 1;
		else if(key==32) x_speed = 0;

		return true;
	}
	public void run(){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true){

			if(x_pos > appletsize_x - radius) x_speed = -1;
			else if(x_pos < radius) x_speed = 1;

			// beaming ball
			/*
			if(x_pos > appletsize_x + radius){
				x_pos = -20;
			}*/
			x_pos+=x_speed;
			repaint();
			try {
				Thread.sleep(20);
			} catch(InterruptedException ex){
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillOval(x_pos-radius,y_pos-radius,2*radius,2*radius);
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
}