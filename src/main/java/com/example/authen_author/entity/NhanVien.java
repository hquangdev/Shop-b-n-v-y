package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nhan_vien")
    private Integer id;

    @Column(name = "ten_dang_nhap")
    private String tenDangNhap;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "chuc_vu")
    private String chucVu;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "can_cuoc_cong_dan")
    private String canCuocCongDan;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "ngay_vao_lam")
    private Date ngayVaoLam;
}
