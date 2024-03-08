package com.example.thymeleafminibankapp.Repository;

import com.example.thymeleafminibankapp.Entity.UnibankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnibankRepository extends JpaRepository<UnibankEntity,Integer> {
}
