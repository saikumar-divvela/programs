class SuperClass {
	private int index =0 ;
	public void setIndex(int value) {
		this.index = value;
	}
	public int getIndex() {
		return this.index;
	}
	public SuperClass (int index){
		this.index = index;
	}
	public SuperClass() {
	}
}

class ClassDemo extends SuperClass {
	private int subIndex = 0;
	private ClassDemo(int subIndex) {
		super(100);
		this.subIndex = subIndex;
	}
	public ClassDemo(){
	}
	public static void main(String[] args) {
		ClassDemo temp = new ClassDemo(50);
		//temp.setIndex(10);
		System.out.println("index is:"+temp.getIndex());
	}
}