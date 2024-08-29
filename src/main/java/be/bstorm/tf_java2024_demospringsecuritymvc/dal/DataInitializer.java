package be.bstorm.tf_java2024_demospringsecuritymvc.dal;

import be.bstorm.tf_java2024_demospringsecuritymvc.dal.repositories.UserRepository;
import be.bstorm.tf_java2024_demospringsecuritymvc.dl.entities.User;
import be.bstorm.tf_java2024_demospringsecuritymvc.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("User", passwordEncoder.encode("Test1234="), Set.of(UserRole.USER),true);
        User admin = new User("Admin", passwordEncoder.encode("Test1234="), Set.of(UserRole.ADMIN),true);
        userRepository.save(user);
        userRepository.save(admin);
    }
}
