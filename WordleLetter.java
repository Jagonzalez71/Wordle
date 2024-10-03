public class WordleLetter {

	// attributes
	private char letter;
	private String color;

	// constructor
	public WordleLetter (char letra){
		this.letter = letra;
	}

	// Setter for color
	public void setColor(String color){
		if(color.equals("green")){
			this.color = color;
		}
		else if(color.equals("yellow")){
			this.color = color;
		}
		else if(color.equals("red")){
			this.color = color;
		}
	}

	// Methods to check if any color has been set.
	public boolean isColorSet(){
		if("green".equals(color) || "yellow".equals(color) || "red".equals(color)){
			return true;
		}
		return false;
	}

	// Method to check if color is set to green
	public boolean isGreen(){
		if("green".equals(color)){
			return true;
		}
		return false;
	}

	public String getColor(){
		return color;
	}

	// TODO - include the below code back in once rest of class is implemented.
	// Do not modify this method implementation.
	public String toString() {
	// 	// Determine the special characters to add
	// 	// at the beginning of the String
	// 	// to change the text color to the right color.
		String colorCode;
		if(color.equals("green")) {
			colorCode = "\u001B[32m";
		} else if(color.equals("yellow")) {
			colorCode = "\u001B[33m";
		} else {
			colorCode = "\u001B[31m";
		}

	// 	// These are the special character to add
	// 	// to the end of the String
	// 	// to signify the end of the color change.
		String resetCode = "\u001B[0m";

	// 	// Surround the letter with
	// 	// space characters and with
	// 	// the above color changing special characters.
		return String.format("%s %s %s",colorCode, letter, resetCode);
	}

}
