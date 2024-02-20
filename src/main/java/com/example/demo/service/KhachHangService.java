package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;

    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    public KhachHang add(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    public void delete(Long makhachhang) {
        khachHangRepository.deleteById(makhachhang);
    }

    public KhachHang getById(Long makhachhang) {
        return khachHangRepository.findById(makhachhang).orElse(null);

    }

    public Page<KhachHang> search(String tenhang, String keyword, Pageable pageable) {
        return khachHangRepository.search(tenhang, keyword, pageable);
    }

    public Boolean checkSoDienThoai(String sodienthoai) {
        return khachHangRepository.existsBySodienthoai(sodienthoai);
    }
}
