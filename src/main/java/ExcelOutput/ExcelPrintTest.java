package ExcelOutput;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelPrintTest{
        public static void main (String [] args){
            excelPrint();
            System.out.println("[PROCESS DONE]");
        }


        static void excelPrint(){
            // Workbook 생성
            Workbook xlsxWb = new HSSFWorkbook(); // Excel 2007 이전 버전
            Workbook workbook = new SXSSFWorkbook(); // Excel 2007 이상
            CellStyle cellStyle_an = workbook.createCellStyle();
            Sheet sheet1_an = workbook.createSheet();
            Row row_an = null;
            Cell cell_an = null;
            // *** Sheet-------------------------------------------------

            // 컬럼 너비 설정

            sheet1_an.setColumnWidth(0, 2000);
            sheet1_an.setColumnWidth(1, 2800);
            sheet1_an.setColumnWidth(2, 2500);
            sheet1_an.setColumnWidth(3, 3500);
            sheet1_an.setColumnWidth(4, 3500);
            sheet1_an.setColumnWidth(5, 2500);
            sheet1_an.setColumnWidth(6, 2500);
            sheet1_an.setColumnWidth(7, 3000);
            // ----------------------------------------------------------

            // *** Style--------------------------------------------------

            // Cell 색깔, 무늬 채우기
//        cellStyle.setFillForegroundColor(HSSFColor.LIME.index);
//        cellStyle.setFillPattern(CellStyle.BIG_SPOTS);



            //sheet1_an.setColumnWidth(0, 1000);
            //sheet1_an.setColumnWidth(9, 1000);
            // 줄 바꿈
            cellStyle_an.setWrapText(true);
            // 첫 번째 줄
            row_an = sheet1_an.createRow(0);
            // 첫 번째 줄에 Cell 설정하기-------------
            cell_an = row_an.createCell(0);
            cell_an.setCellValue("등록일");
            cell_an = row_an.createCell(1);
            cell_an.setCellValue("메시지내용");
            cell_an = row_an.createCell(2);
            cell_an.setCellValue("고객번호");
            cell_an = row_an.createCell(3);
            cell_an.setCellValue("고객전화번호");
            cell_an = row_an.createCell(4);
            cell_an.setCellValue("프로그램명");
            cell_an = row_an.createCell(5);
            cell_an.setCellValue("PGM 코드");
            cell_an = row_an.createCell(6);
            cell_an.setCellValue("전시여부");
            cell_an = row_an.createCell(7);
            cell_an.setCellValue("관리자여부");
            cell_an.setCellStyle(cellStyle_an); // 셀 스타일 적용

            // excel 파일 저장
            try {
                File xlsFile = new File("C:\\Users\\Oscar\\Desktop\\Oscar_Documents\\testOscarExcel.xlsx");
                FileOutputStream fileOut = new FileOutputStream(xlsFile);
                workbook.write(fileOut);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
