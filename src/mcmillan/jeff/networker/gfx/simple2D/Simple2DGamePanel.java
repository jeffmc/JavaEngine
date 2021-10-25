package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Simple2DGamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int width, height;
	
	public Simple2DDisplay display;

	
	public Simple2DGamePanel(Simple2DDisplay _display, int _width, int _height) {
		super(true);
		display = _display;
		width = _width;
		height = _height;
		setPreferredSize(new Dimension(640,360));
		setBackground(Color.red);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		display.render(g);
	}
}
