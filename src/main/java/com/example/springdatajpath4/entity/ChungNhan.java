package com.example.springdatajpath4.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chungnhan")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ChungNhanPK.class)
public class ChungNhan {
	@Id
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "mamb",
	foreignKey = @ForeignKey(name = "ChuyenBay_ID_FK"))
	private ChuyenBay maMB;
	@Id
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "manv",
			foreignKey = @ForeignKey(name = "NhanVien_ID_FK"), columnDefinition = "varchar(9)")
	private NhanVien maNV;
	
}
