package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KieuDang")
public class KieuDang {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_kieu_dang")
    private Integer idKieuDang;
    @Column(name = "ma_kieu_dang")
    private String maKieuDang;
    @Column(name = "ten_kieu_dang")
    private String tenKieuDang;
    @Column(name = "mo_ta")
    private String moTa;

}
