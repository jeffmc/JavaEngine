package mcmillan.jeff.networker.gfx;

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

import mcmillan.jeff.networker.Main;
import mcmillan.jeff.networker.math.Vec2Int;

public class Display {
	
	private GamePanel panel;
	private int width, height;
	private int frames;
	
	public Display(int _width, int _height) {
		width = _width;
		height = _height;
		JFrame frame = new JFrame("Networker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
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
				Main.running = false;
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
		
		panel = new GamePanel(this, width, height);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		frame.pack();
		
		frame.setVisible(true);
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
		double _x = Math.cos(a) * radius;
		double _y = Math.sin(a) * radius;
		
		Vec2Int redBox = new Vec2Int((int)Math.round(_x), (int)Math.round(_y));
		int r = (int) radius;
		
		g.setColor(Color.red);
		g.fillRect(20+r+redBox.x, 20+r+redBox.y, 60, 60);
		frames++;
	}
	
	class RenderListener implements ActionListener {

		private Display display;
		
		public RenderListener(Display _display) {
			display = _display;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			display.callForNextFrame();
			System.out.println("Render through menu item!");
		}
		
	}
	
}
