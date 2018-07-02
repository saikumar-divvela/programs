/*
	equals() & hashCode() example
*/

public class equalsTest
{
	public static void main(String args[]){
		Data data1 = new Data(7);
		Data data2 = new Data(7);
		System.out.println(data1.equals(data2));
	}
}

class Data{
	private int value;
	Data(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	public boolean equals(Object obj){
		System.out.println("calling overriden function");
		if( obj instanceof Data){
			return (((Data)obj).value== value);
		}
		return false;
	}

	public boolean equals(Data obj){	
		System.out.println("calling overloaded function");
		return (obj.value== value);
	}

	public int hashCode(){
		return (value);
	}
}