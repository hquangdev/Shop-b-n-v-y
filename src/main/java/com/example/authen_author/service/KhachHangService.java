package com.example.authen_author.service;

import com.example.authen_author.dto.request.KhachHangRequest;
import com.example.authen_author.dto.respone.KhachHangResponse;

import java.util.List;
import java.util.Optional;

public interface KhachHangService {

    KhachHangResponse createKhachHang(KhachHangRequest request);
    List<KhachHangResponse> getAllKhachHang();
    Optional<KhachHangResponse> getKhachHangById(Integer id);
    Optional<KhachHangResponse> updateKhachHang(Integer id, KhachHangRequest request);
    boolean deleteKhachHang(Integer id);

}
