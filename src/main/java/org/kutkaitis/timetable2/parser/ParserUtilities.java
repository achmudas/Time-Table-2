package org.kutkaitis.timetable2.parser;

import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 *
 * @author achmudas
 */
public class ParserUtilities {
    /**
	 * This method for the type of data in the cell, extracts the data and
	 * returns it as a string.
	 */
	public static String getCellValueAsString(XSSFCell cell) {
		String strCellValue = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_STRING:
				strCellValue = cell.toString();
				break;
			case XSSFCell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					strCellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					Double value = cell.getNumericCellValue();
					Long longValue = value.longValue();
					strCellValue = longValue.toString();
				}
				break;
			case XSSFCell.CELL_TYPE_BOOLEAN:
				strCellValue = new Boolean(cell.getBooleanCellValue()).toString();
				break;
			case XSSFCell.CELL_TYPE_BLANK:
				strCellValue = "";
				break;
			}
		}
		return strCellValue;
	}
    
}
