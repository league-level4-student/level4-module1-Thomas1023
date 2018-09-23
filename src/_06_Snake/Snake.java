package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;
	Location l;
	Location le;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}
	
	
	public void feed() {
		System.out.println("feed");
		// 1. add a new SnakeSegment object to the snake
		snake.add(new SnakeSegment(head.getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		// 2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		
		// 1. use a switch statement to check on the currentDirection
		// of the snake and calculate its next x and y position.
		switch (currentDirection) {
		// Notice that 'DataTypes.' is not requires when accessing categories
		case UP: {
			 le= new Location(head.getLocation().x, head.getLocation().y - 1);
			break;
		}
		case DOWN: {
			 le= new Location(head.getLocation().x, head.getLocation().y + 1);
			break;
		}
		case LEFT: {
			 le= new Location(head.getLocation().x - 1, head.getLocation().y);
			break;
		}
		case RIGHT: {
			 le= new Location(head.getLocation().x + 1, head.getLocation().y);
			break;
		}
		}
		// 2. Iterate through the SnakeSegments in reverse order
		// 2a. Update each snake segment to the location of the segment
		// in front of it.
		for (int i = snake.size()-1; i > 0; i--) {
			snake.get(i).setLocation(snake.get(i-1).getLocation());
		}
		
		// 3. set the location of the head to the new location calculated in step 1
		
		snake.get(0).setLocation(le);
		// 4. set canMove to true
		canMove = true;
	}

	public void setDirection(Direction d) {
		if (canMove&&!isOp(d)) {
			currentDirection = d;
		} else {

		}
		// 1. set the current direction equal to the passed in Direction only if canMove
		// is true.
		// set canMove equal to false.
		// make sure the snake cannot completely reverse directions.

	}

	public boolean isOp(Direction d) {

		switch (currentDirection) {
		// Notice that 'DataTypes.' is not requires when accessing categories
		case UP: {
			if (d == Direction.DOWN) {
				return true;

			}else {
				return false;
			}
		}
		case DOWN: {
			if (d == Direction.UP) {
				return true;

			}else {
				return false;
			}
		}
		case LEFT: {
			if (d == Direction.RIGHT) {
				return true;
				

			}else {
				return false;
			}
		}
		case RIGHT: {
			if (d == Direction.LEFT) {
				return true;
				

			}else {
				return false;
			}
		}
		}
		return false;

	}

	public void reset(Location loc) {
		// 1. clear the snake
		snake.clear();
		// 2. set the location of the head
head.setLocation(new Location(8, 6));
		// 3. add the head to the snake
snake.add(head);
	}

	public boolean isOutOfBounds() {
		if (getHeadLocation().x>15||getHeadLocation().x<0||getHeadLocation().y>12||getHeadLocation().y<0) {
return true;

		}
		return false;
	}

	public boolean isHeadCollidingWithBody() {
		//1. complete the method so it returns true if the head is located
		//   in the same location as any other body segment
		for (int i = 1; i < snake.size(); i++) {
			if(snake.get(i).getLocation().equals(head.getLocation())) {
				System.out.println("true "+i);
				return true;
				
			}
		}
			
		
		System.err.println("false");
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		// 1. complete the method so it returns true if the passed in
		// location is located on the snake
		System.err.println(loc.x+" , "+loc.y);
//		System.out.println(s.getLocation().x+" , "+s.getLocation().y);
for (SnakeSegment s : snake) {
	
	if(s.getLocation().equals(loc)) {
		

		System.out.println("TRUE");
		return true;
	}
	}

		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
