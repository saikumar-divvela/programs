import java.util.List;
import java.util.ArrayList;

class  Animal
{
	void show(){
		System.out.println("i am an animal");
	}
}

class Dog extends Animal
{
	void show(){
		System.out.println("i am a  dog");
	}
}
public class TestWildcard
{
		void process(List<Animal> animalList){
				System.out.println("adding animal");
				animalList.add(new Animal());
				System.out.println("adding dog");
				animalList.add(new Dog());
		}
		public static void main(String args[]){
				TestWildcard tw = new TestWildcard();
				List<Animal> animalList = new ArrayList<Animal>();
				List<Dog> dogList = new ArrayList<Dog>();
				tw.process(animalList);
				//tw.process(dogList);
				
				for(Animal a: animalList){
						a.show();
				}
		}
}