import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameKL implements KeyListener{
	
	World world;

	int tickCount = 0;
	
	ArrayList<Integer> keys;
	
	public GameKL(World world) {
		keys = new ArrayList<Integer>();
		this.world = world;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		Integer kc = arg0.getKeyCode();
		if(!keys.contains(kc))
			keys.add(kc);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		Integer kc = arg0.getKeyCode();
		keys.remove(kc);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	private boolean isPressed(Integer kc)
	{
		return keys.contains(kc);
	}
	
	public void tick()
	{
		//for (int i = 0; i < keys.size(); i++) {
			//System.out.println(keys.get(i));
		//}
		
		if (isPressed(KeyEvent.VK_W) && world.player.pos[1] - 1 >= 0) {
			world.player.move(0, -1);
			world.update();
		}
		if (isPressed(KeyEvent.VK_S) && world.player.pos[1] + 1 <= world.sizeY && world.terrain[(int)world.player.pos[0]][(int)world.player.pos[1] + 2].state == 1) {
			world.player.move(0, 1);
			world.update();
		}
		if (isPressed(KeyEvent.VK_A) && world.player.pos[0] - 1 >= 0 && world.terrain[(int) (world.player.pos[0]-1)][(int) world.player.pos[1]].state == 1 && world.terrain[(int) (world.player.pos[0]-1)][(int) world.player.pos[1]+1].state == 1) {
			world.player.move(-1, 0);
			world.update();
		}
		if (isPressed(KeyEvent.VK_D) && world.player.pos[0] + 1 <= world.sizeX && world.terrain[(int) (world.player.pos[0]+1)][(int) world.player.pos[1]].state == 1 && world.terrain[(int) (world.player.pos[0]+1)][(int) world.player.pos[1]+1].state == 1) {
			world.player.move(1, 0);
			world.update();
		}
		if (isPressed(KeyEvent.VK_SPACE) && world.player.pos[1] - 2 >= 0 && world.terrain[(int) world.player.pos[0]][(int) (world.player.pos[1]+2)].state ==2) {
			world.player.move(0, -5);
			world.update();
		}
		
		if (world.terrain[(int)world.player.pos[0]][(int)world.player.pos[1] + 2].state == 1) {
			world.player.move(0, .5);
		}
		
		world.update();
		
	}

}
