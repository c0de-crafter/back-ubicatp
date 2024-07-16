package com.cico.backubicatp.config;

import com.cico.backubicatp.model.User;
import com.cico.backubicatp.repo.IUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final IUserRepo userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(IUserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Cargar datos iniciales en la base de datos
        userRepository.save(new User(1, "luis@gmail.com", passwordEncoder.encode("1234"), "Luis", "Gorpa", "luis_picture.png", "admin"));
        userRepository.save(new User(2, "maria.rodriguez@example.com", passwordEncoder.encode("password1"), "Maria", "Rodriguez", "maria_picture.png", "admin"));
        userRepository.save(new User(3, "juan.perez@example.com", passwordEncoder.encode("password2"), "Juan", "Perez", "juan_picture.png", "admin"));
        userRepository.save(new User(4, "ana.lopez@example.com", passwordEncoder.encode("password3"), "Ana", "Lopez", "ana_picture.png", "admin"));
        userRepository.save(new User(5, "carlos.gomez@example.com", passwordEncoder.encode("password4"), "Carlos", "Gomez", "carlos_picture.png", "admin"));
        userRepository.save(new User(6, "laura.martinez@example.com", passwordEncoder.encode("password5"), "Laura", "Martinez", "laura_picture.png", "admin"));
    }
}