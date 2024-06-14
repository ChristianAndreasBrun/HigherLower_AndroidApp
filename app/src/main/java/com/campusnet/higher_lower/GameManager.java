package com.campusnet.higher_lower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GameManager {

    static public int quizType;
    static public int currentQuiz;


    static public Info[] vehicles = new Info[]
        {
            new Info("Vehiculos", "Aston Martin Vantage", 50000, R.drawable.astonmartin_vantagev12),
            new Info("Vehiculos", "Alfa Romeo 4C", 25000, R.drawable.alfaromeo_4c),
            new Info("Vehiculos", "Audi R9", 75000, R.drawable.audi_r9),
            new Info("Vehiculos", "Bentley Continental GT", 40000, R.drawable.bentley_continentalgt),
            new Info("Vehiculos", "BMW M5", 60000, R.drawable.bmw_m5),
            new Info("Vehiculos", "Chevrolet Camaro", 55000, R.drawable.chevrolet_camaro),
            new Info("Vehiculos", "Ford Mustang", 80000, R.drawable.ford_mustang),
            new Info("Vehiculos", "Tesla Model S", 90000, R.drawable.tesla_model_s),
            new Info("Vehiculos", "Ferrari 812", 30000, R.drawable.ferrari_812),
            new Info("Vehiculos", "Citroen C4 Cactus", 20000, R.drawable.citroen_c4_cactus),
            new Info("Vehiculos", "Honda Civic", 70000, R.drawable.honda_civic),
            new Info("Vehiculos", "Jaguar F-Type", 35000, R.drawable.jaguar_f_type),
            new Info("Vehiculos", "JEEP Wrangler", 45000, R.drawable.jeep_wrangler),
            new Info("Vehiculos", "KIA Niro", 15000, R.drawable.kia_niro),
            new Info("Vehiculos", "Lamborghini Aventador", 10000, R.drawable.lamborghini_aventador),
            new Info("Vehiculos", "LAND ROVER Evoque", 38000, R.drawable.landrover_evoque),
            new Info("Vehiculos", "NISSAN GT-R", 28000, R.drawable.nissan_gt_r),
            new Info("Vehiculos", "Subaru WRX STI", 22000, R.drawable.subaru_wrx_sti)
        };

    static public Info[] animals = new Info[]
        {
            new Info("Animales", "Husky", 80000, R.drawable.husky),
            new Info("Animales", "Gato Siames", 60000, R.drawable.gatosiames),
            new Info("Animales", "Jirafa", 40000, R.drawable.jirafa),
            new Info("Animales", "Elefante", 75000, R.drawable.elefante),
            new Info("Animales", "Leon", 90000, R.drawable.leon),
            new Info("Animales", "Gorila", 55000, R.drawable.gorila),
            new Info("Animales", "Mantis", 20000, R.drawable.mantis),
            new Info("Animales", "Libelula", 15000, R.drawable.libelula),
            new Info("Animales", "Hamster", 30000, R.drawable.hamster),
            new Info("Animales", "Raton", 25000, R.drawable.raton),
            new Info("Animales", "Paloma", 35000, R.drawable.paloma),
            new Info("Animales", "Avestruz", 18000, R.drawable.avestruz),
            new Info("Animales", "Canguro", 50000, R.drawable.canguro),
            new Info("Animales", "Tigre", 70000, R.drawable.tigre),
            new Info("Animales", "Pingüino", 10000, R.drawable.pinguino),
            new Info("Animales", "Serpiente", 45000, R.drawable.serpiente),
            new Info("Animales", "Caballo", 65000, R.drawable.caballo),
            new Info("Animales", "Loro", 28000, R.drawable.loro)
        };

    static public Info[] sports = new Info[]
        {
            new Info("Deportes", "Futbol", 85000, R.drawable.futbol),
            new Info("Deportes", "Esports", 95000, R.drawable.esports),
            new Info("Deportes", "Baseball", 60000, R.drawable.baseball),
            new Info("Deportes", "Baloncesto", 75000, R.drawable.baloncesto),
            new Info("Deportes", "Tenis", 80000, R.drawable.tenis),
            new Info("Deportes", "Golf", 40000, R.drawable.golf),
            new Info("Deportes", "Rugby", 30000, R.drawable.rugby),
            new Info("Deportes", "Natacion", 55000, R.drawable.natacion),
            new Info("Deportes", "Ajedrez", 25000, R.drawable.ajedrez),
            new Info("Deportes", "Tiro con Arco", 20000, R.drawable.tiro_con_arco),
            new Info("Deportes", "Patinaje sobre Hielo", 35000, R.drawable.patinaje_hielo),
            new Info("Deportes", "Bawling", 15000, R.drawable.bawling),
            new Info("Deportes", "Ciclismo", 45000, R.drawable.ciclismo),
            new Info("Deportes", "F1", 70000, R.drawable.f1),
            new Info("Deportes", "Paracaidismo", 10000, R.drawable.paracaidismo),
            new Info("Deportes", "Skateboard", 50000, R.drawable.skateboard),
            new Info("Deportes", "Boxeo", 65000, R.drawable.boxeo),
            new Info("Deportes", "Padel", 22000, R.drawable.padel)
        };


    static public Info[] GetNewInfo() {

      currentQuiz = 0;

      ArrayList<Info> newList = new ArrayList<>();
      switch (quizType)
      {
          case 0: //Vehiculos
              newList = new ArrayList<>(Arrays.asList(vehicles));
              Collections.shuffle(newList);
              return newList.toArray(new Info[0]);

          case 1: //Animales
              newList = new ArrayList<>(Arrays.asList(animals));
              Collections.shuffle(newList);
              return newList.toArray(new Info[0]);

          case 2: //Deportes
              newList = new ArrayList<>(Arrays.asList(sports));
              Collections.shuffle(newList);
              return newList.toArray(new Info[0]);

          case 3: //Random
              int totalPerArray = 6;
              ArrayList<Info> randomList = new ArrayList<>();

              for (int i = 0; i < totalPerArray; i++)
              {
                  Random random = new Random();
                  int randomValue = random.nextInt(vehicles.length);

                  while (randomList.contains(vehicles[randomValue]) == true)
                  {
                      randomValue = random.nextInt(vehicles.length);
                  }
                  randomList.add(vehicles[randomValue]);
              }
              for (int i = 0; i < totalPerArray; i++)
              {
                  Random random = new Random();
                  int randomValue = random.nextInt(animals.length);

                  while (randomList.contains(animals[randomValue]) == true)
                  {
                      randomValue = random.nextInt(animals.length);
                  }
                  randomList.add(animals[randomValue]);
              }
              for (int i = 0; i < totalPerArray; i++)
              {
                  Random random = new Random();
                  int randomValue = random.nextInt(sports.length);

                  while (randomList.contains(sports[randomValue]) == true)
                  {
                      randomValue = random.nextInt(sports.length);
                  }
                  randomList.add(sports[randomValue]);
              }
              Collections.shuffle(randomList);
              return randomList.toArray(new Info[0]);
      }
      return null;
    }
}
