package io.github.angeliquecarpo.inspectora.analysis;

import io.github.angeliquecarpo.inspectora.crawl.HtmlFetcher;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class BrokenLinkAnalyzer {

    private final HtmlFetcher fetcher;

    public BrokenLinkAnalyzer(HtmlFetcher fetcher){
        this.fetcher = fetcher;
    }

    public String analyze(Document document, String website){

        for (Element link : document.select("a[href]")){
            String href = link.attr("abs:href");

            if (!href.startsWith(website)){
                continue;
            }

            Document linkedDocument = fetcher.fetch(href);

            if (linkedDocument == null){
                return "BROKEN INTERNAL LINKS";
            }
        }

        return "NO BROKEN INTERNAL LINKS";
    }
}
