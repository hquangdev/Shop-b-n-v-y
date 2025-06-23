package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanhMucRequest {
    private Integer idDanhMuc;
    private String maDanhMuc;
    private String tenDanhMuc;
    private String moTa;
    private Boolean trangThai;


}
