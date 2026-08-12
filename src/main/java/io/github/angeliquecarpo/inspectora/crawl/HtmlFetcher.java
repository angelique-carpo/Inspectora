package io.github.angeliquecarpo.inspectora.crawl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class HtmlFetcher {

    private final Map<String, Document> cache = new HashMap<>();
    private final Set<String> fetchedUrls = new HashSet<>();

    public Document fetch(String url) {

        if (fetchedUrls.contains(url)) {
            return cache.get(url);
        }

        Connection connection = Jsoup.connect(url).ignoreContentType(true);

        try {
            Document document = connection.get();

            fetchedUrls.add(url);
            cache.put(url, document);

            return document;

        } catch (IOException e) {

            fetchedUrls.add(url);

            System.out.println("Failed to fetch: " + url);

            return null;
        }
    }

    public Document fetchIfExists(String url){
        Connection connection = Jsoup.connect(url).ignoreContentType(true);
        try{
            return connection.get();
        }catch (IOException e){
            return null;
        }
    }

    public String fetchText(String url){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new URL(url).openStream(),
                        StandardCharsets.UTF_8))){
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) !=null){
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            return null;
        }
    }
}
