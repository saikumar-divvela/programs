public class CardBoard
{
		Short story = 5;

		CardBoard go(CardBoard cb){
				cb = null;
				return cb;
		}
		public static void main(String args[]){
				CardBoard cb1 = new CardBoard();
				CardBoard cb2 = new CardBoard();
				CardBoard cb3 =  cb1.go(cb2);
				System.out.println("cb1:"+cb1.story);
				System.out.println("cb2:"+cb2.story);
				System.out.println("cb3:"+cb3);
		}
}