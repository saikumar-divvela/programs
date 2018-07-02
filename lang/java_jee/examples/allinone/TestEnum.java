public class TestEnum {
		public enum Dogs {collie, harrier, shepherd};
				public static void main(String [] args) {
						 Dogs myDog = Dogs.shepherd;
						switch (myDog) {
						case collie:
									System.out.print("collie");
						default:
									 System.out.print("default" );
						case shepherd:
									 System.out.print("shepherd ");
						case harrier:
									 System.out.print("harrier ");
						}
			}
 }