package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MauSacRequest {
    private Integer idMauSac;
    private String maMauSac;
    private String tenMauSac;
    private Boolean trangThai;
    private String moTa;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;


}
