package com.example.springdatajpath4.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springdatajpath4.entity.NhanVien;

@Repository
@Transactional
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
//	3
	@Query(value = "select * from nhanvien where luong < 10000", nativeQuery = true)
	List<NhanVien> findNVLuongNhoHon10000();
//	8
	@Query(value = "select SUM(luong) from nhanvien ", nativeQuery = true)
	int totalLuong();
//	9
	@Query(value = "select DISTINCT nv.manv from chungnhan c join maybay mb on c.mamb = mb.mamb join nhanvien nv on nv.manv = c.manv where loai like ?1% ", nativeQuery = true)
	List<String> phiCongLaiBoeing(String ma);
//  10
	@Query(value = "select * from nhanvien nv JOIN chungnhan cn on nv.manv = cn.manv Join maybay mb on mb.mamb = cn.mamb where mb.mamb=?1", nativeQuery = true)
	List<NhanVien> phiCongMayBay747(String mb);
//	12
	@Query(nativeQuery = true, 
			value = "SELECT nhanvien.manv FROM nhanvien WHERE nhanvien.manv IN (SELECT DISTINCT manv FROM chungnhan WHERE mamb IN (SELECT mamb FROM maybay WHERE loai LIKE ?1)) AND nhanvien.manv IN ( SELECT DISTINCT manv FROM chungnhan WHERE mamb IN (SELECT mamb FROM maybay WHERE loai LIKE ?2) )")
	List<String> phiCongLai2MB(String mb1, String mb2);
	
//	15
	@Query(value = "select DISTINCT nv.ten from chungnhan c join maybay mb on c.mamb = mb.mamb join nhanvien nv on nv.manv = c.manv where loai like ?1% ", nativeQuery = true)
	List<String> findNameByMB(String loai);
}
