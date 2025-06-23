package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_khuyen_mai")
    private Integer idKhuyenMai;

    @Column(name = "ma_khuyen_mai", length = 50, nullable = false)
    private String maKhuyenMai;

    @Column(name = "ten_khuyen_mai", length = 100, nullable = false)
    private String tenKhuyenMai;

    @Column(name = "ngay_bat_dau", nullable = false)
    private LocalDateTime ngayBatDau;

    @Column(name = "ngay_ket_thuc", nullable = false)
    private LocalDateTime ngayKetThuc;

    @Column(name = "so_tien_giam", nullable = false, precision = 10, scale = 2)
    private BigDecimal soTienGiam;

    @Column(name = "nguoi_tao", length = 100, nullable = false)
    private String nguoiTao;


    @Column(name = "mo_ta", length = 255)
    private String moTa;

    public void setIdKhuyenMai(Integer idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public void setNgayBatDau(LocalDateTime ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setNgayKetThuc(LocalDateTime ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public void setSoTienGiam(BigDecimal soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public LocalDateTime getNgayBatDau() {
        return ngayBatDau;
    }

    public LocalDateTime getNgayKetThuc() {
        return ngayKetThuc;
    }

    public BigDecimal getSoTienGiam() {
        return soTienGiam;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public String getMoTa() {
        return moTa;
    }
}

