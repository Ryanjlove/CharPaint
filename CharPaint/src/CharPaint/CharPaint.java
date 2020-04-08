import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

public class CharPaint extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
   
   private List<CharObject> myList = new ArrayList<>();
	

	public CharPaint() {

      JMenuBar menuBar;
      JMenu file, edit;
      JMenuItem createNew, save, load, exit, undo, redo;

     JFrame frame = new JFrame ("CharPaint");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //Create the menu bar.
      menuBar = new JMenuBar();
      
      //Build the first menu.
      file = new JMenu("File");
      menuBar.add(file);
      
     createNew = new JMenuItem("New");
     createNew.addActionListener(new MenuActionListener());
     //createNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
     //createNew.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
     file.add(createNew);
     
     save = new JMenuItem("Save");
     save.addActionListener(new MenuActionListener());
     //save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
     //save.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
     file.add(save);
     
     load = new JMenuItem("Load");
     load.addActionListener(new MenuActionListener());
     file.add(load);
     
     exit = new JMenuItem("Exit");
     exit.addActionListener(new MenuActionListener());
     //exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
     //exit.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
     file.add(exit);
     
     
     //Second menu 
     edit = new JMenu("Edit");
     menuBar.add(edit);
     
     undo = new JMenuItem("Undo");
     undo.addActionListener(new MenuActionListener());
     edit.add(undo);
     
     redo = new JMenuItem("Redo");
     redo.addActionListener(new MenuActionListener());
     edit.add(redo);
     
     frame.setJMenuBar(menuBar);
     NewPanel panel = new NewPanel();
     frame.getContentPane().add(panel);
     frame.setSize (new Dimension(750,750));

     panel.addMouseListener(this);

     frame.setVisible(true);

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

class NewPanel extends JPanel {
     public NewPanel () 
     {
       this.setBackground (Color.cyan);
     }
     
     public void paintComponent (Graphics g)
     {
   		setBackground(Color.blue);
   		char[] mychars ={'c','p','q','h'};
   		g.setColor(Color.blue);
   		g.drawChars(mychars,0,4,350,350);
     }
}

class MenuActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    String s = e.getActionCommand();
    if (s.equals("Exit"))
      System.exit(0);
    else if (s.equals("Save"));
    else if (s.equals("New"));
    else if (s.equals("Load"));
    else if (s.equals("Undo"));
    else if (s.equals("Redo"));

  }
}
