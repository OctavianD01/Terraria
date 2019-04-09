import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WorldPanel extends JPanel {
	
	World world;

	public WorldPanel(World world) {
		this.world = world;
		this.setBackground(Color.BLUE);		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D)g;
		/*
		for (int i = 0; i < world.terrain.length; i++) {
			for (int j = 0; j < world.terrain[i].length; j++) {
				gg.setColor(world.terrain[i][j].color);
				gg.fillRect(i * world.spaceSize, j * world.spaceSize, world.spaceSize-1, world.spaceSize-1);
			}
		}
		*/
		Space[][] camera = new Space[70][50];
		for (int i = 0; i < camera.length; i++) {
			for (int j = 0; j < camera[i].length; j++) {
				camera[i][j] = world.terrain[(int) (world.player.pos[0] + (i - 35))][(int) (world.player.pos[1] + (j - 25))];
			}
		}
		
		for (int i = 0; i < camera.length; i++) {
			for (int j = 0; j < camera[i].length; j++) {
				gg.setColor(camera[i][j].color);
				gg.fillRect(1890 - (35 * world.spaceSize) + i*world.spaceSize, 1020 - (25 * world.spaceSize) + j*world.spaceSize, world.spaceSize-1, world.spaceSize-1);
			}
		}
		
		for (int i = 0; i < world.player.inventory.length; i++) {
			gg.setColor(Color.GRAY);
			gg.fillRect((int) (1890 + (i-4.5)*200), 1800, 200, 200);
		}
		
		gg.setColor(Color.MAGENTA);
		gg.fillRect(1890, 1020, world.spaceSize - 2, 2 * world.spaceSize - 1);
		
	}
}
