package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "XuatXu")
public class XuatXu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_xuat_xu")
    private Integer idXuatXu;
    @Column(name = "ma_xuat_xu")
    private String maXuatXu;
    @Column(name = "ten_xuat_xu")
    private String tenXuatXu;
    @Column(name = "mo_ta")
    private String moTa;
}
