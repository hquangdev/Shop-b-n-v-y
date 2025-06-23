package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "ThuongHieu")
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_thuong_hieu")
    private Integer idThuongHieu;
    @Column(name = "ma_thuong_hieu")
    private String maThuongHieu;
    @Column(name = "ten_thuong_hieu")
    private String tenThuongHieu;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;
    @Column(name = "trang_thai")
    private Boolean trangThai;
}
