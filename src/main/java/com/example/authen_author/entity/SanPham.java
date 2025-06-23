package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_san_pham")
    private Integer idSanPham;
    @Column(name = "ma_san_pham")
    private String maSanPham;
    @Column(name = "ten_san_pham")
    private String tenSanPham;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;
    @Column(name = "trang_thai")
    private EnumStatus trangThai;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "so_luong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "id_kieu_dang", referencedColumnName = "id_kieu_dang")
    private KieuDang kieuDang;
    @ManyToOne
    @JoinColumn(name = "id_danh_muc", referencedColumnName = "id_danh_muc")
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "id_thuong_hieu", referencedColumnName = "id_thuong_hieu")
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "id_chat_lieu", referencedColumnName = "id_chat_lieu")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "id_xuat_xu", referencedColumnName = "id_xuat_xu")
    private XuatXu xuatXu;
}
