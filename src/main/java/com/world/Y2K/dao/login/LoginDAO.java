package com.world.Y2K.dao.login;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Member;

@Repository("loginDAO")
public class LoginDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int registerMember(Member member) {
		System.out.println(member);
		return sqlSession.insert("memberMapper.registerMember", member);
	}

	public Member findUser(String username) {
		return sqlSession.selectOne("memberMapper.findUser", username);
		
	}
	
	public int checkId(String username) {
		return sqlSession.selectOne("memberMapper.checkId", username);
	}
	
	public int updateNickname(HashMap<String, Object> map) {
		return sqlSession.update("memberMapper.updateNickname", map);
	}

	public int checkNickname(String nickname) {
		return sqlSession.selectOne("memberMapper.checkNickname", nickname);
	}

	public int updatePassword(HashMap<String, String> map) {
		return sqlSession.update("memberMapper.updatePassword", map);
		
	}

	public String searchIdFormEmail(String email) {
		return sqlSession.selectOne("memberMapper.searchIdFormEmail", email);
	}

	public int deleteMember(Long userNo) {
		return sqlSession.update("memberMapper.deleteMember", userNo);
		
	}
	
	public ArrayList<Member> getFriendsList(Long userNo){
		return (ArrayList)sqlSession.selectList("memberMapper.getFriendList", userNo);
	}
	

}
