package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import mcmillan.jeff.networker.gfx.simple2D.Simple2DRenderer.Drawable;

@SuppressWarnings("serial")
public class Simple2DCanvas extends Canvas {
	
	public int width, height;
	public Simple2DDisplay display;
	
	private Drawable draw;
	
	public Simple2DCanvas(Simple2DDisplay _display, int _width, int _height) {
		super();
		display = _display;
		width = _width;
		height = _height;
		setPreferredSize(new Dimension(640,360));
		setBackground(Color.black);
	}
	
	public void useDraw(Drawable d) {
		draw = d;
	}
	
	@Override
	public void paint(Graphics g) {
		draw.draw(g);
	}
}
