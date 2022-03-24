package com.example.ps_project.configuration;

import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.Product;
import com.example.ps_project.entity.User;
import com.example.ps_project.repository.CategoryRepository;
import com.example.ps_project.repository.ProductRepository;
import com.example.ps_project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//fisierul de configuratie practic initializeaza tabelel din baza de date cu obiectele create

@Configuration
public class ConfigurationFile {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        return args -> {

            User zoltan = new User("Zoltan", "Darlaczi", "darlaczi.zoltan@gmail.com");

            User alex = new User("Alex", "Alex", "alex.alex@gmail.com");

            Category shoes = new Category("Shoes", "Best shoes in town");

            Category shorts = new Category("Shorts", "Best shorts for sport");

            Product nikeCourtV = new Product("Under Army", (float) 120.4, (float) 2.4, "asdddfasd", "WHITE", "NIKE");
            Product adidasNano = new Product("Nano", (float) 243.4, (float) 3.4, "arwefewrfew", "BLACK", "adidas");

            shoes.getProductList().add(nikeCourtV);
            shoes.getProductList().add(adidasNano);
            nikeCourtV.setCategory(shoes);
            adidasNano.setCategory(shoes);

            userRepository.saveAll(List.of(zoltan, alex));
            categoryRepository.saveAll(List.of(shoes, shorts));
            productRepository.saveAll(List.of(nikeCourtV,adidasNano));
        };
    }
}
