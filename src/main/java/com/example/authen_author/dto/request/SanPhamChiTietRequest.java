package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamChiTietRequest {
    private Integer idSpct;
    private String maSpct;

    private float gia;
    private String hinhAnh;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;


}
