package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.EnumStatus;
import com.example.authen_author.entity.SanPhamChiTiet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamChiTietRespone {
    private Integer idSpct;
    private String maSpct;
    private SanPhamRespone sanPhamRespone;
    private MauSacRespone mauSacRespone;
    private KichThuocRespone kichThuocRespone;
//    private KhuyenMaiRepone khuyenMaiRepone; chưa dùng đến
    private double gia;
    private String hinhAnh;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;
    private EnumStatus trangThai;


    public SanPhamChiTietRespone(SanPhamChiTiet sanPhamChiTiet){

        this.idSpct = sanPhamChiTiet.getIdSPCT();
        this.maSpct = sanPhamChiTiet.getMaSPCT();
       this.gia = sanPhamChiTiet.getGia();
       this.hinhAnh = sanPhamChiTiet.getHinhAnh();
        this.ngayTao = sanPhamChiTiet.getNgayTao();
        ngaySua = sanPhamChiTiet.getNgaySua();
        trangThai = sanPhamChiTiet.getSanPham().getTrangThai();
        sanPhamRespone = new SanPhamRespone(sanPhamChiTiet.getSanPham());
        mauSacRespone = new MauSacRespone(sanPhamChiTiet.getMauSac());
        kichThuocRespone = new KichThuocRespone(sanPhamChiTiet.getKichThuoc());
    }
}
