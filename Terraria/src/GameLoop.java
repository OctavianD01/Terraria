
public class GameLoop implements Runnable{
	
	World world;
	GameKL kl;
	WorldPanel worldPanel;

	public GameLoop(World world, GameKL kl, WorldPanel worldPanel) {
		this.world = world;
		this.kl = kl;
		this.worldPanel = worldPanel;
	}
	
	@Override
	public void run() {
		try {
			while(true)
			{
				Thread.sleep(50);
				kl.tick();
				world.update();
				worldPanel.repaint();
				System.out.println(kl.keys.size());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
