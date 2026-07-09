package io.github.angeliquecarpo.inspectora.crawl;

import io.github.angeliquecarpo.inspectora.analysis.ContentAnalyzer;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.HashSet;
import java.util.Set;

public class SiteCrawler {

    public Set<String> crawl(String url) {
        System.out.println(">>> ΕΚΤΕΛΕΙΤΑΙ Η CRAWL <<<");

        HtmlFetcher fetcher = new HtmlFetcher();
        ContentAnalyzer analyzer = new ContentAnalyzer();// Δημιουργία αντικειμένου του ContentAnalyzer

        Document document = fetcher.fetch(url);// Κατέβασμα της αρχικής σελίδας

        Set<String> urls = new HashSet<>();

        for (Element link : document.select("a")) { // Εξαγωγή όλων των συνδέσμων (a tags)
            urls.add(link.attr("abs:href"));
        }
        for (String currentUrl: urls){
            if (!currentUrl.startsWith("https://www.alamaras.gr")) {// Φιλτράρισμα ώστε να ελέγχουμε μόνο το domain "alamaras.gr"
                continue;
            }

            System.out.println("Checking: " + currentUrl);
            Document currentDocument = fetcher.fetch(currentUrl);

            int wordCount = analyzer.countWords(currentDocument); // Κλήση της μεθόδου words για το τρέχον έγγραφο

            System.out.println("Title: " + currentDocument.title());
            System.out.println("Words on page : " + wordCount);

            if (wordCount < 150){
                System.out.println("⚠ Thin Content");
            }

            System.out.println("-----------------------------");
        }
        return urls;
    }
}
