package org.example;

public class ServiceFactory {
    public Service getService(String serviceType){
        switch (serviceType.toLowerCase()){
            case "xray": return new XRay();
            case "surgery": return new Surgery();
            case "consultation": return new Consultation();
            default: return null;
        }
    }
}
