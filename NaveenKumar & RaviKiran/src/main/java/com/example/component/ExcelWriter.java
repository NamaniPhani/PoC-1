package com.example.component;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.model.JobPortal;

public class ExcelWriter {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "id", "availability", "country", "experience", "job_description", "job_title",
			"pay_rate", "reply_rate", "skills", "state", "user_name_id", "job_type", "language" };
	static String SHEET = "Tutorials";

	public static ByteArrayInputStream tutorialsToExcel(List<JobPortal> tutorials) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (JobPortal tutorial : tutorials) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(tutorial.getId());
				row.createCell(1).setCellValue(tutorial.getAvailability());
				row.createCell(2).setCellValue(tutorial.getCountry());
				row.createCell(3).setCellValue(tutorial.getExperience());
				row.createCell(4).setCellValue(tutorial.getJobDescription());
				row.createCell(5).setCellValue(tutorial.getJobTitle());
				row.createCell(6).setCellValue(tutorial.getPayRate());
				row.createCell(7).setCellValue(tutorial.getSkills());
				row.createCell(8).setCellValue(tutorial.getState());
				row.createCell(9).setCellValue(tutorial.getUserInfo().getUsername());
				row.createCell(10).setCellValue(tutorial.getUserInfo().getId());
				row.createCell(11).setCellValue(tutorial.getJobType());
				row.createCell(12).setCellValue(tutorial.getLanguage());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}
}
