package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KichThuoc")
public class KichThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kich_thuoc")
    private Integer idKichThuoc;
    @Column(name = "ma_kich_thuoc")
    private String maKichThuoc;
    @Column(name = "ten_kich_thuoc")
    private String tenKichThuoc;
    @Column(name = "trang_thai")
    private Boolean trangThai;
}
