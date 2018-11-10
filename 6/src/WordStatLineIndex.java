import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordStatLineIndex {
    public static void main(String[] args) {
        try (FastScanner in = new FastScanner(new FileInputStream(args[0]), StandardCharsets.UTF_8)) {
            Map<String, List<Map.Entry<Integer, Integer>>> map = new TreeMap<>();
            Pattern pt = Pattern.compile("[\\p{L}\\p{Pd}\\']+");
            int line = 1;
            while (in.hasNextLine()) {
                String s = in.nextLine().toLowerCase();
                int wordNum = 1;
                Matcher matcher = pt.matcher(s);
                while (matcher.find()) {
                    String word = matcher.group();
                    map.computeIfAbsent(word, a -> new ArrayList<>()).add(new AbstractMap.SimpleEntry<>(line,wordNum));
                    wordNum++;
                }
                line++;
            }
            try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
                map.forEach((word, positions) -> {
                    try {
                        out.write(word + " " + positions.size() + " " + positions.stream().map(pos -> pos.getKey() + ":" + pos.getValue()).collect(Collectors.joining(" ")));
                        out.newLine();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
