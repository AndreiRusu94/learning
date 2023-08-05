package com.learning.designpatterns.methodfactory;

public class Car implements MotorVehicle {

    @Override
    public void build() {
        System.out.println("Build car");
    }
}
