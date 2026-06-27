package com.corejava.Oops.Statics.FactoryDemo;

public class Sedan extends Car {
    private double trunkCapacityInLiters;
    private boolean hasSunroof;
    private int engineCapacity;

    @Override
    public void deliver() {
        System.out.printf(
            "Delivering a %s model %s and mfg. year %d of engine capacity %d and Trunk capacity of %f%n",
            super.getMake(), super.getModel(), super.getyear(), getEngineCapacity(), getCapacityTrunk()
        );
    }

    public double getCapacityTrunk() {
        return trunkCapacityInLiters;
    }

    public int getEngineCapacity () {
        return engineCapacity;
    }

    public Sedan (String make, 
                  String model, 
                  int year, 
                  double trunkCapacityInLiters, 
                  boolean hasSunroof, 
                  int engineCapacity) 
    {
        super(make, model, year);
        this.engineCapacity = engineCapacity;
        this.trunkCapacityInLiters = trunkCapacityInLiters;
        this.hasSunroof = hasSunroof;
        
    }
}
