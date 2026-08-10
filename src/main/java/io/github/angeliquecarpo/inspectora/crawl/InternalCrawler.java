package io.github.angeliquecarpo.inspectora.crawl;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URI;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class InternalCrawler {

    private final HtmlFetcher fetcher = new HtmlFetcher();

    private final ResourceFilter resourceFilter = new ResourceFilter();

    public Set<String> getUrls(String website) {

        Queue<String> urlsToVisit = new LinkedList<>();
        Set<String> visitedUrls = new HashSet<>();

        String baseUrl = extractBaseUrl(website);

        urlsToVisit.add(website);

        while (!urlsToVisit.isEmpty()) {

            String currentUrl = urlsToVisit.poll();

            if (visitedUrls.contains(currentUrl)) {
                continue;
            }

            visitedUrls.add(currentUrl);

            Document currentDocument = fetcher.fetch(currentUrl);

            if (currentDocument == null) {
                continue;
            }

            for (Element link : currentDocument.select("a")) {

                String nextUrl = link.attr("abs:href");

                if (nextUrl.isBlank()) {
                    continue;
                }

                if (resourceFilter.isNonHtmlResource(nextUrl)) {
                    continue;
                }

                URI nextUri = URI.create(nextUrl);
                URI websiteUri = URI.create(website);

                if (nextUri.getHost() == null) {
                    continue;
                }

                if (!nextUri.getHost().equals(websiteUri.getHost())) {
                    continue;
                }

                if (!visitedUrls.contains(nextUrl)) {
                    urlsToVisit.add(nextUrl);
                }
            }
        }

        return visitedUrls;
    }

    private String extractBaseUrl(String url) {
        URI parsedUri = URI.create(url);
        return parsedUri.getScheme() + "://" + parsedUri.getHost();
    }
}
