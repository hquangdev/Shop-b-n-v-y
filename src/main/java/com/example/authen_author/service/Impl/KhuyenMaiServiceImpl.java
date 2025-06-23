package com.example.authen_author.service.Impl;

import com.example.authen_author.dto.request.KhuyenMaiRequest;
import com.example.authen_author.dto.respone.KhuyenMaiRepone;
import com.example.authen_author.entity.KhuyenMai;
import com.example.authen_author.repository.KhuyenMaiRepository;
import com.example.authen_author.service.KhuyenMaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private final KhuyenMaiRepository repository;

    @Override
    public List<KhuyenMaiRepone> getAllKhuyenMais() {
        return repository.findAll()
                .stream()
                .map(KhuyenMaiRepone::new)
                .collect(Collectors.toList());
    }

    @Override
    public KhuyenMaiRepone getKhuyenMaiById(Integer id) {
        Optional<KhuyenMai> khuyenMai = repository.findById(id);
        return khuyenMai.map(KhuyenMaiRepone::new).orElse(null);
    }

    @Override
    public KhuyenMaiRepone createKhuyenMai(KhuyenMaiRequest request) {
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMaKhuyenMai(request.getMaKhuyenMai());
        khuyenMai.setTenKhuyenMai(request.getTenKhuyenMai());
        khuyenMai.setNgayBatDau(request.getNgayBatDau());
        khuyenMai.setNgayKetThuc(request.getNgayKetThuc());
        khuyenMai.setSoTienGiam(request.getSoTienGiam());
        khuyenMai.setNguoiTao(request.getNguoiTao());
        khuyenMai.setMoTa(request.getMoTa());
        
        KhuyenMai saved = repository.save(khuyenMai);
        return new KhuyenMaiRepone(saved);
    }

    @Override
    public KhuyenMaiRepone updateKhuyenMai(Integer id, KhuyenMaiRequest request) {
        Optional<KhuyenMai> existing = repository.findById(id);
        if (existing.isPresent()) {
            KhuyenMai khuyenMai = existing.get();
            khuyenMai.setMaKhuyenMai(request.getMaKhuyenMai());
            khuyenMai.setTenKhuyenMai(request.getTenKhuyenMai());
            khuyenMai.setNgayBatDau(request.getNgayBatDau());
            khuyenMai.setNgayKetThuc(request.getNgayKetThuc());
            khuyenMai.setSoTienGiam(request.getSoTienGiam());
            khuyenMai.setNguoiTao(request.getNguoiTao());
            khuyenMai.setMoTa(request.getMoTa());
            
            KhuyenMai updated = repository.save(khuyenMai);
            return new KhuyenMaiRepone(updated);
        } else {
            return null;
        }
    }

    @Override
    public void deleteKhuyenMai(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<KhuyenMaiRepone> getKhuyenMaiByTrangThai(String trangThai) {
        LocalDateTime now = LocalDateTime.now();
        
        List<KhuyenMai> khuyenMais;
        switch (trangThai.toUpperCase()) {
            case "DANG_DIEN_RA":
                khuyenMais = repository.findAll().stream()
                        .filter(km -> now.isAfter(km.getNgayBatDau()) && now.isBefore(km.getNgayKetThuc()))
                        .collect(Collectors.toList());
                break;
            case "CHUA_BAT_DAU":
                khuyenMais = repository.findAll().stream()
                        .filter(km -> now.isBefore(km.getNgayBatDau()))
                        .collect(Collectors.toList());
                break;
            case "DA_KET_THUC":
                khuyenMais = repository.findAll().stream()
                        .filter(km -> now.isAfter(km.getNgayKetThuc()))
                        .collect(Collectors.toList());
                break;
            default:
                khuyenMais = repository.findAll();
        }
        
        return khuyenMais.stream()
                .map(KhuyenMaiRepone::new)
                .collect(Collectors.toList());
    }
}
