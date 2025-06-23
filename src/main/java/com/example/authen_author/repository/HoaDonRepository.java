package com.example.authen_author.repository;

import com.example.authen_author.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    // Define any custom query methods if needed
}
