
public class Letter {
	// private variables
	private char letter;
	private int label;
	private int UNSET = 0; 
	private int UNUSED = 1;
	private int USED = 2;
	private int CORRECT = 3;
	
	public Letter(char c) {
		// Initializer setting a default state and char
		this.label = this.UNSET;
		this.letter = c;
	}
	
	public boolean equals(Object otherObject) {
		// checks if the object is of type letter
		if (otherObject instanceof Letter) {
			Letter LetterObject = (Letter) otherObject;
			if(this.letter == LetterObject.letter) {
				// if both letters are equal, return true, else, return false
				return true;
			} else {
				return false;
			}
		} else {
		return false;
		}
	}

	public String decorater() {
		String decString = "";
		// depending on label stored, returns a label marker
		if (this.label == this.UNSET) {
			decString = " ";
		}else if(this.label == this.UNUSED) {
			decString = "-";
		}else if(this.label == this.USED) {
			decString = "+";
		}else if(this.label == this.CORRECT) {
			decString = "!";
		}
		return decString;
	}
	
	public String toString() {
		// returns a string of order decorator - letter - decorator
		String letterString = "";
		letterString += this.decorater();
		letterString += this.letter;
		letterString += this.decorater();
		return letterString;
	}
	
	public void setUnused() {
		// sets label to unused
		this.label = this.UNUSED;
		
	}
	
	public void setUsed() {
		// sets label to used
		this.label = this.USED;
		
	}
	
	public void setCorrect() {
		// sets label to correct
		this.label = this.CORRECT;
		
	}
	
	public void setUnset() {
		// sets label to unused
		this.label = this.UNSET;
		
	}
	public boolean isUnused() {
		// checks if label is set to unUsed and returns result
		if (this.label == this.UNUSED) {
			return true;
		}
		return false;
	}
	
	public static Letter[] fromString(String s) {
		// creates new letter objects from string
		Letter[] letterArray = new Letter[s.length()];
		for (int i = 0; i < s.length();i++) {
			char c = s.charAt(i);
			Letter arrayLetter = new Letter(c);
			// stores letter objects in array
			letterArray[i] = arrayLetter;
		}
		return letterArray;
		}
	
	}
