public class Deck {

    
    private String[] words= new String[100];
    private String[] definitions = new String[100];
    private int numWords = 0;
    private int numDefinitions = 0;

  
    public void addWords(String w) {
        words[numWords] = w;
        numWords++;
    }

    public void addDefinitions(String d) {
        definitions[numDefinitions] = d;
        numDefinitions++;
    }

    public String readWord(int i){
        return words[i];

    }
    public String readDefinition(int i){
        return definitions[i];

    }
    public int size() {
        return Math.min(numWords, numDefinitions);
    }
}
