package fi.academy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// !!! adapted from https://spring.io/guides/gs/relational-data-access/

@SpringBootApplication
public class Application {
//public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
//
//    @Autowired
//    JdbcTemplate jdbc;
//
//    @Override
//    public void run(String... params) throws Exception {
//
//        // print progress to log/console
//        // log.info("DB preparation");
//        System.out.println("\nLOG - DB preparation");
//
//        jdbc.execute("DROP TABLE customers IF EXISTS");
//        jdbc.execute("CREATE TABLE customer(" +
//                "id SERIAL, firstname VARCHAR(255), lastname VARCHAR(255))");
//
//        // name array to firsname/lastname array inside a list
//        List<Object[]> splitUpNames = Arrays.asList("Andy Zerkis", "Bill Goldblum", "Charlie Factory", "Daniela Oklahoma")
//                .stream()
//                .map(s -> s.split(" "))
//                .collect(Collectors.toList());
//
//        // print name pairs from arrays in the list (log & console)
//        // splitUpNames.forEach(s -> log.info(String.format("Customer insert: %s %s", s[0], s[1])));
//        splitUpNames.forEach(s -> System.out.println("Customer: " + String.format("%s %s", s[0], s[1])));
//
//        // Jdbc: batchUpdate to insert all customers from list
//        jdbc.batchUpdate("INSERT INTO customer(firstname, lastname) VALUES (?,?)", splitUpNames);
//
//        // Query to ascertain data in db
//
//        // og.info("Query for all records:");
//        System.out.println("\nQuery for all records:");
//
//        jdbc.query(
//                "SELECT id, firstname, lastname FROM customer",
//                (rs, rowNum) ->
//                        new Customer(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"))
//        ).forEach(
//                customer -> {
//                    // log.info(customer.toString());
//                    System.out.println(customer.toString());
//                }
//        );
//
//
//        // log.info("Query for a record of firstname = 'Charlie':");
//        System.out.println("\nQuery for a record of firstname = 'Charlie':");
//
//        jdbc.query(
//                "SELECT id, firstname, lastname FROM customer WHERE firstname = ?", new Object[] { "Charlie" },
//                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"))
//        ).forEach(
//                customer -> {
//                    // log.info(customer.toString());
//                    System.out.println(customer.toString());
//                }
//        );
//
//        System.out.println("");
//
//    }
}