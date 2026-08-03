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

            for (Element link : currentDocument.select("a")) {

                String nextUrl = link.attr("abs:href");

                if (nextUrl.isBlank()) {
                    continue;
                }

                if (isNonHtmlResource(nextUrl)) {
                    continue;
                }

                if (!nextUrl.startsWith(baseUrl)) {
                    continue;
                }

                if (!visitedUrls.contains(nextUrl)) {
                    urlsToVisit.add(nextUrl);
                }
            }
        }

        return visitedUrls;
    }

    private boolean isNonHtmlResource(String url) {

        String lowerUrl = url.toLowerCase();

        return lowerUrl.endsWith(".jpg")
                || lowerUrl.endsWith(".jpeg")
                || lowerUrl.endsWith(".png")
                || lowerUrl.endsWith(".gif")
                || lowerUrl.endsWith(".webp")
                || lowerUrl.endsWith(".svg")
                || lowerUrl.endsWith(".bmp")
                || lowerUrl.endsWith(".ico")
                || lowerUrl.endsWith(".pdf")
                || lowerUrl.endsWith(".doc")
                || lowerUrl.endsWith(".docx")
                || lowerUrl.endsWith(".xls")
                || lowerUrl.endsWith(".xlsx")
                || lowerUrl.endsWith(".ppt")
                || lowerUrl.endsWith(".pptx")
                || lowerUrl.endsWith(".zip")
                || lowerUrl.endsWith(".rar")
                || lowerUrl.endsWith(".7z")
                || lowerUrl.endsWith(".css")
                || lowerUrl.endsWith(".js")
                || lowerUrl.endsWith(".json")
                || lowerUrl.endsWith(".xml");
    }

    private String extractBaseUrl(String url) {
        URI parsedUri = URI.create(url);
        return parsedUri.getScheme() + "://" + parsedUri.getHost();
    }
}
