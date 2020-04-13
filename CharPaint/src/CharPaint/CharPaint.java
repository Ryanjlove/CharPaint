package CharPaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CharPaint extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;

	private List<CharObject> myList = new ArrayList<>();

	private VectorStack<CharObject> added = new VectorStack<>();

	private VectorStack<CharObject> undone = new VectorStack<>();
	private NewPanel panel = new NewPanel();

	public CharPaint() {

		JMenuBar menuBar;
		JMenu file, edit;
		JMenuItem createNew, save, load, exit, undo, redo;

		JFrame frame = new JFrame("CharPaint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		file = new JMenu("File");
		menuBar.add(file);

		createNew = new JMenuItem("New");
		createNew.addActionListener(new MenuActionListener());
		file.add(createNew);

		save = new JMenuItem("Save");
		save.addActionListener(new MenuActionListener());
		file.add(save);

		load = new JMenuItem("Load");
		load.addActionListener(new MenuActionListener());
		file.add(load);

		exit = new JMenuItem("Exit");
		exit.addActionListener(new MenuActionListener());
		file.add(exit);

		// Second menu
		edit = new JMenu("Edit");
		menuBar.add(edit);

		undo = new JMenuItem("Undo");
		undo.addActionListener(new MenuActionListener());
		edit.add(undo);

		redo = new JMenuItem("Redo");
		redo.addActionListener(new MenuActionListener());
		edit.add(redo);

		frame.setJMenuBar(menuBar);

		frame.getContentPane().add(panel);
		frame.setSize(new Dimension(750, 750));

		panel.addMouseListener(this);

		frame.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		CharObject myC = new CharObject('X', mouse.getX(), mouse.getY());// being added
		boolean add = false, loop = true;
		int sizel = myList.size();
		if (myList.size() == 0) {// adding the first charObject
			myList.add(myC);
			added.push(myC);
		} else {
			for (int i = 0; i < sizel; i++) {
				if (!loop) {// exits loop if already added myC
					break;
				}
				if ((myList.get(i).getX() + myList.get(i).getY()) == (myC.getY() + myC.getX())) {// fix if add
					if ((myList.get(i).getX() == myC.getX()) && myList.get(i).getY() == myC.getY()) {
						myList.remove(i);
						myList.add(myC);// replacing the char object with a new one
						loop = false;
						added.push(myC);
					} else {
						myList.add(myC);
						added.push(myC);
						loop = false;
						add = true;
					}
				} else if (!add) {
					myList.add(myC);
					added.push(myC);
					loop = false;
				}
				add = false;
			}
			// Add myC to arraylist.
			// add to queue

		}
		panel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// this is for mouse entering the screen, don't do anything

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// this is for mouse exiting the screen, dont't do anything

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// This is for mouse hold draw a line of chars

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// This is for mouse realease don't do anything

	}

	/*
	 * public void actionPerformed(ActionEvent e) { Legacy code for a button action
	 * event. getContentPane().setBackground(Color.red); size++;
	 * System.out.println(e + " size: " + size); this.repaint(); }
	 */

	class NewPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NewPanel() {
			this.setBackground(Color.white);
		}

		public void paintComponent(Graphics g) {
			if (myList.size() == 0) {
				// do nothing
			} else {

				for (int i = 0; i < myList.size(); i++) {
					int x = myList.get(i).getX();
					int y = myList.get(i).getY();
					char[] val = myList.get(i).getChar();
					setBackground(Color.white);
					g.setColor(Color.black);
					g.drawChars(val, 0, 1, x, y);
				}
			}
		}
	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if (s.equals("Exit"))
				System.exit(0);
			else if (s.equals("Save"))
				;
			else if (s.equals("New"))
				;
			else if (s.equals("Load"))
				;
			else if (s.equals("Undo")) {
				undone.push(added.pop());
				myList.remove(undone.peek());
				panel.repaint();
			} else if (s.equals("Redo")) {
				added.push(undone.pop());
				myList.add(added.peek());
				panel.repaint();
			}

		}
	}
}

// class NewPanel extends JPanel {
//      public NewPanel () 
//      {
//        this.setBackground (Color.white);
//      }
//      
//      public void paintComponent (Graphics g)
//      {
//        for(int i = 0; i < myList.size(); i++){
//          int x = myList.get(i).getX();
//          int y = myList.get(i).getY();
//          char [] val = myList.get(i).getChar();
//          g.drawChars(val,0,4,x,y);
//        }
//    	// 	setBackground(Color.white);
// //    		char[] mychars ={'c','p','q','h'};
// //    		g.setColor(Color.black);
// //    		g.drawChars(mychars,0,4,350,350);
//      }
// }

// class MenuActionListener implements ActionListener {
//   public void actionPerformed(ActionEvent e) {
//     String s = e.getActionCommand();
//     if (s.equals("Exit"))
//       System.exit(0);
//     else if (s.equals("Save"));
//     else if (s.equals("New"));
//     else if (s.equals("Load"));
//     else if (s.equals("Undo")){
//       undone.push(added.pop());
//       myList.remove(undone.peek());
//     }
//     else if (s.equals("Redo"));
// 
//   }
// }
