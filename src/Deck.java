public class Deck {

    /** 
     * here the array of words and definitions is created with a value of 100 each signifying a limit of 100 potential flashcards per deck
     * the variables refering to the number of words and definitions are also created 
     */
    private String[] words= new String[100];
    private String[] definitions = new String[100];
    private int numWords = 0;
    private int numDefinitions = 0;

  /**
   * This method stores the provided word in the words array at the current index
   * It then increments the numWords counter for the next entry 
   * @param w
   */
    public void addWords(String w) {
        words[numWords] = w;
        numWords++;
    }
/**
 * This method stores the provided definition in the definitions array at the current index
   * It then increments the numDefinitions counter for the next entry 
 * @param d
 */
    public void addDefinitions(String d) {
        definitions[numDefinitions] = d;
        numDefinitions++;
    }
/** returns the word stored at index i */
    public String readWord(int i){
        return words[i];

    }
    /** returns the definition stored at index i */
    public String readDefinition(int i){
        return definitions[i];

    }
    /** returns the number of flashcards in the deck */
    public int size() {
        return Math.min(numWords, numDefinitions);
    }
/**
 * this method shuffles the deck of flashcards by creating temporary variables for the word and definition moving them along the deck
 * This method contains the fisher yates method of shuffling to ensure the cards are mmoved around the deck randomly
 */
    public void shuffle (){
        for (int i = numWords - 1; i >= 1; i--) {
        int j = (int) (Math.random() * (i +1));
        String temp = words[i];
           words[i] = words[j];
           words[j] = temp;

            temp = definitions[i];
           definitions[i] = definitions[j];
           definitions[j] = temp;
        }
    }
}
