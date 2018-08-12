package com.company.model;

public class Car implements Comparable<Car> {
    private String brand;
    private String model;
    private Integer year;
    private Integer parkingPlace;
    private Boolean hasFolder; //если ли синяя папка?


    public Car() {
    }

    public Car(String brand, String model, Integer year, Integer parkingPlace, Boolean hasFolder) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.parkingPlace = parkingPlace;
        this.hasFolder = hasFolder;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(Integer parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public Boolean isHasFolder() {
        return hasFolder;
    }

    public void setHasFolder(Boolean hasFolder) {
        this.hasFolder = hasFolder;
    }

    @Override
    public String toString() {
        String hasFolderAnswer = "";
        if (this.hasFolder == true) {
            hasFolderAnswer = "YES";
        } else {
            hasFolderAnswer = "NO";
        }

        //question ? true : false
        //hasFolderAnswer ? "YES" : "NO";

        return String.format("Brand: %s | Model: %s | Year: %s | Parking place: %s | Has folder: %s\n",
                this.brand,
                this.model,
                this.year,
                this.parkingPlace,
                hasFolderAnswer);
    }

    @Override
    public int compareTo(Car o) {
        int returnValue = this.brand.compareTo(o.getBrand());
        if (returnValue != 0) {
            return returnValue;
        }

        returnValue = this.model.compareTo(o.getModel());
        if (returnValue != 0) {
            return returnValue;
        }

        returnValue = this.year.compareTo(o.getYear());
        if (returnValue != 0) {
            return returnValue;
        }

        returnValue = this.parkingPlace.compareTo(o.getParkingPlace());
        if (returnValue != 0) {
            return returnValue;
        }

        return this.hasFolder.compareTo(o.isHasFolder());
    }
}
