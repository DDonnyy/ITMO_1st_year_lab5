package Utility;

import java.io.*;
import java.util.Scanner;

public class FileRead {
    private static final String envPath = System.getenv("kek");
    public static String getFilePath(){
        return envPath;
    }

    public static String readFromFile(String filePath) throws FileNotFoundException {
        String data = "";
        try {
            Reader fileReader = new FileReader(filePath);
            while (fileReader.ready())
                data += (char) fileReader.read();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw  e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String readFromConsole() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}


