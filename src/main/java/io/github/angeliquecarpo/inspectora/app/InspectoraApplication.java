package io.github.angeliquecarpo.inspectora.app;
import io.github.angeliquecarpo.inspectora.crawl.SiteCrawler;
import io.github.angeliquecarpo.inspectora.report.ExcelExporter;
import io.github.angeliquecarpo.inspectora.report.ReportEntry;
import io.github.angeliquecarpo.inspectora.report.ReportGenerator;
import java.util.List;


public class InspectoraApplication {
    public static void main(String[] args) {

        System.out.println("Starting Inspectora...");

        SiteCrawler crawler = new SiteCrawler();

        List<ReportEntry> reportEntries = crawler.crawl("https://www.alamaras.gr/");

        System.out.println("Total pages: " + reportEntries.size());

        ReportGenerator reportGenerator = new ReportGenerator();

        for (ReportEntry entry : reportEntries) {
            reportGenerator.addEntry(entry);
        }

        reportGenerator.printReport();

        ExcelExporter excelExporter = new ExcelExporter();
        excelExporter.export(
                reportEntries,
                "https://www.alamaras.gr/",
                "alamaras-report.xlsx"
        );
    }
}
