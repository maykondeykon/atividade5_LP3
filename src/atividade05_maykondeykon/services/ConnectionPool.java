
package atividade05_maykondeykon.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author maykon
 */
public class ConnectionPool 
{
    private MysqlDataSource dataSource; 
	
	public ConnectionPool()
	{
		MysqlDataSource pool= new MysqlDataSource();
		pool.setUrl("jdbc:mysql://localhost/atividadesLp3");
		pool.setUser("root");
		pool.setPassword("");
		
		this.dataSource = (MysqlDataSource) pool;
	}
	
	public Connection getConnection() throws SQLException
	{
		Connection connection = (Connection) ((MysqlDataSource) dataSource).getConnection();
		return connection;
	}

}
