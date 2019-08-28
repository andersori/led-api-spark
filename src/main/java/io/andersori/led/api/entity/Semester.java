package io.andersori.led.api.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

@Embeddable
public class Semester {

    @Column(name = "year", nullable = false)
    @Min(1954) @NotNull
    private Integer year;

    @Column(name = "number_semester", nullable = false)
    @Min(1) @Max(2) @NotNull
    private Integer numberSemester;

    public Semester() {

    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumberSemester() {
		return numberSemester;
	}

	public void setNumberSemester(Integer numberSemester) {
		this.numberSemester = numberSemester;
    }
    
    @Override
	public boolean equals(Object obj) {
		return this.year == ((Semester) obj).getYear() && this.numberSemester == ((Semester) obj).getNumberSemester() ? true : false;
	}
}