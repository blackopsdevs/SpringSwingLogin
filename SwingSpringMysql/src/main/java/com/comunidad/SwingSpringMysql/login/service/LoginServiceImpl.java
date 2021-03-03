package com.comunidad.SwingSpringMysql.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunidad.SwingSpringMysql.login.dao.LoginDaoImpl;
import com.comunidad.SwingSpringMysql.login.dao.vo.LoginVo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	protected LoginDaoImpl loginDaoImpl;

	@Override
	public int existeLogin(LoginVo loginVo) throws Exception {
		return loginDaoImpl.existeLogin(loginVo);
	}

}
