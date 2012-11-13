package scrame;

public class TextFormat {
	public static String capitalize(String _text) {
		return _text.substring(0,1).toUpperCase() + _text.substring(1);
	}
	
	public static String scoreToGrade(double _score) {		
		double gradeDist = 90.0;
		double gradeA = 80.0;
		double gradeB = 70.0;
		double gradeC = 60.0;
		double gradeD = 50.0;
		
		if (_score >= gradeDist) return "DIST";
		else if (_score >= gradeA) return "A";
		else if (_score >= gradeB) return "B";
		else if (_score >= gradeC) return "C";
		else if (_score >= gradeD) return "D";
		
		return "F";
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}

	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}
}
