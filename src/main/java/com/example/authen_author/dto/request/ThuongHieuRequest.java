package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThuongHieuRequest {
    private Integer idThuongHieu;
    private String maThuongHieu;
    private String tenThuongHieu;
    private Boolean trangThai;
    private String moTa;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;

}
