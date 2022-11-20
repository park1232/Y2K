package com.world.Y2K.service.login.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

<<<<<<< HEAD
import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;
=======
@Service("service")
public class UserDetailsServiceImpl implements UserDetailsService{
>>>>>>> 34af81e1153239d0cc90e725123dd6f745288eec


public class UserDetailsServiceImpl  implements UserDetailsService{

//	private SqlSessionTemplate sqlSession;
	@Autowired
	private LoginDAO loginDAO;
	
	
	
//	@Inject
//	private SqlSessionTemplate sqlSession;


//	public UserDetailsServiceImpl() {
//		this.loginDAO = LoginDAO.getLoginDAO();
//	}
	
//	public UserDetailsServiceImpl(SqlSessionTemplate sqlSession) {
//		this.sqlSession = sqlSession;
//	}

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
<<<<<<< HEAD
		System.out.println(username);
		System.out.println(loginDAO);

		Member member = loginDAO.findUser(username);
		if(member == null) {
			return (UserDetails) new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(member);
=======
		System.out.println("�����");
		return null;
>>>>>>> 34af81e1153239d0cc90e725123dd6f745288eec
	}

}
