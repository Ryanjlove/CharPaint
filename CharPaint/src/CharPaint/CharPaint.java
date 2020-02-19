package CharPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CharPaint extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	int size = 0;

	public CharPaint() {
		super("CharPaint"); // giving a title to my JFrame.
		setSize(750, 750);
		setVisible(true);
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillOval(200, 200, 300, 300);

	}

	public void actionPerformed(ActionEvent e) {
		getContentPane().setBackground(Color.red);
		size++;
		System.out.println(e + " size: " + size);
		this.repaint();
	}
}
