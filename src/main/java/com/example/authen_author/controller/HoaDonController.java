package com.example.authen_author.controller;

import com.example.authen_author.entity.*;
import com.example.authen_author.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/HoaDon")
@RequiredArgsConstructor
public class HoaDonController {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private MaGiamGiaRepository maGiamGiaRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private PhuongThucGiamGiaRepository phuongThucGiamGiaRepository;

    @GetMapping("/home")
    public String hienThi(Model model) {
        // SỬ DỤNG query mới
        List<HoaDon> listHD = hoaDonRepository.findAll();
        List<KhachHang> ListKH = khachHangRepository.findAll();
        List<MaGiamGia> listGG = maGiamGiaRepository.findAll();
        List<NhanVien> listNV = nhanVienRepository.findAll();
        List<PhuongThucThanhToan> listPTTT = phuongThucGiamGiaRepository.findAll();

        model.addAttribute("listHD", listHD);
        model.addAttribute("ListKH", ListKH);
        model.addAttribute("listGG", listGG);
        model.addAttribute("listNV", listNV);
        model.addAttribute("listPTTT", listPTTT);
        model.addAttribute("hoaDon", new HoaDon());
        return "HoaDonVIew";
    }
    @PostMapping("/add")
    public String addHoaDon(@ModelAttribute  HoaDon hoaDon, Model model) {
        hoaDon.setNgayTao(new Date());
        hoaDon.setNgaySua(new Date());
        hoaDonRepository.save(hoaDon);
        return "redirect:/HoaDon/home";
    }
    @PostMapping("/update-trang-thai")
    public String updateTrangThai(@RequestParam("id") Integer id,
                                  @RequestParam("trangThai") Integer trangThai) {
        hoaDonRepository.findById(id).ifPresent(hd -> {
            hd.setTrangThai(trangThai.byteValue());
            hd.setNgaySua(new Date()); // Cập nhật ngày sửa nếu cần
            hoaDonRepository.save(hd);
        });
        return "redirect:/HoaDon/home";
    }
}
