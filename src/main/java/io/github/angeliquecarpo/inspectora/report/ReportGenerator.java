package io.github.angeliquecarpo.inspectora.report;
import java.util.ArrayList;
import java.util.List;


public class ReportGenerator {
    private final List<ReportEntry> entries = new ArrayList<>();

    public void addEntry(ReportEntry entry){
        entries.add(entry);
    }

    public void printReport() {

        System.out.println();
        System.out.println("=========================================");
        System.out.println("         INSPECTORA REPORT");
        System.out.println("=========================================");

        for (ReportEntry entry : entries) {
            System.out.printf("%-6d %-15s %s%n",
                    entry.getWordCount(),
                    entry.getStatus(),
                    entry.getUrl());
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total pages : " + entries.size());
    }

}


