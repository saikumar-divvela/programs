/*
	This class is used to generate books.xml
*/
class Book{
	private String subject;
	private String author;
	private String title;
	Book(String subject,String author,String title){
		this.subject = subject;
		this.author = author;
		this.title = title;
	}
	Book(){
	}
	public String getSubject(){
		return subject;
	}
	public String getAuthor(){
		return author;
	}
	public String getTitle(){
		return title;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
	public void setAuthor(String author){
		this.author = author;
	}
	public void setTitle(String title){
		this.title = title;
	}
}