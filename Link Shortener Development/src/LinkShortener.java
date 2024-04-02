import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LinkShortener {
    private Map<String, String> urlMap;
    private int counter;
    private static final String FILENAME = "url_mappings.txt";

    public LinkShortener() {
        this.urlMap = new HashMap<>();
        this.counter = 0;
        loadUrlMappingsFromFile();
    }

    public String shorten(String longUrl) {
        String shortUrl = "http://short.url/" + counter++;
        urlMap.put(shortUrl, longUrl);
        saveUrlMappingsToFile();
        return shortUrl;
    }

    public String expand(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    private void saveUrlMappingsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Map.Entry<String, String> entry : urlMap.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUrlMappingsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    urlMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            // File doesn't exist or other IO error, ignore
        }
    }
}
