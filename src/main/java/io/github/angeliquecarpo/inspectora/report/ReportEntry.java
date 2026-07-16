package io.github.angeliquecarpo.inspectora.report;

public class ReportEntry {

    private final String url;
    private final int wordCount;
    private final String status;

    public ReportEntry(String url, int wordCount, String status){
        this.url = url;
        this.wordCount = wordCount;
        this.status = status;
    }

    public String getUrl(){
        return url;
    }

    public int getWordCount(){
        return wordCount;
    }

    public String getStatus(){
        return status;
    }
}
