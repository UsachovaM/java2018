import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FastScanner implements AutoCloseable {
    private InputStreamReader in;
    private StringBuilder sb;
    private int c;

    public FastScanner(InputStream stream) {
        in = new InputStreamReader(stream);
        sb = new StringBuilder();
        c = 0;
    }

    public boolean hasNextLine() throws IOException {
        if (sb.length() > 0) {
            return true;
        } else {
            while ((c = in.read()) != -1 && c != '\n') {
                sb.append((char)c);
            }
            if (c == -1)
                return false;
            return true;
        }
    }

    public String nextLine() {
        String s = sb.toString();
        sb.setLength(0);
        return s;
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
