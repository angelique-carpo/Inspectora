package io.github.angeliquecarpo.inspectora.crawl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.HashSet;
import java.util.Set;

public class SitemapReader {

    private final HtmlFetcher fetcher = new HtmlFetcher();

    public Set<String> getUrls(String sitemapUrl) {
        Set<String> urls = new HashSet<>();

        Document document = fetcher.fetch(sitemapUrl);

        for (Element element : document.select("loc")){
            urls.add(element.text());
        }
        return urls;
    }
}