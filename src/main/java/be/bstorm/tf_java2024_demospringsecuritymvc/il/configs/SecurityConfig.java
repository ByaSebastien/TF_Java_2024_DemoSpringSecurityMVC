package be.bstorm.tf_java2024_demospringsecuritymvc.il.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(a ->
                        a.requestMatchers("/login", "/register", "/home").permitAll()
                                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").permitAll()
                        .defaultSuccessUrl("/home",true))
                .logout(logout -> logout.logoutUrl("/logout")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true))
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
