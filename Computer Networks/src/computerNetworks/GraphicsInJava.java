package computerNetworks;
import java.awt.Color;

import javax.swing.*;
public class GraphicsInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setSize(1000,600);
		window.setTitle("OSI Model");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		MyComponent m= new MyComponent();
		window.add(m);
		m.setBackground(Color.red);
		
	}

}
