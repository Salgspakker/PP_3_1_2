package com.vadimzhavoronkov.springboot.pp_3_1_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AppInitMain {

    public static void main(String[] args) {
        SpringApplication.run(AppInitMain.class, args);
        openHomePage();
    }

    private static void openHomePage() {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080");
        } catch (IOException e) {
            System.out.println("Unable to start web application view");
            e.printStackTrace();
        }
    }
}
