package jp.co.htv.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jp.co.htv.demo.entity.VehicleRegistrationPlates;

@SpringBootTest
public class VehicleRegistrationPlatesServiceTest {
    @Autowired
    VehicleRegistrationPlatesService platesService;

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void testGet() {
        VehicleRegistrationPlates plate = platesService.findByProvinceCode("01");
        assertNotNull(plate, "not null");
    }
}
