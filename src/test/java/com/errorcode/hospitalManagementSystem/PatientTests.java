package com.errorcode.hospitalManagementSystem;

import com.errorcode.hospitalManagementSystem.entity.Patient;
import com.errorcode.hospitalManagementSystem.repository.PatientRepository;
import com.errorcode.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient>patientList = patientRepository.findAll();
        System.out.println(patientList);

        Patient p1=new Patient();
        patientRepository.save(p1);
    }

    @Test
    public void testTransactioMethods(){

        //Patient patient=patientService.getPatientById(1L);
        //Patient patient=patientRepository.findById(1L).orElseThrow(()->new EntityNotFoundException("Patient not found with id : 1"));

        //Patient patient=patientRepository.findByName("Diya Patel");

        //List<Patient>patientList=patientRepository.findByBirthDateOrEmail(LocalDate.of(1988,3,15),"diya.patel@example.com");

        List<Patient>patientList=patientRepository.findByNameContainingOrderByIdDesc("Di");

        for (Patient patient:patientList) {
            System.out.println(patient);
        }
    }
}
