package com.comunidad.SwingSpringMysql.login.service;

import com.comunidad.SwingSpringMysql.login.dao.vo.LoginVo;

public interface LoginService {
	int existeLogin(LoginVo loginVo) throws Exception;
}
