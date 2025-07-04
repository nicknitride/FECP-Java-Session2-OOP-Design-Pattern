package org.example;

class Consultation extends Service {
    @Override
    public String getName() {
        return "Consultation";
    }

    @Override
    public double getCost() {
        return 700;
    }
}
