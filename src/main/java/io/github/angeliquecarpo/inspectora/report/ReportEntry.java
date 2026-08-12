package io.github.angeliquecarpo.inspectora.report;

public class ReportEntry {

    private final String url;
    private final int wordCount;
    private final String status;
    private final String h1Status;
    private final String altStatus;
    private final String metaDescriptionStatus;
    private final String titleStatus;
    private final String internalLinkStatus;
    private final String brokenLinkStatus;

    private final int seoScore;

    public ReportEntry(String url, int wordCount, String status,
                       String h1Status, String altStatus, String metaDescriptionStatus, String titleStatus, String internalLinkStatus, String brokenLinkStatus, int seoScore) {
        this.url = url;
        this.wordCount = wordCount;
        this.status = status;
        this.h1Status = h1Status;
        this.altStatus = altStatus;
        this.metaDescriptionStatus = metaDescriptionStatus;
        this.titleStatus = titleStatus;
        this.internalLinkStatus = internalLinkStatus;
        this.brokenLinkStatus = brokenLinkStatus;
        this.seoScore = seoScore;
    }

    public String getUrl() {
        return url;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getStatus() {
        return status;
    }

    public String getH1Status() {
        return h1Status;
    }

    public String getAltStatus() {
        return altStatus;
    }

    public String getMetaDescriptionStatus(){
        return metaDescriptionStatus;
    }

    public String getTitleStatus(){
        return titleStatus;
    }

    public String getInternalLinkStatus(){
        return internalLinkStatus;
    }

    public String getBrokenLinkStatus(){
        return brokenLinkStatus;
    }

    public int getSeoScore(){
        return seoScore;
    }
}