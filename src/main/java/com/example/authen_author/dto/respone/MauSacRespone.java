package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.MauSac;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MauSacRespone {
    private Integer idMauSac;
    private String maMauSac;
    private String tenMauSac;
    private Boolean trangThai;
    private String moTa;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;


    public MauSacRespone(MauSac mauSac) {
        this.idMauSac = mauSac.getIdMauSac();
        this.maMauSac = mauSac.getMaMauSac();
        this.tenMauSac = mauSac.getTenMauSac();
        this.trangThai = mauSac.isTrangThai();
        this.moTa = mauSac.getMoTa();
        this.ngayTao = mauSac.getNgayTao();
        this.ngaySua = mauSac.getNgaySua();

    }
}
