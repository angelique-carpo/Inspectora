package io.github.angeliquecarpo.inspectora.report;
import java.util.ArrayList;
import java.util.List;


public class ReportGenerator {
    private final List<ReportEntry> entries = new ArrayList<>();

    public void addEntry(ReportEntry entry){
        entries.add(entry);
    }

    public void printReport() {

        int okCount = 0;
        int thinCount = 0;
        int veryThinCount = 0;
        int emptyCount = 0;



        for (ReportEntry entry : entries) {
            switch(entry.getStatus()) {
                case "OK":
                    okCount++;
                    break;

                case "THIN CONTENT":
                    thinCount++;
                    break;

                case "VERY THIN":
                    veryThinCount++;
                    break;

                case "EMPTY":
                    emptyCount++;
                    break;
            }
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("         INSPECTORA REPORT");
        System.out.println("=========================================");
        System.out.println();
        System.out.println("Total pages : " + entries.size());
        System.out.println("OK :" +  okCount);
        System.out.println("THIN CONTENT : " + thinCount);
        System.out.println("VERY THIN : " + veryThinCount);
        System.out.println("EMPTY  : " + emptyCount);
        System.out.println();
    }

}


