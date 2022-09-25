package com.example.springdatajpath4.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "chuyenbay")
public class ChuyenBay {
	@Id
	@GeneratedValue
	@Column(columnDefinition = "varchar(5)", nullable = false)
	private String maCb;
	private String gaDi;
	private String gaDen;
	private int doDai;
	@Column(columnDefinition = "time")
	private Date gioDi;
	@Column(columnDefinition = "time")
	private Date gioDen;
	private int chiPhi;

}
