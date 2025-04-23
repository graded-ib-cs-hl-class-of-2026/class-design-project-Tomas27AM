public class App {

    private Deck deck = new Deck();
    private Printer printer = new Printer();
/** This method starts the program running getSetFromFile first then the shuffle then finally showing the set. 
 * This code just ensures that the program starts running and in the right order*/
    public void start() {

        getSetFromFile();
        deck.shuffle();
        showSet();
        
    }

   
/** The getSetFromFile method gives the user a option between three sets. 
 * It then takes the first line and the next line from the file to make a flashcard with a word and its definintion.
 * It reads the files line by line to do so until the entire file has been read and all of the flashcards are added to the deck*/
    public void getSetFromFile() {
       printer.output ("write CS.txt for Computer Science Flashcards, Econ.txt for Economics Flashcards, or BM.txt for Buisness Flashcards");
       String filename = printer.input();
        try {
            printer.openFile(filename);
        }catch (Exception e) {
            printer.output (e.toString());
            return;
        }
        while (printer.fileHasNextLine()) {
            String line = printer.getNextLine();
            deck.addWords(line);
            if (printer.fileHasNextLine()) {
                line = printer.getNextLine();
                deck.addDefinitions(line);
            }
        }
        printer.closeFile();
    }
/**
 * This method displays the deck of flashcards card by card
 * First it shows the word from the flash card putting it into the record.txt file to track the which words have been studied
 * The program waits for user input to simulate flipping the flashcard to then show the definition of the word shown
 * The program then wait for another input to show the next word and the process is repeated
 */
    public void showSet() {
        try {
            printer.openFile("record.txt");
        }catch (Exception e) {
            printer.output (e.toString());
            return;
        }
        for(int i =0; i < deck.size(); i++){
        printer.output("\n"+ deck.readWord(i));
        printer.fileOutput(deck.readWord(i));
        printer.input();
        printer.output(deck.readDefinition(i));
        printer.input();
    }
    }

/**
 * Starts the start method 
 * @param args
 * @throws Exception
 */
    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
