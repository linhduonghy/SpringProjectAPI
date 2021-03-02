package com.iu.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CompanyServiceId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int company;
	
	private int service;
	
	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CompanyServiceId that = (CompanyServiceId) o;
        return Objects.equals(company, that.company) && Objects.equals(service, that.service);
    }
    @Override
    public int hashCode() {
        return Objects.hash(company, service);
    }
}
