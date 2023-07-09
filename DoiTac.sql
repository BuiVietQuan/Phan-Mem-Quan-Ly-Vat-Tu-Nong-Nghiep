
create database DoiTac
go
use DoiTac
DROP database DoiTac

go

CREATE TABLE KhachHang
(   
	MaKH CHAR(10),	
	HoTen NVARCHAR(50) NOT NULL,
	NgaySinh DATE,
	SoDienThoai CHAR(10),
	DiaChi NVARCHAR(50),
	CONSTRAINT PK_MAKH PRIMARY KEY(MAKH)
)

go
   ALTER table KhachHang   
   ADD CONSTRAINT UC_KhachHang_Sdt UNIQUE (SoDienThoai),
   
   CONSTRAINT CK_KhachHang_NgaySinh check (NgaySinh < getdate())

go

insert into KhachHang values('KH01',N'Bùi Viết Quân','2002/01/19',,'0868380792','Lưu Chí Hiếu')
insert into KhachHang values('KH02',N'Bùi Viết Q','2002/01/19','0868380793','Lưu Chí Hiếu')
insert into KhachHang values('KH03',N'Bùi Viết Quang','2002/01/19','0868360792','Lưu Chí Hiếu')
insert into KhachHang values('KH04',N'Bùi Quốc Quân','2002/01/19','0868388792','Lưu Chí Hiếu')
insert into KhachHang values('KH05',N'Bùi Văn Quân','2002/01/19','0868380992','Lưu Chí Hiếu')
insert into KhachHang values('KH06',N'Bùi Anh Quân','2002/01/19','0868380592','Lưu Chí Hiếu')
insert into KhachHang values('KH07',N'Bùi Viết ','2002/01/19','0868380795','Lưu Chí Hiếu')
insert into KhachHang values('KH08',N'Đỗ Tuấn Kha','2002/01/19','0868330792','Lưu Chí Hiếu')
insert into KhachHang values('KH09',N'Đỗ Tuấn E','2002/01/19','0868300792','Lưu Chí Hiếu')
insert into KhachHang values('KH10',N'Bùi Văn Huy','2002/01/19','0868320792','Lưu Chí Hiếu')