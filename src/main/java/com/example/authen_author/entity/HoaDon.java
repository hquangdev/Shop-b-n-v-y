package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hoa_don")
    private Integer id;
    @Column(name="ma_hoa_don")
    private String maHoaDon;

    @Column(name="ngay_dat")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ngayDat;

    @Column(name="tong_tien")
    private float tongTien;

    @Column(name="da_giam_gia_khuyen_mai")
    private float daGiamGiaKhuyenMai;

    @Column(name="da_giam_gia_lien")
    private float daGiamGiaLien;

    @Column(name="ngay_tao")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ngayTao;

    @Column(name="ngay_sua")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ngaySua;

    @Column(name="trang_thai")
    private Byte trangThai;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public void setDaGiamGiaKhuyenMai(float daGiamGiaKhuyenMai) {
        this.daGiamGiaKhuyenMai = daGiamGiaKhuyenMai;
    }

    public void setDaGiamGiaLien(float daGiamGiaLien) {
        this.daGiamGiaLien = daGiamGiaLien;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public void setTrangThai(Byte trangThai) {
        this.trangThai = trangThai;
    }

    public void setPhuongThucThanhToan(PhuongThucThanhToan phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setMaGiamGia1(MaGiamGia maGiamGia1) {
        this.maGiamGia1 = maGiamGia1;
    }

    public Integer getId() {
        return id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public float getTongTien() {
        return tongTien;
    }

    public float getDaGiamGiaKhuyenMai() {
        return daGiamGiaKhuyenMai;
    }

    public float getDaGiamGiaLien() {
        return daGiamGiaLien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public Byte getTrangThai() {
        return trangThai;
    }

    public PhuongThucThanhToan getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public MaGiamGia getMaGiamGia1() {
        return maGiamGia1;
    }

    @ManyToOne
    @JoinColumn(name = "id_phuong_thuc_thanh_toan", referencedColumnName = "id_phuong_thuc_thanh_toan")
    private PhuongThucThanhToan phuongThucThanhToan;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id", referencedColumnName = "id_khach_hang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "nhan_vien_id", referencedColumnName = "id_nhan_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_ma_giam_gia", referencedColumnName = "id_ma_giam_gia")
    private MaGiamGia maGiamGia1;

}
