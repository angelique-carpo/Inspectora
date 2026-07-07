package io.github.angeliquecarpo.inspectora.app;
import io.github.angeliquecarpo.inspectora.crawl.HtmlFetcher;
import org.jsoup.nodes.Document;

public class InspectoraApplication {
    public static void main(String[] args){
        System.out.println("Starting Inspectora...");

        HtmlFetcher fetcher = new HtmlFetcher();

        Document document = fetcher.fetch("https://www.alamaras.gr/");

        System.out.println(document.body().text());
    }
}
