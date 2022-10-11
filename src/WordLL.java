
public class WordLL {
	private Word mysteryWord;
	private LinearNode<Word> history;
	
	public WordLL(Word mystery) {
		// Initialize history and mystery word object
		this.history = null;
		this.mysteryWord = mystery;
	}
	
	public Boolean tryWord(Word guess) {
		// Try to label the input guess
		boolean matching = guess.labelWord(mysteryWord);
		LinearNode<Word> guessNode = new LinearNode<Word>(guess);
		// stores in history
		guessNode.setNext(history);
		history = guessNode;
		// returns if the guess was matching
		return matching;
		
	}
	@Override
	public String toString() {
		// takes history as a current node
		LinearNode<Word> current = history;
		String pastEntries = "";
		while (current != null) {
			// iterates till the end of the LL, returning whole history
			pastEntries += current.getElement().toString() + "\n";
			current = current.getNext();
		}
		return pastEntries;
	}
}
