import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WorldPanel extends JPanel {
	
	World world;

	public WorldPanel(World world) {
		this.world = world;
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D)g;
		
		
		
		for(int y = 0; y < 40; y++) {
			for (int x = 0; x < 40; x++) {
				int tempX = world.player.pos[0] - 20 + x;
				int tempY = world.player.pos[1] - 20 + y;
				
				if (tempX < 0) tempX = 0;
				if (tempX > (int)(world.size * 2 * Math.PI)) tempX = (int)(world.size * 2 * Math.PI);
				if (tempY < 0) tempY = 0;
				if (tempY > world.size) tempY = world.size;
				

				else if (world.terrain[tempX][tempY].type == "Dirt") gg.setColor(Color.GREEN);
				else if (world.terrain[tempX][tempY].type == "Stone") gg.setColor(Color.LIGHT_GRAY);
				else if (world.terrain[tempX][tempY].type == "Magma") gg.setColor(Color.ORANGE);
				gg.fillRect((tempX)*world.spaceSize, world.size * world.spaceSize - (tempY) * world.spaceSize, world.spaceSize -1, world.spaceSize -1);
			}
		}
		
		gg.setColor(Color.RED);
		gg.fillRect(5*world.spaceSize, 4 * world.spaceSize , world.spaceSize - 1, world.spaceSize*2 - 1);
		
	}
}
