package com.ojas.poc4.util;

import java.util.List;

import com.ojas.poc4.model.JobModel;
import com.ojas.poc4.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;


 

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author Prasad Rachamalla
 *
 */
public class ExcelFileReader {
	private static final Logger log = LoggerFactory.getLogger(ExcelFileReader.class);
	 public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	    static String[] HEADERs = { "id", "availability", "country", "experience", "job_description","job_type", "job_title",
	    		 "language","pay_rate", "reply_rate", "skills", "state", "user_name_id" };

	 

	    static String SHEET = "Worksheet";

	 

	    public static boolean hasExcelFormat(MultipartFile file) {

	 

	        if (!TYPE.equals(file.getContentType())) {
	            return false;
	        }
	        return true;
	    }

	 

	    public static List<JobModel> readExcel(InputStream is) {
	    	log.error("In excelToDb");
	        try {
	            Workbook workbook = new XSSFWorkbook(is);

	 

	            Sheet sheet = workbook.getSheet(SHEET);
	            Iterator<Row> rows = sheet.iterator();

	 

	            List<JobModel> jobs = new ArrayList<>();

	 

	            int rowNumber = 0;
	            while (rows.hasNext()) {
	                Row currentRow = rows.next();

	 

	                // skip header
	                if (rowNumber == 0) {
	                    rowNumber++;
	                    continue;
	                }

	 

	                Iterator<Cell> cellsInRow = currentRow.iterator();

	 

	                JobModel job = new JobModel();

	 

	                int cellIdx = 0;
	                while (cellsInRow.hasNext()) {
	                    Cell currentCell = cellsInRow.next();

	 

	                    switch (cellIdx) {
	                    case 0:
	                        job.setId(Long.valueOf((int)currentCell.getNumericCellValue()));
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
	                    case 12:
	                        User user = new User();
	                        Long id = Long.valueOf((int)currentCell.getNumericCellValue());
	                        user.setId(id);
	                        job.setUserInfo(user);
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
	        	log.error(e.getMessage());
	            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	        }
	    }
	
}
