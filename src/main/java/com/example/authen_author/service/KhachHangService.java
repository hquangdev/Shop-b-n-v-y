package com.example.authen_author.service;

import com.example.authen_author.dto.request.KhachHangRequest;
import com.example.authen_author.dto.respone.KhachHangResponse;
import com.example.authen_author.entity.KhachHang;
import com.example.authen_author.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public KhachHangResponse createKhachHang(KhachHangRequest request) {
        KhachHang khachHang = new KhachHang();
        khachHang.setTenKhachHang(request.getTenKhachHang());
        khachHang.setSoDienThoai(request.getSoDienThoai());
        khachHang.setEmail(request.getEmail());
        khachHang.setDiaChi(request.getDiaChi());
        khachHang.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        khachHang.setNgayTao(new Date());
        khachHang.setNgaySua(new Date());

        KhachHang saved = khachHangRepository.save(khachHang);
        return mapToResponse(saved);
    }

    public List<KhachHangResponse> getAllKhachHang() {
        return khachHangRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public Optional<KhachHangResponse> getKhachHangById(Integer id) {
        return khachHangRepository.findById(id)
                .map(this::mapToResponse);
    }

    public Optional<KhachHangResponse> updateKhachHang(Integer id, KhachHangRequest request) {
        Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(id);
        if (optionalKhachHang.isPresent()) {
            KhachHang khachHang = optionalKhachHang.get();
            khachHang.setTenKhachHang(request.getTenKhachHang());
            khachHang.setSoDienThoai(request.getSoDienThoai());
            khachHang.setEmail(request.getEmail());
            khachHang.setDiaChi(request.getDiaChi());
            khachHang.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
            khachHang.setNgaySua(new Date());

            KhachHang updated = khachHangRepository.save(khachHang);
            return Optional.of(mapToResponse(updated));
        }
        return Optional.empty();
    }

    public boolean deleteKhachHang(Integer id) {
        if (khachHangRepository.existsById(id)) {
            khachHangRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private KhachHangResponse mapToResponse(KhachHang khachHang) {
        KhachHangResponse response = new KhachHangResponse();
        response.setId(khachHang.getId());
        response.setTenKhachHang(khachHang.getTenKhachHang());
        response.setSoDienThoai(khachHang.getSoDienThoai());
        response.setEmail(khachHang.getEmail());
        response.setDiaChi(khachHang.getDiaChi());
        response.setNgayTao(khachHang.getNgayTao());
        response.setNgaySua(khachHang.getNgaySua());
        return response;
    }
}
