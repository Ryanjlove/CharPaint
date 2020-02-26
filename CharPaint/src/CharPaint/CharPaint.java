package CharPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JFrame;

public class CharPaint extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	int size = 0;

	public CharPaint() {
		super("CharPaint"); // giving a title to my JFrame.
		setSize(750, 750);
		setVisible(true);
		setBackground(Color.white);
		addMouseListener(this);// most important line of code
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillOval(200, 200, 300, 300);

	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		//this is where we make the chars go at mouse.getX(), mouse.getY()
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//this is for mouse entering the screen, don't do anything
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//this is for mouse exiting the screen, dont'd do anything
		
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
