package sss.temp;

enum Day {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY;
		}
public class EnumTest {
	Day day;
	EnumTest(Day day){
		this.day  = day;
	}
	void setDay(Day day){
		this.day = day;
	}
	void printDay(){
		switch(day){
			case SATURDAY:
			case SUNDAY:
					System.out.println("Today is holiday");
					break;
			case MONDAY:
			case TUESDAY:
			case WEDNESDAY:
			case THURSDAY:
			case FRIDAY:
					System.out.println("Today is a week day");
					break;
			/* default:
					System.out.println("invalid day");*/
		}
	}
	public static void main(String[] args) {
		EnumTest today = new EnumTest(Day.SUNDAY);
		today.printDay();
		today.setDay(Day.WEDNESDAY);
		today.printDay();
		System.out.println("All the Days");
		for(Day day : Day.values()){
			System.out.println(day);
		}
		
	}
}
