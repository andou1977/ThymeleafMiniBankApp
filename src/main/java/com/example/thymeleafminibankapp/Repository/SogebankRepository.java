package com.example.thymeleafminibankapp.Repository;

import com.example.thymeleafminibankapp.Entity.SogebankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SogebankRepository extends JpaRepository<SogebankEntity,Integer> {
}
