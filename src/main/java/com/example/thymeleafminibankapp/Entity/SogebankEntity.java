package com.example.thymeleafminibankapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="sogebank")
public class SogebankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String password;
    private double compte;
    LocalDateTime date;
    @PrePersist
    protected void onCreate() {
        date= LocalDateTime.now();
    }

}
