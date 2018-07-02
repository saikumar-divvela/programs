import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.PrintWriter ;
import java.io.IOException ;
import foo.Person;
import java.util.ArrayList;
import java.util.List;

public class  PersonServlet extends HttpServlet
{
	public PersonServlet(){
		System.out.println("constructor");
	}
	public void init(){
		System.out.println("init method");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
			PrintWriter  out = res.getWriter();
			String userName = req.getParameter("username");
			List<Person> personList = new ArrayList<Person>();

			Person p = new Person();
			p.setName("Jessica");
			Person friend = new Person();
			friend.setName("cathy");
			friend.setEmail("waytohell@skynet.com");
			p.setFriend(friend);
			req.setAttribute("person",p);
			personList.add(p);

			p = new Person();
			p.setName("britney");
			friend = new Person();
			friend.setName("megafox");
			friend.setEmail("waytoheaven@skynet.com");
			p.setFriend(friend);
			personList.add(p);
			req.setAttribute("persons",personList);

			List nums = new ArrayList();
			nums.add("1");
			nums.add("2");
			nums.add("3");
			req.setAttribute("numbers",nums);
			String music[] ={"Rahman","Keera Vani","Mani Sharma","Patnayak"};
			req.setAttribute("musicList",music);
			//out.write("hello");
			System.out.println("just before forwarding request");
			req.getRequestDispatcher("/WEB-INF/jsp/friendData.jsp").forward(req,res);	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		doGet(req,res);		
	}
}