import javax.swing.*;
class Rectangle
{
    private int length;
    private int width;

    public Rectangle(int l,int w)
    {
		length = l;
		width = w;
    }

    public Rectangle(){

	}
    public void setRectangle(int L, int W)
    {
      setLength(L);
      setWidth(W);
    }

    public void setWidth(int W)
    {
        width=W;
    }

    public void setLength(int L)
    {
        length=L;
    }

    public int getWidth()
    {
        return width;
    }

    public int getLength()
    {
        return length;
    }

}
public class TestRectangle {
	public static void main (String[]args) throws Exception
    {
        Rectangle r=new Rectangle(5,10);
        System.out.println("Perimter of the rectangle:"+ (r.getLength()+r.getWidth())*2);
        System.out.println("Area of rectangle:"+r.getWidth()*r.getLength());

    }
}



