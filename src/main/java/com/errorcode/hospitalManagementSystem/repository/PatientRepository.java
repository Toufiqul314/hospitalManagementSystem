package com.errorcode.hospitalManagementSystem.repository;

import com.errorcode.hospitalManagementSystem.entity.Patient;
import com.errorcode.hospitalManagementSystem.entity.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient>findByBirthDateBetween(LocalDate startDate,LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    //Using JPQL @Query method
    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient>findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    // group by query metho
    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
    List<Object[]>countEachBloodGroupTye();
}
