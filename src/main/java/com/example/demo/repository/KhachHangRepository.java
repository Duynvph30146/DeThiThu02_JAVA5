package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {
    @Query("SELECT kh FROM KhachHang kh WHERE (kh.tenkhachhang LIKE ?2 OR kh.sodienthoai LIKE ?2) AND (?1 IS NULL OR kh.hangkhachhang.tenhang=?1)")
    Page<KhachHang> search(String tenhang, String keyword, Pageable pageable);
    boolean existsBySodienthoai(String sodienthoai);
}
