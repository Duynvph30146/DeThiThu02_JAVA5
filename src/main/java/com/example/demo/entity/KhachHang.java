package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long makhachhang;
    private String tenkhachhang;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sinhnhat;
    private String diachi;
    private String sodienthoai;
    private String email;
    private Boolean gioitinh;
    private String chungminhthu;
    private String socancuoc;
    private String anhdaidien;
    private Integer trangthai;
    private Integer diemtichluy;
    @ManyToOne
    @JoinColumn(name = "hangkhachhang")
    HangKhachHang hangkhachhang;

}
//    CREATE TABLE KhachHang(
//        MaKhachHang		BIGINT
//		IDENTITY(1,1) PRIMARY KEY,
//    TenKhachHang	NVARCHAR(50),
//    SinhNhat		DATE,
//    DiaChi			NVARCHAR(MAX),
//    SoDienThoai		VARCHAR(15) ,
//    Email			VARCHAR(50) ,
//    GioiTinh		BIT,
//    ChungMinhThu	VARCHAR(15)	,
//    SoCanCuoc		VARCHAR(15)	,
//    AnhDaiDien		VARCHAR(50), -- Link anh
//        TrangThai		INT,
//        DiemTichLuy		INT DEFAULT 0, --Mac dinh 0
//        HangKhachHang	INT
//        REFERENCES HangKhachHang(MaHang),
//        NguoiGioiThieu	BIGINT
//        REFERENCES KhachHang(MaKhachHang)
//        )