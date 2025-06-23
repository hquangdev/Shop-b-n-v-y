package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HinhAnhSanPham")
public class HinhAnhSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hinh_anh_san_pham")
    private Integer idHinhAnhSanPham;
    @Column(name = "duong_dan_hinh_anh")
    private String duongDanHinhAnh;
    @Column(name = "ten_anh")
    private String tenAnh;

    @ManyToOne
    @JoinColumn(name = "id_spct", referencedColumnName = "id_spct")
    private SanPhamChiTiet sanPhamChiTiet;

}
