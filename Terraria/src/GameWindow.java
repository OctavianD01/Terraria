import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameWindow{
	
	public GameWindow() {
		//Creating window
		
		int sizeY = 200;
		int sizeX = (int)(sizeY * 2 * Math.PI);
		
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(3840,2160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		
		Player player = new Player(new double[] {40, 40});
		
		World world = new World(sizeX, sizeY, player, 60);
		ActionListeners actionListener = new ActionListeners(world);
		
		GameKL kl = new GameKL(world);
		frame.addKeyListener(kl);
		frame.requestFocus();
		
		WorldPanel worldPanel = new WorldPanel(world);

		worldPanel.addMouseListener(actionListener.onClick);
		
		Thread thread = new Thread(new GameLoop(world, kl, worldPanel));
		thread.start();
		
		frame.add(worldPanel);
		worldPanel.setSize(frame.getSize());
		worldPanel.setVisible(true);
		frame.setVisible(true);
		
	}
}