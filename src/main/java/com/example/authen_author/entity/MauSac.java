package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mau_sac")
    private Integer idMauSac;
    @Column(name = "ma_mau_sac")
    private String maMauSac;
    @Column(name = "ten_mau_sac")
    private String tenMauSac;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;
    @Column(name = "trang_thai")
    private boolean trangThai;
}
