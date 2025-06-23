package com.example.authen_author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "MaGiamGia")
public class MaGiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ma_giam_gia")
    private Integer idMaGiamGia;

    @Column(name = "ma_giam_gia")
    private String maGiamGia;

    @Column(name = "gia_tri_giam")
    private BigDecimal giaTriGiam;

    @Column(name = "gia_tri_toi_thieu")
    private BigDecimal giaTriToiThieu;

    @Column(name = "ngay_bat_dau")
    private LocalDate ngayBatDau;

    @Column(name = "ngay_het_han")
    private LocalDate ngayHetHan;

    @Column(name = "gioi_han_su_dung")
    private Integer gioiHanSuDung;

    @Column(name = "so_lan_da_dung")
    private Integer soLanDaDung;

    @Column(name = "lich_su")
    private String lichSu;
}
