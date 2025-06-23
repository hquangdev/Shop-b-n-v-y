package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.KhuyenMai;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMaiRepone {
    private Integer idKhuyenMai;
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private LocalDateTime ngayBatDau;
    private LocalDateTime ngayKetThuc;
    private BigDecimal soTienGiam;
    private String nguoiTao;
    private String moTa;


    public KhuyenMaiRepone(KhuyenMai khuyenMai) {
        this.idKhuyenMai = khuyenMai.getIdKhuyenMai();
        this.maKhuyenMai = khuyenMai.getMaKhuyenMai();
        this.tenKhuyenMai = khuyenMai.getTenKhuyenMai();
        this.ngayBatDau = khuyenMai.getNgayBatDau();
        this.ngayKetThuc = khuyenMai.getNgayKetThuc();
        this.soTienGiam = khuyenMai.getSoTienGiam();
        this.nguoiTao = khuyenMai.getNguoiTao();
        this.moTa = khuyenMai.getMoTa();

        

    }
}
