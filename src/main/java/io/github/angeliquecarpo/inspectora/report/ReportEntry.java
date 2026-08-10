package io.github.angeliquecarpo.inspectora.report;

public class ReportEntry {

    private final String url;
    private final int wordCount;
    private final String status;
    private final String h1Status;
    private final String altStatus;

    public ReportEntry(String url, int wordCount, String status,
                       String h1Status, String altStatus) {
        this.url = url;
        this.wordCount = wordCount;
        this.status = status;
        this.h1Status = h1Status;
        this.altStatus = altStatus;
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
}