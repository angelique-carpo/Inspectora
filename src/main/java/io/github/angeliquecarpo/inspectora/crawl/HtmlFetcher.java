package io.github.angeliquecarpo.inspectora.crawl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HtmlFetcher {

    public Document fetch (String url){

        Connection connection = Jsoup.connect(url).ignoreContentType(true);
        Document document = null;
        try{
            document = connection.get();
        } catch (IOException e) {
            System.out.println("Failed to fetch: " + url);
            return null;
        }

        return document;
    }

    public Document fetchIfExists(String url){
        Connection connection = Jsoup.connect(url).ignoreContentType(true);
        try{
            return connection.get();
        }catch (IOException e){
            return null;
        }
    }
    /**
     * Fetches plain text content from a URL.
     */
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
