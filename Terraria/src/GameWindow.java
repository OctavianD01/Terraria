import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameWindow{
	
	public GameWindow() {
		//Creating window
		
		int size = 50;
		
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(3500,2000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		
		Player player = new Player(new int[] {5,0});
		
		World world = new World(size, player, 100);
		
		GameKL kl = new GameKL(world);
		frame.addKeyListener(kl);
		frame.requestFocus();
		
		WorldPanel worldPanel = new WorldPanel(world);

		Thread thread = new Thread(new GameLoop(world, kl, worldPanel));
		thread.start();
		
		
		frame.add(worldPanel);
		worldPanel.setSize(frame.getSize());
		worldPanel.setVisible(true);
		frame.setVisible(true);
		
	}
}