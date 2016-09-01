package sss.temp;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

enum Month {
	JAN(30),
	FEB(28),
	MAR(31),
	APR(30),
	MAY(31),
	JUN(30),
	JUL(31),
	AUG(31),
	SEP(30),
	OCT(31),
	NOV(30),
	DEC(31);
	int noOfDays;
	Month(int days){
		noOfDays = days;
	}
	public void printDays() {
		System.out.println(" The month "+this.name()+" has "+noOfDays+ "days");
	} // 

}

public class EnumConstructorDemo {
	public static void main(String[] args){
		for (Month m : Month.values()){
			m.printDays();
		}
		
	}
	
}

