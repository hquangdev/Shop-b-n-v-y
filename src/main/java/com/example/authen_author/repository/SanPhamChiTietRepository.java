package com.example.authen_author.repository;

import com.example.authen_author.entity.SanPham;
import com.example.authen_author.entity.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {
    List<SanPhamChiTiet> findBySanPham(SanPham sanPham);
}
