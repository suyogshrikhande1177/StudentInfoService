package com.atdev.service_by_suyog.utils;

import com.atdev.service_by_suyog.models.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExportFile {

    public ByteArrayInputStream createXlsFileNew(JSONArray jArr, String headers, String dataiIndex, String headerFirst, String dataIndFirst, String examheading) {
        byte[] bytes = new byte[0];
        try {
            int rowcount = 0;
            String[] headerArr = headers.split(",");
            String[] indexArr = dataiIndex.split(",");

            String[] headerArrFirst = headerFirst.split(",");
            String[] indexArrFirst = dataIndFirst.split(",");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            org.apache.poi.ss.usermodel.Workbook wb = new HSSFWorkbook();
            Sheet studentSheet = wb.createSheet("Center All Student");

            org.apache.poi.ss.usermodel.Font font = wb.createFont();
            font.setFontHeightInPoints((short) 10);
            font.setBold(true);

            org.apache.poi.ss.usermodel.Font headingFont = wb.createFont();
            headingFont.setFontHeightInPoints((short) 10);
            headingFont.setBold(true);

            CellStyle headStyle = wb.createCellStyle();
            headStyle.setAlignment(HorizontalAlignment.CENTER);
            headStyle.setWrapText(true);
            headStyle.setFont(font);

            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setBorderBottom(BorderStyle.MEDIUM);
            cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderLeft(BorderStyle.MEDIUM);
            cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderRight(BorderStyle.MEDIUM);
            cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderTop(BorderStyle.MEDIUM);
            cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setFont(headingFont);

            //firstrow
            Row headerRow1 = studentSheet.createRow(rowcount);
            headerRow1.createCell(1).setCellValue("Maharashtra State Council Of Examination , Pune");
            headerRow1.getCell(1).setCellStyle(headStyle);
            headerRow1.setHeight((short) 700);
            studentSheet.addMergedRegion(new CellRangeAddress(0, 0, 1, headerArr.length - 2));

            rowcount++;
            if (jArr != null && jArr.length() > 0) {
                //secondrow
                Row headerRow2 = studentSheet.createRow(rowcount);
                JSONObject jsonobjfirst = (JSONObject) jArr.get(0);
                StringBuilder sb = new StringBuilder();
                for (int ind = 0; ind < indexArrFirst.length; ind++) {
                    String head = headerArrFirst[ind];
                    String val = (String) jsonobjfirst.get(indexArrFirst[ind]);
                    sb.append(head);
                    sb.append(val);
                    sb.append("   ");
                }
                headerRow2.createCell(1).setCellValue(sb.toString());
                headerRow2.getCell(1).setCellStyle(headStyle);

                studentSheet.addMergedRegion(new CellRangeAddress(1, 1, 1, headerArr.length - 2));

                rowcount++;
                Row language = studentSheet.createRow(rowcount);
                language.createCell(1).setCellValue(examheading);
                language.getCell(1).setCellStyle(headStyle);
                studentSheet.addMergedRegion(new CellRangeAddress(2, 2, 1, headerArr.length - 2));
                rowcount += 2;
                //thirdrow
                Row colmheaderrw = studentSheet.createRow(rowcount);
                for (int j = 0; j < headerArr.length; j++) {

                    colmheaderrw.createCell(j).setCellValue(headerArr[j]);
                    colmheaderrw.getCell(j).setCellStyle(cellStyle);
                }
                for (int i = 0; i < jArr.length(); i++) {
                    rowcount++;
                    Row datarow = studentSheet.createRow(rowcount);
                    JSONObject jsonobj = (JSONObject) jArr.get(i);
                    for (int ind = 0; ind < indexArr.length; ind++) {
                        String val = (String) jsonobj.get(indexArr[ind]);
                        datarow.createCell(ind).setCellValue(val);
                        datarow.getCell(ind).setCellStyle(cellStyle);
                        studentSheet.autoSizeColumn(ind);
                    }
                }
            } else {
                rowcount++;
                Row headerNull = studentSheet.createRow(rowcount);
                headerNull.createCell(1).setCellValue("NO STUDENT RECORD");
                headerNull.getCell(1).setCellStyle(headStyle);
                studentSheet.addMergedRegion(new CellRangeAddress(rowcount, rowcount, 1, headerArr.length - 2));
            }
            wb.write(byteArrayOutputStream);
            bytes = byteArrayOutputStream.toByteArray();

            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(bytes);
    }

    public ByteArrayInputStream createXlsFileNew(List<Student> students,String header) {
        ByteArrayOutputStream outputStream = null;
        try(Workbook workbook = new XSSFWorkbook();ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("All Students");
            String[] columns = header.split(",");
            // Header Row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }
            int rowIdx = 1;
//            "Sr.No,First Name,Middle Name,Last Name,Gender," +
//                    "Mother Name,Qualification,Address,Mobile,Date of Birth,Date_Of_Admission,Taluka,District,Handicapped"
            for (Student student : students) {
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(rowIdx);
                row.createCell(1).setCellValue(student.getFirstName());
                row.createCell(2).setCellValue(student.getMiddleName());
                row.createCell(3).setCellValue(student.getLastName());
                row.createCell(4).setCellValue(student.getGender());
                row.createCell(5).setCellValue(student.getMotherName());
                row.createCell(6).setCellValue(student.getQualification());
                row.createCell(7).setCellValue(student.getAddress());
                row.createCell(8).setCellValue(student.getMobileNum());
                row.createCell(9).setCellValue(student.getDob());
                row.createCell(10).setCellValue(student.getDtOfAdmsn());
                row.createCell(11).setCellValue(student.getTaluka());
                row.createCell(12).setCellValue(student.getDistrict());
                row.createCell(13).setCellValue(student.getHandicapped());
                rowIdx++;
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
