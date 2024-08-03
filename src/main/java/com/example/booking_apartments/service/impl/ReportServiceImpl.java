package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.model.entity.AddressEntity;
import com.example.booking_apartments.model.entity.BookingInfoEntity;
import com.example.booking_apartments.repository.BookingInfoRepository;
import com.example.booking_apartments.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final BookingInfoRepository bookingInfoRepository;

    @Override
    public void createReport() {

        List<BookingInfoEntity> all = bookingInfoRepository.findAll();
        File file = new File("C:\\Users\\user\\IdeaProjects\\booking_apartments\\booking_reports.xlsx");
        try (FileInputStream input = new FileInputStream(file);
             Workbook book = new XSSFWorkbook(input)) {

            Sheet sheet = book.getSheetAt(0);
            int counter = 1;

            for (BookingInfoEntity info : all) {
                Row row = sheet.createRow(counter++);
                AddressEntity address = info.getApartment().getAddressEntity();
                row.createCell(0).setCellValue(address.getCity() + " " + address.getStreet() + " " + address.getApartmentNumber());
                row.createCell(1).setCellValue(info.getStartDate());
                row.createCell(2).setCellValue(info.getEndDate());
                row.createCell(3).setCellValue(getFullPrice(info));
                row.createCell(4).setCellValue(getFullPrice(info));
                //info.getPrice()
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            book.write(outputStream);
            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFullPrice(BookingInfoEntity entity) {

        Double discount = entity.getDiscount().getDiscount();
        Double entityPrice = entity.getPrice();
        Double full = (100.0 + discount);
        double v = entityPrice * full;
        return String.valueOf(v);

    }

}
