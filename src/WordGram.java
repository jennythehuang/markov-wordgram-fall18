import java.util.ArrayList;
/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author JENNY HUANG
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	public WordGram(String[] words, int index, int size) { 
		myWords = new String[size];
		ArrayList<String> newwords = new ArrayList<String>(); 
		for (int i = index; i < size + index ; i ++) {
			newwords.add(words[i]);
		}
		myWords = newwords.toArray(myWords); 
		myToString = null;
		myHash = 0;
		
	}

	
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	
	public int length(){
		int len = myWords.length;
		return len;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null) {
			return false;
		}
	
		WordGram wg = (WordGram) o;
		if ((wg.length() != this.length())) {
			return false;
		}
		for (int i = 0; i < myWords.length; i ++ ) {
			if (! (this.myWords[i].equals(wg.wordAt(i)))) {
				return false;
			}
		}
	    		
		return true; 
		}
		

	
	@Override
	public int hashCode(){
		for (int i = 0; i < myWords.length; i ++) {
			myHash = myWords[i].toString().hashCode();
		}
			
		return myHash;
	}
	

	
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		for (int i= 0; i < wg.myWords.length; i ++) {
			if (i < wg.myWords.length - 1) {
				wg.myWords[i] = this.myWords[i+1];
			}
			
			else {
				wg.myWords[i] = last;
			}
		}						
								
		return wg;
	}

	@Override
	public String toString(){
		myToString = String.join(" ", myWords);
		return myToString;
	}
}
