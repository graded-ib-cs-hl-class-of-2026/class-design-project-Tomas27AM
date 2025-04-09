public class App {

    private Deck deck = new Deck();
    private Printer printer = new Printer();

    public void start() {

        userChooseSet();
        getSetFromFile();
        showSet();

    }

    public void userChooseSet() {

    }

    public void getSetFromFile() {
        try {
            printer.openFile("Cards.txt");
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
    }

    public void showSet() {
        for(int i =0; i < deck.size(); i++){
        printer.output(deck.readWord(0));
        printer.input();
        printer.output(deck.readDefinition(0));
    }
    }


    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
