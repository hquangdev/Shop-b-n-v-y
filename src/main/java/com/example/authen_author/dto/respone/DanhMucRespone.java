package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.DanhMuc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanhMucRespone {
    private Integer idDanhMuc;
    private String maDanhMuc;
    private String tenDanhMuc;
    private String moTa;


    public DanhMucRespone(DanhMuc danhMuc) {
        this.idDanhMuc = danhMuc.getIdDanhMuc();
        this.maDanhMuc = danhMuc.getMaDanhMuc();
        this.tenDanhMuc = danhMuc.getTenDanhMuc();
        this.moTa = danhMuc.getMoTa();


    }

}
