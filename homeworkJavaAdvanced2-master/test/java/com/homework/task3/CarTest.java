package com.homework.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void shouldReturnDiesel(){
        //given
        Car car = new Car();
        Car.Engine engine = car.new Engine();
        car.setBrand("Toyota");
        car.setType("economy");
        //when
        engine.setEngine(car);
        String actual = engine.getEngineType();
        String expected = "diesel";
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnElectic(){
        //given
        Car car = new Car();
        Car.Engine engine = car.new Engine();
        car.setBrand("Toyota");
        car.setType("luxury");
        //when
        engine.setEngine(car);
        String actual = engine.getEngineType();
        String expected = "electric";
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPetrol(){
        //given
        Car car = new Car();
        Car.Engine engine = car.new Engine();
        car.setBrand("Toyota");
        car.setType("cheap");
        //when

        engine.setEngine(car);
        String actual = engine.getEngineType();
        String expected = "petrol";
        //then
        assertEquals(expected, actual);
    }
}