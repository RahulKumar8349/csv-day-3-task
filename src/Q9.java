import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.stream.Stream;


public class Q9 {

    public static   void delete(String studentFilePath,String addressFilePath,int id)
    {
        List<String> lines = readCsvFile(studentFilePath);



        // Use the Stream API to filter out the line(s) to delete
        List<String> filteredLines = lines.stream()
                .filter(line -> !line.startsWith(id + ",")) // Change the condition as needed
                .collect(Collectors.toList());

        // Write the remaining lines back to the CSV file
        writeCsvFile(filteredLines, studentFilePath);

        List<String> addr = readCsvFile(addressFilePath);



        // Use the Stream API to filter out the line(s) to delete
        List<String> filteredAddr = addr.stream()
                .filter(line -> !line.endsWith(id+"")) // Change the condition as needed
                .collect(Collectors.toList());

        // Write the remaining lines back to the CSV file
        writeCsvFile(filteredAddr, addressFilePath);



    }

    public static List<String> readCsvFile(String studentFilePath) {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(studentFilePath))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeCsvFile(List<String> lines, String filePath) {
        try {
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}