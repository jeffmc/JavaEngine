package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.Color;
import java.awt.Graphics;

import mcmillan.jeff.networker.gfx.Renderer;

public class Simple2DRenderer extends Renderer {
	public Simple2DDisplay display;
	private Graphics graphics;
	private int width, height;
	private boolean activeFrame;
	
	public Simple2DRenderer(int _width, int _height) {
		width = _width;
		height = _height;
		display = new Simple2DDisplay(this, width, height);
		activeFrame = false;
	}
	
	public void beginFrame() {
		display.callForNextFrame();
		activeFrame = true;
	}
	
	public void endFrame() {
		graphics.dispose();
		activeFrame = false;
	}
	
	public void setGraphics(Graphics g) {
		this.graphics = g;
		g.setColor(Color.RED);
		g.fillRect(10, 10, 40, 40);
	}
	
	public boolean hasGraphics() {
		return graphics != null && activeFrame;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setColor(Color c) {
		graphics.setColor(c);
		
	}

	public void drawRect(int x, int y, int w, int h) {
		graphics.drawRect(x,y,w,h);
	}

	public void fillRect(int x, int y, int w, int h) {
		graphics.fillRect(x,y,w,h);
	}
}
