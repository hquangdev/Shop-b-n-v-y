package com.example.authen_author.repository;

import com.example.authen_author.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuonghieuRepository extends JpaRepository<ThuongHieu, Integer> {
}
