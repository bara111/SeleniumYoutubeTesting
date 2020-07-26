package infrastructure;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static util.ReadExcelFile.readExcel;

public class YoutubeSearchQueryDataProvider {
    public static ArrayList<Object[]> getDataFromExcel() throws IOException {
        ArrayList<Object[]> list = new ArrayList<>();
        Sheet sheet = readExcel("src" + "\\", "youtubeSearchQueryData.xlsx", "testYoutubeSearchQuery");
        int lastRowCount = sheet.getLastRowNum() + 1;
        for (int i = 1; i < lastRowCount; i++) {
            String run = sheet.getRow(i).getCell(0).getStringCellValue();
            String query = sheet.getRow(i).getCell(1).getStringCellValue();
            Object[] ob = {run, query};
            if (run.equals("do")) {
                list.add(ob);
            }
        }
        return list;
    }

    @DataProvider
    public static Iterator<Object[]> youtubeSearchQueryProvider() throws IOException {
        ArrayList<Object[]> list = getDataFromExcel();
        return list.iterator();
    }
}
