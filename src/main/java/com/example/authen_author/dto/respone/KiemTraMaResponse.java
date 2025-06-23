package com.example.authen_author.dto.respone;

import java.math.BigDecimal;

public class KiemTraMaResponse {
    private boolean hopLe;
    private String thongBao;
    private BigDecimal giaTriGiam;

    public KiemTraMaResponse(boolean hopLe, String thongBao, BigDecimal giaTriGiam) {
        this.hopLe = hopLe;
        this.thongBao = thongBao;
        this.giaTriGiam = giaTriGiam;
    }

    public boolean isHopLe() {
        return hopLe;
    }

    public String getThongBao() {
        return thongBao;
    }

    public BigDecimal getGiaTriGiam() {
        return giaTriGiam;
    }
}
