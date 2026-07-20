package io.github.angeliquecarpo.inspectora.app;
import io.github.angeliquecarpo.inspectora.crawl.SiteCrawler;
import java.util.Set;


public class InspectoraApplication {
    public static void main(String[] args){
        System.out.println("Starting Inspectora...");

        SiteCrawler crawler = new SiteCrawler();

        Set<String> urls = crawler.crawl("https://www.alamaras.gr/sitemap.html");

        System.out.println("Unique URLs: " + urls.size());
    }
}
