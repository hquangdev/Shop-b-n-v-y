package com.example.authen_author.service.Impl;

import com.example.authen_author.entity.MaGiamGia;
import com.example.authen_author.dto.request.KiemTraMaRequest;
import com.example.authen_author.dto.respone.KiemTraMaResponse;
import com.example.authen_author.repository.MaGiamGiaRepository;
import com.example.authen_author.service.GiamGiaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GiamGiaServiceImpl implements GiamGiaService {

    private final MaGiamGiaRepository repository;

    public GiamGiaServiceImpl(MaGiamGiaRepository repository) {
        this.repository = repository;
    }

    @Override
    public MaGiamGia create(MaGiamGia maGiamGia) {
        return repository.save(maGiamGia);
    }

    @Override
    public List<MaGiamGia> getAll() {
        return repository.findAll();
    }

    @Override
    public MaGiamGia getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy mã giảm giá"));
    }

    @Override
    public MaGiamGia update(Integer id, MaGiamGia maGiamGia) {
        MaGiamGia existing = getById(id);
        existing.setMaGiamGia(maGiamGia.getMaGiamGia());
        existing.setGiaTriGiam(maGiamGia.getGiaTriGiam());
        existing.setGiaTriToiThieu(maGiamGia.getGiaTriToiThieu());
        existing.setNgayBatDau(maGiamGia.getNgayBatDau());
        existing.setNgayHetHan(maGiamGia.getNgayHetHan());
        existing.setGioiHanSuDung(maGiamGia.getGioiHanSuDung());
        existing.setSoLanDaDung(maGiamGia.getSoLanDaDung());
        existing.setLichSu(maGiamGia.getLichSu());
        return repository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public KiemTraMaResponse kiemTraMa(KiemTraMaRequest request) {
        Optional<MaGiamGia> optional = repository.findByMaGiamGia(request.getMaGiamGia());
        if (optional.isEmpty()) {
            return new KiemTraMaResponse(false, "Mã không tồn tại", null);
        }
        MaGiamGia ma = optional.get();
        if (ma.getNgayHetHan().isBefore(request.getNgayHienTai())) {
            return new KiemTraMaResponse(false, "Mã đã hết hạn", null);
        }
        if (ma.getSoLanDaDung() >= ma.getGioiHanSuDung()) {
            return new KiemTraMaResponse(false, "Mã đã hết lượt dùng", null);
        }
        if (request.getTongTien().compareTo(ma.getGiaTriToiThieu()) < 0) {
            return new KiemTraMaResponse(false, "Không đủ điều kiện tối thiểu", null);
        }
        return new KiemTraMaResponse(true, "Mã hợp lệ", ma.getGiaTriGiam());
    }
    @Override
    public List<MaGiamGia> timKiemVaLoc(String maGiamGia, BigDecimal giaTriGiam, BigDecimal giaTriToiThieu,
                                        LocalDate ngayBatDau, LocalDate ngayHetHan) {
        return repository.timKiemVaLoc(maGiamGia, giaTriGiam, giaTriToiThieu, ngayBatDau, ngayHetHan);
    }
}
