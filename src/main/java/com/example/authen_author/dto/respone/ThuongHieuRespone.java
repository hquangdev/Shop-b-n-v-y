package com.example.authen_author.dto.respone;

import com.example.authen_author.entity.ThuongHieu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThuongHieuRespone {
    private Integer idThuongHieu;
    private String maThuongHieu;
    private String tenThuongHieu;
    private Boolean trangThai;
    private String moTa;
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;

    public ThuongHieuRespone(ThuongHieu thuongHieu) {
        idThuongHieu = thuongHieu.getIdThuongHieu();
        maThuongHieu = thuongHieu.getMaThuongHieu();
        tenThuongHieu = thuongHieu.getTenThuongHieu();
        trangThai = thuongHieu.getTrangThai();
        moTa = thuongHieu.getMoTa();
        ngayTao = thuongHieu.getNgayTao();
        ngaySua = thuongHieu.getNgaySua();
    }
}
