import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Notepad implements  ActionListener {

	JFrame frame;
	JPanel contentPane;
	JTextArea textArea;
	JFileChooser fileChooser;
	String openedFileName;
	String myTitle;
	String currentTitle;
	class MyDocumentListener implements  DocumentListener
	{
		public void insertUpdate(DocumentEvent e){
			System.out.println("insert happenned");
			System.out.println(e.getType().toString());
			frame.setTitle(currentTitle+"*");
		}
		public void removeUpdate(DocumentEvent e) {
			System.out.println("remove happenned");
			System.out.println(e.getType().toString());
			frame.setTitle(currentTitle+"*");
		}

		public void changedUpdate(DocumentEvent e){
			System.out.println("remove happenned");
			System.out.println(e.getType().toString());
			frame.setTitle(currentTitle+"*");
		}
	
	}
	public Notepad(){
		fileChooser = new JFileChooser();
		myTitle ="Xpad";
		currentTitle=myTitle+"-"+"NoTitle";
	}

	public void actionPerformed(ActionEvent e){
		System.out.println("Action:"+e.getActionCommand());
		String command = e.getActionCommand();
		if(command.equalsIgnoreCase("new")) newFile();
		if(command.equalsIgnoreCase("open")) openFile();
		else if(command.equalsIgnoreCase("save")) {
			if(openedFileName==null || openedFileName.equals("")) saveAsFile();
			else saveFile();
		} else if(command.equalsIgnoreCase("saveas")) saveAsFile();
		else if(command.equalsIgnoreCase("exit")) exitPad();
	}

	private void exitPad(){
		
		frame.dispose();
	}
	private void newFile(){
		openedFileName = null;
		textArea.setText("");
		currentTitle=myTitle+"-"+"NoTitle";
		frame.setTitle(currentTitle);
	}
	private void openFile(){
		System.out.println("opening file........");
		int val = fileChooser.showOpenDialog(frame);
		if(val==JFileChooser.APPROVE_OPTION){
			openedFileName = fileChooser.getSelectedFile().getPath();
			BufferedReader br = null;
			try
			{
				File file = new File(openedFileName);
				if(file.exists()){
					textArea.setText("");
					currentTitle = myTitle+"-"+file.getName();
					frame.setTitle(currentTitle);
					br = new BufferedReader(new FileReader(file));
					String line;
					while((line=br.readLine())!=null) {
						textArea.append(line);
						textArea.append("\n");
					}
				}
			}catch (Exception e)
			{
				System.out.println(e);
			} finally{
				try
				{
					if(br!=null) br.close();
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}
	}
	private void saveFile(){
		System.out.println("Saving file.........");	
		BufferedWriter bw = null;
		try
		{
			File file = new File(openedFileName);
			currentTitle = myTitle+"-"+file.getName();
			frame.setTitle(currentTitle);
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(textArea.getText());
		}catch (Exception e)
			{
				System.out.println(e);
			} finally{
				try
				{
					if(bw!=null) bw.close();
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}

	}

	private void saveAsFile(){
		System.out.println("Saving as file..........");		
		int val = fileChooser.showSaveDialog(frame);
		System.out.println(fileChooser.getSelectedFile().getPath());
		if(val==JFileChooser.APPROVE_OPTION){
			openedFileName = fileChooser.getSelectedFile().getPath();
			BufferedWriter bw = null;
			try
			{
				File file = new File(openedFileName);
				currentTitle = myTitle+"-"+file.getName();
				frame.setTitle(currentTitle);
				bw = new BufferedWriter(new FileWriter(file));
				bw.write(textArea.getText());
			}catch (Exception e)
			{
				System.out.println(e);
			} finally{
				try
				{
					if(bw!=null) bw.close();
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}

	}
	public void showGUI(){
		frame = new JFrame(currentTitle);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// we can create contentpane and set it to top level container
		contentPane = new JPanel(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(500,500));
		textArea = new JTextArea();
		textArea.setTabSize(4);
		textArea.getDocument().addDocumentListener(new MyDocumentListener());
		contentPane.add(textArea);

		frame.setJMenuBar(createMainMenu());
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}

	private JMenuBar createMainMenu(){
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;

		menuBar = new JMenuBar();
		menuBar.setOpaque(true); // if true component paints every pixel within its bounds
		menuBar.setBackground(new Color(154, 165, 127));
		menuBar.setPreferredSize(new Dimension(200,20));

		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menuItem = new JMenuItem("New",KeyEvent.VK_N);
		menuItem.addActionListener(this);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_N, ActionEvent.ALT_MASK));
		menu.add(menuItem);
		menuItem = new JMenuItem("Open",KeyEvent.VK_O);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("Save",KeyEvent.VK_S);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("SaveAs",KeyEvent.VK_A);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuItem = new JMenuItem("Exit",KeyEvent.VK_X);
		menuItem.addActionListener(this);
		menu.add(menuItem);
		menuBar.add(menu);

		menu = new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_E);
		menuItem = new JMenuItem("Copy",KeyEvent.VK_C);
		menu.add(menuItem);
		menuItem = new JMenuItem("Cut",KeyEvent.VK_U);
		menu.add(menuItem);
		menuItem = new JMenuItem("Paste",KeyEvent.VK_P);
		menu.add(menuItem);
		menuItem = new JMenuItem("Find",KeyEvent.VK_F);
		menu.add(menuItem);
		menuItem = new JMenuItem("Replace",KeyEvent.VK_R);
		menu.add(menuItem);
		menuBar.add(menu);

		menu = new JMenu("Format");
		menu.setMnemonic(KeyEvent.VK_R);
		menuItem = new JMenuItem("Wrap",KeyEvent.VK_W);
		menu.add(menuItem);
		menuItem = new JMenuItem("Font",KeyEvent.VK_F);
		menu.add(menuItem);
		menuBar.add(menu);


		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menuItem = new JMenuItem("About",KeyEvent.VK_A);
		menu.add(menuItem);
		menuItem = new JMenuItem("Help Topics",KeyEvent.VK_H);
		menu.add(menuItem);
		menuBar.add(menu);

		return menuBar;
	}
	public static void main(String args[]){
		javax.swing.SwingUtilities.invokeLater( new Runnable(){
			public void run(){
				new Notepad().showGUI();
			}

		});
	}
}