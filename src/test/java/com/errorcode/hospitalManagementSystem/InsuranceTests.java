package com.errorcode.hospitalManagementSystem;

import com.errorcode.hospitalManagementSystem.entity.Insurance;
import com.errorcode.hospitalManagementSystem.entity.Patient;
import com.errorcode.hospitalManagementSystem.service.InsuranceService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService  insuranceService;

    @Test
    public void insuranceTest(){
        Insurance insurance = Insurance.builder()
                .policyNumber("BRAC-BANK_1234")
                .provider("BRACK")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

      Patient patient=insuranceService.assingInsuranceToPatient(insurance,1L);
        System.out.println(patient);
    }
}
