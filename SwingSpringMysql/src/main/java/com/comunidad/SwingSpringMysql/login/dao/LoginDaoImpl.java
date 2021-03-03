package com.comunidad.SwingSpringMysql.login.dao;

import java.util.ArrayList;
import java.util.List;

import com.comunidad.SwingSpringMysql.jdbc.JdbcDao;
import com.comunidad.SwingSpringMysql.login.dao.vo.LoginVo;

public class LoginDaoImpl extends JdbcDao implements LoginDao {

	private String existeLogin;

	@Override
	public int existeLogin(LoginVo loginVo) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("existeLogin...");
		}
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(loginVo.getUsername());
		parameters.add(loginVo.getPassword());
		Object[] args = parameters.toArray();
		return jdbcTemplate.queryForInt(existeLogin, args);
	}

	public void setExisteLogin(String existeLogin) {
		this.existeLogin = existeLogin;
	}

}
