package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KieuDangRequest {
    private Integer idKieuDang;
    private String maKieuDang;
    private String tenKieuDang;
    private String moTa;


}
