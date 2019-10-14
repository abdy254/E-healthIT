package app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

abstract public class BaseDao extends NamedParameterJdbcDaoSupport{
	@Autowired
	public void setDatasource2(javax.sql.DataSource ds) {
		super.setDataSource(ds);
	}

}
