package io.github.angeliquecarpo.inspectora.report;

public class ReportEntry {

    private final String url;
    private final int wordCount;
    private final String status;
    private final String h1Status;
    private final String altStatus;
    private final String metaDescriptionStatus;
    private final int seoScore;

    public ReportEntry(String url, int wordCount, String status,
                       String h1Status, String altStatus, String metaDescriptionStatus, int seoScore) {
        this.url = url;
        this.wordCount = wordCount;
        this.status = status;
        this.h1Status = h1Status;
        this.altStatus = altStatus;
        this.metaDescriptionStatus = metaDescriptionStatus;
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

    public int getSeoScore(){
        return seoScore;
    }
}