package io.github.angeliquecarpo.inspectora.crawl;

public class RobotsReader {
    private final HtmlFetcher fetcher = new HtmlFetcher();

    public String getSitemapUrl(String website){
        String robotsUrl = website + "/robots.txt";
        String robots = fetcher.fetchText(robotsUrl);

        if (robots == null){
            return null;
        }

        String[] lines = robots.split("\n");

        for (String line : lines){

            if (line.startsWith("Sitemap:")){
                return line.substring("Sitemap:".length()).trim();
            }

        }

        return null;
    }
}
