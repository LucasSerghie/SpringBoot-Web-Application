package com.example.demo.configuration;

import com.example.demo.domain.*;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.ReceiptRepository;
import com.example.demo.repository.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner ClientCommandLineRunner(ClientRepository clientRepository, ManagerRepository managerRepository, StoreRepository storeRepository, ReceiptRepository receiptRepository) {
        return args -> {

            //Client objects configuration

            Client johnSmith = new Client(
                    "John Smith",
                    "john.smith@email.com",
                    LocalDate.of(1995, 8, 12),
                    "123 Main Street, Los Angeles USA",
                    "male"
            );

            Client emilyDavis = new Client(
                    "Emily Davis",
                    "emily.davis@email.com",
                    LocalDate.of(1990, 2, 25),
                    "456 Elm Street, New York City USA",
                    "female"
            );

            Client jacobNguyen = new Client(
                    "Jacob Nguyen",
                    "jacob.nguyen@email.com",
                    LocalDate.of(1988, 6, 3),
                    "789 Oak Street, Columbus USA",
                    "male"
            );

            Client avaBrown = new Client(
                    "Ava Brown",
                    "ava.brown@email.com",
                    LocalDate.of(1999, 11, 18),
                    "321 Pine Street, New York City USA",
                    "female"
            );

            Client liamGonzalez = new Client(
                    "Liam Gonzalez",
                    "liam.gonzalez@email.com",
                    LocalDate.of(1993, 4, 30),
                    "654 Cedar Street, Austin USA",
                    "male"
            );

            Client ameliaWang = new Client(
                    "Amelia Wang",
                    "amelia.wang@email.com",
                    LocalDate.of(1996, 1, 10),
                    "987 Maple Street, Jacksonville USA",
                    "female"
            );

            Client danielLopez = new Client(
                    "Daniel Lopez",
                    "daniel.lopez@email.com",
                    LocalDate.of(1992, 9, 22),
                    "246 Birch Street, New York City USA",
                    "male"
            );

            Client graceChen = new Client(
                    "Grace Chen",
                    "grace.chen@email.com",
                    LocalDate.of(1997, 5, 6),
                    "135 Walnut Street, Los Angeles USA",
                    "female"
            );

            Client lucasNg = new Client(
                    "Lucas Ng",
                    "lucas.ng@email.com",
                    LocalDate.of(1985, 12, 28),
                    "864 Cherry Street, San Jose USA",
                    "male"
            );

            Client sophiaLee = new Client(
                    "Sophia Lee",
                    "sophia.lee@email.com",
                    LocalDate.of(1991, 7, 14),
                    "975 Ash Street, San Diego USA",
                    "female"
            );


            clientRepository.saveAll(List.of(johnSmith, emilyDavis, jacobNguyen, avaBrown, liamGonzalez, ameliaWang, danielLopez, graceChen, lucasNg, sophiaLee));


            // Store objects configuration

            Store walmart = new Store(
                    "Walmart",
                    "123 Main Street, Phoenix USA",
                    LocalTime.of(9, 0),
                    LocalTime.of(18, 0)
            );

            Store target = new Store(
                    "Target",
                    "456 Elm Street, Fort Worth USA",
                    LocalTime.of(8, 30),
                    LocalTime.of(19, 30)
            );

            Store bestBuy = new Store(
                    "Best Buy",
                    "789 Oak Street, San Diego USA",
                    LocalTime.of(10, 0),
                    LocalTime.of(17, 0)
            );

            Store appleStore = new Store(
                    "Apple Store",
                    "321 Pine Street, Jacksonville USA",
                    LocalTime.of(10, 30),
                    LocalTime.of(22, 0)
            );

            Store homeDepot = new Store(
                    "Home Depot",
                    "654 Cedar Street, Jacksonville USA",
                    LocalTime.of(7, 30),
                    LocalTime.of(16, 0)
            );

            Store starbucks = new Store(
                    "Starbucks",
                    "987 Maple Street, Houston USA",
                    LocalTime.of(6, 0),
                    LocalTime.of(17, 30)
            );

            Store lowes = new Store(
                    "Lowe's",
                    "246 Birch Street, Los Angeles USA",
                    LocalTime.of(8, 0),
                    LocalTime.of(12, 30)
            );

            Store costco = new Store(
                    "Costco",
                    "135 Walnut Street, San Diego USA",
                    LocalTime.of(9, 30),
                    LocalTime.of(18, 0)
            );

            Store kroger = new Store(
                    "Kroger",
                    "864 Cherry Street, Austin USA",
                    LocalTime.of(7, 0),
                    LocalTime.of(19, 0)
            );

            Store wholeFoods = new Store(
                    "Whole Foods",
                    "975 Ash Street, San Francisco USA",
                    LocalTime.of(9, 0),
                    LocalTime.of(17, 0)
            );


            storeRepository.saveAll(List.of(walmart, target, bestBuy, appleStore, homeDepot, bestBuy, starbucks, lowes, costco, kroger, wholeFoods));


            ReceiptKey receiptKey1 = new ReceiptKey(
                    johnSmith.getId(),
                    walmart.getId()
            );

            ReceiptKey receiptKey2 = new ReceiptKey(
                    emilyDavis.getId(),
                    appleStore.getId()
            );

            ReceiptKey receiptKey3 = new ReceiptKey(
                    jacobNguyen.getId(),
                    costco.getId()
            );

            ReceiptKey receiptKey4 = new ReceiptKey(
                    avaBrown.getId(),
                    starbucks.getId()
            );

            ReceiptKey receiptKey5 = new ReceiptKey(
                    danielLopez.getId(),
                    lowes.getId()
            );

            ReceiptKey receiptKey6 = new ReceiptKey(
                    graceChen.getId(),
                    appleStore.getId()
            );

            ReceiptKey receiptKey7 = new ReceiptKey(
                    johnSmith.getId(),
                    starbucks.getId()
            );

            ReceiptKey receiptKey8 = new ReceiptKey(
                    appleStore.getId(),
                    kroger.getId()
            );

            ReceiptKey receiptKey9 = new ReceiptKey(
                    sophiaLee.getId(),
                    target.getId()
            );

            ReceiptKey receiptKey10 = new ReceiptKey(
                    lucasNg.getId(),
                    homeDepot.getId()
            );



            Receipt receipt1 = new Receipt(
                    receiptKey1,
                    storeRepository.findById(receiptKey1.getStore_id()).get(),
                    clientRepository.findById(receiptKey1.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    13.7
            );

            Receipt receipt2 = new Receipt(
                    receiptKey2,
                    storeRepository.findById(receiptKey2.getStore_id()).get(),
                    clientRepository.findById(receiptKey2.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    123.3
            );

            Receipt receipt3 = new Receipt(
                    receiptKey3,
                    storeRepository.findById(receiptKey3.getStore_id()).get(),
                    clientRepository.findById(receiptKey3.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    12.53
            );

            Receipt receipt4 = new Receipt(
                    receiptKey4,
                    storeRepository.findById(receiptKey4.getStore_id()).get(),
                    clientRepository.findById(receiptKey4.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    131.17
            );

            Receipt receipt5 = new Receipt(
                    receiptKey5,
                    storeRepository.findById(receiptKey5.getStore_id()).get(),
                    clientRepository.findById(receiptKey5.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    164.7
            );

            Receipt receipt6 = new Receipt(
                    receiptKey6,
                    storeRepository.findById(receiptKey6.getStore_id()).get(),
                    clientRepository.findById(receiptKey6.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    3.7
            );

            Receipt receipt7 = new Receipt(
                    receiptKey7,
                    storeRepository.findById(receiptKey7.getStore_id()).get(),
                    clientRepository.findById(receiptKey7.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    124.53
            );

            Receipt receipt8 = new Receipt(
                    receiptKey8,
                    storeRepository.findById(receiptKey8.getStore_id()).get(),
                    clientRepository.findById(receiptKey8.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    74.01
            );

            Receipt receipt9 = new Receipt(
                    receiptKey9,
                    storeRepository.findById(receiptKey9.getStore_id()).get(),
                    clientRepository.findById(receiptKey9.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    53.99
            );

            Receipt receipt10 = new Receipt(
                    receiptKey10,
                    storeRepository.findById(receiptKey10.getStore_id()).get(),
                    clientRepository.findById(receiptKey10.getClient_id()).get(),
                    LocalDate.of(2023, 7, 9),
                    99.99
            );


            receiptRepository.saveAll(List.of(receipt1, receipt2, receipt3, receipt4, receipt5, receipt6, receipt7, receipt8, receipt9, receipt10));


            // Manager objects configuration

            Manager elvisSmith = new Manager(
                    "Elvis Smith",
                    "123 Main Street, Phoenix USA",
                    LocalDate.of(1980, 5, 10),
                    LocalDate.of(2010, 1, 1),
                    walmart
            );

            Manager janeDoe = new Manager(
                    "Jane Doe",
                    "456 Elm Street, Houston USA",
                    LocalDate.of(1975, 7, 20),
                    LocalDate.of(2015, 1, 1),
                    starbucks
            );

            Manager michaelJohnson = new Manager(
                    "Michael Johnson",
                    "789 Oak Street, Jacksonville USA",
                    LocalDate.of(1985, 9, 15),
                    LocalDate.of(2020, 1, 1),
                    homeDepot
            );

            Manager emilyWilliams = new Manager(
                    "Emily Williams",
                    "321 Pine Street, Jacksonville USA",
                    LocalDate.of(1990, 3, 25),
                    LocalDate.of(2025, 1, 1),
                    homeDepot
            );

            Manager davidLee = new Manager(
                    "David Lee",
                    "555 Cedar Street, San Diego USA",
                    LocalDate.of(1982, 12, 1),
                    LocalDate.of(2030, 1, 1),
                    costco
            );

            Manager samanthaKim = new Manager(
                    "Samantha Kim",
                    "111 Maple Street, San Diego USA",
                    LocalDate.of(1995, 2, 10),
                    LocalDate.of(2022, 1, 1),
                    bestBuy
            );

            Manager robertChen = new Manager(
                    "Robert Chen",
                    "222 Oak Street, Houston USA",
                    LocalDate.of(1988, 6, 6),
                    LocalDate.of(2023, 1, 1),
                    starbucks
            );

            Manager lindaGarcia = new Manager(
                    "Linda Garcia",
                    "333 Cherry Street, Houston USA",
                    LocalDate.of(1989, 6, 5),
                    LocalDate.of(2024, 1, 1),
                    starbucks
            );

            Manager williamRodriguez = new Manager(
                    "William Rodriguez",
                    "444 Birch Street, Los Angeles USA",
                    LocalDate.of(1983, 4, 3),
                    LocalDate.of(2026, 1, 1),
                    lowes
            );

            Manager amandaMartinez = new Manager(
                    "Amanda Martinez",
                    "31 Rockey Street, Jacksonville USA",
                    LocalDate.of(1992, 1, 15),
                    LocalDate.of(2027, 1, 1),
                    appleStore
            );


            managerRepository.saveAll(List.of(elvisSmith, janeDoe, michaelJohnson, emilyWilliams, davidLee, samanthaKim, robertChen, lindaGarcia, williamRodriguez, amandaMartinez));

        };
    }
}
