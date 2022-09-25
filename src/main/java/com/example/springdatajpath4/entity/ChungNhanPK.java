package com.example.springdatajpath4.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ChungNhanPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maNV;
	private int maMB;
}
