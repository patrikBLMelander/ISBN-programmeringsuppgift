package util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/**
    Reads input path and makes a List<String>

 */

public class InputFileReader {
    public static List<String> readStringFile(String path) {
        List<String> list = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
