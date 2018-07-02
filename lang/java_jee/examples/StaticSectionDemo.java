class StaticSectionDemo {
	private static int dummy = initializeDummy();
	static {
		dummy =20;
	}
	private static int initializeDummy() {
		dummy = 50;
		return dummy;
	}
	public void printData() {
			System.out.println("dummy:"+dummy);
	}
	public static void main(String[] args) {
		StaticSectionDemo staticDemo = new StaticSectionDemo();
		staticDemo.printData();
		staticDemo.initializeDummy();
		staticDemo.printData();
	}
}