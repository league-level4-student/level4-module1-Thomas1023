package _05_Enum_Stuff;

import javax.swing.JOptionPane;

import _04_Intro_To_Enums.IntroToEnums.DataTypes;

public class _00_Horoscope {
	// 1. Create an enum in a separate file called Zodiac that contains a category for
	//    all 12 zodiac signs.
	
	// 2. Write a method that takes in a Zodiac enum object and uses a JOPtionPane to display
	//    a different horoscope based on the Zodiac's state.
	
	// 3. Make a main method to test your method
	public static void main(String[] args) {
		Zodiac zodiac = Zodiac.ARIES;
		switch(zodiac) {
		// Notice that 'DataTypes.' is not requires when accessing categories
		case ARIES:{
			JOptionPane.showMessageDialog(null, "Every step you take towards the happinest you will never find is one closer to your grave");

break;
		}
		case TAURUS:{
			JOptionPane.showMessageDialog(null, "you will use the restroom today");		
			break;
		}
		case GEMINI:{
			JOptionPane.showMessageDialog(null, "you will use the restroom today");		
			break;
		}
		case CANCER:{
			JOptionPane.showMessageDialog(null, "You eat food");		

			break;
		}
		case LEO:{
			JOptionPane.showMessageDialog(null, "You will drink today");		

			break;
		}
		case VIRGO:{
			JOptionPane.showMessageDialog(null, "You are useing a computer");		
			break;
		}
		case LIBRA:{
			JOptionPane.showMessageDialog(null, "you speak english");		
			break;
		}
		case SCORPIO:{
			JOptionPane.showMessageDialog(null, "you are good at computers");		
			break;
		}
		case SAGITTARIUS:{
			JOptionPane.showMessageDialog(null, "you have never died before");		
			break;
		}
		case CAPRICORN:{
			JOptionPane.showMessageDialog(null, "You have sight");		
			break;
		}
		case AQUARIUS:{
			System.out.println("SHORT");
			break;
		}
		case PISCES:{
			System.out.println("BYTE");
			break;
		}
		}
	}
}
