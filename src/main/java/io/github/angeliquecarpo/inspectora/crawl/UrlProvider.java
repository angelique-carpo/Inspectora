package io.github.angeliquecarpo.inspectora.crawl;

import org.jsoup.nodes.Document;

import java.util.Set;

public class UrlProvider {

    private final HtmlFetcher htmlFetcher = new HtmlFetcher();

    public Set<String> getUrls(String website){
        String sitemap = findSitemap(website);

        if (sitemap != null){
            SitemapReader sitemapReader = new SitemapReader();
            return sitemapReader.getUrls(sitemap);
        }
        InternalCrawler internalCrawler = new InternalCrawler();
        return internalCrawler.getUrls(website);
    }

    private String findSitemap(String website){
        String sitemapUrl = website + "/sitemap.xml";
        Document document = htmlFetcher.fetchIfExists(sitemapUrl);

        if (document != null && !document.select("loc").isEmpty()){
            return sitemapUrl;
        }
        return null;
    }
}
