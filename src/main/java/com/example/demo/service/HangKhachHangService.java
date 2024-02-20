package com.example.demo.service;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.repository.HangKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HangKhachHangService {
    @Autowired
    HangKhachHangRepository hangKhachHangRepository;

    public List<HangKhachHang> getAll() {
        return hangKhachHangRepository.findAll();
    }
}
