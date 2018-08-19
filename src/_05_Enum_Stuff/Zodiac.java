package _05_Enum_Stuff;

public enum Zodiac {
	enum DataTypes {
	ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, 
	LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN, AQUARIUS, PISCES
	}
	
	switch(DataTypes) {
	// Notice that 'DataTypes.' is not requires when accessing categories
	case ARIES:{
		System.out.println("INT");
		break;
	}
	case TAURUS:{
		System.out.println("DOUBLE");
		break;
	}
	case GEMINI:{
		System.out.println("BOOLEAN");
		break;
	}
	case CANCER:{
		System.out.println("LONG");
		break;
	}
	case SHORT:{
		System.out.println("SHORT");
		break;
	}
	case BYTE:{
		System.out.println("BYTE");
		break;
	}
	}
}
