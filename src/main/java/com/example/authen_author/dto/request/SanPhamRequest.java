package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamRequest {
    private Integer idSanPham;
    private String maSanPham;
    private String tenSanPham;

    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;
    private Boolean trangThai;
    private String moTa;
    private Integer soLuong;

    private Integer idKieuDang;
    private Integer iddanhMuc;
    private Integer idThuongHieu;
    private Integer idChatLieu;
    private Integer idXuatXu;

}
