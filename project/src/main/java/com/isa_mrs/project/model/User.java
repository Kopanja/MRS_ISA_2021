package com.isa_mrs.project.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




@Entity
@Table(name="USER")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="EMAIL", length = 50, unique=true)
	private String email;
	
	@Column(name="PASSWORD", unique=false)
	private String password;
	
	 @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
		private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();

	public User() {
		super();
	}

	

	public User(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	
	}

	

	public User(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public Set<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}



	public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}




	@Override
	public String getUsername() {
		return email;
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



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = 
				this.getUserAuthorities().
				stream()
	            .map(authority -> new SimpleGrantedAuthority(
	            	authority.getAuthority().getName()))
	            .collect(Collectors.toList());
		return grantedAuthorities;
	}



	public Date getLastPasswordResetDate() {
		return null;
	}






	
	
	
	
}
