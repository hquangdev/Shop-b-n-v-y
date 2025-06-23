package com.example.authen_author.controller;

import com.example.authen_author.entity.MaGiamGia;
import com.example.authen_author.service.GiamGiaService;
import com.example.authen_author.dto.request.KiemTraMaRequest;
import com.example.authen_author.dto.respone.KiemTraMaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ma-giam-gia")
public class GiamGiaController {

    private final GiamGiaService giamGiaService;
////
    public GiamGiaController(GiamGiaService giamGiaService) {
        this.giamGiaService = giamGiaService;
    }

    @PostMapping("/create")
    public ResponseEntity<MaGiamGia> create(@RequestBody MaGiamGia maGiamGia) {
        return ResponseEntity.ok(giamGiaService.create(maGiamGia));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MaGiamGia>> getAll() {
        return ResponseEntity.ok(giamGiaService.getAll());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<MaGiamGia> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(giamGiaService.getById(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<MaGiamGia> update(@PathVariable Integer id, @RequestBody MaGiamGia maGiamGia) {
        return ResponseEntity.ok(giamGiaService.update(id, maGiamGia));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        giamGiaService.delete(id);
        return ResponseEntity.ok("Xóa thành công");
    }

    @PostMapping("/kiem-tra")
    public ResponseEntity<KiemTraMaResponse> kiemTraMa(@RequestBody KiemTraMaRequest request) {
        return ResponseEntity.ok(giamGiaService.kiemTraMa(request));
    }
    @GetMapping("/search")
    public ResponseEntity<List<MaGiamGia>> timKiemVaLoc(
            @RequestParam(required = false) String maGiamGia,
            @RequestParam(required = false) BigDecimal giaTriGiam,
            @RequestParam(required = false) BigDecimal giaTriToiThieu,
            @RequestParam(required = false) LocalDate ngayBatDau,
            @RequestParam(required = false) LocalDate ngayHetHan
    ) {
        return ResponseEntity.ok(giamGiaService.timKiemVaLoc(maGiamGia, giaTriGiam, giaTriToiThieu, ngayBatDau, ngayHetHan));
    }
}
