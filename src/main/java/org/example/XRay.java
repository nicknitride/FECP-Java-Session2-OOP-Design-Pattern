package org.example;

class XRay extends Service {
    @Override
    public String getName() {
        return "XRay";
    }

    @Override
    public double getCost() {
        return 500;
    }
}
