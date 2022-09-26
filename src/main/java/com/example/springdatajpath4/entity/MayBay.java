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

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maybay")
@Data
public class MayBay {
	@Id
	@GeneratedValue
	@Column(name = "mamb")
	private int maMB;
	private String loai;
	@Column(name = "tam_bay")
	private int tambay;
	
//	@OneToMany(mappedBy = "maybay", cascade =CascadeType.ALL)
//	private List<ChungNhan> chungNhans;
}
