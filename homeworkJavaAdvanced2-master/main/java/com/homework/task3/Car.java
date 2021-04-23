package com.homework.task3;

import java.util.Locale;

public class Car {
    private String brand;
    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    class Engine{
        private String engineType;

        public String getEngineType(){
            return engineType;
        }

        public void setEngine(Car car){
            if(car.getType().equalsIgnoreCase("economy")){
                engineType = "diesel";
            }else if(car.getType().equalsIgnoreCase("luxury")){
                engineType = "electric";
            }else{
                engineType = "petrol";
            }
        }
    }
}
