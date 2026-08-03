package io.github.angeliquecarpo.inspectora.crawl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HtmlFetcher {

    public Document fetch (String url){

        Connection connection = Jsoup.connect(url).ignoreContentType(true);
        Document document = null;
        try{
            document = connection.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
}
