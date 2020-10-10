package com.ojas.job;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.exception.RecordNotFoundException;
import com.ojas.user.User;
import com.ojas.user.UserService;

@Component
public class ExcelHelper {

	@Autowired
	private UserService userService;
	// public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	public static String TYPE = "application/octet-stream";

	static String SHEET = "Worksheet";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public List<Job> excelToTutorials(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Job> jobs = new ArrayList<>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Job job = new Job();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {

					case 0:
						int id = (int) currentCell.getNumericCellValue();

						User userById = userService.getUserById(id);
						if (userById == null) {
							throw new RecordNotFoundException("user with user id" + id + "not found");
						}
						job.setUserInfo(userById);

						break;

					case 1:
						job.setAvailability(currentCell.getStringCellValue());

						break;

					case 2:
						job.setCountry(currentCell.getStringCellValue());

						break;
					case 3:
						job.setExperience((int) currentCell.getNumericCellValue());

						break;
					case 4:
						job.setJobDescription(currentCell.getStringCellValue());

						break;
					case 5:
						job.setJobTitle(currentCell.getStringCellValue());

						break;
					case 6:
						job.setJobType(currentCell.getStringCellValue());

						break;
					case 7:
						job.setLanguage(currentCell.getStringCellValue());

						break;
					case 8:
						job.setPayRate((int) currentCell.getNumericCellValue());

						break;
					case 9:
						job.setReplyRate((int) currentCell.getNumericCellValue());

						break;
					case 10:
						job.setSkills(currentCell.getStringCellValue());

						break;
					case 11:
						job.setState(currentCell.getStringCellValue());

						break;

					default:
						break;
					}

					cellIdx++;
				}
				jobs.add(job);
			}

			workbook.close();

			return jobs;
		} catch (

		IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

}
