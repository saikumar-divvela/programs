/*
	Applet program
*/
import java.applet.*;
import java.awt.*;

public class FirstApplet extends Applet{
	// standard methods
	// this method is called the first time you enter the HTML site with the applet
	public void init(){
		setBackground (Color.blue);
	}

	// this method is called every time html page is entered
	public void start(){
	}

	// this method is called when u leave the html site with the applet
	public void stop(){
	}

	// this method is called if you leave the page finally (ex: closing browser)
	public void destroy(){
	}
	/* paint method allows to paint into the applet.This method is called if we move the browser or
	   if repaint is called
	*/
	public void paint(Graphics g){
	}
}
