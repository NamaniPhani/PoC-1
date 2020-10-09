package com.emp.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "job_id", "availability", "country", "experience", "job_description", "job_title",
			"job_type", "language_id", "pay_rate", "reply_rate", "skills_id", "state", "user_name_id" };

	static String SHEET = "Worksheet";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Job> excel(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Job> jobs = new ArrayList<>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skipping the header
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
						job.setJobId((int) currentCell.getNumericCellValue());
						break;

					case 1:
						job.setAvailability(currentCell.getStringCellValue());
						break;

					case 2:
						job.setCountry(currentCell.getStringCellValue());
						break;

					case 3:
						job.setExperience((float) currentCell.getNumericCellValue());
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
						Language language=new Language();
						int id=(int) currentCell.getNumericCellValue();
						language.setLanguageId(id);
						job.setLanguage(language);
						
						break;

					case 8:
						job.setPayRate((int) currentCell.getNumericCellValue());
						break;
					case 9:
						job.setReplyRate((int) currentCell.getNumericCellValue());
						break;
					case 10:
						Skills skills=new Skills();
						int id1=(int) currentCell.getNumericCellValue();
						skills.setSkillsId(id1);
						job.setSkills(skills);
						break;
					case 11:
						job.setState(currentCell.getStringCellValue());
						break;
					case 12:
						User user = new User();
						int id2 = (int) currentCell.getNumericCellValue();
						user.setUserId(id2);
						job.setUser(user);
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
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
