package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd){
		Member member = memberDao.selectByEmail(email);
		if(member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd,  newPwd);
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao){	// setter를 통해서 의존 객체 주입 받음
		this.memberDao = memberDao;
	}
}
