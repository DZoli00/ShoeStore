//package com.example.ps_project.configuration;
//
//import com.example.ps_project.entity.User;
//import com.opencsv.CSVParser;
//import com.opencsv.CSVParserBuilder;
//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.CsvToBeanBuilder;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.Reader;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.stream.Stream;
//
//@Configuration
//public class CSVConfiguration implements CommandLineRunner {
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        BufferedReader reader = new BufferedReader(new FileReader("user.csv"));
//        String currentline;
//        String[] currentDetails;
//        while ((currentline = reader.readLine()) != null) {
//            System.out.println(currentline);
//            currentDetails = currentline.split(";");
//            System.out.println(currentDetails[0]);
//        }
//        reader.close();
//
//    }
//}
