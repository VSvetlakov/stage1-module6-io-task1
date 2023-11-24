package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        Profile profile = null;

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))){

            String line;

            String name = "";
            Integer age = null;
            String email = "";
            Long phone = null;

            while ((line = bufferedReader.readLine()) != null) {

                String[] words = line.split(":");

                if (words.length != 2){
                    continue;
                }

                if (words[0].equals("Name")){
                    name = words[1].trim();
                } else if (words[0].equals("Age")) {
                    age = Integer.parseInt(words[1].trim());
                } else if (words[0].equals("Email")) {
                    email = words[1].trim();
                } else if (words[0].equals("Phone")) {
                    phone = Long.parseLong(words[1].trim());
                }
            }

            profile = new Profile(name,age,email,phone);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
