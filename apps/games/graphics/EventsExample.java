/*

*/

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

public class EventsExample extends Applet implements Runnable,KeyListener,MouseListener,MouseMotionListener{
	private int speed;
	int currentLine;
	private Thread th;
	private Image dbImage;
	private Graphics dbg;

	public void init(){
		setBackground(Color.blue);
		currentLine = 10;
		addKeyListener(this);
	}
	public void start(){
		th = new Thread(this);
		th.start();
	}
	public void stop(){
		th.stop();
		th = null;
	}
	public void keyPressed(KeyEvent e){
		getGraphics().drawString("user pressed key "+e.getKeyChar(),10,currentLine);
		currentLine += 20;
	}
	public void keyReleased(KeyEvent e){
		getGraphics().drawString("user released key "+e.getKeyChar(),10,currentLine);
		currentLine += 20;
	}
	public void keyTyped(KeyEvent e){
	}
	public void mouseClicked(MouseEvent e){
		getGraphics().drawString("user clicked mouse "+e.getClickCount() +" times!",10,currentLine);
		currentLine += 20;
	}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}
	public void mouseEntered(MouseEvent e){
		getGraphics().drawString("mouse entered at "+e.getX(),10,currentLine);
		currentLine += 20;
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseMoved(MouseEvent e){
	}
	public void mouseDragged(MouseEvent e){
	}
	public void destroy(){
	}
	public void run(){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY)	;
		while (true){
			try {
				paint(getGraphics());
				Thread.sleep(speed);
			} catch (InterruptedException ex){
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}
	public void paint(Graphics g){
		if(currentLine > 380){
			g.setColor(Color.blue);
			g.fillRect(0,0,300,300);
			currentLine = 10;
		}
		g.setColor(Color.yellow);
	}
	public void update(Graphics g){

	}
}