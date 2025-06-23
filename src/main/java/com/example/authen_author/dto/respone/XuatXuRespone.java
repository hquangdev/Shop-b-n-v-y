package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.XuatXu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XuatXuRespone {
    private Integer idXuatXu;
    private String maXuatXu;
    private String tenXuatXu;
    private String moTa;


    public XuatXuRespone(XuatXu xuatXu) {
        idXuatXu = xuatXu.getIdXuatXu();
        maXuatXu = xuatXu.getMaXuatXu();
        tenXuatXu = xuatXu.getTenXuatXu();
        moTa = xuatXu.getMoTa();
    }
}
