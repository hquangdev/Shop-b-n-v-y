package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DanhMuc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_danh_muc")
    private Integer idDanhMuc;
    @Column(name = "ma_danh_muc")
    private String maDanhMuc;
    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;
    @Column(name = "mo_ta")
    private String moTa;


}
