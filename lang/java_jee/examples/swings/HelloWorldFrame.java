import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldFrame {

	public static void createAndShowGUI(){
		JFrame frame = new JFrame();
		JLabel label = new JLabel("Hello World");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(label);
		frame.setSize(300,300);
		//frame.pack();
		frame.setVisible(true);
	}
	public static void main(String args[]){

		javax.swing.SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					createAndShowGUI();
				}
			}
		);
	}
}