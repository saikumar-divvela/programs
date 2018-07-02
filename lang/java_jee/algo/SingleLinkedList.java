/*
	Program for Single Linked List
*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
class genericFn
{
	static int readInt() throws Exception{
		int n;
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(stdin);
		return (Integer.parseInt(bReader.readLine()));
	}
	static void showMenu(){
		System.out.println();
		System.out.println("1)Add item");
		System.out.println("2)Delete item");
		System.out.println("3)Add item at First");
		System.out.println("4)Search item");
		System.out.println("5)Display list");
		System.out.println("6)exit ");
		System.out.print("Enter your choice:");
	}
}
public class SingleLinkedList
{
	private class List
	{
		int num;
		List next;
		List(){
			next = null;
		}
	}
	List list;
	SingleLinkedList(){
		list = new List();
	}
	private List createNode(int n){
		List data = new List();
		data.num = n;
		return data;
	}
	public void add(int n){
		List temp = list;
		while(temp.next!=null) temp = temp.next;
		temp.next = createNode(n);
	}
	public boolean delete(int n){
		List temp = list; 
		while(temp.next!=null){
			System.out.println("inside delete:"+temp.next.num);
			if(temp.next.num ==n) {
				temp.next = temp.next.next;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	public void addFirst(int n){
		List temp = list;
		List data = createNode(n);
		data.next = temp.next;
		list.next = data;
	}
	public boolean search(int n){
		List temp = list.next;
		while(temp!=null){
			if (temp.num == n) return true;
			temp = temp.next;
		}
		return false;
	}
	public void show(){
		List temp = list.next;
		if(temp == null) System.out.println("List is empty");
		while(temp!=null) {
			System.out.print(" "+temp.num);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public String toString(){
		List temp = list.next;
		StringBuffer sb = new StringBuffer();
		if(temp == null) sb.append("List is empty\n");
		while(temp!=null) {
			sb.append(" "+temp.num);
			temp = temp.next;
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public static void main(String args[]) throws Exception{
		SingleLinkedList list = new SingleLinkedList();
		int choice,data;
		while(true){
			genericFn.showMenu();
			choice = genericFn.readInt();
			switch(choice){
				case 1: System.out.print("Enter data:");
					data = genericFn.readInt();	
					list.add(data);
					break;
				case 2: System.out.print("Enter data:");
					data = genericFn.readInt();	
					if (list.delete(data)) System.out.println(data+" deleted");
					else System.out.println(data+" not deleted");
					break;
				case 3: System.out.print("Enter data:");
					data = genericFn.readInt();	
					list.addFirst(data);
					break;
				case 4: System.out.print("Enter data:");
					data = genericFn.readInt();	
					if (list.search(data)) System.out.println(data+" found");
					else System.out.println(data+" not found");
					break;
				case 5: System.out.print("List: ");
					//list.show();
					System.out.println(list.toString());
					break;
				case 6: System.exit(0);
					break;
				default:System.out.println("Enter proper choice:");
					break;
			}
		}
	}
}
