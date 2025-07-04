package org.example;

class Surgery extends Service {
    @Override
    public String getName() {
        return "Surgery";
    }

    @Override
    public double getCost() {
        return 12000;
    }
}
