
package com.example.ps_project.configuration;

import com.example.ps_project.controller.UserControllerCSV;
import com.example.ps_project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@Configuration
public class CSVConfiguration implements CommandLineRunner {

    private final UserControllerCSV userControllerCSV;

    @Autowired
    public CSVConfiguration(UserControllerCSV userControllerCSV) {
        this.userControllerCSV = userControllerCSV;
    }


    @Override
    public void run(String... args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("user.csv"));
        String currentline;
        String[] currentDetails;
        long userId = 0;
        while ((currentline = reader.readLine()) != null) {
            currentDetails = currentline.split(";");
            User newUser = new User( userId++, currentDetails[0],currentDetails[1],currentDetails[2]);
            //System.out.println(newUser.getId() + " " + newUser.getFirstName() + " " + newUser.getLastName() + " " + newUser.getEmail());
            userControllerCSV.registerNewUser(newUser);
        }

        for(User user:userControllerCSV.getUsers()){
            System.out.println(user.getEmail());
        }
        reader.close();

   }
}

