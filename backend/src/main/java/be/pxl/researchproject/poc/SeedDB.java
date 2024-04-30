package be.pxl.researchproject;

import be.pxl.researchproject.domain.*;
import be.pxl.researchproject.repository.BreedingDateRepository;
import be.pxl.researchproject.repository.FoalRepository;
import be.pxl.researchproject.repository.HorseRepository;
import be.pxl.researchproject.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class SeedDB {
    private final BreedingDateRepository breedingDateRepository;
    private final FoalRepository foalRepository;
    private final HorseRepository horseRepository;
    private final UserRepository userRepository;
    Horse horse1;
    Horse horse2;
    Horse horse3;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${administrator_password}")
    private String administratorPassword;

    @Value("${normal_user_password}")
    private String normalUserPassword;

    @Autowired
    public SeedDB(BreedingDateRepository breedingDateRepository, FoalRepository foalRepository, HorseRepository horseRepository, UserRepository userRepository) {
        this.breedingDateRepository = breedingDateRepository;
        this.foalRepository = foalRepository;
        this.horseRepository = horseRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        seedHorses();
        seedFoals();
        seedUsers();
        seedBreedingData();
    }

    private void seedHorses() {
        if (horseRepository.count() > 0) return;

        List<BirthDiary> list1 = new ArrayList<>();
        List<BirthDiary> list2 = new ArrayList<>();
        List<BirthDiary> list3 = new ArrayList<>();
        List<BirthDiary> list4 = new ArrayList<>();
        list1.add(new BirthDiary("Geboren tijdens een onweersbui", 2024));
        list2.add(new BirthDiary("niet zo aardig na geboorte", 2023));
        list2.add(new BirthDiary("Geboren in de lente", 2024));
        list3.add(new BirthDiary("Geboren tijdens een onweersbui", 2024));
        list4.add(new BirthDiary("Geboren tijdens een zonnige dag", 2024));

        Horse stallion1 = new Horse();
        stallion1.setName("jeffrryyy");
        stallion1.setGender("male");
        stallion1.setWithersHeight(160.0);
        stallion1.setBirthDate(LocalDate.of(2012, 8, 20));
        stallion1.setPregnant(true);
        stallion1.setBirthDiary(list1);
        horseRepository.save(stallion1);


        horse1 = new Horse();
        horse1.setName("Misty");
        horse1.setGender("female");
        horse1.setWithersHeight(150.5);
        horse1.setBirthDate(LocalDate.of(2010, 5, 15));
        horse1.setPregnant(false);
        horse1.setBirthDiary(list2);
        horse1.setStallion(stallion1);
        horseRepository.save(horse1);

        horse2 = new Horse();
        horse2.setName("Shadow");
        horse2.setGender("male");
        horse2.setWithersHeight(160.0);
        horse2.setBirthDate(LocalDate.of(2012, 8, 20));
        horse2.setPregnant(true);
        horse2.setBirthDiary(list3);
        horseRepository.save(horse2);

        horse3 = new Horse();
        horse3.setName("Stella");
        horse3.setGender("female");
        horse3.setWithersHeight(155.0);
        horse3.setBirthDate(LocalDate.of(2015, 3, 25));
        horse3.setPregnant(true);
        horse3.setBirthDiary(list4);
        horseRepository.save(horse3);
    }

    private void seedFoals() {
        if (foalRepository.count() > 0) return;
        Foal foal1 = new Foal();
        foal1.setName("Buddy");
        foal1.setHorse(horse1);
        foal1.setBirthDate(LocalDate.of(2021, 4, 10));
        foalRepository.save(foal1);

        Foal foal2 = new Foal();
        foal2.setName("Snowflake");
        foal2.setHorse(horse2);
        foal2.setBirthDate(LocalDate.of(2020, 12, 25));
        foalRepository.save(foal2);

        Foal foal3 = new Foal();
        foal3.setName("Spirit");
        foal3.setHorse(horse3);
        foal3.setBirthDate(LocalDate.of(2022, 6, 5));
        foalRepository.save(foal3);

        Foal foal4 = new Foal();
        foal4.setName("Angel");
        foal4.setHorse(horse3);
        foal4.setBirthDate(LocalDate.of(2023, 7, 5));
        foalRepository.save(foal4);
    }

    private void seedUsers() {
        // Always create or update user depending on environment
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("toonvankimmenade@gmail.com");
        user1.setPassword(passwordEncoder.encode(administratorPassword));
        user1.setAdmin(true);
        user1.setName("Toon Van Kimmenade");
        user1.setUserName("toonvankimmenade");
        userRepository.save(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setEmail("jaaaman103@gmail.com");
        user2.setPassword(passwordEncoder.encode(normalUserPassword));
        user2.setAdmin(false);
        user2.setName("Jaaaman103");
        user2.setUserName("jaaaman103");
        userRepository.save(user2);
    }

    private void seedBreedingData() {
        if (breedingDateRepository.count() > 0) return;
        BreedingDate breedingDate1 = new BreedingDate();
        breedingDate1.setHorse(horse1);
        breedingDate1.setDate(LocalDate.of(2024, 2, 20));
        breedingDate1.setLast(true);
        breedingDateRepository.save(breedingDate1);

        BreedingDate breedingDate2 = new BreedingDate();
        breedingDate2.setHorse(horse1);
        breedingDate2.setDate(LocalDate.of(2024, 2, 21));
        breedingDate2.setLast(false);
        breedingDateRepository.save(breedingDate2);

        BreedingDate breedingDate3 = new BreedingDate();
        breedingDate3.setHorse(horse2);
        breedingDate3.setDate(LocalDate.of(2024, 2, 21));
        breedingDate3.setLast(false);
        breedingDateRepository.save(breedingDate3);

        BreedingDate breedingDate4 = new BreedingDate();
        breedingDate4.setHorse(horse1);
        breedingDate4.setDate(LocalDate.of(2024, 2, 22));
        breedingDate4.setLast(true);
        breedingDateRepository.save(breedingDate4);

        BreedingDate breedingDate5 = new BreedingDate();
        breedingDate5.setHorse(horse1);
        breedingDate5.setDate(LocalDate.of(2023, 2, 20));
        breedingDate5.setLast(true);
        breedingDateRepository.save(breedingDate5);

        BreedingDate breedingDate6 = new BreedingDate();
        breedingDate6.setHorse(horse1);
        breedingDate6.setDate(LocalDate.of(2023, 2, 21));
        breedingDate6.setLast(false);
        breedingDateRepository.save(breedingDate6);

        BreedingDate breedingDate7 = new BreedingDate();
        breedingDate7.setHorse(horse2);
        breedingDate7.setDate(LocalDate.of(2023, 2, 21));
        breedingDate7.setLast(false);
        breedingDateRepository.save(breedingDate7);

        BreedingDate breedingDate8 = new BreedingDate();
        breedingDate8.setHorse(horse1);
        breedingDate8.setDate(LocalDate.of(2023, 2, 22));
        breedingDate8.setLast(true);
        breedingDateRepository.save(breedingDate8);

        BreedingDate breedingDate9 = new BreedingDate();
        breedingDate9.setHorse(horse2);
        breedingDate9.setDate(LocalDate.of(2024, 2, 20));
        breedingDate9.setLast(true);
        breedingDateRepository.save(breedingDate9);

        BreedingDate breedingDate10 = new BreedingDate();
        breedingDate10.setHorse(horse2);
        breedingDate10.setDate(LocalDate.of(2024, 2, 21));
        breedingDate10.setLast(false);
        breedingDateRepository.save(breedingDate10);

        BreedingDate breedingDate11 = new BreedingDate();
        breedingDate11.setHorse(horse3);
        breedingDate11.setDate(LocalDate.of(2024, 2, 21));
        breedingDate11.setLast(false);
        breedingDateRepository.save(breedingDate11);

        BreedingDate breedingDate12 = new BreedingDate();
        breedingDate12.setHorse(horse3);
        breedingDate12.setDate(LocalDate.of(2024, 2, 22));
        breedingDate12.setLast(true);
        breedingDateRepository.save(breedingDate12);
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}