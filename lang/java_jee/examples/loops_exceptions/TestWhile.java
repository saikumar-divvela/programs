public class TestWhile
{
			public static void main(String args[]){
				int age =1;
				outer:
				while(age<=21){
					if(age == 16){
						System.out.println("Get your driving liscense");
						break outer;
					}
					System.out.println("Another Year");
					age++;
				}
			}
}