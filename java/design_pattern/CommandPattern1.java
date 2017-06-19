package com.sss.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 This pattern is used to encapsulate a request as an object and pass to invoker. The invoker doesn't know how to service 
 the request but uses encapsulated command to perform action.
	
	when needed
		used for call back methods	
	how implemented
		command is an interface with execute method
		Receiver is the actual object that knows the actual steps to perform the action
		Command implementation is the binding between receiver and action
		Client creates an instance of command implementation and associates with receiver
		An invoker instructs the command to perform an action
		
	
	example:
		Java API, runnable and swing action follows command design pattern

 */
public class CommandPattern1 {
	public static void main(String args[]){
		RemoteControl rc = new RemoteControl();
		ConsumerElectronics ce = RemoteControl.getActiveDevice();
		Command oc = new OnCommand(ce);
		
		List<ConsumerElectronics> list = new ArrayList<ConsumerElectronics>();
		list.add(new Television());
		list.add(new SoundSystem());
		Command m = new MuteAllCommand(list);
		
		// tv on
		rc.setCommand(oc);
		rc.click();
		
		//	mute tv + sound system
		rc.setCommand(m);
		rc.click();
	}
}

// command interface

interface Command {
	public void execute();
}


interface ConsumerElectronics {
	public void on();
	public void mute();
}

// command implementation 1
class OnCommand implements Command {
	private ConsumerElectronics ce;
	OnCommand(ConsumerElectronics ce){
		this.ce = ce;
	}
	public void execute(){
		ce.on();
	}
}

//command implementation 2
class MuteAllCommand implements Command {
	private List<ConsumerElectronics> ceList;
	MuteAllCommand(List<ConsumerElectronics> ce){
		this.ceList = ce;
	}
	public void execute(){
		for(ConsumerElectronics ce:ceList){
			ce.mute();
		}
	}
}

// Receiver 1
class  Television implements ConsumerElectronics{
	
	public void on(){
		System.out.println("Television is on");
	}
	
	public void mute(){
		System.out.println("Televsion is mute");
	}
}

//Receiver 2
class SoundSystem implements ConsumerElectronics {
	public void on(){
		System.out.println("Sound system is on");
	}
	
	public void mute(){
		System.out.println("Sound system is mute");
	}
}

// command invoker
class RemoteControl {
	Command c;
	public void setCommand(Command c){
		this.c = c;
	}
	public void click(){
		c.execute();
	}
	public static ConsumerElectronics getActiveDevice(){
		return new Television();
	}
}	

