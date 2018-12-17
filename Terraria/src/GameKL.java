import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameKL implements KeyListener{
	
	World world;

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
		for (int i = 0; i < keys.size(); i++) {
			System.out.println(keys.get(i));
		}
		
		if (isPressed(KeyEvent.VK_W)) world.player.pos[1]--;
		if (isPressed(KeyEvent.VK_S)) world.player.pos[1]++;
		if (isPressed(KeyEvent.VK_A)) world.player.pos[0]--;
		if (isPressed(KeyEvent.VK_D)) world.player.pos[0]++;
		
		System.out.println(world.player.pos[0] + " " + world.player.pos[0]);
		
	}

}
