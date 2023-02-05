package com.ricky.read_file.service;

import com.ricky.read_file.model.PersonDataResponse;
import com.ricky.read_file.util.DateTimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
@Service("readFileService")
public class ReadFileService {

    @Autowired
    DateTimeFormatUtil dateTimeFormatUtil;

    public PersonDataResponse buildResponse() throws FileNotFoundException {
        File text = new File("C:\\Users\\Public\\Documents\\test.txt");
        Scanner scanner = new Scanner(text);
        ArrayList<String> list = new ArrayList<>();
        PersonDataResponse response = new PersonDataResponse();

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        response.setName(list.get(0));
        response.setAddress(list.get(1));
        response.setBirthDate(list.get(2));
        LocalDate checkInDate = dateTimeFormatUtil.stringToLocalDate(list.get(2), "dd-MM-yyyy");
        response.setAge(calculateAge(checkInDate,LocalDate.now()));

        return response;
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
