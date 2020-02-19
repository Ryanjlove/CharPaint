
package CharPaint;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
public class CharPaintDriver {
	public static void main(String[] args) {
		JPanel mainPanel = new JPanel();
		JFrame myFrame = new JFrame("Panel");
		myFrame.setVisible(true);
		myFrame.pack();
		JLabel label = new JLabel("Enter username:");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField userName = new JTextField(20);
		myFrame.add(mainPanel);
		mainPanel.setBackground(Color.blue);
		mainPanel.add(label, BorderLayout.NORTH);
		mainPanel.add(userName, BorderLayout.SOUTH);
	}
}
