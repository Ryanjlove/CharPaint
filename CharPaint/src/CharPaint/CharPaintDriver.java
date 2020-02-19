
package CharPaint;

import java.awt.BorderLayout;

import javax.swing.JButton;

public class CharPaintDriver {
	public static void main(String[] args) {
		CharPaint p = new CharPaint();
		JButton flip = new JButton();
		flip.addActionListener(p);
		p.add(flip, BorderLayout.SOUTH);
		while (true) {
			p.repaint();
		}
		/*
		 * JPanel mainPanel = new JPanel(); JFrame myFrame = new JFrame("Panel");
		 * Graphics myG; myFrame.setPreferredSize(new Dimension(1000, 1000));
		 * myFrame.setVisible(true); myFrame.setBackground(Color.blue); myFrame.pack();
		 * JLabel label = new JLabel("Enter username:");
		 * myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); JTextField userName =
		 * new JTextField(20);
		 * 
		 * mainPanel.add(myFrame); mainPanel.setBackground(Color.blue);
		 * myFrame.add(mainPanel); mainPanel.add(label, BorderLayout.NORTH);
		 * mainPanel.add(userName, BorderLayout.SOUTH);
		 */
	}
}
