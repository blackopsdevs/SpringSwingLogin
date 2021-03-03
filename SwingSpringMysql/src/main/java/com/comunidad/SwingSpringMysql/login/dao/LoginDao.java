package com.comunidad.SwingSpringMysql.login.dao;

import com.comunidad.SwingSpringMysql.login.dao.vo.LoginVo;

public interface LoginDao {
	int existeLogin(LoginVo loginVo) throws Exception;
}
