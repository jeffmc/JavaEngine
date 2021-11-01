package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.Graphics;

import mcmillan.jeff.networker.gfx.Renderer;

public class Simple2DRenderer extends Renderer {
	public Simple2DDisplay display;
	private int width, height;
	private boolean activeFrame;
	
	public Simple2DRenderer(int _width, int _height) {
		width = _width;
		height = _height;
		display = new Simple2DDisplay(this, width, height);
		activeFrame = false;
	}
	
	public void beginFrame() {
		activeFrame = true;
	}
	
	public void draw(Drawable d) {
		// Use this webpage to fix this process.
		// https://www.oracle.com/java/technologies/painting.html
		beginFrame();
		display.draw(d);
		endFrame();
	}
	
	public void endFrame() {
		activeFrame = false;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
//	
//	public void setColor(Color c) {
//		graphics.setColor(c);
//	}
//
//	public void drawRect(int x, int y, int w, int h) {
//		graphics.drawRect(x,y,w,h);
//	}
//
//	public void fillRect(int x, int y, int w, int h) {
//		graphics.fillRect(x,y,w,h);
//	}

	public interface Drawable {
		public void draw(Graphics g);
	}
}
