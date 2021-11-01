package mcmillan.jeff.networker;

import java.awt.Color;
import java.awt.Graphics;

import org.joml.Vector2f;

import mcmillan.jeff.networker.gfx.simple2D.Simple2DRenderer;

public class Application {
	
	public boolean running = false;
	
	public Simple2DRenderer renderer;

	private double frames;
	
	public void start() {
		// TODO: Add layer stack.
		renderer = new Simple2DRenderer(640, 360);
		Util.init();
		
		run();
	}
	
	public void run() {
		running = true;
		
		long lastFrame, now, FPS = 60, target = 1000000000 / FPS;
		
		lastFrame = System.nanoTime();
		
		frames = 0;
		
		while (running) {
			now = System.nanoTime();
			if (now-lastFrame>=target) {
				lastFrame = now;
				// TODO: Move to layerStack
				renderer.draw(new AppDraw(this));
			}
		}
		if (running) {
			System.err.println("DID NOT CLEANLY END RUN LOOP!!!");
		}
	}
	
	public void draw(Graphics g) {
		double a = ((double)frames  ) / 60;

		Vector2f rad = new Vector2f(100f, 100f);
		Vector2f pos = new Vector2f((float)(Math.cos(a) * rad.x), (float)(Math.sin(a) * rad.y));
		pos.add(rad);
		pos.add(20, 20);
		Vector2f size = new Vector2f(60f, 60f);
		
		g.setColor(Color.RED);
		g.fillRect((int)pos.x, (int)pos.y, (int)size.x, (int)size.y);
		frames++;
	}
	
	class AppDraw implements Simple2DRenderer.Drawable {

		private Application app;
		
		public AppDraw(Application a) {
			app = a;
		}
		
		@Override
		public void draw(Graphics g) {
			app.draw(g);
		}
	}
	
}
