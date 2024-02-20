package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "hangkhachhang")
public class HangKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mahang;
    private String tenhang;
    private String mota;
    private Integer diemtoithieu;
    private Integer trangthai;


}
//    MaHang INT AUTO_INCREMENT PRIMARY KEY,
//        TenHang NVARCHAR(50),
//        MoTa TEXT,
//        DiemToiThieu INT NOT NULL,
//        TrangThai INT