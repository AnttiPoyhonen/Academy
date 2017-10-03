package fi.academy.maanantai;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Paivat {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(Calendar.getInstance());
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
    }
}
