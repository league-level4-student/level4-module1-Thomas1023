package _06_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// Go through the methods and complete the steps in this class
// and the Snake class

public class _00_SnakeGame implements ActionListener, KeyListener {
	public static final Color BORDER_COLOR = Color.WHITE;
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color FOOD_COLOR = Color.RED;
	public static final int WIDTH = 14;
	public static final int HEIGHT = 12;
	public static final int WINDOW_SCALE = 50;
	public static final int WINDOW_WIDTH = WINDOW_SCALE * WIDTH;
	public static final int WINDOW_HEIGHT = WINDOW_SCALE * HEIGHT;

	private JFrame window;
	private JPanel panel;

	private Snake snake;

	private Timer timer;

	private static Location foodLocation;

	public _00_SnakeGame() {
		
		snake = new Snake(new Location(WIDTH / 2, HEIGHT / 2));
snake.l=new Location(Math.floorDiv(WIDTH, 2),Math.floorDiv(HEIGHT, 2));
		window = new JFrame("Snake");
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(BACKGROUND_COLOR);
				g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

				g2.setColor(FOOD_COLOR);
				g2.drawOval(foodLocation.x * WINDOW_SCALE, foodLocation.y * WINDOW_SCALE, Snake.BODY_SIZE,Snake.BODY_SIZE);
				snake.draw(g);
			}
		};

		panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		window.add(panel);

		timer = new Timer(0, this);

		window.pack();
		window.addKeyListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		setFoodLocation();
		

		startGame();
	}

	public void startGame() {
		// 1. Save the instructions for the game in the following string variable.
		String instructions = "whats this";

		String[] options = new String[] { "Expert", "Moderate", "Beginner" };
		int input = JOptionPane.showOptionDialog(null, instructions, "Snake", 0, -1, null, options, 0);

		String choice = options[input];
		switch (choice) {
		// Notice that 'DataTypes.' is not requires when accessing categories
		case "Expert": {
			timer.setDelay(20);
			break;
		}
		case "Moderate": {
			timer.setDelay(40);
			break;
		}
		case "Beginner": {
			timer.setDelay(150);
			break;
		}
		}
		// 2. Use a switch statement to determine which difficulty was chosen.
		// Use timer.setDelay(delay) with different numbers to change the speed
		// of the game. The smaller the number, the faster it goes.

		// 3. start the timer
		timer.start();
	}

	public static void main(String[] args) {
		new _00_SnakeGame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// left arrow 37
	// up arrow 38
	// right arrow 39
	// down arrow 40
	@Override
	public void keyPressed(KeyEvent e) {
		
		// 1. Use a switch statement on e.getKeyCode()
		// to determine which key was pressed.
		switch (e.getKeyCode()) {
		// Notice that 'DataTypes.' is not requires when accessing categories
		case KeyEvent.VK_LEFT: {
			snake.setDirection(Direction.LEFT);
			break;
		}
		case KeyEvent.VK_UP: {
			snake.setDirection(Direction.UP);
			break;
		}
		case KeyEvent.VK_RIGHT: {
			snake.setDirection(Direction.RIGHT);
			break;
		}

		case KeyEvent.VK_DOWN: {
			snake.setDirection(Direction.DOWN);
			break;
		}
		case KeyEvent.VK_SPACE: {
			snake.feed();
			break;
		}
		}
		// if an arrow key is pressed, set the snake's
		// direction accordingly

		// if the space key is pressed, call the snake's feed method

	}

	private void setFoodLocation() {
		System.out.println("setfood");
		// 1. Create a new Location object that is set to a random location
		Random rand = new Random();

		int a = rand.nextInt(HEIGHT);
		int b = rand.nextInt(WIDTH);
		Location locs = new Location(a, b);
		// 2. set the foodLocation variable equal to the Location object you just
		// created.
		// use the snake's isLocationOnSnake method to make sure you don't put the food
		// on the snake
		System.out.println("feed!");
		while (snake.isLocationOnSnake(locs)) {
			System.out.println("feed!");
			 a = rand.nextInt(HEIGHT);
			 b = rand.nextInt(WIDTH);
			 locs = new Location(a, b);
			
		} 
		foodLocation=locs;
	}

	private void gameOver() {
		timer.stop();
		// 1. stop the timer

		// 2. tell the user their snake is dead
		JOptionPane.showMessageDialog(null, "HE dead");
		// 3. ask them if they want to play again.
		String temp = JOptionPane.showInputDialog("play again y/n");
		// 4. if they want to play again
		// reset the snake and the food and start the timer
		// else, exit the game
		switch (temp) {
		// Notice that 'DataTypes.' is not requires when accessing categories
		case "y": {
			startGame();
			snake = new Snake(new Location(WIDTH / 2, HEIGHT / 2));
			snake.l=new Location(Math.floorDiv(WIDTH, 2),Math.floorDiv(HEIGHT, 2));
				
		
			break;
		}
		case "n": {
			break;
		}
		}

	}
	public void onFood() {
		if(foodLocation.equals(snake.getHeadLocation())) {
			snake.feed();
			setFoodLocation();
		}
			
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(snake.isOutOfBounds()) {
			gameOver();
		}
		
		// 1. update the snake
		onFood();
		snake.update();
		// 2. if the snake is colliding with its own body
		// or if the snake is out of bounds, call gameOver
		if (snake.isHeadCollidingWithBody()) {
			gameOver();
		}

		// 3. if the location of the head is equal to the location of the food,
		// feed the snake and set the food location
		// if(Snake.getHeadLocation=) {
		// }
		panel.repaint();
	}
}
