package com.example.authen_author.controller;

import com.example.authen_author.dto.request.KhuyenMaiRequest;
import com.example.authen_author.dto.respone.KhuyenMaiRepone;
import com.example.authen_author.service.KhuyenMaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khuyenmai")
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @GetMapping
    public List<KhuyenMaiRepone> getAll() {
        return khuyenMaiService.getAllKhuyenMais();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhuyenMaiRepone> getById(@PathVariable Integer id) {
        KhuyenMaiRepone km = khuyenMaiService.getKhuyenMaiById(id);
        return (km != null) ? ResponseEntity.ok(km) : ResponseEntity.notFound().build();
    }

    @GetMapping("/trang-thai/{trangThai}")
    public List<KhuyenMaiRepone> getByTrangThai(@PathVariable String trangThai) {
        return khuyenMaiService.getKhuyenMaiByTrangThai(trangThai);
    }

    @PostMapping
    public ResponseEntity<KhuyenMaiRepone> create(@Valid @RequestBody KhuyenMaiRequest request) {
        KhuyenMaiRepone created = khuyenMaiService.createKhuyenMai(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhuyenMaiRepone> update(@PathVariable Integer id, 
                                                  @Valid @RequestBody KhuyenMaiRequest request) {
        KhuyenMaiRepone updated = khuyenMaiService.updateKhuyenMai(id, request);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        khuyenMaiService.deleteKhuyenMai(id);
        return ResponseEntity.noContent().build();
    }
}

