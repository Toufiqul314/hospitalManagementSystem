package com.errorcode.hospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name = "patient_tbl",
        uniqueConstraints = {
               // @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthday",columnNames = {"name","birthDay"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date",columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name",nullable = false,length = 40)
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private  String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
