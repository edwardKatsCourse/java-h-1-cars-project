package com.company.repository;

import com.company.model.Car;

import java.util.*;

public class CarRepository {

    private Set<Car> cars = new TreeSet<>();

    private TreeMap<Integer, TreeSet<Car>> byYear = new TreeMap<>();
    private TreeMap<String, TreeSet<Car>> byBrand = new TreeMap<>();
    private TreeMap<Boolean, TreeSet<Car>> byFolder = new TreeMap<>();


    public Iterable<Car> getAll() {
        return cars;
    }

    public boolean addCar(Car car) {
        boolean isNewCar = cars.add(car);
        if (!isNewCar) {
            return isNewCar;
        }

        addCarByBrand(car);
        addCarByFolder(car);
        addCarByYear(car);

        return isNewCar;
    }

    private void addCarByYear(Car car) {
        TreeSet<Car> byYearCars = byYear.get(car.getYear());
        if (byYearCars == null) {
            byYearCars = new TreeSet<>();
        }

        byYearCars.add(car);

        byYear.put(car.getYear(), byYearCars);
    }

    private void addCarByBrand(Car car) {
        TreeSet<Car> byBrandCars = byBrand.get(car.getBrand());
        if (byBrandCars == null) {
            byBrandCars = new TreeSet<>();
        }

        byBrandCars.add(car);

        byBrand.put(car.getBrand(), byBrandCars);
    }

    private void addCarByFolder(Car car) {
        TreeSet<Car> byFolderCars = byFolder.get(car.isHasFolder());
        if (byFolderCars == null) {
            byFolderCars = new TreeSet<>();
        }

        byFolderCars.add(car);

        byFolder.put(car.isHasFolder(), byFolderCars);
    }

    //Car getCar() -> null
    //List<Car> getCars() -> new ArrayList<>()

    public Iterable<Car> getByBrand(String brand) {
        return byBrand.getOrDefault(brand, new TreeSet<>());
    }

    public Iterable<Car> getByFolder(boolean hasFolder) {
        return byFolder.getOrDefault(hasFolder, new TreeSet<>());
    }

    public Iterable<Car> getByYear(Integer year) {
        return byYear.getOrDefault(year, new TreeSet<>());
    }

    //startYear = 2015: 2015, 2014, 2013, 2012 ....
    public Iterable<Car> getByYearBefore(Integer startYear) {
        List<Car> yearBeforeCars = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<Car>> yearCar : byYear.entrySet()) {
            if (yearCar.getKey() <= startYear) {
                yearBeforeCars.addAll(yearCar.getValue());
            }
        }

        return yearBeforeCars;
    }


}
