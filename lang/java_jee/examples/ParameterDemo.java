class Point {
	private int x=10,y=20;

	public void setX(int x){
		this.x =x;
	}
	public void setY(int y){
		this.y =y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void printDetails(){
		System.out.println("location (x,y) -> ("+x+","+y+")");
	}
}
class ParameterDemo {
	public void movePoint(Point myPoint,int x,int y){
		myPoint.setX(x);
		myPoint.setY(y);
		myPoint = new Point();
	}
	public static void main(String args[]){
		ParameterDemo pdemo = new ParameterDemo();
		Point myPoint = new Point();
		myPoint.printDetails();
		pdemo.movePoint(myPoint,20,30);
		myPoint.printDetails();

	}
}