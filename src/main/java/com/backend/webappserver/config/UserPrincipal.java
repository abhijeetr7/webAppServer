package com.backend.webappserver.config;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.backend.webappserver.data.model.Tbresource;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails {
    private Integer id;
    private String name;
    private String username;
    private String companyCode;
    private String email;
    private String password;
    private String companyaddress;
    private String firstName;
    private String lastName;
    private String mainmenulabel;
    private String token;
    private String dbName;
    private String message;
    private String status;
    private String fullname;
    private String companyName;
    private String fullnamefortoggal;
    private Character cancreateproject;
    private Character isreporting;
    private String telephone1;
    private String accesstype;
    private boolean productcompulsory;
    private boolean productflag;
    private Integer usergroupid;
    private String landingpage;
    private String resourceName;
    private String mobile;
    private String designation;
    private String employeecode;
    private Integer reportingmanager;
    private String band;
    private String department;
    private Integer useridmenu;
    private Character reshead;
    private boolean chkselect;
	private boolean add;
	private boolean edit;
	private boolean delete;
	private boolean view;
	private boolean approve;
	private boolean microbe;

    public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Integer id, String name, String username, String email, String password, String companyCode) {
	this.id = id;
	this.name = name;
	this.username = username;
	this.email = email;
	this.password = password;
	this.companyCode = companyCode;

    }

    /**
     * 
     */
    public UserPrincipal() {
	// TODO Auto-generated constructor stub
    }

    public static UserPrincipal create(Tbresource user, String companyCode2) {

	return new UserPrincipal(user.getResourceID(), user.getName(), user.getLoginName(), user.getEmail(),
		user.getPassword(), companyCode2);
    }

    public Integer getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getCompanyCode() {
	return companyCode;
    }

    public String getEmail() {
	return email;
    }

    @Override
    public String getUsername() {
	return username;
    }

    @Override
    public String getPassword() {
	return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getMainmenulabel() {
	return mainmenulabel;
    }

    public void setMainmenulabel(String mainmenulabel) {
	this.mainmenulabel = mainmenulabel;
    }

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public String getDbName() {
	return dbName;
    }

    public void setDbName(String dbName) {
	this.dbName = dbName;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public void setCompanyCode(String companyCode) {
	this.companyCode = companyCode;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	UserPrincipal that = (UserPrincipal) o;
	return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

	return Objects.hash(id);
    }

    public String getCompanyName() {
	return companyName;
    }

    public void setCompanyName(String companyName) {
	this.companyName = companyName;
    }

    public String getFullname() {
	return fullname;
    }

    public void setFullname(String fullname) {
	this.fullname = fullname;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

	public String getAccesstype() {
		return accesstype;
	}

	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}

	public boolean isProductcompulsory() {
		return productcompulsory;
	}

	public void setProductcompulsory(boolean productcompulsory) {
		this.productcompulsory = productcompulsory;
	}

	public boolean isProductflag() {
		return productflag;
	}

	public void setProductflag(boolean productflag) {
		this.productflag = productflag;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public Integer getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(Integer usergroupid) {
		this.usergroupid = usergroupid;
	}

	public String getLandingpage() {
		return landingpage;
	}

	public void setLandingpage(String landingpage) {
		this.landingpage = landingpage;
	}


	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;

	}

	public String getFullnamefortoggal() {
		return fullnamefortoggal;
	}

	public void setFullnamefortoggal(String fullnamefortoggal) {
		this.fullnamefortoggal = fullnamefortoggal;
	}

	public Character getCancreateproject() {
		return cancreateproject;
	}

	public void setCancreateproject(Character cancreateproject) {
		this.cancreateproject = cancreateproject;
	}

	public Character getIsreporting() {
		return isreporting;
	}

	public void setIsreporting(Character isreporting) {
		this.isreporting = isreporting;
	}

	public Integer getReportingmanager() {
		return reportingmanager;
	}

	public void setReportingmanager(Integer reportingmanager) {
		this.reportingmanager = reportingmanager;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getUseridmenu() {
		return useridmenu;
	}

	public void setUseridmenu(Integer useridmenu) {
		this.useridmenu = useridmenu;
	}

	public Character getReshead() {
		return reshead;
	}

	public void setReshead(Character reshead) {
		this.reshead = reshead;
	}

	public boolean isChkselect() {
		return chkselect;
	}

	public void setChkselect(boolean chkselect) {
		this.chkselect = chkselect;
	}

	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}

	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	public boolean isMicrobe() {
		return microbe;
	}

	public void setMicrobe(boolean microbe) {
		this.microbe = microbe;
	}

	



	

}
