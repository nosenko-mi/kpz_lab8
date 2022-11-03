package com.example;

import com.example.datasource.DataSource;
import com.example.datasource.FileDataSource;
import com.example.decorators.CompressionDecorator;
import com.example.decorators.DataSourceDecorator;
import com.example.decorators.EncryptionDecorator;
import com.example.facade.VideoConversionFacade;

import java.io.File;

public class Main {

    public static void main(String[] args) {
//        decoratorExample();
        facadeExample();
    }

    private static void facadeExample() {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
    }

    public static void decoratorExample(){
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/OutputDemo.txt")));

//        encoded -> (CompressionDecorator(EncryptionDecorator(salaryRecords)))

        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
