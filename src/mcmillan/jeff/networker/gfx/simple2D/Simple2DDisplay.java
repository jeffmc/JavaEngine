package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mcmillan.jeff.networker.gfx.simple2D.Simple2DRenderer.Drawable;

public class Simple2DDisplay {
	
	private Simple2DCanvas panel;
	public Simple2DRenderer renderer;
	private JFrame frame;
	private int width, height;
	
	public Simple2DDisplay(Simple2DRenderer _r, int _width, int _height) {
		renderer = _r;
		width = _width;
		height = _height;
		
		frame = new JFrame("Networker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		panel = new Simple2DCanvas(this, width, height);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack();
		
		frame.setVisible(true);
	}

	public void draw(Drawable d) {
		panel.useDraw(d);
		panel.repaint();
	}
	
}
