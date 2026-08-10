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

        RobotsReader robotsReader = new RobotsReader();

        String robotsSitemap = robotsReader.getSitemapUrl(website);

        if (robotsSitemap != null){
            SitemapReader sitemapReader = new SitemapReader();
            return sitemapReader.getUrls(robotsSitemap);
        }

        String htmlSitemap = findHtmlSitemap(website);

        if (htmlSitemap != null){
            HtmlSitemapReader htmlSitemapReader = new HtmlSitemapReader();
            return htmlSitemapReader.getUrls(htmlSitemap);
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

    private String findHtmlSitemap(String website){

        String sitemapUrl = website + "/sitemap.html";

        Document document = htmlFetcher.fetchIfExists(sitemapUrl);

        if (document != null && !document.select("a[href]").isEmpty()){
            return sitemapUrl;
        }

        return null;
    }
}
