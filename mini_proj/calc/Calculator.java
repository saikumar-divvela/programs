package com.sss.calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent;

public class Calculator extends JFrame  {

	public Calculator (String title){
		super (title);
	}
	
	public void showGUI() {
		
		
		
		JTextArea textBox = new JTextArea(4,20);
		textBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textBox.setFont(new Font("couriernew",Font.BOLD,13));
		textBox.setLineWrap(true);
		textBox.setText("0");
		textBox.setFocusable(false);
		
		JButton clickBtn  = new JButton("Show Text");
		clickBtn.setActionCommand("SHOW");
		clickBtn.addActionListener(new buttonListener(textBox));	
		//clickBtn.setBackground(Color.GRAY);
		
		JButton clearBtn  = new JButton("Clear");
		clearBtn.setActionCommand("CLEAR");
		clearBtn.addActionListener(new buttonListener(textBox));	
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
	    panel.add(textBox);
		panel.setBackground(Color.BLUE);	
		String btnValues[] = new String[] {"\u2190","CE","C","1/x","x"+"\u207F","7","8","9","\u00B1","\u221A","4","5","6","/","*","1","2","3","+","-","0","=","."};

		for(int i=0; i<btnValues.length;i++){
			JButton button =  new JButton(btnValues[i]);
			
			if(btnValues[i].equals("0") || btnValues[i].equals("=")){
				button.setPreferredSize (new Dimension(95,45));
			} else {
				button.setPreferredSize (new Dimension(45,45));
			}
			button.setMargin(new Insets(0,0,0,0));
			button.setFont(new Font("sansserif",Font.BOLD,12));
			button.setFocusable(false);
			button.addActionListener(new buttonListener(textBox));	
			panel.add(button);
		}
		

		Container content = getContentPane();
		content.add(panel);
		//content.setBackground(Color.BLUE);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400,200);
		setPreferredSize(new Dimension(260,360));
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String args[]){
		Calculator cal = new Calculator("Simple Calculator");
		cal.showGUI();
	}
}

class buttonListener implements ActionListener {
	JTextArea textField = null;
	String command = null;
	public buttonListener( JTextArea textComp){
		textField = textComp;
	}
	
	public void actionPerformed(ActionEvent e) {
		command = e.getActionCommand();
		System.out.println("Button click command :"+ command);
		calcData.getInstance().process(textField,command);
	}
	
	
}


class calcData {
	private static String instructions;
	private static long param1;
	private static long param2;
	private static long result;
	private static String cmd;
	private static calcData instance = new calcData();
	private static boolean clearFlag;
	
	private calcData (){
		reset();
	}	
	
	public static void reset(){
		instructions = "";
		param1 =  0;
		param2 = 0;
		cmd =  "";
		result = 0;
		clearFlag = true;
	}
	
	public static void print (){
		System.out.println("Instrcution :"+instructions+ " Param1 :"+param1+" Param2 :"+param2+" result :"+result+" cmd :"+cmd+" clearFlag :"+clearFlag);
	}
	
	public static void process(JTextArea textField, String  key){
		if(key.equalsIgnoreCase("CE") || key.equals("\u2190") || key.equals("C")){
			textField.setText("0");
			reset();
		} else if (key.equals("+") || key.equals("-") || key.equals("*") || key.equals("/") || key.equals("x"+"\u207F") ){
			//result = param1;  
			// 2 + 3   + 5
			// 0 + 5 * 2
			// 48 + -
			if(!cmd.equals("")){
				param2 = Integer.parseInt(textField.getText());
				calculate();
				textField.setText(""+result);
			} else {
				param1 = Integer.parseInt(textField.getText());
			}
			cmd = key;
			clearFlag = true;
		} else if (key.equals("\u00B1")){ // + - symbol
			if(textField.getText() !=  null && !textField.getText().equals("0")){
				long val = Integer.parseInt(textField.getText());
				val= val * -1;
				textField.setText(""+val);
				if(!cmd.equals("")){
					param1 = Integer.parseInt(textField.getText());
				}
			}
		} else if (key.equals("\u221A")){  // square root function
			if(textField.getText() != null && !textField.getText().equals("0")){
				long val = (long)Math.sqrt(Integer.parseInt(textField.getText()));
				result = val;
				textField.setText(""+val);
			}
			clearFlag = true;
		} else if(key.equals("1/x")){
			if(textField.getText() != null && !textField.getText().equals("0")){
				long val = 1 / (Integer.parseInt(textField.getText()));
				textField.setText(""+val);
			}
			cmd = "";
			clearFlag = true;
		} else if(key.equals(".")){

		} else if (key.equals("=")){
			param2 = Integer.parseInt(textField.getText());
			calculate();
			textField.setText(""+result);
			cmd = "";	
			clearFlag = true;
		} else {
			if(clearFlag){
				textField.setText(null);
				clearFlag = false;
			}
			textField.append(key);
		}
		print();
		System.out.println("key :"+key);
	}

	
	public static void calculate (){
		if (cmd.equals("+")){
			result = param1 + param2;
			param1 =  result;
		} else if (cmd.equals("-")){ 
			result = param1 - param2;
			param1 =  result;
		} else if (cmd.equals("*")){ 
			result = param1 * param2;
			param1 =  result;
		} else if (cmd.equals("/")){ 
			result = param1/param2;
			param1 =  result;
		} else if (cmd.equals("x"+"\u207F")){
			result = (long)Math.pow(param1,param2);
			param1 =  result;
		}
	}
	public static calcData getInstance(){
		if(instance == null){
			instance = new calcData();
		}
		return instance;
	}
}
