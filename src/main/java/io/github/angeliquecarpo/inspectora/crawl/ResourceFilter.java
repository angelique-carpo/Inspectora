package io.github.angeliquecarpo.inspectora.crawl;

import javax.lang.model.element.NestingKind;

public class ResourceFilter {

    public boolean isNonHtmlResource(String url){
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
}
