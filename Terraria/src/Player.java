
public class Player {
	double[] pos;
	double[] velocity;
	
	int health;
	int stamina;
	int hunger;
	int thirst;
	
	Inventoriable[][] inventory = new Inventoriable[9][5];
	
	public Player(double[] pos) {
		this.pos = pos;
		
		velocity = new double[] {0, 0};
		
		health = 100;
		stamina = 100;
		hunger = 0;
		thirst = 0;
		
	}
	
	public void move(double x, double y) {
		pos[0] += x;
		pos[1] += y;
	}
	
}
