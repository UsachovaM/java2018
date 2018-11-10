import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordStatCount {
    public static void main(String args[]) {
        Map<String, Integer> m = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"))) {
            String line = "";
            Pattern p = Pattern.compile("[\\p{L}\\p{Pd}\\']+");
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                Matcher matcher = p.matcher(line);
                while (matcher.find()) {
                    String w = matcher.group();
                    m.putIfAbsent(w, 0);
                    m.put(w, m.get(w)+1);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(m.entrySet());
        Collections.sort(list, Map.Entry.comparingByValue());
        try (PrintWriter writer = new PrintWriter(args[1], "UTF-8")) {
            for (Map.Entry<String, Integer> entry : list) {
                writer.println(entry.getKey() + " " + entry.getValue().toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
