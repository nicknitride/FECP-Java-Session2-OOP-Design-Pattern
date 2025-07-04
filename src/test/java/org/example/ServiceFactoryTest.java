package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceFactoryTest {
    ServiceFactory sv = new ServiceFactory();

    @Test
    void getValidXrayServiceCost() {
        XRay xray = new XRay();
        assertEquals(xray.getCost(), sv.getService("Xray").getCost());
    }

    @Test
    void getValidSurgeryServiceCost() {
        Surgery surgery = new Surgery();
        assertEquals(surgery.getCost(), sv.getService("Surgery").getCost());
    }

    @Test
    void getValidConsultServiceCost() {
        Consultation consult = new Consultation();
        assertEquals(consult.getCost(), sv.getService("Consultation").getCost());
    }

    @Test
    void getInvalidService(){
        assertNull(sv.getService("Botox"));
    }

}