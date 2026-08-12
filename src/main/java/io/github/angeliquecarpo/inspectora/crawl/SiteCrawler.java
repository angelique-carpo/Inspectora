package io.github.angeliquecarpo.inspectora.crawl;

import io.github.angeliquecarpo.inspectora.analysis.*;
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

        H1Analyzer h1Analyzer = new H1Analyzer();
        AltAnalyzer altAnalyzer = new AltAnalyzer();
        MetaDescriptionAnalyzer metaDescriptionAnalyzer = new MetaDescriptionAnalyzer();
        SeoScoreAnalyzer seoScoreAnalyzer = new SeoScoreAnalyzer();
        TitleAnalyzer titleAnalyzer = new TitleAnalyzer();
        InternalLinkAnalyzer internalLinkAnalyzer = new InternalLinkAnalyzer();
        BrokenLinkAnalyzer brokenLinkAnalyzer = new BrokenLinkAnalyzer(fetcher);

        List<ReportEntry> reportEntries = new ArrayList<>();

        for (String currentUrl : urls) {

            if (resourceFilter.isNonHtmlResource(currentUrl)) {
                continue;
            }

            Document currentDocument = fetcher.fetch(currentUrl);

            if (currentDocument == null) {
                continue;
            }

            int wordCount = analyzer.countWords(currentDocument);
            int imageCount = analyzer.countImages(currentDocument);

            String status = analyzer.getPageStatus(wordCount, imageCount);

            String h1Status = h1Analyzer.analyze(currentDocument);
            String metaDescriptionStatus = metaDescriptionAnalyzer.analyze(currentDocument);
            String altStatus = altAnalyzer.analyze(currentDocument);
            String titleStatus = titleAnalyzer.analyze(currentDocument);
            String internalLinkStatus = internalLinkAnalyzer.analyze(currentDocument, url);
            String brokenLinkStatus = brokenLinkAnalyzer.analyze(currentDocument,url);

            int seoScore = seoScoreAnalyzer.calculateScore(
                    status,
                    h1Status,
                    altStatus,
                    metaDescriptionStatus
            );

            ReportEntry entry = new ReportEntry(
                    currentUrl,
                    wordCount,
                    status,
                    h1Status,
                    altStatus,
                    metaDescriptionStatus,
                    titleStatus,
                    internalLinkStatus,
                    brokenLinkStatus,
                    seoScore
            );

            reportEntries.add(entry);

            System.out.println("Analyzing: " + currentUrl);
        }

        return reportEntries;
    }
}