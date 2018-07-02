class Employee {
	private String name;
	private String type;
	private int age;
	private int id;
	Employee(String name,String type,int age,int id){
		this.name = name;
		this.type = type;
		this.age = age;
		this.id = id;
	}
	Employee(){
	}
	public String getName(){
		return name;
	}
	public String getType() {
		return type;
	}
	public int getAge(){
		return age;
	}
	public int getId(){
		return id;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Employee Details - ");
		sb.append("Name:"+getName()+" ");
		sb.append("Age:"+getAge()+" ");
		sb.append("Id:"+getId()+" ");
		sb.append("Type:"+getType());
		return sb.toString();
	}
	public void setName(String name){
		this.name = name;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setId(int id){
		this.id = id;
	}
}
