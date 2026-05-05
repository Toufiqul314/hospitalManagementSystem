package com.errorcode.hospitalManagementSystem.service;

import com.errorcode.hospitalManagementSystem.entity.Insurance;
import com.errorcode.hospitalManagementSystem.entity.Patient;
import com.errorcode.hospitalManagementSystem.repository.InsuranceRepository;
import com.errorcode.hospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private  InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;

    @Transactional
    public Patient assingInsuranceToPatient(Insurance insurance,Long patientId){

        Patient patient=patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bidirectional consistency maintenance

        return patient;
    }
}
