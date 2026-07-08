package com.cognizant;

import com.cognizant.model.Stock;
import com.cognizant.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication
                .run(OrmLearnApplication.class, args);

        OrmLearnApplication app = context.getBean(OrmLearnApplication.class);

        app.testFacebookSeptember2019();
        app.testGoogleCloseGreaterThan1250();
        app.testTop3HighestVolume();
        app.testTop3LowestNetflix();
    }

    // Test 1 - Facebook stocks in September 2019
    public void testFacebookSeptember2019() {
        System.out.println("\n--- Facebook Stocks Sep 2019 ---");
        List<Stock> list = stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        );
        list.forEach(s -> System.out.println(
                s.getCode() + " | " + s.getDate() +
                        " | " + s.getOpen() + " | " + s.getClose() +
                        " | " + s.getVolume()));
    }

    // Test 2 - Google stocks where close > 1250
    public void testGoogleCloseGreaterThan1250() {
        System.out.println("\n--- Google Stocks Close > 1250 ---");
        List<Stock> list = stockRepository
                .findByCodeAndCloseGreaterThan("GOOGL", 1250.0);
        list.forEach(s -> System.out.println(
                s.getCode() + " | " + s.getDate() +
                        " | " + s.getOpen() + " | " + s.getClose() +
                        " | " + s.getVolume()));
    }

    // Test 3 - Top 3 highest volume
    public void testTop3HighestVolume() {
        System.out.println("\n--- Top 3 Highest Volume ---");
        List<Stock> list = stockRepository.findTop3ByOrderByVolumeDesc();
        list.forEach(s -> System.out.println(
                s.getCode() + " | " + s.getDate() +
                        " | " + s.getOpen() + " | " + s.getClose() +
                        " | " + s.getVolume()));
    }

    // Test 4 - Top 3 lowest Netflix stocks
    public void testTop3LowestNetflix() {
        System.out.println("\n--- Top 3 Lowest Netflix Stocks ---");
        List<Stock> list = stockRepository
                .findTop3ByCodeOrderByCloseAsc("NFLX");
        list.forEach(s -> System.out.println(
                s.getCode() + " | " + s.getDate() +
                        " | " + s.getOpen() + " | " + s.getClose() +
                        " | " + s.getVolume()));
    }
}