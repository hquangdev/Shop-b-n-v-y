package com.example.authen_author.dto.respone;

import lombok.Data;

import java.util.Date;

@Data
public class KhachHangResponse {
    private Integer id;
    private String tenKhachHang;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private Date ngayTao;
    private Date ngaySua;
}
