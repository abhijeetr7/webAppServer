package com.backend.webappserver.payload;

public class validator {

	public boolean mandatory;
	public boolean lessthncurrentdate;
	public boolean greatthncurrentdate;
	public boolean currentdate;
	public boolean booleanyes;
	public boolean booleanno;
	public boolean allownegative;
	public boolean allownegativeforfloat;
	public Integer maxlength;
	public Integer minlength;
	public String unittype;
	public Integer maxlength1;
	public Integer minlength1;
	public Integer decimalplaces;
	public Integer minforinteger;
	public Integer minforfloat;




	
	
	public boolean getMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	public Integer getMaxlength() {
		return maxlength;
	}
	public void setMaxlength(Integer maxlength) {
		this.maxlength = maxlength;
	}
	public Integer getMinlength() {
		return minlength;
	}
	public void setMinlength(Integer minlength) {
		this.minlength = minlength;
	}
	public String getUnittype() {
		return unittype;
	}
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}
	public boolean isLessthncurrentdate() {
		return lessthncurrentdate;
	}
	public void setLessthncurrentdate(boolean lessthncurrentdate) {
		this.lessthncurrentdate = lessthncurrentdate;
	}
	public boolean isGreatthncurrentdate() {
		return greatthncurrentdate;
	}
	public void setGreatthncurrentdate(boolean greatthncurrentdate) {
		this.greatthncurrentdate = greatthncurrentdate;
	}
	public boolean isCurrentdate() {
		return currentdate;
	}
	public void setCurrentdate(boolean currentdate) {
		this.currentdate = currentdate;
	}
	public boolean isBooleanyes() {
		return booleanyes;
	}
	public void setBooleanyes(boolean booleanyes) {
		this.booleanyes = booleanyes;
	}
	public boolean isBooleanno() {
		return booleanno;
	}
	public void setBooleanno(boolean booleanno) {
		this.booleanno = booleanno;
	}
	public boolean isAllownegative() {
		return allownegative;
	}
	public void setAllownegative(boolean allownegative) {
		this.allownegative = allownegative;
	}
	public boolean isAllownegativeforfloat() {
		return allownegativeforfloat;
	}
	public void setAllownegativeforfloat(boolean allownegativeforfloat) {
		this.allownegativeforfloat = allownegativeforfloat;
	}
	public Integer getMaxlength1() {
		return maxlength1;
	}
	public void setMaxlength1(Integer maxlength1) {
		this.maxlength1 = maxlength1;
	}
	public Integer getMinlength1() {
		return minlength1;
	}
	public void setMinlength1(Integer minlength1) {
		this.minlength1 = minlength1;
	}
	public Integer getDecimalplaces() {
		return decimalplaces;
	}
	public void setDecimalplaces(Integer decimalplaces) {
		this.decimalplaces = decimalplaces;
	}
	public Integer getMinforinteger() {
		return minforinteger;
	}
	public void setMinforinteger(Integer minforinteger) {
		this.minforinteger = minforinteger;
	}
	public Integer getMinforfloat() {
		return minforfloat;
	}
	public void setMinforfloat(Integer minforfloat) {
		this.minforfloat = minforfloat;
	}
	
	
	
}
