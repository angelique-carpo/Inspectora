package io.github.angeliquecarpo.inspectora.crawl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HtmlFetcher {

    public Document fetch (String url){

        Connection connection = Jsoup.connect(url);
        Document document = null;
        try{
            document = connection.get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return document;
    }
}
