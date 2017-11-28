package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner init(UserRepository userRepository, CompanyRepository companyRepository){
        return (evt) -> {
            Address[] addresses = {
                    new Address("1200 Pennsylvania Avenue", "Washington", "00000"),
                    new Address("Mannerheimintie 12", "Helsinki", "00000")
            };
            User[] users = {
                    new User("John Doe", "john@acme.com"),
                    new User("Mikki Hiiri", "mickey13@disney.com"),
                    new User("Matti Meikäläinen", "masa@suomi.fi"),
                    new User("John Doe", "john@fbi.gov")
            };
            Company[] companies = {
                    new Company("Anonymous"),
                    new Company("Evil corporation"),
                    new Company("Academy Finland"),
                    new Company("Academy Sweden")
            };
            users[3].setAddress(addresses[0]);
            users[2].setAddress(addresses[1]);
            companies[0].addUser(users[3]);
            companies[1].addUser(users[1]);
            companies[2].addUser(users[0]);
            companies[2].addUser(users[2]);
            for(Company c : companies)
                companyRepository.save(c);
        };
    }
}