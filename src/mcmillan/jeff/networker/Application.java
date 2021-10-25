package mcmillan.jeff.networker;

import java.awt.Color;

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
				renderer.beginFrame();
				draw(renderer);
				renderer.endFrame();
			}
		}
		if (running) {
			System.err.println("DID NOT CLEANLY END RUN LOOP!!!");
		}
	}
	
	public void draw(Simple2DRenderer r) {
		r.setColor(Color.white);
		r.drawRect(10, 10, 620, 340);
		
		double a = ((double)frames  ) / 60; 
		double radius = 100;
		
		Vector2f redBox = new Vector2f((float)(Math.cos(a) * radius), (float)(Math.sin(a) * radius));
		int rad = (int) radius;
		
		r.setColor(Color.red);
		r.fillRect((int)(20+rad+redBox.x), (int)(20+rad+redBox.y), 60, 60);
		frames++;
	}
}
