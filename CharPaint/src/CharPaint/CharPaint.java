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

import java.io.*;
import java.util.Scanner;

public class CharPaint extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;

	private List<CharObject> myList = new ArrayList<>();//Holds all char objects that are currently being displayed

	private VectorStack<CharObject> added = new VectorStack<>();//Stack that holds most recent char objects

	private VectorStack<CharObject> undone = new VectorStack<>();//When Undo is selected, char object gets pushed onto this stack
   
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
			else if (s.equals("Save")){
				System.out.println("Please enter a filename to save as:  ");
            String filename;
            Scanner in = new Scanner(System.in);
            filename = in.nextLine();
            File file = new File(filename);
            try{
               ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(file));
               
               fout.writeInt(myList.size());
               for(int i = 0; i < myList.size(); i++){
                  if(myList.get(i) != null)
                     fout.writeObject(myList.get(i));
               }
               fout.close();
               System.out.println("File saved successfully.");
            } catch (IOException E) {
               System.out.println("An error has occurred with saving the file.");
            }
         }   
			else if (s.equals("New")){
            myList = new ArrayList<>();
	         added = new VectorStack<>();
	         undone = new VectorStack<>();
            panel.repaint();
         }
			else if (s.equals("Load")){
				System.out.println("Please enter a filename to load:  ");
            String filename;
            Scanner in = new Scanner(System.in);
            filename = in.nextLine();
            File file = new File(filename);
            try{
               ObjectInputStream fin = new ObjectInputStream(new FileInputStream(file));
               myList = new ArrayList<>();
	            added = new VectorStack<>();
	            undone = new VectorStack<>();
               int size = fin.readInt();
               for(int i = 0; i < size; i++){
                  CharObject obj = (CharObject)fin.readObject();
                  myList.add(obj);
               }
               fin.close();
               panel.repaint();
            } catch (ClassNotFoundException | IOException Z){
               System.out.println("An error has occurred in loading the file");
            }
         }   
			else if (s.equals("Undo")) {
            if(!added.empty()){
   				undone.push(added.pop());
   				myList.remove(undone.peek());
   				panel.repaint();
            }   
			} else if (s.equals("Redo")) {
            if(!undone.empty()){
   				added.push(undone.pop());
   				myList.add(added.peek());
   				panel.repaint();
            }
			}

		}
	}
}
