create database DuAn1;
create table PhieuTra(
  idPhieuTra UNIQUEIDENTIFIER primary key default NEWID(),
  idThit UNIQUEIDENTIFIER,
  MaPhieuTra nvarchar(50),
  tenHangHoa nvarchar(50),
  donViTinh nvarchar(50),
  soLuong int,
  donGia int,
  soHoaDon int,
  kyHieu nvarchar(50),
  ngayPhatHanh date,
  tongCongThanhToan int,
  lyDo nvarchar(50));

  
  create table DotKM(
  idDotKM UNIQUEIDENTIFIER primary key default NEWID(),
  idThit UNIQUEIDENTIFIER,
  MaDotKM nvarchar(50),
  MucGiamGia int,
  
  ngayBatDau date,
  ngayKetThuc date,
  moTa nvarchar(50),)
  
create table donGiao(
  idDonGiao UNIQUEIDENTIFIER primary key default NEWID(),
  MaDG nvarchar(50),
  Mota nvarchar(50))
create table DonViVanChuyen(
  iddonViVanChuyen UNIQUEIDENTIFIER primary key default NEWID(),
  maDVVC nvarchar(50),
  ten nvarchar(50),
  phamViVanChuyen nvarchar(50),
  trangThai int)
create table donGiaoChiTiet(
  idDonGiaoChiTiet UNIQUEIDENTIFIER primary key default NEWID(),
  idKhachHang UNIQUEIDENTIFIER,
  idDonGiao UNIQUEIDENTIFIER,
  idDonViVanChuyen UNIQUEIDENTIFIER,
  ngayGiaoHang date,
  ngayNhanHang date,
  diaChi nvarchar(50),
  tinhTrang nvarchar(50))
create table hoaDon(
  idHoaDon UNIQUEIDENTIFIER primary key default NEWID(),
  idKH UNIQUEIDENTIFIER,
  idVC UNIQUEIDENTIFIER,
  idDKM UNIQUEIDENTIFIER,
  idNV UNIQUEIDENTIFIER,
  idDonGiaoCt UNIQUEIDENTIFIER,
  ma nvarchar(50),
  ngaytao date,
  tinhTrang int)
create table hoaDonChiTiet(
  idhdct UNIQUEIDENTIFIER primary key default NEWID(),
  idhd UNIQUEIDENTIFIER,
  idThit UNIQUEIDENTIFIER,
  soluong int,
  donGia decimal(20,5),
  tienKhachDua decimal(20,5))
create table thit(
  idThit UNIQUEIDENTIFIER primary key default NEWID(),
  LoaiThit nvarchar(50),
  TrongLuong int,
  Soluong int,
  GiaTien int,
  HSD nvarchar(50),
  NguonGoc nvarchar(50))
create table voucher(
  idVoucher UNIQUEIDENTIFIER primary key default NEWID(),
  Loai bit,
  Giatri int,
  NgayBatDau date,
  NgayKetThuc date)
create table voucherChitiet(
  idVoucherChitiet UNIQUEIDENTIFIER primary key default NEWID(),
  idVoucher UNIQUEIDENTIFIER,
  idKhachHang UNIQUEIDENTIFIER,
  Tinhtrang bit)
create table nhanVien(
  idNhanVien UNIQUEIDENTIFIER primary key default NEWID(),
  MaNV varchar(50),
  HoTen nvarchar(50),
  GioiTinh nvarchar(50),
  Email nvarchar(50),
  DiaChi nvarchar(50),
  SDT nvarchar(50),
  MatKhau nvarchar(50),
  TenCV nvarchar(50),
  TrangThai nvarchar(50),)


create table khachHang(
  idKhachHang UNIQUEIDENTIFIER primary key default NEWID(),
  maKh nvarchar(50),
  hoTen nvarchar(50),
  sdt nvarchar(50),
  diaChi nvarchar(50))
alter table donGiaoChiTiet add foreign key(idDonGiao) references donGiao(idDonGiao);
alter table donGiaoChiTiet add foreign key(idDonViVanChuyen) references DonViVanChuyen(iddonViVanChuyen);
alter table hoaDon add foreign key (idKH) references khachHang(idKhachHang);
alter table voucherChiTiet add foreign key (idvoucher) references voucher(idvoucher);
alter table hoaDonChiTiet add foreign key (idhd) references hoaDon(idHoaDon);
alter table hoaDonChiTiet add foreign key (idhd) references hoaDon(idHoaDon);
alter table hoaDonChiTiet add foreign key (idthit) references thit(idthit);

alter table hoaDon add foreign key (idNV) references nhanvien(idNhanVien);
alter table hoaDon add foreign key (idDonGiaoCt) references donGiaoChiTiet(idDonGiaoChiTiet);
alter table hoaDon add foreign key (idVC) references voucher(idvoucher);
alter table donGiaoChiTiet add foreign key (idKhachHang) references KhachHang(idKhachHang);
alter table DotKM add foreign key (idThit) references Thit(idThit);
alter table PhieuTra add foreign key (idThit) references Thit(idThit);


