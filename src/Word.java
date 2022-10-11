
public class Word {
	// private node to be used
	private LinearNode<Letter> firstLetter;
	
	private Boolean includes(LinearNode<Letter> letter) {
		// private helper method to check if letter is contained
		LinearNode<Letter> current = this.firstLetter;
		while (current != null) {
			// iterates through nodes till the end, and if no matches, returns false
			if(current.getElement().equals(letter.getElement())) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	public Word(Letter[ ] letters) {
		// Initializes linear node from letters array
		LinearNode<Letter> current = null;
		LinearNode<Letter> previous = null;
		for (int i = 0; i < letters.length;i++) {
			current = new LinearNode<Letter>(letters[i]);
			if (i==0) {
				// if first letter, sets it to previous and current
				this.firstLetter = current;
				previous = current;
			}else{
				// iterates through Nodes
			previous.setNext(current);
			previous = current;
			}
		}
	}
	@Override
	public String toString() {
		String wordResult = "Word: ";
		LinearNode<Letter> current = this.firstLetter;
		while (current != null) {
			// creates a string from the elements toString method and returns it.
			wordResult += current.getElement().toString() + " ";
			current = current.getNext();
		}
		System.out.println(wordResult);
		return wordResult;
	}
	
	public Boolean labelWord(Word mystery) {
		LinearNode<Letter> mysteryNode = mystery.firstLetter;
		LinearNode<Letter> wordNode = this.firstLetter;
		boolean matching = false;
		while (wordNode != null) {
			if (mysteryNode == null) {
				// if null, reset mysteryNode
				mysteryNode = this.firstLetter;
				matching = false;
			}
			// set default to unUsed
			wordNode.getElement().setUnused();
			if (mystery.includes(wordNode)) {
				// if included, if equivalent, set to correct, else, set to used.
				if (wordNode.getElement().equals(mysteryNode.getElement())) {
					wordNode.getElement().setCorrect();
					matching = true;
				}else {
					wordNode.getElement().setUsed();
					matching = false;
				}
			} 
			// iterate through the Nodes
			mysteryNode = mysteryNode.getNext();
			wordNode = wordNode.getNext();

		}
		
		return matching;
	}


	
}
