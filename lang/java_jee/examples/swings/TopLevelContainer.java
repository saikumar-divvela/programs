/*
	Top level containers JFrame, JDailog, JApplet
	Any GUI component to be displayes has to be added to top level container
	Each top level container has a content pane , which displays GUI components
	We can add option menu bar to the top level container
*/
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class TopLevelContainer{

	public static void createAndShowGUI(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(10,200,0));
		menuBar.setPreferredSize(new Dimension(200, 20));

		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Edit");

		menuBar.add(menu1);
		menuBar.add(menu2);

		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(new Color(100,10,0));
		label.setPreferredSize(new Dimension(200,180));

		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(label,BorderLayout.CENTER);
		frame.setTitle("Frame Example");

		frame.pack();
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