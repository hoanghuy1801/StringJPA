package com.example.springdatajpath4.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "nhanvien")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class NhanVien {
	@Id
	@Column(columnDefinition = "varchar(9)")
	private String maNV;
	
	private String ten;
	private int luong;
	
//	@OneToMany(mappedBy = "nhanvien", cascade =CascadeType.ALL)
//	
//	@ToString.Exclude
//	private List<ChungNhan> chungNhans;
	
}
