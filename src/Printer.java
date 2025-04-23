import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;

public class Printer {

    private Scanner in = new Scanner(System.in);
    private Scanner fileInput;
    private File file;
    private FileWriter fileWriter;

    /**
     * This method opens the file with the give filename
     * it throws an exception of the file can not be opened or found
     * @param filename
     * @throws Exception
     */
    public void openFile(String filename) throws Exception {
        file = new File(filename);
        fileInput = new Scanner(file);
    }
/**
 * This method closes any open file that is being read or written in
 */
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
/**
 * This method adds a line of text to the currently open file
 * Using filewriter it writes in the given string followed by a new line
 * filewriter is then closed and if there is a exception it is caught and ignored
 * @param s
 */
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
/** 
 * This method checks whether or not the file has a next line to read
 */
    public boolean fileHasNextLine() {
        if (fileInput == null) {
            return false;
        } else {
            return fileInput.hasNextLine();
        }
    }
/**
 * This method gets the next line from the opened file
 * it uses the filehasnextline method to check if there is a next line to get
 * @return
 */
    public String getNextLine() {
        if (fileHasNextLine()) {
            return fileInput.nextLine();
        } else {
            return "";
        }
    }
/**
 * prints the given string using System.out.println
 * @param s
 */
    public void output(String s) {
        System.out.println(s);
    }
/**
 * Returns the users input as a string 
 * @return
 */
    public String input() {
        return in.nextLine();
    }

}
