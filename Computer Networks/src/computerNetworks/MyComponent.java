package computerNetworks;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		int y=0;
		for(int i=1;i<=7;i++) {
			g2.drawRect(10, y+10, 120, 25);
			g2.drawLine(65, y+35, 65, y+50);
			g2.drawString("V", 62, y+50);
			g2.drawRect(190, y+10, 120, 25);
			g2.drawLine(250, y+35, 250, y+50);
			g2.drawString("^", 248, y+44);
			
			if(i==1) {
				g2.drawString("Application Layer", 25,y+25);
				g2.drawString("Application Layer", 200,y+25);
			}
			else if(i==2) {
				g2.drawString("Presentation Layer",25, y+25);
				g2.drawString("Presentation Layer",200,y+25);
			}
			else if(i==3) {
				g2.drawString("Session Layer", 25, y+25);
				g2.drawString("Session Layer", 200, y+25);
			}
			else if(i==4) {
				g2.drawString("Transport Layer", 25, y+25);
				g2.drawString("Transport Layer", 200, y+25);
			}
			else if(i==5) {
				g2.drawString("Network Layer", 25, y+25);
				g2.drawString("Network Layer",200, y+25);
			}
			else if(i==6) {
				g2.drawString("Data Link Layer", 25, y+25);
				g2.drawString("Data Link Layer",200, y+25);
			}
			else{
				g2.drawString("Physical Layer", 25,y+25);
				g2.drawString("Physical Layer",200, y+25);
			}
			y+=40;
		}
		g2.drawLine(65, y+10, 250, y+10);
		g2.drawString(">", 150, y+15);
		g2.drawString("Sender's Side", 35, y+35);
		g2.drawString("Receiver's Side", 210, y+35);
		
		
		
		
		
	}
}
