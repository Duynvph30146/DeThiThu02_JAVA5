package com.example.demo.controller;

import com.example.demo.dto.KhachHangSearchInfo;
import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.HangKhachHangService;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class KhachHangController {
    @Autowired
    HangKhachHangService hangKhachHangService;
    @Autowired
    KhachHangService khachHangService;


    //    @GetMapping("/khach-hang/hien-thi")
//    public String hienThi(@ModelAttribute("searchInfo") KhachHangSearchInfo info, Model model) {
//        List<KhachHang> list = repo.search(info.getMaHang(), "%" + info.getKeyword() + "%");
//        model.addAttribute("kh", new KhachHang());
//        model.addAttribute("list", list);
//        return "khach-hang/index";
//    }
//@GetMapping("/phieu-giam-gia/hien-thi")
//public String hienThi(@ModelAttribute("searchInfo") PhieuGiamGiaSearchInfo searchInfo, @RequestParam(defaultValue = "0") int p, Model model) {
//    Sort sort = Sort.by(Sort.Direction.ASC, "tenphieu");
//    Pageable pageable = PageRequest.of(p, 5,sort);
//    Page<PhieuGiamGia> page = phieuGiamService.search(searchInfo.getMaKhachHang(), searchInfo.getNgayBatDau(), searchInfo.getNgayKetThuc(), pageable);
//    model.addAttribute("page", page);
//    return "phieu-giam-gia/index";
//}

    @GetMapping("/khach-hang/hien-thi")
    public String hienThi(@ModelAttribute("search") KhachHangSearchInfo info, @ModelAttribute("kh") KhachHang kh, @RequestParam(defaultValue = "0") int p, Model model) {
        Pageable pageable = PageRequest.of(p, 5);
        Page<KhachHang> page = khachHangService.search(info.getTenhang(), "%" + info.getKeyword() + "%", pageable);
        model.addAttribute("page", page);
        return "khach-hang/index";
    }

    @PostMapping("/khach-hang/add")
    public String add(@ModelAttribute("kh") KhachHang khachHang, @ModelAttribute("search") KhachHangSearchInfo info, @RequestParam(defaultValue = "0") int p, @RequestParam("sodienthoai") String sodienthoai, Model model) {
        if (khachHangService.checkSoDienThoai(sodienthoai)) {
            model.addAttribute("sdt", "Số điện thoại đã tồn tại!!");
            System.out.println("So dien thoai da ton tai");
            Pageable pageable = PageRequest.of(p, 5);
            Page<KhachHang> page = khachHangService.search(info.getTenhang(), "%" + info.getKeyword() + "%", pageable);
            model.addAttribute("page", page);
            return "khach-hang/index";
        }
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/delete/{makhachhang}")
    public String delete(@PathVariable("makhachhang") Long makhachhang) {
        khachHangService.delete(makhachhang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/update/{makhachhang}")
    public String update(@PathVariable("makhachhang") Long makhachhang, @ModelAttribute("search") KhachHangSearchInfo info, @RequestParam(defaultValue = "0") int p, Model model) {
        model.addAttribute("kh", khachHangService.getById(makhachhang));
        Pageable pageable = PageRequest.of(p, 5);
        Page<KhachHang> page = khachHangService.search(info.getTenhang(), "%" + info.getKeyword() + "%", pageable);
        model.addAttribute("page", page);
        return "khach-hang/index";
    }

    @PostMapping("/khach-hang/update/{makhachhang}")
    public String updateSave(@PathVariable("makhachhang") Long makhachhang, Model model, @ModelAttribute("kh") KhachHang khachHang) {
        khachHang.setMakhachhang(makhachhang);
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @ModelAttribute("dsHang")
    public List<HangKhachHang> getDSHang() {
        return hangKhachHangService.getAll();
    }
}
