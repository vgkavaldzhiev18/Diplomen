package com.app.pizzashop.initialization;

import com.app.pizzashop.entity.Sauce;
import com.app.pizzashop.repository.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SauceInit implements CommandLineRunner {
    private SauceRepository repository;

    @Autowired
    public SauceInit(SauceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0){

         repository.save(new Sauce("Барбекю",0.50));
         repository.save(new Sauce("Трюфел",0.50));
         repository.save(new Sauce("Кетчуп",0.50));
         repository.save(new Sauce("Майонеза",0.50));
         repository.save(  new Sauce("Доматен сос",0.50));
        }

    }
}
