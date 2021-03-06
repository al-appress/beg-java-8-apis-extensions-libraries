// JLayerSmartBorderFrame.java
package com.jdojo.swing;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.LayerUI;

public class JLayerSmartBorderFrame extends JFrame {
	private JLabel firstNameLabel = new JLabel("First Name:");
	private JLabel lastNameLabel = new JLabel("Last Name:");
	private JTextField firstName = new JTextField(10);
	private JTextField lastName = new JTextField(10);

	public JLayerSmartBorderFrame(String title) {
		super(title);
		initFrame();
	}

	public void initFrame() {
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create an object of LayerUI subclass - SmartBorderUI 
		LayerUI<JTextField> ui = new SmartBorderUI();

		// Wrap the LayerUI and two JTextFields in two JLayers 
		JLayer<JTextField> layer1 = new JLayer<>(firstName, ui);
		JLayer<JTextField> layer2 = new JLayer<>(lastName, ui);

		this.add(firstNameLabel);
		this.add(layer1); // Add layer1 and not firstName to the frame 

		this.add(lastNameLabel);
		this.add(layer2); // Add layer2 and not lastName to the frame		 
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JLayerSmartBorderFrame frame
				= new JLayerSmartBorderFrame("JLayer Test Frame");
			frame.pack();
			frame.setVisible(true);
		});
	}
}
