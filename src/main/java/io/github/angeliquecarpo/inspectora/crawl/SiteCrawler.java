package io.github.angeliquecarpo.inspectora.crawl;

import io.github.angeliquecarpo.inspectora.analysis.ContentAnalyzer;
import io.github.angeliquecarpo.inspectora.report.ReportEntry;
import org.jsoup.nodes.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SiteCrawler {

    public List<ReportEntry> crawl(String url) {

        UrlProvider urlProvider = new UrlProvider();
        Set<String> urls = urlProvider.getUrls(url);

        HtmlFetcher fetcher = new HtmlFetcher();
        ContentAnalyzer analyzer = new ContentAnalyzer();
        ResourceFilter resourceFilter = new ResourceFilter();

        List<ReportEntry> reportEntries = new ArrayList<>();

        for (String currentUrl : urls) {

            if (resourceFilter.isNonHtmlResource(currentUrl)){
                continue;
            }

            Document currentDocument = fetcher.fetch(currentUrl);

            if (currentDocument == null){
                continue;
            }

            int wordCount = analyzer.countWords(currentDocument);
            int imageCount = analyzer.countImages(currentDocument);

            String status = analyzer.getPageStatus(wordCount, imageCount);

            ReportEntry entry = new ReportEntry(currentUrl, wordCount, status);
            reportEntries.add(entry);

            System.out.println("Analyzing: " + currentUrl);
        }
        return reportEntries;
    }
}
