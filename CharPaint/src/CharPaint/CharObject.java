package CharPaint;

public class CharObject {
	private int x;
	private int y;
	private char[] myC = new char[1];

	CharObject() {
		myC[0] = 'b';
		x = 0;
		y = 0;
	}

	CharObject(char c, int X, int Y) {
		myC[0] = c;
		if (X > 0 || X < 750) {
			x = X;
		}
		if (Y > 0 || Y < 750) {
			y = Y;
		}
	}

	public char[] getChar() {
		return myC;
	}

	public void setChar(char[] C) {
		myC[0] = C[0];
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int newX) {
		if (newX > 0 || newX < 750) {
			x = newX;
		}
	}

	public void setY(int newY) {
		if (newY > 0 || newY < 750) {
			y = newY;
		}
	}
}
