class Car {
		int speed=0;
		int gear=1;
		void changeGear(int newGearValue) {
			this.gear = newGearValue;
		}
		void speedUp(int value){
			this.speed += value;
		}
		void printState() {
			System.out.println("Status: speed="+speed+" gear="+gear);
		}
}
public class CarDemo {
	public static void main(String args[]){
		Car car1 = new Car();
		Car car2 = new Car();
		car1.changeGear(3);
		car1.speedUp(20);
		car1.printState();
		car2.changeGear(2);
		car2.speedUp(30);
		car2.printState();
	}
}