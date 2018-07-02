import java.io.*;

class Car implements Serializable
{
	String model;
	String makeYear;
	int  maxSpeed;
	boolean autoGear;
	Engine engine;
	private transient Audio audio;

	public Car(){
		this.model ="junk";
		this.makeYear ="10000BC";
		this.maxSpeed = 10;
		autoGear = false;
		this.engine = new Engine();
		this.audio = new Audio();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("model :"+model);
		sb.append(" makeYear:"+makeYear);
		sb.append(" maximumSpeed :"+maxSpeed);
		sb.append(" autoGear:"+autoGear);
		sb.append(" \n engine state:");
		sb.append(" engine model :"+engine.type);
		sb.append(" front engine :"+engine.frontEngine);
		sb.append(" \n Audio System details:");
		sb.append(" model:"+audio.model);
		sb.append(" supports DVDs :"+audio.isDVDPlayer);
		return sb.toString();
	}

	private void writeObject(ObjectOutputStream os) 
	{
		try
		{
			System.out.print(" came to customized writeObject");
			os.defaultWriteObject();
			os.writeObject(audio.model);
			os.writeBoolean(audio.isDVDPlayer);
		}
		catch (IOException exp)
		{
			System.out.println(exp.getMessage());
		}
	}
	
	private void  readObject(ObjectInputStream is) 
	{
		try
		{
			System.out.print(" came to customized readObject");
			is.defaultReadObject();
			this.audio = new Audio();
			audio.model = (String)is.readObject();
			audio.isDVDPlayer = is.readBoolean();
		}
		catch (IOException exp)
		{
			System.out.println(exp.getMessage());
		}
		catch (ClassNotFoundException exp)
		{
			System.out.println(exp.getMessage());
		}
	}
}
class Engine implements Serializable
{
	String type;
	boolean frontEngine;
	public Engine()
	{
		this.type ="v4";
		frontEngine = true;
	}
}

class Audio
{
	String model;
	boolean isDVDPlayer;
	public Audio(){
		model = "sony";
		isDVDPlayer = true;
	}
}
public class SerializeCar
{
	public static void main(String args[]){
		File file = null;
		Car car = null;
		try{
			file = new File("test4.se");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			car = new Car();
			System.out.println("before serializing car state:"+car);
			oos.writeObject(car);
			oos.close();
		} catch(IOException exp){
			System.out.println(exp.getMessage());	
		}
		try
		{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Car car1 = (Car) ois.readObject();
			System.out.println("after  deserializing car state:"+car1);
		}
		catch(IOException exp){
			System.out.println(exp.getMessage());	
		}
		catch(ClassNotFoundException exp){
			System.out.println(exp.getMessage());	
		}
	}
}