package com.app.pizzashop.initialization;

import com.app.pizzashop.entity.Size;
import com.app.pizzashop.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SizeInit implements CommandLineRunner {
    private SizeRepository repository;

    @Autowired
    public SizeInit(SizeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count()==0){
            Size thirtyCM = new Size(30,3);
            Size thirtySixCM = new Size(36, 4);
            repository.save(thirtyCM);
            repository.save(thirtySixCM);

        }
    }
}
