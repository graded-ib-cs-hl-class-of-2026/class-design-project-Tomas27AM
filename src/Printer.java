import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;

public class Printer {

    private Scanner in = new Scanner(System.in);
    private Scanner fileInput;
    private File file;
    private FileWriter fileWriter;

    public void openFile(String filename) throws Exception {
        file = new File(filename);
        fileInput = new Scanner(file);
    }

    public void closeFile() {
        fileInput.close();
        file = null;
        fileInput = null;
        try {
            fileWriter.close();
        } catch (Exception e) {
            return;
        }
    }

    public void fileOutput(String s) {
        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.write(s + "\n");
            fileWriter.close();
        } catch (

        Exception e) {
            return;
        }

    }

    public boolean fileHasNextLine() {
        if (fileInput == null) {
            return false;
        } else {
            return fileInput.hasNextLine();
        }
    }

    public String getNextLine() {
        if (fileHasNextLine()) {
            return fileInput.nextLine();
        } else {
            return "";
        }
    }

    public void output(String s) {
        System.out.println(s);
    }

    public String input() {
        return in.nextLine();
    }

}
