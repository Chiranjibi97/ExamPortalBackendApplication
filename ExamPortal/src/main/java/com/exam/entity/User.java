package com.exam.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="EXAM_USER")
public class User implements UserDetails{

	@Id
	@GeneratedValue
	private int id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String password;
	@NonNull
	private Long phone;
	@NonNull
	private String userName;
	@NonNull
	private String profile;
	private boolean enabled;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<UsersRole> userRole=new HashSet<>(); 
	

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", phone=" + phone + ", userName=" + userName + ", profile=" + profile + ", enabled=" + enabled + "]";
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userRole.stream().map(role->new SimpleGrantedAuthority(role.getRole()
				.getRoll_name())).collect(Collectors.toSet());
	}


	@Override
	public String getUsername() {
		return userName;
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
	
}
