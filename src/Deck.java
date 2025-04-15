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

    public void shuffle (){
        for (int i = numWords - 1; i >= 1; i--) {
        int j = (int) Math.random() * (i +1);
        String temp = words[i];
           words[i] = words[j];
           words[j] = temp;

            temp = definitions[i];
           definitions[i] = definitions[j];
           definitions[j] = temp;
        }
    }
}
