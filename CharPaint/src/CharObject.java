
public class CharObject {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int newX) {
		if(x>0 || x < 750) {
			x = newX;
		}
	}
	public void setY(int newY) {
		if(x>0 || x < 750) {
			y = newY;
		}	
	}
}
