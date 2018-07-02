package foo;

import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class Person implements  HttpSessionBindingListener
{
	
	private String name;
	private String email;
	private Person friend;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return  email;
	}

	public Person  getFriend(){
		return this.friend;
	}

	public void setFriend(Person friend){
		this.friend = friend;
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("(name:"+this.name).append("  ").append(" email :"+this.email+")");
		return sb.toString();
	}

	public  void valueBound  (HttpSessionBindingEvent event){
		System.out.println("bounding attribute to session  name:"+event.getName()+" value:"+event.getValue());
	}
	public void  valueUnbound (HttpSessionBindingEvent event) {
		System.out.println("unbounding  attribute from  session  name:"+event.getName()+" value:"+event.getValue());
	}
}