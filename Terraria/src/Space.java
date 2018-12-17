import java.awt.Color;

public class Space {
	int[] pos;
	int state;
	String type;
	int size = 30;
	Color color;
	
	public Space(int[] pos, int state, String type) {
		this.pos = pos;
		this.state = state;
		this.type = type;
	}
	
	public void setColor() {
		if (type == "Sky") color = Color.BLUE;
		else if (type == "Dirt") color = Color.GREEN;
		else if (type == "Stone") color = Color.LIGHT_GRAY;
		else if (type == "Magma") color = Color.RED;
	}
	
	
}
