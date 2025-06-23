package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spct")
    private Integer idSPCT;
    @Column(name = "ma_spct")
    private String maSPCT;
    @Column(name = "gia")
    private Double gia;
    @Column(name = "hinh_anh")
    private String hinhAnh;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;

    @ManyToOne
    @JoinColumn(name = "id_san_pham", referencedColumnName = "id_san_pham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac", referencedColumnName = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_kich_thuoc", referencedColumnName = "id_kich_thuoc")
    private KichThuoc kichThuoc;

}
