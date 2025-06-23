package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PhuongThucThanhToan")
public class PhuongThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phuong_thuc_thanh_toan")
    private Integer id;
    @Column(name = "ten_phuong_thuc")
    private String tenPhuongThuc;

    @Column(name = "mo_ta")
    private String moTa;
}
