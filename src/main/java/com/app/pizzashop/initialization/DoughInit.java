package com.app.pizzashop.initialization;

import com.app.pizzashop.entity.Dough;
import com.app.pizzashop.repository.DoughRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DoughInit  implements CommandLineRunner {
    private DoughRepository repository;

    @Autowired
    public DoughInit(DoughRepository repository) {
        this.repository = repository;
    }




    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0){
            Dough white = new Dough("Бяло", 3);
            Dough b = new Dough("Пълнозърнесто", 3);
            repository.save(white);
            repository.save(b);
        }
    }
}
