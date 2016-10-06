
public class Rectangle {
	private int mLength;
	private int mWidth;
	
	public Rectangle(int width, int length){
	
		mWidth = width;
		
		mLength = length;
	}
	
	public int getArea(){
		return this.mLength * this.mWidth;		
	}
	
	public int getLength(){
		return this.mLength;
	}
	
	public int getWidth(){
		return this.mWidth;
	}
	
	public boolean isSquare(){
		return (this.mLength == this.mWidth);
	}
	
	public boolean isSmaller(Rectangle rect){
		return this.getArea() < rect.getArea();
	}
	
	public static void main(String[] args){
		Rectangle rectangle1 = new Rectangle(3, 5);
		Rectangle rectangle2 = new Rectangle(4, 6);
		System.out.println(rectangle1.getArea());
		System.out.println(rectangle2.getArea());
		System.out.println(rectangle1.isSmaller(rectangle2));
	}
	
}
