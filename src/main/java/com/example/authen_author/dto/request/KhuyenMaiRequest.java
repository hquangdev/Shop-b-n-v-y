package com.example.authen_author.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMaiRequest {
    
    @NotBlank(message = "Mã khuyến mãi không được để trống")
    private String maKhuyenMai;
    
    @NotBlank(message = "Tên khuyến mãi không được để trống")
    private String tenKhuyenMai;
    
    @NotNull(message = "Ngày bắt đầu không được để trống")
    @Future(message = "Ngày bắt đầu phải là tương lai")
    private LocalDateTime ngayBatDau;
    
    @NotNull(message = "Ngày kết thúc không được để trống")
    @Future(message = "Ngày kết thúc phải là tương lai")
    private LocalDateTime ngayKetThuc;
    
    @NotNull(message = "Số tiền giảm không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Số tiền giảm phải lớn hơn 0")
    private BigDecimal soTienGiam;
    
    @NotBlank(message = "Người tạo không được để trống")
    private String nguoiTao;


    @NotBlank(message = "Mô tả không được bỏ trống")
    private String moTa;
}
