import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

public class CharPaint extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
   
   private List<CharObject> myList = new ArrayList<>();
	

	public CharPaint() {
// 		super("CharPaint"); // giving a title to my JFrame.
// 		pack();
// 
// 		this.getContentPane().setBackground(Color.red);
//       //Button time
//       JButton undo = new JButton("Undo");
//       undo.setBounds(100,100,140,40);
//       add(undo);
// 		addMouseListener(this);// most important line of code
//       setVisible(true);
// 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JMenuBar menuBar;
      Component undo;
      Component redo;


     JFrame frame = new JFrame ("CharPaint");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //Create the menu bar.
      menuBar = new JMenuBar();
      
      //Build the first menu.
      undo = new JMenu("Undo");
      //menu.setMnemonic(KeyEvent.VK_A);
      menuBar.add(undo);
     //frame.setJMenuBar(menuBar);
     
     //Second menu button
     redo = new JMenu("Redo");
     menuBar.add(redo);
     frame.setJMenuBar(menuBar);
     JPanel panel = new JPanel();
     frame.getContentPane().add(panel);
     frame.setSize (new Dimension(750,750));
     frame.getContentPane().setBackground(Color.red);
     addMouseListener(this);
     frame.show();

     //JButton button = new JButton("Undo");
     //button.setBounds(0,0,140,40);
     //panel.add (button);
     //frame.getContentPane().add(panel);
     //this.getContentPane().setBackground(Color.red);
     addMouseListener(this);// most important line of code

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
