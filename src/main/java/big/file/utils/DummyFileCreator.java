package big.file.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

public class DummyFileCreator {
    // create dummy IP's in order to test;
    public static void main(String[] args) {
        dummyIpAddresses();
    }
    private static Random random = new Random();

    public static void dummyIpAddresses() {
        File file = new File("fakeIpAddresses.txt");
        StringBuffer buffer = new StringBuffer();

        IntStream.range(0, 100_000_000).forEach(ip-> {
            for (int i = 1; i <= 4; i++) {
                if (i % 4!=0){
                    buffer.append(random.nextInt(0, 256));
                    buffer.append(".");
                } else {
                    buffer.append(random.nextInt(0, 256));
                    buffer.append("\n");
                }
            }

        });

        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            // Write content to the file
            bos.write(buffer.toString().getBytes());

            System.out.println("File created and content written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
