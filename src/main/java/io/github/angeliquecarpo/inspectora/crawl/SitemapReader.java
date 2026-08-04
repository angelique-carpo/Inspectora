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

        if (isSitemapIndex(document)){
            for (Element sitemap : document.select("sitemap")){
                String childSitemap = sitemap.select("loc").text();
                urls.addAll(getUrls(childSitemap));
            }
            return urls;
        }

        for (Element element : document.select("loc")){
            urls.add(element.text());
        }
        return urls;
    }
    private boolean isSitemapIndex(Document document){
        return !document.select("sitemap").isEmpty();
    }
}