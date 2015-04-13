package atividade05_maykondeykon.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author maykon
 */
public class AbstractDAO 
{
    protected Connection conn;
    protected PreparedStatement stmt;
    protected ResultSet rs;
    
    protected void getConnection()
    {
        try {
            ConnectionPool database = new ConnectionPool();
            Connection connection = database.getConnection();
            this.conn = connection;
        } catch (Exception e) {
            System.out.println("erro: "+e.getMessage());
        }
        
    }
    
    protected void closeConnection()
    {
        try {
            if(this.rs != null){
                this.rs.close();
            }
            if(this.stmt != null){
                this.stmt.close();
            }
            if(this.conn != null){
                this.conn.close();
            }
            
        } catch (Exception e) {
            System.out.println("erro: "+ e.getMessage());
        }
        
    }
    
    protected void getStatement(String sql)
    {
        try {
            this.stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
        }
    }

}
