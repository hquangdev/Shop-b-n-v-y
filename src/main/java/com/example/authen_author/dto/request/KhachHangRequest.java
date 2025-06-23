package com.example.authen_author.dto.request;

import lombok.Data;

@Data
public class KhachHangRequest {
    private String tenKhachHang;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private String matKhau;
}
