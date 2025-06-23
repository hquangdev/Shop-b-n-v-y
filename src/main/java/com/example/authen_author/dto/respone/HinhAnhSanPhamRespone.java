package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.HinhAnhSanPham;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HinhAnhSanPhamRespone {
    private Integer idHinhAnhSanPham;
    private String duongDanHinhAnh;
    private String tenAnh;

    public HinhAnhSanPhamRespone(HinhAnhSanPham hinhAnhSanPham) {
        this.idHinhAnhSanPham = hinhAnhSanPham.getIdHinhAnhSanPham();
        this.tenAnh = hinhAnhSanPham.getTenAnh();
        this.duongDanHinhAnh = hinhAnhSanPham.getDuongDanHinhAnh();

    }

}
