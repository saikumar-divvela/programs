import javax.swing.*;
public class HelloWorldSwing {
	private static void createAndShowGUI(){
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Hello World");
		// default content pane is a container that inherits from JComponent and uses BorderLayout
		// as layout manager
		frame.getContentPane().add(label);
		frame.pack(); // causes the window to fit preferred size
		frame.setVisible(true);
	}

	public static void main(String args[]){
		/*
			run method has to be executed asynchronously on the AWT event dispatching thread.
			This will happen after all pending AWT events are processed.

		*/
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}