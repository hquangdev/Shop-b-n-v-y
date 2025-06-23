package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.KichThuoc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KichThuocRespone {
    private Integer idKichThuoc;
    private String maKichThuoc;
    private String tenKichThuoc;
    private Boolean trangThai;


    public KichThuocRespone(KichThuoc kichThuoc) {
       this.idKichThuoc = kichThuoc.getIdKichThuoc();
       this.maKichThuoc = kichThuoc.getMaKichThuoc();
       this.tenKichThuoc = kichThuoc.getTenKichThuoc();
       this.trangThai = kichThuoc.getTrangThai();
    }

}
