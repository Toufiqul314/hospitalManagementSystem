package com.errorcode.hospitalManagementSystem;

import com.errorcode.hospitalManagementSystem.dto.BloodGroupCountResponseEntity;
import com.errorcode.hospitalManagementSystem.entity.Patient;
import com.errorcode.hospitalManagementSystem.repository.PatientRepository;
import com.errorcode.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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

        //List<Patient>patientList=patientRepository.findByNameContainingOrderByIdDesc("Di");

        //List<Patient>patientList=patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

        //List<Patient>patientList=patientRepository.findByBornAfterDate(LocalDate.of(1993,3,14));

        Page<Patient> patientList=patientRepository.findAllPatients(PageRequest.of(0,2));

        for (Patient patient:patientList) {
            System.out.println(patient);
        }

        /*
        List<Object[]>bloodGroupList=patientRepository.countEachBloodGroupTye();
        for (Object[] objects:bloodGroupList){
            System.out.println(objects[0]+" "+objects[1]);
        }
         */

//        int rowsUpdated=patientRepository.updateNameWithID("Arav Sharma",1L);
//        System.out.println(rowsUpdated);

//        List<BloodGroupCountResponseEntity>bloodGroupList=patientRepository.countEachBloodGroupType();
//        for (BloodGroupCountResponseEntity bloodGroup : bloodGroupList) {
//            System.out.println(bloodGroup);
//        }
    }
}
