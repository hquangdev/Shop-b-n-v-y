package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HinhAnhSanPhamRequest {
    private Integer idHinhAnhSanPham;
    private String duongDanHinhAnh;
    private String tenAnh;


}
