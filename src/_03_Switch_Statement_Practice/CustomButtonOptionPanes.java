
package _03_Switch_Statement_Practice;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
	switch(choice) {
	case "Tuesday":
JOptionPane.showMessageDialog(null, "Mr. Iwata, perhaps this year I can just take the names and you can kick the....you know...");
	break;
	case "Sunday":
		JOptionPane.showMessageDialog(null, "My name is Reggie. I'm about kickin' ass, I'm about takin' names, and we're about makin' games");
	break;
	case "Monday": 
		JOptionPane.showMessageDialog(null, "My name is Reggie, and I, am happy.");
	break;
	case "Wednesday":
		JOptionPane.showMessageDialog(null, "NO Johns");
	break;
	case "Thursday":
				JOptionPane.showMessageDialog(null, "If its not fun why bother");
	break;
	case "Friday": 
				JOptionPane.showMessageDialog(null, "My body is Ready");
	break;
	case "Saturday": 
		JOptionPane.showMessageDialog(null, "At least I don't need a sword to kick ass and take names, alright");
break;
		}
	}
	}

