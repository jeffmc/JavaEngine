package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.joml.Vector2f;

import mcmillan.jeff.networker.Launch;

public class Simple2DDisplay {
	
	private Simple2DGamePanel panel;
	private JFrame frame;
	private int width, height;
	private int frames;
	
	public Simple2DDisplay(int _width, int _height) {
		width = _width;
		height = _height;
		
		frame = new JFrame("Networker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		setupMenubar();
		
		panel = new Simple2DGamePanel(this, width, height);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		frame.pack();
		
		frame.setVisible(true);
	}
	
	private void setupMenubar() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		JMenuItem renderItem = new JMenuItem("Render");
		renderItem.setMnemonic(KeyEvent.VK_R);
		renderItem.addActionListener(new RenderListener(this));
		
		JMenuItem haltItem = new JMenuItem("Halt");
		renderItem.setMnemonic(KeyEvent.VK_H);
		renderItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Launch.game.running = false;
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_E);
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exited through menu item!");
				System.exit(0);
			}
		});

		menu.add(renderItem);
		menu.add(haltItem);
		menu.add(exitItem);
		menubar.add(menu);
		frame.setJMenuBar(menubar);
	}

	public void callForNextFrame() {
		panel.repaint();
	}
	
	// TODO: Find a better name for method than "reallyRender"
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.white);
		g.drawRect(10, 10, 620, 340);
		
		double a = ((double)frames) / 60; 
		double radius = 100;
		
		Vector2f redBox = new Vector2f((float)(Math.cos(a) * radius), (float)(Math.sin(a) * radius));
		int r = (int) radius;
		
		g.setColor(Color.red);
		g.fillRect((int)(20+r+redBox.x), (int)(20+r+redBox.y), 60, 60);
		frames++;
	}
	
	class RenderListener implements ActionListener {

		private Simple2DDisplay display;
		
		public RenderListener(Simple2DDisplay _display) {
			display = _display;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			display.callForNextFrame();
			System.out.println("Render through menu item!");
		}
		
	}
	
}
