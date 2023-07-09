
create database QLCuaHangVatTuNongNghiep
go
use QLCuaHangVatTuNongNghiep
/*DROP database QLCuaHangVatTuNongNghiep*/

go
CREATE TABLE NhaCungCap
(
  MaNCC CHAR(10) NOT NULL,
  TenNCC NVARCHAR(100) NOT NULL,
  DiaChi NVARCHAR(100) NOT NULL,
  SoDienThoai CHAR(10) NOT NULL,
  PRIMARY KEY (MaNCC)
);
    ALTER table NhaCungCap
   ADD CONSTRAINT UC_NhaCungCap_Sdt UNIQUE (SoDienThoai);
go
CREATE TABLE NhanVien
(   
	MaNV CHAR(10),	
	HoTen NVARCHAR(50) NOT NULL,
	TenDangNhap Varchar(20) NOT NULL,
	MatKhau VARchar(250) NOT NULL,
	NgaySinh DATE,
	GioiTinh NVARCHAR(5),
	SoDienThoai CHAR(10),
	DiaChi NVARCHAR(50),
	ChucVu NVARCHAR(30) NOT NULL,
	CONSTRAINT PK_MANV PRIMARY KEY(MANV)
)

go
   ALTER table NhanVien   
   ADD CONSTRAINT UC_NhanVien_Sdt UNIQUE (SoDienThoai),
   CONSTRAINT UC_NhanVien_TenDangNhap UNIQUE (TenDangNhap),
   CONSTRAINT CK_NhanVien_GioiTinh check (GioiTinh in(N'Nam',N'Nữ')),
   CONSTRAINT CK_NhanVien_ChucVu check (ChucVu in(N'Nhân viên',N'Quản lý')),
   CONSTRAINT CK_NhanVien_NgaySinh check (NgaySinh < getdate())

go

CREATE TABLE LoaiHang
(
  MaLoaiHang CHAR(10) NOT NULL,
  TenLoaiHang NVARCHAR(100) NOT NULL,
  PRIMARY KEY (MaLoaiHang),
);
go
CREATE TABLE HangHoa
(
  MaHang CHAR(10) NOT NULL,
  TenHang NVARCHAR(100) NOT NULL,
  AnhHangHoa VarChar(50) Null,
  MaLoaiHang CHAR(10) NOT NULL,  
  DonViTinh NVARCHAR(15) NOT NULL,
  PRIMARY KEY (MaHang),
  FOREIGN KEY (MaLoaiHang) REFERENCES LoaiHang(MaLoaiHang)
);
alter table HangHoa
ADD CONSTRAINT UC_HangHoa_TenHang UNIQUE (TenHang)

go
CREATE TABLE ChiTietLoaiHang
(
	MaCTLH CHAR(10),
	MaHang CHAR(10) not null,
	TenLoai NVARCHAR(50) not null,	
	GiaMacDinh Int not null,
	SoLuongTon INT not null,	
	CONSTRAINT PK_CTLH PRIMARY KEY(MACTLH),
	FOREIGN KEY(MAHANG) REFERENCES HangHoa(MaHang)
);
alter table ChiTietLoaiHang
add CONSTRAINT CK_ChiTietLoaiHang_GiaMacDinh check (GiaMacDinh > 0)

   ALTER table ChiTietLoaiHang
   add CONSTRAINT CK_ChiTietLoaiHang_SoLuongTon check (SoLuongTon >= 0)
go
CREATE TABLE GiaMatHang
(
	MaCTLH CHAR(10),
	GiaBan int,
	DieuKien int,
	CONSTRAINT PK_GiaMatHang PRIMARY KEY(MaCTLH,DieuKien),
	FOREIGN KEY(MaCTLH) REFERENCES ChiTietLoaiHang(MaCTLH)
);

ALTER table GiaMatHang
   add CONSTRAINT CK_GiaMatHang_GiaBan check (GiaBan > 0),
   CONSTRAINT CK_GiaMatHang_DieuKien check (DieuKien > 0)
go
CREATE TABLE NguonHang
(
  MaNCC CHAR(10) NOT NULL,
  MaCTLH CHAR(10) NOT NULL,
  GiaNhap INT NOT NULL,
  FOREIGN KEY (MACTLH) REFERENCES CHITIETLOAIHANG(MACTLH),
  FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC),
  constraint PK_nguonhang primary key(MACTLH,MaNCC)
)

  ALTER table NguonHang
  add CONSTRAINT CK_NguonHang_GiaNhap check (GiaNhap > 0)
  
go

CREATE TABLE PhieuDatHang
(
  SoDonDatHang CHAR(10) NOT NULL,
  MaNCC CHAR(10) NOT NULL,
  MaNV CHAR(10),
  NgayDat DateTime NOT NULL,
  TongSL INT NOT NULL,
  ThanhTien INT NOT NULL,
  PRIMARY KEY (SoDonDatHang),
  FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC),
  FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV)
);
   ALTER table PhieuDatHang
   add CONSTRAINT CK_PhieuDatHang_TongSL check (TongSL >= 0),
   CONSTRAINT DF_PhieuDatHang_TongSL default 0 for TongSL,
   CONSTRAINT DF_PhieuDatHang_NgayDat default GETDATE() for NgayDat,
   CONSTRAINT DF_PhieuDatHang_ThanhTien default 0 for ThanhTien,
   CONSTRAINT CK_PhieuDatHang_ThanhTien check (ThanhTien >= 0)

go 
CREATE TABLE PhieuGiaoHang
(
  SoPhieuGiao VARCHAR(30) NOT NULL,
  SoDonDatHang CHAR(10) NOT NULL,
  NgayGiao DateTime NOT NULL,
  TongSL int not null,
  ThanhTien INT NOT NULL,
  TrangThai NVARCHAR(13) NOT NULL,
  GhiChu NVARCHAR(100)
  PRIMARY KEY (SoPhieuGiao),
  FOREIGN KEY (SoDonDatHang) REFERENCES PhieuDatHang(SoDonDatHang)
);

 ALTER table PhieuGiaoHang 
   add CONSTRAINT CK_PhieuGiaoHang_TongSL check (TongSL >= 0),
   CONSTRAINT DF_PhieuGiaoHang_TongSL default 0 for TongSL,
   CONSTRAINT DF_PhieuGiaoHang_NgayGiao default getdate() for NgayGiao,
   CONSTRAINT DF_PhieuGiaoHang_ThanhTien default 0 for ThanhTien,
   CONSTRAINT CK_PhieuGiaoHang_ThanhTien check (ThanhTien >= 0),
   CONSTRAINT CK_PhieuGiaoHang_TrangThai CHECK (TrangThai in(N'Chờ xác nhận',N'Hoàn tất',N'Bị hủy'))
go 

CREATE TABLE ChiTietGiaoHang
(
  SoPhieuGiao VARCHAR(30) NOT NULL,
  MaCTLH CHAR(10) NOT NULL,
  SoLuong INT NOT NULL,
  PRIMARY KEY (SoPhieuGiao,MaCTLH),
  FOREIGN KEY (SoPhieuGiao) REFERENCES PhieuGiaoHang (SoPhieuGiao),
  FOREIGN KEY (MaCTLH) REFERENCES CHITIETLOAIHANG(MaCTLH),
);
   ALTER table ChiTietGiaoHang
   add CONSTRAINT CK_ChiTietGiaoHang_SoLuong check (SoLuong > 0)
go
CREATE TABLE ChiTietDatHang
(
  SoDonDatHang CHAR(10) NOT NULL,
  MaCTLH CHAR(10) NOT NULL,
  DonGia int NOT NULL,
  SoLuong INT NOT NULL,
  PRIMARY KEY (MACTLH,SoDonDatHang),
  FOREIGN KEY (SoDonDatHang) REFERENCES PhieuDatHang(SoDonDatHang),
  FOREIGN KEY (MACTLH) REFERENCES CHITIETLOAIHANG(MACTLH)
)
   ALTER table ChiTietDatHang
   add CONSTRAINT CK_ChiTietDatHang_SoLuong check (SoLuong > 0),
   CONSTRAINT CK_ChiTietDatHang_GiaNhap check (DonGia > 0)
go
CREATE TABLE KhachHang
(
  MaKH CHAR(10) NOT NULL,
  TenKH NVARCHAR(100) NOT NULL,
  DiaChi NVARCHAR(100),
  SoDienThoai CHAR(10) NOT NULL unique,
  PRIMARY KEY (MaKH),
);

CREATE TABLE HoaDon
(
  SoHoaDon CHAR(10) NOT NULL,
  MaNV CHAR(10) NOT NULL,
  MaKH CHAR(10),
  NgayMua DateTime NOT NULL,
  ThanhTien INT NOT NULL, 
  PRIMARY KEY (SoHoaDon),
  FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
  FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
  
);

   ALTER table HoaDon
   add CONSTRAINT CK_HoaDon_ThanhTien check (ThanhTien >= 0),
   CONSTRAINT DF_HoaDon_ThanhTien default 0 for ThanhTien,
   CONSTRAINT DF_HoaDon_NgayMua default GETDATE() for NgayMua

go
CREATE TABLE ChiTietHoaDon
(
  SoHoaDon CHAR(10) NOT NULL,
  MaCTLH CHAR(10),
  SoLuong INT NOT NULL,
  DonGia int not null,
  PRIMARY KEY (SoHoaDon,MACTLH),
  FOREIGN KEY (SoHoaDon) REFERENCES HoaDon(SoHoaDon),
  FOREIGN KEY (MaCTLH) REFERENCES ChiTietLoaiHang(MaCTLH),
)

  ALTER table ChiTietHoaDon
   add CONSTRAINT CK_ChiTietHoaDon_SoLuong check (SoLuong > 0),
   CONSTRAINT CK_ChiTietHoaDon_DonGia check (DonGia > 0)
go

----Trigger tự động lấy giá cho chi tiết hóa đơn
--create trigger CapNhatGiaTuDong
--on ChiTietHoaDon
--after insert
--as
--begin
--	declare @maCTLH char(10), @sl int, @gia int, @soHD char(10)
--	select @maCTLH = MACTLH, @sl = SoLuong from inserted
--	select top 1 @gia = GiaBan from GIAMATHANG where MACTLH = @maCTLH and DieuKien < @sl ORDER by DieuKien DESC
--	update ChiTietHoaDon set DonGia = @gia where SoHoaDon = @soHD and MACTLH = @maCTLH
--end
--go
--/*ràng buộc: Trên phiếu giao hàng chỉ có các mặt hàng mà nhà cung cấp đó có cung ứng.*/
--   create trigger GiaoHangDungMatHangTuNhaCungCap
--   on ChiTietGiaoHang
--   after insert 
--   as
--   begin
--	declare @maCTLH char(10), @ncc char(10)
--	select @maCTLH = MACTLH, @ncc = MaNCC 
--		from (inserted i join PhieuGiaoHang p
--			on i.SoPhieuGiao = p.SoPhieuGiao) join PhieuDatHang dh
--			on p.SoDonDatHang = p.SoDonDatHang
--	if(@maCTLH NOT in (select MACTLH from NguonHang where MaNCC = @ncc))
--		begin
--		Print(CAST(@maHang as varchar(10))+ N' không được cung cấp từ nhà cung cấp' + cast(@ncc as char(10)))
--			ROLLBACK TRANSACTION
--		end
--   end
--   go

-- trigger tên của từng chi tiết loại hàng hóa không của 1 hàng hóa không được phép trùng nhau
   create trigger TenCacLoaiSanPhamMoiHangKhongDuocTrung
   on ChiTietLoaiHang
   after insert,update
   as
   begin
	declare @maHang char(10), @tenLoai Nvarchar(50)
	select @tenLoai = TenLoai,@maHang = MaHang from inserted
	if((select count(*) from ChiTietLoaiHang where MaHang = @maHang and TenLoai = @tenLoai)>1)
		begin
			Print N'Tên loại sản phẩm của cùng 1 mặt hàng không được phép trùng nhau!!!'			
			ROLLBACK TRANSACTION
		end
   end
   go
   select * from ChiTietLoaiHang

   --trigger ràng buộc giá mặt hàng có điều kiện cao hơn luôn luôn phải thấp hơn giá mặt hàng có điều kiện thấp hơn

  