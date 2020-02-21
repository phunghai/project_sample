package jp.co.htv.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.htv.demo.entity.VehicleRegistrationPlates;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VehicleRegistrationPlatesServiceTest {
    @Autowired
    VehicleRegistrationPlatesService platesService;

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void testGet() {
    	List<VehicleRegistrationPlates> result = new ArrayList<VehicleRegistrationPlates>();
    	List<VehicleRegistrationPlates> dbResult = platesService.findAll();
    	assertEquals(2, dbResult.size());
//        assertEquals(result , platesService.findAll());
    }
}
