package com.example.authen_author.repository;

import com.example.authen_author.entity.PhuongThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhuongThucGiamGiaRepository extends JpaRepository<PhuongThucThanhToan, Integer> {
}
