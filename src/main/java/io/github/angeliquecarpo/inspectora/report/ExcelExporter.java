package io.github.angeliquecarpo.inspectora.report;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public void export(List<ReportEntry> entries, String website, String fileName){
        try (Workbook workbook = new XSSFWorkbook()){

            Sheet sheet = workbook.createSheet("Report");

            Row titleRow = sheet.createRow(0);
            titleRow.createCell(0).setCellValue("INSPECTORA REPORT");

            Row siteRow = sheet.createRow(1);
            siteRow.createCell(0).setCellValue("Site: " + website);

            Row summaryTitleRow = sheet.createRow(3);
            summaryTitleRow.createCell(0).setCellValue("SUMMARY");

            int totalPages = entries.size();
            int okPages = 0;
            int thinContentPages = 0;
            int veryThinPages = 0;
            int emptyPages = 0;

            for (ReportEntry entry : entries){
                switch (entry.getStatus()){
                    case "OK":
                        okPages++;
                        break;

                    case "THIN CONTENT":
                        thinContentPages++;
                        break;

                    case "VERY THIN":
                        veryThinPages++;
                        break;

                    case "EMPTY":
                        emptyPages++;
                        break;
                }
            }

            Row totalRow = sheet.createRow(4);
            totalRow.createCell(0).setCellValue("Total Pages");
            totalRow.createCell(1).setCellValue(totalPages);

            Row okRow = sheet.createRow(5);
            okRow.createCell(0).setCellValue("OK");
            okRow.createCell(1).setCellValue(okPages);

            Row thinRow = sheet.createRow(6);
            thinRow.createCell(0).setCellValue("THIN CONTENT");
            thinRow.createCell(1).setCellValue(thinContentPages);

            Row veryThinRow = sheet.createRow(7);
            veryThinRow.createCell(0).setCellValue("VERY THIN");
            veryThinRow.createCell(1).setCellValue(veryThinPages);

            Row emptyRow = sheet.createRow(8);
            emptyRow.createCell(0).setCellValue("EMPTY");
            emptyRow.createCell(1).setCellValue(emptyPages);

            Row header = sheet.createRow(10);

            header.createCell(0).setCellValue("URL");
            header.createCell(1).setCellValue("Word Count");
            header.createCell(2).setCellValue("Status");
            header.createCell(3).setCellValue("H1");
            header.createCell(4).setCellValue("ALT");
            header.createCell(5).setCellValue("META DESCRIPTION");
            header.createCell(6).setCellValue("SEO SCORE");

            int rowNumber = 11;

            CellStyle okStyle = workbook.createCellStyle();
            okStyle.setFillForegroundColor(
                    IndexedColors.LIGHT_GREEN.getIndex()
            );
            okStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle thinStyle = workbook.createCellStyle();
            thinStyle.setFillForegroundColor(
                    IndexedColors.LIGHT_YELLOW.getIndex()
            );
            thinStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle veryThinStyle = workbook.createCellStyle();
            veryThinStyle.setFillForegroundColor(
                    IndexedColors.ORANGE.getIndex()
            );
            veryThinStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle emptyStyle = workbook.createCellStyle();
            emptyStyle.setFillForegroundColor(
                    IndexedColors.RED.getIndex()
            );
            emptyStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle h1OkStyle = workbook.createCellStyle();
            h1OkStyle.setFillForegroundColor(
                    IndexedColors.LIGHT_GREEN.getIndex()
            );
            h1OkStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle h1MissingStyle = workbook.createCellStyle();
            h1MissingStyle.setFillForegroundColor(
                    IndexedColors.RED.getIndex()
            );
            h1MissingStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle h1MultipleStyle = workbook.createCellStyle();
            h1MultipleStyle.setFillForegroundColor(
                    IndexedColors.ORANGE.getIndex()
            );
            h1MultipleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle altOkStyle = workbook.createCellStyle();
            altOkStyle.setFillForegroundColor(
                    IndexedColors.LIGHT_GREEN.getIndex()
            );
            altOkStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle altMissingStyle = workbook.createCellStyle();
            altMissingStyle.setFillForegroundColor(
                    IndexedColors.RED.getIndex()
            );
            altMissingStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle altNoImagesStyle = workbook.createCellStyle();
            altNoImagesStyle.setFillForegroundColor(
                    IndexedColors.GREY_25_PERCENT.getIndex()
            );
            altNoImagesStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle metaDescriptionOkStyle = workbook.createCellStyle();
            metaDescriptionOkStyle.setFillForegroundColor(
                    IndexedColors.LIGHT_GREEN.getIndex()
            );
            metaDescriptionOkStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle metaDescriptionMissingStyle = workbook.createCellStyle();
            metaDescriptionMissingStyle.setFillForegroundColor(
                    IndexedColors.RED.getIndex()
            );
            metaDescriptionMissingStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle metaDescriptionEmptyStyle = workbook.createCellStyle();
            metaDescriptionEmptyStyle.setFillForegroundColor(
                    IndexedColors.ORANGE.getIndex()
            );
            metaDescriptionEmptyStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle seoGoodStyle = workbook.createCellStyle();
            seoGoodStyle.setFillForegroundColor(
                    IndexedColors.LIGHT_GREEN.getIndex()
            );
            seoGoodStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle seoNeedsImprovementStyle = workbook.createCellStyle();
            seoNeedsImprovementStyle.setFillForegroundColor(
                    IndexedColors.ORANGE.getIndex()
            );
            seoNeedsImprovementStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle seoPoorStyle = workbook.createCellStyle();
            seoPoorStyle.setFillForegroundColor(
                    IndexedColors.RED.getIndex()
            );
            seoPoorStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle seoCriticalStyle = workbook.createCellStyle();
            seoCriticalStyle.setFillForegroundColor(
                    IndexedColors.DARK_RED.getIndex()
            );
            seoCriticalStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            for (ReportEntry entry : entries){

                Row row = sheet.createRow(rowNumber++);

                row.createCell(0).setCellValue(entry.getUrl());
                row.createCell(1).setCellValue(entry.getWordCount());

                Cell statusCell = row.createCell(2);
                statusCell.setCellValue(entry.getStatus());

                Cell h1Cell = row.createCell(3);
                h1Cell.setCellValue(entry.getH1Status());

                switch (entry.getH1Status()) {

                    case "OK":
                        h1Cell.setCellStyle(h1OkStyle);
                        break;

                    case "MISSING":
                        h1Cell.setCellStyle(h1MissingStyle);
                        break;

                    case "MULTIPLE":
                        h1Cell.setCellStyle(h1MultipleStyle);
                        break;
                }

                Cell altCell = row.createCell(4);
                altCell.setCellValue(entry.getAltStatus());

                Cell metaDescriptionCell = row.createCell(5);
                metaDescriptionCell.setCellValue(entry.getMetaDescriptionStatus());

                Cell seoScoreCell = row.createCell(6);
                seoScoreCell.setCellValue(entry.getSeoScore());

                if (entry.getSeoScore() >= 80) {
                    seoScoreCell.setCellStyle(seoGoodStyle);

                } else if (entry.getSeoScore() >= 60) {
                    seoScoreCell.setCellStyle(seoNeedsImprovementStyle);

                } else if (entry.getSeoScore() >= 40) {
                    seoScoreCell.setCellStyle(seoPoorStyle);

                } else {
                    seoScoreCell.setCellStyle(seoCriticalStyle);
                }

                switch (entry.getAltStatus()) {

                    case "OK":
                        altCell.setCellStyle(altOkStyle);
                        break;

                    case "MISSING":
                        altCell.setCellStyle(altMissingStyle);
                        break;

                    case "NO IMAGES":
                        altCell.setCellStyle(altNoImagesStyle);
                        break;
                }

                switch (entry.getMetaDescriptionStatus()) {

                    case "OK":
                        metaDescriptionCell.setCellStyle(metaDescriptionOkStyle);
                        break;

                    case "MISSING":
                        metaDescriptionCell.setCellStyle(metaDescriptionMissingStyle);
                        break;

                    case "EMPTY":
                        metaDescriptionCell.setCellStyle(metaDescriptionEmptyStyle);
                        break;
                }

                switch (entry.getStatus()) {

                    case "OK":
                        statusCell.setCellStyle(okStyle);
                        break;

                    case "THIN CONTENT":
                        statusCell.setCellStyle(thinStyle);
                        break;

                    case "VERY THIN":
                        statusCell.setCellStyle(veryThinStyle);
                        break;

                    case "EMPTY":
                        statusCell.setCellStyle(emptyStyle);
                        break;
                }

            }

            sheet.setAutoFilter(
                    new org.apache.poi.ss.util.CellRangeAddress(
                            10,
                            rowNumber - 1,
                            0,
                            6
                    )
            );

            sheet.createFreezePane(0, 11);

            sheet.setColumnWidth(0, 80 * 256);
            sheet.setColumnWidth(1, 15 * 256);
            sheet.setColumnWidth(2, 20 * 256);
            sheet.setColumnWidth(3, 15 * 256);
            sheet.setColumnWidth(4, 15 * 256);
            sheet.setColumnWidth(5, 25 * 256);
            sheet.setColumnWidth(6, 15 * 256);

            try (FileOutputStream outputStream = new FileOutputStream(fileName)){
                workbook.write(outputStream);
            }
        } catch (IOException e){
            System.out.println("Failed to create Excel report: " + e.getMessage());
        }
    }
}
