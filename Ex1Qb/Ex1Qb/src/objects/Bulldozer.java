package objects;

import engine.StoneBreaker;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;


//TODO
//Pode ser necessario mudar a declaracao da classe e/ou construtor
//
public class Bulldozer extends GameObject {

	public Bulldozer(Point2D position) {
		super("bulldozer_U", position, 2);
	}

	public Bulldozer(String name, Point2D position) {
		super(name, position, 2);
	}
	private void changeFace(Direction dir) {
		if(this instanceof AutoBulldozer) {
			switch (dir) {
				case DOWN: super.setName("autobulldozer_D");break;
				case UP: super.setName("autobulldozer_U");break;
				case LEFT: super.setName("autobulldozer_L");break;
				case RIGHT: super.setName("autobulldozer_R");break;
			}
		}else {
			switch (dir) {
				case DOWN: super.setName("bulldozer_D");break;
				case UP: super.setName("bulldozer_U");break;
				case LEFT: super.setName("bulldozer_L");break;
				case RIGHT: super.setName("bulldozer_R");break;
			}
		}
	}
	public void move(Direction d) {
		if(this instanceof AutoBulldozer)
			d = Direction.random();
		Point2D newPosition = super.getPosition().plus(d.asVector());
		for(Breakable x : StoneBreaker.getInstance().breakablesAt(newPosition))
			x.brokenBy(this);
		if(StoneBreaker.getInstance().canMoveTo(newPosition))
			super.setPosition(newPosition);
		changeFace(d);
	}
	
	@Override
	public boolean isTransposable() {
		return false;
	}
}
