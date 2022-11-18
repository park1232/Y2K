package com.world.Y2K.model.service.login.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.world.Y2K.model.vo.Member;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails{
	
	private Member member;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grantedAuthorityCollection = new ArrayList<GrantedAuthority>();
		
		grantedAuthorityCollection.add(
				new GrantedAuthority() {
					@Override
					public String getAuthority() {
						return member.getRole();
					}
				});
		return grantedAuthorityCollection;
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
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

}
