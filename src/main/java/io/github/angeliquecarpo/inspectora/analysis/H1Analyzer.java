package io.github.angeliquecarpo.inspectora.analysis;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class H1Analyzer {

    public String analyze(Document document) {

        Elements h1Elements = document.select("h1");

        if (h1Elements.isEmpty()) {
            return "MISSING";
        }

        if (h1Elements.size() > 1) {
            return "MULTIPLE";
        }

        return "OK";
    }
}