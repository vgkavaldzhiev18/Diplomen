package com.app.pizzashop.initialization;

import com.app.pizzashop.entity.Topping;
import com.app.pizzashop.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ToppingInit implements CommandLineRunner {
    private ToppingRepository repository;

    @Autowired
    public ToppingInit(ToppingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count()==0){
            repository.save(new Topping("Чедър", 0.50));
            repository.save(new Topping("Пресни домати", 0.50));
            repository.save(new Topping("Кисели краставички", 0.50));
            repository.save(new Topping("Пармезан", 0.50));
            repository.save(new Topping("Прошуто", 0.50));
            repository.save(new Topping("Пилешко филе", 0.50));
            repository.save(new Topping("Рукола", 0.50));
            repository.save(new Topping("Риба тон", 0.50));
            repository.save(new Topping("Гъби", 0.50));
            repository.save(new Topping("Царевица", 0.50));
            repository.save(new Topping("Ананас", 0.50));
            repository.save(new Topping("Краве сирене", 0.50));
            repository.save(new Topping("Пушен бекон", 0.50));
            repository.save(new Topping("Салам", 0.50));
            repository.save(new Topping("Лук", 0.50));
        }
    }
}
