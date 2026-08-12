package io.github.angeliquecarpo.inspectora.analysis;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class InternalLinkAnalyzer {

    public String analyze(Document document, String website) {

        int internalLinkCount = 0;

        for (Element link : document.select("a[href]")) {

            String href = link.attr("abs:href");

            if (href.startsWith(website)) {
                internalLinkCount++;
            }
        }

        if (internalLinkCount == 0) {
            return "NO INTERNAL LINKS";
        }

        return "OK";
    }
}