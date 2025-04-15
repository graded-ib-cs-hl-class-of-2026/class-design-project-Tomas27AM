public class App {

    private Deck deck = new Deck();
    private Printer printer = new Printer();

    public void start() {

        getSetFromFile();
        deck.shuffle();
        showSet();
        
    }

   

    public void getSetFromFile() {
       printer.output ("write CS.txt for computer science Flashcards or PE.txt for Sports Flashcards");
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


    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
