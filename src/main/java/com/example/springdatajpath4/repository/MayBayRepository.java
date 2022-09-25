package com.example.springdatajpath4.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springdatajpath4.entity.MayBay;

@Repository
@Transactional
public interface MayBayRepository extends JpaRepository<MayBay, Integer> {
//	2
	@Query(value="select * from maybay where tam_bay > ?1", nativeQuery = true)
	List<MayBay> findMayBayLon(int tambay);
//	7
	@Query(value="select count(mamb) from maybay where loai like 'Boeing%'", nativeQuery = true)
	int countLoaiBoeing();
//	13
	@Query(value="select * from maybay where tam_bay > (select do_dai from chuyenbay where ma_cb = ?1)", nativeQuery = true)
	List<MayBay> findMayBayByCB(String maCB);
	
//	16
	@Query(value="select  mb.mamb, mb.loai, COUNT(c.manv) as total from chungnhan c join maybay mb on c.mamb = mb.mamb GROUP BY(mb.loai)", nativeQuery = true)
	List<Object> findMayBayDuocLai();
}
