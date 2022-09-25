package com.example.springdatajpath4;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpath4.entity.ChuyenBay;
import com.example.springdatajpath4.entity.MayBay;
import com.example.springdatajpath4.entity.NhanVien;
import com.example.springdatajpath4.repository.ChungNhanRepository;
import com.example.springdatajpath4.repository.ChuyenBayRepository;
import com.example.springdatajpath4.repository.MayBayRepository;
import com.example.springdatajpath4.repository.NhanVienRepository;
import com.google.gson.Gson;



@SpringBootTest
class SpringDataJpaTh4ApplicationTests {
	@Autowired
	ChuyenBayRepository chuyenBayRepository;
	
	@Autowired
	NhanVienRepository nhanVienRepository;
	
	@Autowired
	MayBayRepository mayBayRepository;
	@Autowired
	ChungNhanRepository chungNhanRepository;
	
	//1.	Cho biết các chuyến bay đi Đà Lạt (DAD).
	@Test
	void testCase_1() {
		List<ChuyenBay> ls =chuyenBayRepository.findAllByGaDen("DAD");
		System.out.println("TEST 1: Cho biết các chuyến bay đi Đà Lạt (DAD).");
		for(ChuyenBay cb: ls) {
			System.out.println(cb);
		}
		
	}
	//2.	Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
	@Test
	void testCase_2() {
		List<MayBay> ls = mayBayRepository.findMayBayLon(10000);
		System.out.println("TEST 2: Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.");
		for(MayBay mb: ls) {
			System.out.println(mb);
		}
	}
	//3.	Tìm các nhân viên có lương nhỏ hơn 10,000.
	@Test
	void testCase_3() {
		List<NhanVien> ls = nhanVienRepository.findNVLuongNhoHon10000();
		System.out.println("TEST 3: Tìm các nhân viên có lương nhỏ hơn 10,000.");
		for(NhanVien nv: ls) {
			System.out.println(nv);
		}
	}
	//4.	Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km
	@Test
	void testCase_4() {
		List<ChuyenBay> ls = chuyenBayRepository.chuyenBay8kDen10k();
		System.out.println("TEST 4: Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km");
		for(ChuyenBay cb: ls) {
			System.out.println(cb);
		}
	}
	//5.	Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
	@Test
	void testCase_5() {
		List<ChuyenBay> ls = chuyenBayRepository.chuyenBaySaiGonMeThuoc("SGN", "BMV");
		System.out.println("TEST 5: Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).");
		for(ChuyenBay cb: ls) {
			System.out.println(cb);
		}
	}
	//6.	Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
	@Test
	void testCase_6() {
		int count = chuyenBayRepository.chuyenBayTuSaiGon();
		System.out.println("TEST 6: Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).");
		
			System.out.println(count);
		
	}
	//7.	Có bao nhiêu loại máy báy Boeing.
	@Test
	void testCase_7() {
		int ls = mayBayRepository.countLoaiBoeing();
		System.out.println("TEST 7: Có bao nhiêu loại máy báy Boeing.");
		
			System.out.println(ls);
		
	}
	//8.	Cho biết tổng số lương phải trả cho các nhân viên.
	@Test
	void testCase_8() {
		double total = nhanVienRepository.totalLuong();
		System.out.println("TEST 8: Cho biết tổng số lương phải trả cho các nhân viên.");
			System.out.println(total);
		
	}
	//9.	Cho biết mã số của các phi công lái máy báy Boeing.
	@Test
	void testCase_9() {
		List<String> ls = nhanVienRepository.phiCongLaiBoeing("Boeing");
		System.out.println("TEST 9: Cho biết mã số của các phi công lái máy báy Boeing.");
		for(String ma: ls) {
			System.out.println(ma);
		}
		
	}
	//10.	Cho biết các nhân viên có thể lái máy bay có mã số 747.
	@Test
	void testCase_10() {
		List<NhanVien> ls = nhanVienRepository.phiCongMayBay747("747");
		System.out.println("TEST 10: Cho biết các nhân viên có thể lái máy bay có mã số 747.");
		for(NhanVien nv: ls) {
			System.out.println(nv);
		}
		
	}
	//11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
	@Test
	void testCase_11() {
		List<String> ls = chungNhanRepository.maMBVoiNVHoNguyen("Nguyễn");
		System.out.println("TEST 11: Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.");
		for(String ma: ls) {
			System.out.println(ma);
		}
		
	}
	//12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
	@Test
	void testCase_12() {
		List<String> ls = nhanVienRepository.phiCongLai2MB("Airbus%", "Boeing%");
		System.out.println("TEST 12: Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.");
		for(String ma: ls) {
			System.out.println(ma);
		}
	}
	//13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
	@Test
	void testCase_13() {
		List<MayBay> ls = mayBayRepository.findMayBayByCB("VN280");
		System.out.println("TEST 13: Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.");
		for(MayBay mb: ls) {
			System.out.println(mb.getLoai());
		}
	}
	//14.	Cho biết các chuyến bay có thể được thực hiện bởi máy bay Airbus A320.
	@Test
	void testCase_14() {
		List<ChuyenBay> ls = chuyenBayRepository.chuyenBayCuaAirbusA320();
		System.out.println("TEST 14: Cho biết các chuyến bay có thể được thực hiện bởi máy bay Airbus A320.");
		for(ChuyenBay cb: ls) {
			System.out.println(cb);
		}
	}
	//15.	Cho biết tên của các phi công lái máy bay Boeing.
	@Test
	void testCase_15() {
		List<String> ls = nhanVienRepository.findNameByMB("Boeing");
		System.out.println("TEST 15: Cho biết tên của các phi công lái máy bay Boeing.");
		for(String nv: ls) {
			System.out.println(nv);
		}
		
	}
	//16.	Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.
	@Test
	void testCase_16(){
		List<Object> ls = mayBayRepository.findMayBayDuocLai();
		Gson gson = new Gson();
		System.out.println("TEST 16: Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.");
		for(Object o : ls) {
			System.out.println(gson.toJson(o).toString());
		}
	}

}
