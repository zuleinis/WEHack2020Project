package com.toyotaservice.toyotaapplication;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Controller
public class WebController {

    @GetMapping("/addCity")
    public String submitForm(User user) throws IOException
    {


        String excelFilePath = "Query 1.xlsx";

        //Get Excel Data 
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));


        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        Row nextRow = iterator.next();
        Iterator<Cell> cellIterator = nextRow.cellIterator();

      
            //First row, with the assummption we know the Cell data type for each row 
            Cell cell = cellIterator.next();
            user.setName(cell.getStringCellValue());
            

            //Company Address 
           cell = cellIterator.next();
           user.setAddress(cell.getStringCellValue());
         

           //Distance
           cell = cellIterator.next();
           user.setDistance(cell.getNumericCellValue());
           


           //Appointment Date
           cell = cellIterator.next();
           user.setDate( cell.getDateCellValue());
           

           //Appointment Time 
           cell = cellIterator.next();
           user.setTime(cell.getTimeCellValue();

           /**Second Problem was finding away to push the results to the HTML file  */

           //Return the values as a text to be sent as the city value
           /**Was kinda stuck on dealing with this issue lol if I understood HTML better I would have a better submission */
           user.setName(user.toString());

       
        

        



       
        return "addCity";
    }
    

    @PostMapping("/addCity")
    public String processForm(User user)
    {
        //Returns the stored data to be viewed on the given HTML Template 
        return "form.html";
    }
    
}
