import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ReverseSum {
    public static void main(String[] args) {
        try (FastScanner in = new FastScanner(System.in);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            List<String[]> lines = new ArrayList<>();
            int verticals = 0;
            while (in.hasNextLine()) {
                String s = in.nextLine();
                //System.out.println(s);
                String[] nums = s.split("\\p{javaWhitespace}+");
                verticals = Math.max(verticals, nums.length);
                lines.add(nums);
                //System.out.println("line = " + s);
            }
            int horizontals = lines.size();
            int[] horizontalSum = new int[horizontals];
            int[] verticalSum = new int[verticals];
            for (int i = 0; i < horizontals; i++) {
                for (int j = 0; j < lines.get(i).length; j++) {
                    if (!lines.get(i)[j].equals("")) {
                        int num = Integer.parseInt(lines.get(i)[j]);
                        horizontalSum[i] += num;
                        verticalSum[j] += num;
                    }
                }
            }
            for (int i = 0; i < horizontals; i++) {
                for (int j = 0; j < lines.get(i).length; j++) {
                    if (!lines.get(i)[j].equals("")) {
                        out.write((horizontalSum[i] + verticalSum[j] - Integer.parseInt(lines.get(i)[j])) + " ");
                    }
                }
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
