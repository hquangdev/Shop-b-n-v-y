package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class XuatXuRequest {
    private Integer idXuatXu;
    private String maXuatXu;
    private String tenXuatXu;
    private String moTa;


}
