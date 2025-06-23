package com.example.authen_author.repository;

import com.example.authen_author.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Integer> {

    KhuyenMai findByMaKhuyenMai(String maKhuyenMai);


}

