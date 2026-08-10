package io.github.angeliquecarpo.inspectora.crawl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class HtmlSitemapReader {
    private final HtmlFetcher fetcher = new HtmlFetcher();

    public Set<String> getUrls(String sitemapUrl){
        Set<String> urls = new HashSet<>();
        Document document = fetcher.fetchIfExists(sitemapUrl);

        if (document == null){
            return urls;
        }

        String baseUrl = extractBaseUrl(sitemapUrl);

        for (Element link : document.select("a[href]")){
            String url = link.attr("abs:href");

            if (url.isBlank()){
                continue;
            }

            if (!url.startsWith(baseUrl)){
                continue;
            }

            urls.add(url);
        }

        return urls;
    }

    private String extractBaseUrl(String url){
        URI parsedUri = URI.create(url);
        return parsedUri.getScheme() + "://" + parsedUri.getHost();
    }
}
