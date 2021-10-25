package mcmillan.jeff.networker.gfx.simple2D;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import mcmillan.jeff.networker.Launch;

public class Simple2DDisplay {
	
	private Simple2DGamePanel panel;
	public Simple2DRenderer renderer;
	private JFrame frame;
	private int width, height;
	
	public Simple2DDisplay(Simple2DRenderer _r, int _width, int _height) {
		renderer = _r;
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
