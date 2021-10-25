package mcmillan.jeff.networker;

import mcmillan.jeff.networker.gfx.simple2D.Simple2DDisplay;

public class Application {
	
	public boolean running = false;
	public Simple2DDisplay display;
	
	public void start() {
		// Add layer stack.
		display = new Simple2DDisplay(640, 360);
		Util.init();
		
		run();
	}
	
	public void run() {
		running = true;
		
		long lastFrame, now, FPS = 60, target = 1000000000 / FPS;
		
		lastFrame = System.nanoTime();
		while (running) {
			now = System.nanoTime();
			if (now-lastFrame>=target) {
				lastFrame = now;
				display.callForNextFrame();
			}
		}
		if (running) {
			System.err.println("DID NOT CLEANLY END RUN LOOP!!!");
		}
	}
}
