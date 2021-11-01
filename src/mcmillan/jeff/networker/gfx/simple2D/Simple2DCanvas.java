package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Simple2DCanvas extends Canvas {
	
	public int width, height;
	public Simple2DDisplay display;
	
	public Simple2DCanvas(Simple2DDisplay _display, int _width, int _height) {
		super();
		display = _display;
		width = _width;
		height = _height;
		setPreferredSize(new Dimension(640,360));
		setBackground(Color.black);
	}
	
	@Override
	public void paint(Graphics g) {
		display.renderer.setGraphics(g);
	}
}
