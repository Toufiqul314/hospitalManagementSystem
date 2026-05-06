package com.errorcode.hospitalManagementSystem.service;

import com.errorcode.hospitalManagementSystem.entity.Appointment;
import com.errorcode.hospitalManagementSystem.entity.Doctor;
import com.errorcode.hospitalManagementSystem.entity.Patient;
import com.errorcode.hospitalManagementSystem.repository.AppointmentRepository;
import com.errorcode.hospitalManagementSystem.repository.DoctorRepository;
import com.errorcode.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNeAppointment(Appointment appointment,Long doctorId,Long patientId){

        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId()==null)throw  new IllegalStateException("Appointment should not have an id");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); // to maintain consistent

        return appointmentRepository.save(appointment);
    }
}
