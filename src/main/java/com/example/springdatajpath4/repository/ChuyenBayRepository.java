package com.example.springdatajpath4.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springdatajpath4.entity.ChuyenBay;

@Repository
@Transactional
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
//	4
	List<ChuyenBay> findAllByGaDen(String gaDen);
	@Query(nativeQuery = true, value = "select * from chuyenbay where do_dai < 10000 and do_dai > 8000")
	List<ChuyenBay> chuyenBay8kDen10k();
//	5
	@Query(nativeQuery = true, value = "select * from chuyenbay where ga_di = ?1 and ga_den = ?2")
	List<ChuyenBay> chuyenBaySaiGonMeThuoc(String from, String to);
//	6
	@Query(nativeQuery = true, value = "select count(ma_cb) from chuyenbay where ga_di = 'SGN' ")
	int chuyenBayTuSaiGon();
	
// 	14
	@Query(nativeQuery = true, value = "select * from chuyenbay where do_dai < (select tam_bay from maybay where loai = 'Airbus A320' )")
	List<ChuyenBay> chuyenBayCuaAirbusA320 ();
}
