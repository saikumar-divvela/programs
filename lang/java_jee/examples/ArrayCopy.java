class ArrayCopy {
	public static void main(String[] args) {
		char[] src = {'a','e','i','o','u','x','y','z'};
		char[] dest = new char[10];
		System.arraycopy(src,2,dest,0,4);
		System.out.println(dest);
	}
}