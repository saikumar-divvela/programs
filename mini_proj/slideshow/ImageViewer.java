package com.sss.slideshow;

/**
 *    This program enables to select one or multiple images in file system and run them as slide show.
 *    
 *    Dead line: Dec 31st
 *    
 *    To do
 *    
 *    HP
 *    respond to menu button
 *    Full view/ Normal view  
 *    set slide show time from menu
 *    Rotate    
 *    
 *    LP
 *    Creation of jar or package
 *    
 *    
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;


class ImagePanel extends JPanel  {
	private Image image;
	private int sleepTime ;
	private int currentIndex;
	private int totalImages;
	private ArrayList<String> imgFiles;
	private boolean runSlideShow;
	private Frame frame;
	private GraphicsDevice vc;
	
	public ImagePanel(String imgFileName,Frame frame){
		displayImage(imgFileName);
		this.frame = frame;
	}
	
	public ImagePanel(Frame frame){
		this.frame = frame;
		reset();
	}
	
	public void reset(){
		sleepTime = 3000;
		currentIndex = -1;
		imgFiles = new ArrayList<String>();
		totalImages = 0;
		runSlideShow = false;
	}
	
	/*
	 
	 when clicks next slide show should stop
	 
	 
	 
	 */
	
	public void startSlideShow(){
		SwingWorker worker = new SwingWorker<Boolean,Void>(){
			@Override
			public Boolean doInBackground (){
				runSlideShow = true;
				while(runSlideShow && isNextImageAvailable())
					showNextImage(false);
				return true;
			}
		};
		worker.execute();
	}
	
	public void stopSlideShow(){
		runSlideShow = false;
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println("painting");
		Dimension d= getSize();
		g.drawImage(image, 0, 0,d.width,d.height,null);
	}
	
	public void setFullScreen(){
		vc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		this.frame.setResizable(false);
		vc.setFullScreenWindow(this.frame);
		//this.frame.setFocusable(true);
		this.frame.setFocusable(true);
		this.frame.requestFocus();
		//vc.set
	}
	
	public void restoreScreen(){
		vc.setFullScreenWindow(null);
		this.frame.setResizable(true);
		
	}
	
	private void displayImage(String fileName){
		try {
			image = ImageIO.read(new File(fileName));
		} catch(Exception e){
			System.out.println("Exception in reading the image "+e.getMessage());
			e.printStackTrace();
		}
		if(image == null) return;
		this.frame.setTitle(fileName);
		this.revalidate();
		this.repaint(200);
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void runShow(File[] files){
		reset();
		this.imgFiles = getImagefiles(files);
		this.totalImages = imgFiles.size();
		startSlideShow();
	}
	

	public void runShow(String fileName){
		displayImage(fileName);
	}
	
	private boolean isNextImageAvailable(){
		//System.out.printf("ci %d  ti %d \n",currentIndex,totalImages);
		return currentIndex +1 < totalImages;
	}
	
	private boolean isPreviousImageAvailable(){
		//System.out.printf("ci %d  ti %d \n",currentIndex,totalImages);
		return currentIndex > 0;
	}
	
	private void showNext(){
		if(isNextImageAvailable()){
			currentIndex++;
			displayImage(imgFiles.get(currentIndex));
		}
	}
	
	public void  showNextImage(boolean isBtnClick){
		if(isBtnClick){
			runSlideShow = false;
			SwingWorker worker = new SwingWorker<Boolean,Void>(){
				@Override
				public Boolean doInBackground(){
					showNext();
					return true;
				}
			};
			worker.execute();
			
		} else {
			showNext();
		}
	
	}

	private int showPrevious(){
		if(isPreviousImageAvailable()){
			currentIndex--;
			displayImage(imgFiles.get(currentIndex));
		}
		return isPreviousImageAvailable()?1:0;
	}
	
	// returns 0 if this is the first image
	public void  showPreviousImage(boolean isBtnClick){
		if(isBtnClick){
			runSlideShow = false;
			SwingWorker worker = new SwingWorker<Boolean,Void>(){
				@Override
				public Boolean doInBackground(){
					showPrevious();
					return true;
				}
			};
			worker.execute();
			
		} else {
			showPrevious();
		}
	}
	
	private ArrayList<String> getImagefiles(File[] files){
		ArrayList<String> imgFiles = new ArrayList<String>();
		if(files == null ){
			return imgFiles;
		}
		for(File f1: files){
			if(f1.exists() && f1.isDirectory()){
				File dirFiles[] = f1.listFiles();
				for(File f2: dirFiles){
					if(f2.isFile()){
						imgFiles.add(f2.getAbsolutePath());
						System.out.println(f2.getAbsolutePath());
					}
				}
			} else if(f1.exists() && f1.isFile()){
				imgFiles.add(f1.getAbsolutePath());
			}
		}
		return  imgFiles;
	}
}

class ImageFilter extends FileFilter {
	
	public boolean accept(File f){
		
		if(f== null || !f.exists()){
			return false;
		}
		
		if( f.isDirectory()){
			return false;
		}
		
		if(f.isFile()){
			
			String ext = null; 
			int i= f.getName().lastIndexOf(".");
			if(i >0 && i< f.getName().length()-1){
				ext = f.getName().substring(i+1).toLowerCase();
			}
			if(ext.equals("jpg")
				|| ext.equals("jpeg")
				|| ext.equals("tiff")
				|| ext.equals("tif")
				|| ext.equals("png")
				|| ext.equals("gif")
				|| ext.equals("bmp")
			){
				return true;
			}
		}
		
		return false;
	}
	
	public String getDescription(){
		return "JPG, TIFF ,PNG and GIF Images";
	}
}
public class ImageViewer extends JFrame implements KeyListener{

	ImagePanel panel = null;
	JFileChooser fc = null;
	
	
	public ImageViewer(){
		
		initUI();
	}
	
   /*
	public void paint(Graphics g){
		initUI();
	}
	*/
	
	private void initUI(){
		
		
		setTitle("Slide Show");
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		this.addKeyListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem menuItemOpen = new JMenuItem("Open");
		JMenuItem menuItemFS = new JMenuItem("Full Screen");
		
		menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		menuItemOpen.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int returnVal = fc.showOpenDialog(null);
					if(returnVal == fc.APPROVE_OPTION){
						File[] files = fc.getSelectedFiles();
						panel.runShow(files);
					}
				}
			});
		
		
		
		menuItemFS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		menuItemFS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.setFullScreen();
			}
		});
		
		fileMenu.add(menuItemOpen);
		fileMenu.add(menuItemFS);
		
		
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);
		
		
		JToolBar toolbar = new JToolBar();
		toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
		toolbar.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		
		JButton next = new JButton("Next");
		JButton prev = new JButton("Prev");
		JButton run = new JButton("Run");
		JButton stop = new JButton("Stop");
		JButton stopfs = new JButton("stopfs");
		
		
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.showNextImage(true);
			}
		});
		
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.showPreviousImage(true);
			}
		});
		
		run.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.startSlideShow();
			}
		});
		
		stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.stopSlideShow();
			}
		});
		
		
		stopfs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.restoreScreen();
			}
		});
		

		
	
		
		
		toolbar.add(next);
		toolbar.add(prev);
		toolbar.add(run);
		toolbar.add(stop);
		toolbar.add(stopfs);
		
		
		
		add(toolbar, BorderLayout.SOUTH);
		

		
		
		panel = new ImagePanel(this);
		//panel.setFocusable(true);
		
		add(panel);
		
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setMultiSelectionEnabled(true);
		fc.setAcceptAllFileFilterUsed(false);
		fc.setFileFilter(new ImageFilter());
		
		setVisible(true);
	}
	
	
	
	public void keyTyped(KeyEvent e) {
		System.out.println("Key Typed");
		System.out.println(e.getID());
		System.out.println(e.getExtendedKeyCode());
		System.out.println(e.getKeyChar());
		System.out.println(e.getKeyCode());
		System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Released");
		System.out.println(e.getID());
		System.out.println(e.getExtendedKeyCode());
		System.out.println(e.getKeyChar());
		System.out.println(e.getKeyCode());
		System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
	}

	
	public static void main(String[] args) throws Exception {
		ImageViewer sh = new ImageViewer();
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		System.out.println("done");
	}


}
