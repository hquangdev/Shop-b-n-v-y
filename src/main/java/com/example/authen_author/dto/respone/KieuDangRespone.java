package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.KieuDang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KieuDangRespone {
    private Integer idKieuDang;
    private String maKieuDang;
    private String tenKieuDang;
    private String moTa;

    public KieuDangRespone(KieuDang kieuDang) {
        this.idKieuDang = kieuDang.getIdKieuDang();
        this.maKieuDang = kieuDang.getMaKieuDang();
        this.tenKieuDang = kieuDang.getTenKieuDang();
        this.moTa = kieuDang.getMoTa();
    }

}
