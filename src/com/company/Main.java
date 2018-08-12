package com.company;

import com.company.model.Car;
import com.company.repository.CarRepository;

import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<Car> cars = new HashSet<Car>() {{
        add(new Car("Seat", "Ibiza", 2017, 1, false));
        add(new Car("Seat", "Ibiza", 2016, 2, false));
        add(new Car("Seat", "Leon", 2017, 3, false));
        add(new Car("Seat", "Leon", 2017, 4, true));
        add(new Car("Seat", "Toledo", 2018, 5, true));
        add(new Car("Hyundai", "Elantra i35", 2018, 6, true));
        add(new Car("Hyundai", "i20", 2018, 7, false));
        add(new Car("Hyundai", "Accent i25", 2018, 8, false));
        add(new Car("Hyundai", "i25", 2015, 9, false));
        add(new Car("Hyundai", "i25", 2014, 10, false));
        add(new Car("Hyundai", "i25", 2014, 11, false));
        add(new Car("Hyundai", "i10", 2013, 12, false));
    }} ;

    static CarRepository carRepository = new CarRepository();

    public static void main(String[] args) {
	    for (Car car : cars) {
	        carRepository.addCar(car);
        }

        System.out.println("Cars by brand:");
        System.out.println(carRepository.getByBrand("Seat"));
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Cars by year: ");
        System.out.println(carRepository.getByYear(2018));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Cars by year before: ");
        System.out.println(carRepository.getByYearBefore(2017));


    }
}
