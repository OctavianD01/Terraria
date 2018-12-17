
public class World {
	int size;
	int spaceSize;
	double gravity;
	Space[][] terrain;
	Player player;
		
	public World(int size, Player player, int spaceSize) {
		this.size = size;
		this.gravity = 9.8;
		this.player = player;
		this.spaceSize = spaceSize;
		terrain = new Space[(int)(size*2*Math.PI)][size];
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < (int)(2 * size * Math.PI); x++) {
				if (y > size * .80) terrain[x][y] = new Space(new int[] {x, y}, 1, "Sky");
				else if (y <= size * .8 && y > size * .65) terrain[x][y] = new Space(new int[] {x, y}, 2, "Dirt");
				else if (y <= size * .65 && y > size * .35) terrain[x][y] = new Space(new int[] {x, y}, 2, "Stone");
				else terrain[x][y] = new Space(new int[] {x, y}, 2, "Magma");
			}
		}
		
	}
	
	public void update() {	
		
		
		
	}
		
}
