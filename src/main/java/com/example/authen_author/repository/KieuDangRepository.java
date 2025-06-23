package com.example.authen_author.repository;

import com.example.authen_author.entity.KieuDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KieuDangRepository extends JpaRepository<KieuDang, Integer> {
}
