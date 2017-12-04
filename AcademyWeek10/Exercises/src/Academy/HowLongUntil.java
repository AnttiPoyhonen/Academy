package Academy;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class HowLongUntil {

    private static LocalDate nowDate = LocalDate.now();
    private static LocalDateTime nowDateTime = LocalDateTime.now();

    private static LocalDate inputDate = null;
    private static LocalTime inputTime = null;

    private static LocalDateTime targetDateTime = null;

    private static Period periodBetween = null;
    private static Duration durationBetween = null;
    
    private static String between = "";

    public static void main(String[] args) {

        // query for localdate and localtime
        queryDateAndTime();

        // create localdatetime (if localtime entered)
        if (inputTime != null) createDateTime();
        
        // calculate period or duration between
        calculateBetween();
        
        // print period or duration between
        System.out.println("\nThe amount of time between now and the target is: " + between + "\n");
    }

    private static void queryDateAndTime() {

        try (Scanner in = new Scanner(System.in)) {
            
            System.out.println("");

            System.out.println("What is the target date? (yyyy-MM-dd; next christmas if left empty)");
            String dateString = in.nextLine();
            if ("".equals(dateString)) {                                
                inputDate = getChristmas();
            } else {
                try {
                    inputDate = LocalDate.parse(dateString);
                } catch (DateTimeParseException e) {
                    System.out.println("Could not parse date, calculating for next christmas!");
                    inputDate = getChristmas();
                }
            }
            
            System.out.println("");
            
            System.out.println("What is the target time? (HH:mm; calculating using days if left empty)");
            String timeString = in.nextLine();
            
            if(!"".equals(timeString)) {
                try {
                    if (timeString.length() == 4) inputTime = LocalTime.parse(timeString.substring(0, 2) + ":" + timeString.substring(2));
                    else inputTime = LocalTime.parse(timeString);
                } catch (DateTimeParseException e) {
                    System.out.println("Could not parse time, calculating using days.");
                }
            }

        }

    }

    private static LocalDate getChristmas() {
        
                String nowYear;

                if (nowDate.getMonth().getValue() == 12 && nowDate.getDayOfMonth() > 25) {
                    nowYear = "" + (nowDate.getYear() + 1);
                } else {
                    nowYear = "" + nowDate.getYear();
                }
                
                return LocalDate.parse(nowYear + "-12-24");
                
    }

    private static void createDateTime() {
        
        // Turn Date + Time objects to a parseable DateTime String
        String datetime = "";        
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");        
        datetime += inputDate + "T" + inputTime.format(tf);
        
        // create DateTime from the String
        targetDateTime = LocalDateTime.parse(datetime);
        
    }

    private static void calculateBetween() {
        
        if (targetDateTime != null) {
            calculateDuration();
        } else {
            calculatePeriod();
        }
        
    }

    private static void calculatePeriod() {
        
        periodBetween = Period.between(nowDate, inputDate);
        
        int years = periodBetween.getYears();
        int months = periodBetween.getMonths();
        int days = periodBetween.getDays();
        
        long totalDays = ChronoUnit.DAYS.between(nowDate, inputDate);
        
        between = "Total " + totalDays + " days, meaning " + years + " years, " + months + " months and " + days + " days."; 
        
    }
    
    private static void calculateDuration() {
        
        durationBetween = Duration.between(nowDateTime, targetDateTime);
        
        long days = durationBetween.toDays();
        long hours = durationBetween.toHours() - days * 24;
        long minutes = durationBetween.toMinutes() - hours * 60 - days * 24 * 60;
        long seconds = durationBetween.getSeconds() - minutes * 60 - hours * 60 * 60 - days * 24 * 60 * 60;
        
        between = days + " days, " + hours + " hours, " + minutes + " minutes and " + seconds + " seconds.";
        
    }


}
