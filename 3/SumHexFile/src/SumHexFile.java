import java.io.*;

public class SumHexFile {
    public static void main(String[] args) {
        int sum = 0;
        try {
            String in = args[0];
            String out = args[1];
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(in), "UTF-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] numbers = line.trim().split("\\p{javaWhitespace}+");
                    for (String number : numbers) {
                        try {
                            if (number.length() > 0) {
                                number = number.toLowerCase();
                                if (number.startsWith("0x")) {
                                    sum += Integer.parseUnsignedInt(number.substring(2), 16);
                                }
                                else {
                                    sum += Integer.parseInt(number, 10);
                                }
                            }
                        }
                        catch (NumberFormatException e) {
                            System.err.println("Wrong number format");
                        }
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.err.println("File wasn't found");
            }
            catch (IOException e) {
                System.err.println("Some problems with reading");
            }
            try (PrintWriter writer = new PrintWriter(args[1], "UTF-8")) {
                writer.println(sum);
            }
            catch (FileNotFoundException e) {
                System.err.println("File " + out + " not found");
            }
            catch (IOException e) {
                System.err.println("Some problems with writing");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Not enough arguments");
        }
    }
}
