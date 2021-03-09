package readability;

import java.io.*;
import java.util.Scanner;

public class TextGrabber {

    private final String fileName;

    public TextGrabber(String fileName) {
        this.fileName = fileName;
    }

    public String getText() throws FileNotFoundException, IOException {
        try(BufferedInputStream buf = new BufferedInputStream(new FileInputStream(fileName))) {
            StringBuilder sb = new StringBuilder();
            return new String(buf.readAllBytes());
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        } catch (IOException e) {
            throw new IOException("Data error");
        }
    }

    public String getAlgorithmName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
