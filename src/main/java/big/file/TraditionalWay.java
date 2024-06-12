package big.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static java.lang.StringTemplate.STR;

public class TraditionalWay {

    public static void main(String[] args) {
        String fileName = "./fakeIpAddresses.txt"; //"./fakeIpAddresses.txt"; // Replace with your file name
        Set<String> uniqueLines = new HashSet<>();
        long begin = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                uniqueLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println(STR."Number of unique lines: \{uniqueLines.size()}  Ms \{end - begin}");
    }

}
