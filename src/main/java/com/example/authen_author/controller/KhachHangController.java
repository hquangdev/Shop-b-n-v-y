package com.example.authen_author.controller;

import com.example.authen_author.dto.request.KhachHangRequest;
import com.example.authen_author.dto.respone.KhachHangResponse;
import com.example.authen_author.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @PostMapping
    public ResponseEntity<?> createKhachHang(@RequestBody KhachHangRequest request) {
        KhachHangResponse response = khachHangService.createKhachHang(request);
        return ResponseEntity.ok().body("Tạo khách hàng thành công! ID = " + response.getId());
    }

    @GetMapping
    public ResponseEntity<List<KhachHangResponse>> getAllKhachHang() {
        return ResponseEntity.ok(khachHangService.getAllKhachHang());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKhachHangById(@PathVariable Integer id) {
        return khachHangService.getKhachHangById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateKhachHang(@PathVariable Integer id, @RequestBody KhachHangRequest request) {
        return khachHangService.updateKhachHang(id, request)
                .map(updated -> ResponseEntity.ok().body("Cập nhật khách hàng thành công!"))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKhachHang(@PathVariable Integer id) {
        boolean deleted = khachHangService.deleteKhachHang(id);
        if (deleted) {
            return ResponseEntity.ok().body("Xóa khách hàng thành công!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
