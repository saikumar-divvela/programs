import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;
import java.util.Properties;
import java.util.Enumeration;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.net.URLEncoder;



public class bullitenBoard extends HttpServlet {

	String filePath;
	public void init(ServletConfig config)
					throws ServletException	{
		super.init(config);
		filePath = config.getInitParameter("FilePath");
		if(filePath==null) {
			filePath = "/";
		}
		ServletContext context = getServletContext();
		System.out.println("Context parameter:"+context.getInitParameter("companyName"));
		System.out.println("servlet is initialized");
		System.out.println("filePath:"+filePath);
	}

	public void destroy(){
		System.out.println("servlet is destroyed");
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException {

		FileInputStream fileTopics = null;
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		try {
			fileTopics = new FileInputStream(filePath+"Topics.properties");
			out.println("<html>");
			out.println("<head><title>Bulliten Board</title></head>");
			out.println("<body>");
			out.println("<h3>List of bulliten topics</h3>");
			Properties properties = new Properties();
			properties.load(fileTopics);
			Enumeration topicKeys = properties.propertyNames();
			out.println("<FORM method=\"POST\">");
			out.println("<select name=\"TOPIC\">");
			while (topicKeys.hasMoreElements() ) {
				String topicKey =(String)topicKeys.nextElement();
				String topicValue = properties.getProperty(topicKey);
				System.out.println("Name"+topicKey+"Value:"+topicValue);
				System.out.println("Current Topic:"+req.getParameter("curTopic"));
				if(req.getParameter("curTopic")!=null && req.getParameter("curTopic").equals(topicValue)){
					System.out.println(" Current Topic is equal to Topic");
					out.println("<option SELECTED>"+topicValue+"</option>");
				} else {
					out.println("<option>"+topicValue+"</option>");
				}
			}
			out.println("</select> </br> </br> </br>");
			out.println("<INPUT TYPE=\"SUBMIT\" NAME = \"VIEW\" VALUE =\"VIEW BULLITEN\">");
			out.println("<INPUT TYPE=\"SUBMIT\" NAME = \"POST\" VALUE =\"POST BULLITEN\">");
			out.println("</body>");
			out.println("</html>");
			out.println("</FORM>");
		} catch (Exception e) {
			System.out.println("Exception occured:"+e.getMessage());

		} finally {
			fileTopics.close();
			out.close();
		}
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException {
			String curTopic = "";
			String servletPath = "/servlets-examples"+req.getServletPath();
			String file="";
			PrintWriter out = res.getWriter();

			curTopic = req.getParameter("TOPIC");
			file = filePath+curTopic+".txt";
			try {
				out.println("<HTML>");
				if(req.getParameter("VIEW")!=null){
					out.println("<HEAD><TITLE>"+req.getParameter("VIEW")+"</TITLE></HEAD>");
					out.println("<BODY>");
					out.println("<h3>Bulliten Board-"+curTopic+"</h3>");
					showBullitens(out,curTopic,file);
				}else if(req.getParameter("POST")!=null) {
					out.println("<HEAD><TITLE>"+req.getParameter("POST")+"</TITLE></HEAD>");
					out.println("<BODY>");
					out.println("<h3>Bulliten Board-"+curTopic+"</h3>");
					postBulliten(out,curTopic);
				} else {
					saveBulliten(out,curTopic,file,req);
				}
				out.println("<BR>");
				out.println("<A HREF=\""+servletPath+"?curTopic=" +java.net.URLEncoder.encode(curTopic)+"\">Return to Main Page</A>");
				out.println("</BODY></HTML>");
			} catch (Exception e) {
				System.out.println("Exception occurred in handling POST");
			} finally {
				out.close();
			}
	}

	public void showBullitens(PrintWriter out,String curTopic,String file){
		FileReader fr = null;
		BufferedReader br = null;
		try{
			File fileTopic = new File(file);
			if(fileTopic.exists()){
				fr= new FileReader(fileTopic);
				br= new BufferedReader(fr);
				out.println("<h3>View bullitens</h3>");
				String line = br.readLine();
				while(line!=null){
					out.println(line+"<BR>\n");
					line = br.readLine();
				}
			}else {
				out.println("Currently this topic doesn't contain any comments");
			}
		}catch (Exception e){
			System.out.println("Exception occurred in displaying the bulliten comments:"+e.getMessage());
		}finally {

		}
	}
	public void postBulliten(PrintWriter out,String curTopic){
		out.println("Enter comments");
		out.println("<FORM METHOD=\"POST\">");
		out.println("<TEXTAREA NAME=\"COMMENTS\" ROWS=\"3\" COLS=\"75\"></TEXTAREA>");
		out.println("<BR><BR>");
		out.println("<INPUT TYPE=\"SUBMIT\" NAME=\"STORE\" VALUE=\"SAVE BULLITEN\">");
		out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"TOPIC\" VALUE=\""+curTopic+"\">");
		out.println("</FORM>");
	}
	public void saveBulliten(PrintWriter out,String curTopic,String fileName,HttpServletRequest req)
		throws IOException {
		String servletPath = "/servlets-examples"+req.getServletPath();
		FileWriter fw= null;
		PrintWriter pw=null;
		try {
			fw = new FileWriter(fileName,true);
			pw = new PrintWriter(fw);
			pw.println("------------------------------");
			pw.println(req.getParameter("COMMENTS"));
			out.println("Comments for Bulliten \""+curTopic+"\"are saved");
			out.println("<BR>");
		} catch(Exception e){
			System.out.println("Exception occurred 	in saving the bulliten comments");
		}	finally {
			pw.flush();
			pw.close();
			fw.close();
		}
	}
}