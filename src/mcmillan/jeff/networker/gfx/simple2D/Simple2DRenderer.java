package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.Color;
import java.awt.Graphics;

public class Simple2DRenderer {
	public Simple2DDisplay display;
	private Graphics graphics;
	private int width, height;
	
	public Simple2DRenderer(int _width, int _height) {
		width = _width;
		height = _height;
		display = new Simple2DDisplay(this, width, height);
	}
	
	public void beginFrame() {
		display.callForNextFrame();
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, width, height);
	}
	
	public void endFrame() {
		graphics.dispose();
	}
	
	public void setGraphics(Graphics g) {
		this.graphics = g;
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
