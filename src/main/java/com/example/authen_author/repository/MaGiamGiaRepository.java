package com.example.authen_author.repository;

import com.example.authen_author.entity.MaGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia,Integer> {
    Optional<MaGiamGia> findByMaGiamGia(String maGiamGia);
    @Query("SELECT m FROM MaGiamGia m WHERE " +
            "(:maGiamGia IS NULL OR m.maGiamGia LIKE %:maGiamGia%) AND " +
                    "(:giaTriGiam IS NULL OR m.giaTriGiam = :giaTriGiam) AND " +
                    "(:giaTriToiThieu IS NULL OR m.giaTriToiThieu = :giaTriToiThieu) AND " +
                    "(:ngayBatDau IS NULL OR m.ngayBatDau = :ngayBatDau) AND " +
                    "(:ngayHetHan IS NULL OR m.ngayHetHan = :ngayHetHan)")
    List<MaGiamGia> timKiemVaLoc(
            @Param("maGiamGia") String maGiamGia,
            @Param("giaTriGiam") BigDecimal giaTriGiam,
            @Param("giaTriToiThieu") BigDecimal giaTriToiThieu,
            @Param("ngayBatDau") LocalDate ngayBatDau,
            @Param("ngayHetHan") LocalDate ngayHetHan
    );
}
