package io.github.angeliquecarpo.inspectora.crawl;

import io.github.angeliquecarpo.inspectora.analysis.ContentAnalyzer;
import io.github.angeliquecarpo.inspectora.report.ReportEntry;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.net.URI;

public class SiteCrawler {

    public List<ReportEntry> crawl(String url) {

        HtmlFetcher fetcher = new HtmlFetcher();
        ContentAnalyzer analyzer = new ContentAnalyzer();

        Queue<String> urlsToVisit = new LinkedList<>();
        Set<String> visitedUrls = new HashSet<>();
        List<ReportEntry> reportEntries = new ArrayList<>();
        String baseUrl = extractBaseUrl(url);

        urlsToVisit.add(url);

        while (!urlsToVisit.isEmpty()) {

            String currentUrl = urlsToVisit.poll();

            if (visitedUrls.contains(currentUrl)) {
                continue;
            }

            visitedUrls.add(currentUrl);
            Document currentDocument = fetcher.fetch(currentUrl);
            int wordCount = analyzer.countWords(currentDocument);
            int imageCount = analyzer.countImages(currentDocument);

            String status = analyzer.getPageStatus(wordCount, imageCount);

            ReportEntry entry = new ReportEntry(currentUrl, wordCount, status);
            reportEntries.add(entry);

            System.out.println("Analyzing: " + currentUrl);

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

        return reportEntries;
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

    private String extractBaseUrl(String url){
        URI parsedUri = URI.create(url);
        return parsedUri.getScheme() + "://" + parsedUri.getHost();
    }
}
