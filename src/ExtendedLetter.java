public class ExtendedLetter extends Letter{
	// private variables
    private String content;
    private int family;
    private boolean related;
    private final int SINGLETON = -1;
    
    public ExtendedLetter(String s) {
    	// Initializer when only given string s input
    	super('c');
        this.content = s;
        this.related = false;
        this.family = this.SINGLETON;
    }
    
    public ExtendedLetter(String s,int fam) {
    	// Initializer when given string s input and a family link
    	super('c');
    	this.content = s;
        this.related = false;
        this.family = fam;
    }
    
    public boolean equals(Object other) {
    	// checks if two objects are equal
    	if (other instanceof ExtendedLetter) {
    		// checks if object is of type ExtendedLetter
    		ExtendedLetter ExtendedLetterObject = (ExtendedLetter) other;
    		if(this.family == ExtendedLetterObject.family) {
    			// if they have the same family, sets related to true
    			this.related = true;
    		}
    		if (this.content == ExtendedLetterObject.content) {
    			// if the content in both is the same, returns true, else, returns false
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}
    }
    
    @Override
    public String toString() {
    	String specialDecoratedString = "";
    	if (this.isUnused() && this.related) {
    		// if unUsed and related, returns string as .@.
    		specialDecoratedString += "." + this.content +".";
    	} else {
    		// if other status or unrelated, returns string as regular around content
    		specialDecoratedString += super.decorater() + this.content + super.decorater();
    	}
    	return specialDecoratedString;
    }

    
    public static Letter[] fromStrings(String[] content,int[] codes) {
    	// creates strings and codes from content and code arrays
    	Letter[] letters = new Letter[content.length];
    	for(int i = 0; i  < content.length; i++){
    		// if codes not null, adds both code and content to letter array, if codes null, only adds content.
    		if (codes == null) {
    			letters[i] = new ExtendedLetter(content[i]);
    		} else {
    			letters[i] = new ExtendedLetter(content[i], codes[i]);
    		}
    		
    	}
    	return letters;
    }


}