package com.cico.backubicatp.config;

import com.cico.backubicatp.model.User;
import com.cico.backubicatp.repo.IUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final IUserRepo userRepository;

    public DataLoader(IUserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Cargar datos iniciales en la base de datos
        userRepository.save(new User(1, "luis@gmail.com", "1234", "luis", "gorpa", "picture.png", "admin"));
    }
}