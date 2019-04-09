import java.awt.Color;
import java.util.Scanner;

public class World {
	int sizeX;
	int sizeY;
	int spaceSize;
	double gravity;
	Space[][] terrain;
	Player player;
		
	public World(int sizeX, int sizeY, Player player, int spaceSize) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.gravity = 9.8;
		this.player = player;
		this.spaceSize = spaceSize;
		terrain = new Space[sizeX][sizeY];
		for (int y = 0; y < sizeY; y++) { 
			for (int x = 0; x < sizeX; x++) {
				if (y < sizeY * .2) terrain[x][y] = new Space(new int[] {x, y}, 1, "Sky");
				else if (y >= sizeY * .2 && y < sizeY * .35) terrain[x][y] = new Space(new int[] {x, y}, 2, "Dirt");
				else if (y >= sizeY * .35 && y < sizeY * .65) terrain[x][y] = new Space(new int[] {x, y}, 2, "Stone");
				else terrain[x][y] = new Space(new int[] {x, y}, 2, "Magma");
				terrain[x][y].setColor();
				if (x==40 && y == 38) terrain[x][y].color = Color.RED;
			}
		}
		
		update();
		
		
	}
	
	public void update() {	
		
	}
	
	public void debug() {
	
	}
		
}
