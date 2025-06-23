package com.example.authen_author.service;

import com.example.authen_author.entity.MaGiamGia;
import com.example.authen_author.dto.request.KiemTraMaRequest;
import com.example.authen_author.dto.respone.KiemTraMaResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface GiamGiaService {
    MaGiamGia create(MaGiamGia maGiamGia);
    List<MaGiamGia> getAll();
    MaGiamGia getById(Integer id);
    MaGiamGia update(Integer id, MaGiamGia maGiamGia);
    void delete(Integer id);
    KiemTraMaResponse kiemTraMa(KiemTraMaRequest request);
    List<MaGiamGia> timKiemVaLoc(String maGiamGia, BigDecimal giaTriGiam, BigDecimal giaTriToiThieu,
                                 LocalDate ngayBatDau, LocalDate ngayHetHan);
}
