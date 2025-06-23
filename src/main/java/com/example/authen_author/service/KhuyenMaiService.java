package com.example.authen_author.service;

import com.example.authen_author.dto.request.KhuyenMaiRequest;
import com.example.authen_author.dto.respone.KhuyenMaiRepone;
import com.example.authen_author.entity.KhuyenMai;

import java.util.List;

public interface KhuyenMaiService {
    List<KhuyenMaiRepone> getAllKhuyenMais();
    KhuyenMaiRepone getKhuyenMaiById(Integer id);
    KhuyenMaiRepone createKhuyenMai(KhuyenMaiRequest request);
    KhuyenMaiRepone updateKhuyenMai(Integer id, KhuyenMaiRequest request);
    void deleteKhuyenMai(Integer id);
    List<KhuyenMaiRepone> getKhuyenMaiByTrangThai(String trangThai);
}

