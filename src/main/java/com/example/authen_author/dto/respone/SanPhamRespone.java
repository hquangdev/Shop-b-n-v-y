package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.SanPham;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamRespone {
    private Integer idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;
    private String moTa;
    private Integer soLuong;

    private KieuDangRespone kieuDangRespone;
    private DanhMucRespone danhMucRespone;
    private ThuongHieuRespone thuongHieuRespone;
    private ChatLieuRespone chatLieuRespone;
    private XuatXuRespone xuatXuRespone;

    public SanPhamRespone(SanPham sanPham) {
        idSanPham = sanPham.getIdSanPham();
        maSanPham = sanPham.getMaSanPham();
        tenSanPham = sanPham.getTenSanPham();
        ngayTao = sanPham.getNgayTao();
        ngaySua = sanPham.getNgaySua();
        moTa = sanPham.getMoTa();
        soLuong = sanPham.getSoLuong();

        kieuDangRespone = new KieuDangRespone(sanPham.getKieuDang());
        danhMucRespone = new DanhMucRespone(sanPham.getDanhMuc());
        thuongHieuRespone = new ThuongHieuRespone(sanPham.getThuongHieu());
        chatLieuRespone = new ChatLieuRespone(sanPham.getChatLieu());
        xuatXuRespone = new XuatXuRespone(sanPham.getXuatXu());
    }
}
