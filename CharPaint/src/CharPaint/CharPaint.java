import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JFrame;

public class CharPaint extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
   
   private List<CharObject> myList = new ArrayList<>();
	

	public CharPaint() {
		super("CharPaint"); // giving a title to my JFrame.
		setSize(750, 750);
		setVisible(true);
		this.getContentPane().setBackground(Color.magenta);
		addMouseListener(this);// most important line of code
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		setBackground(Color.blue);
		super.paint(g);
		setBackground(Color.blue);
		char[] mychars ={'c','p','q','h'};
		g.setColor(Color.blue);
		g.drawChars(mychars,0,4,350,350);
	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		CharObject myC = new CharObject('a',mouse.getX(),mouse.getY());
		for(int i =0; i < myList.size(); i++) {
			if((myList.get(i).getX() + myList.get(i).getY())== (myC.getY()+myC.getX())) {
				if((myList.get(i).getX() == myC.getX()) && myList.get(i).getY() == myC.getY()){
				myC.setChar(myList.get(i).getChar());
				}
			}
		}
		//Add myC to arraylist.
		//add to queue
		this.repaint();
      System.out.println(myList.toArray()); 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//this is for mouse entering the screen, don't do anything
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//this is for mouse exiting the screen, dont't do anything
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//This is for mouse hold draw a line of chars
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//This is for mouse realease don't do anything
		
	}

	/*public void actionPerformed(ActionEvent e) { Legacy code for a button action event.
		getContentPane().setBackground(Color.red);
		size++;
		System.out.println(e + " size: " + size);
		this.repaint();
	}*/
}
