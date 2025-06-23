package com.example.authen_author.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class KiemTraMaRequest {
    private String maGiamGia;
    private BigDecimal tongTien;
    private LocalDate ngayHienTai;

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public LocalDate getNgayHienTai() {
        return ngayHienTai;
    }

    public void setNgayHienTai(LocalDate ngayHienTai) {
        this.ngayHienTai = ngayHienTai;
    }
}
