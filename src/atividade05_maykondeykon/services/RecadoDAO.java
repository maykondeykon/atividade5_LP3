package atividade05_maykondeykon.services;

import atividade05_maykondeykon.models.Recado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maykon
 */
public class RecadoDAO extends AbstractDAO
{

    public Recado insert(Recado recado)
    {
        this.getConnection();
        this.getStatement("insert into recados(remetente, destinatario, mensagem, data) values(?, ?, ?, ?)");
        try {
            this.stmt.setString(1, recado.getRemetente());
            this.stmt.setString(2, recado.getDestinatario());
            this.stmt.setString(3, recado.getMensagem());
            this.stmt.setDate(4, recado.getData());
            this.stmt.execute();

            this.rs = this.stmt.getGeneratedKeys();
            if (this.rs.next()) {
                int id = this.rs.getInt(1);
                recado.setId(id);
            }

        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
        }
        this.closeConnection();
        return recado;
    }

    public List<Recado> findAll()
    {
        this.getConnection();
        List<Recado> recados = new ArrayList<>();
        this.getStatement("select * from recados");
        try {
            this.rs = this.stmt.executeQuery();

            while (this.rs.next()) {
                Recado recado = this.hidrate();
                recados.add(recado);
            }

        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
        }

        this.closeConnection();
        return recados;
    }

    public Recado find(Integer id)
    {
        this.getConnection();
        Recado recado = new Recado();
        this.getStatement("select * from recados where id = ?");
        
        try {
            this.stmt.setInt(1, id);
            this.rs = this.stmt.executeQuery();
            while (this.rs.next()) {
                recado = this.hidrate();
            }
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
        }
        
        this.closeConnection();
        return recado;
    }
    
    public Integer delete(Integer id)
    {
        this.getConnection();
        Integer result = 0;
        this.getStatement("delete from recados where id = ?");
        
        try {
            this.stmt.setInt(1, id);
            this.stmt.executeUpdate();
            
            result = 1;
            
        } catch (SQLException e) {
            System.out.println("erro: " + e.getMessage());
        }
        
        this.closeConnection();
        return result;
    }
    
    private Recado hidrate() throws SQLException
    {
        Recado recado = new Recado();
        recado.setId(this.rs.getInt("id"));
        recado.setData(rs.getDate("data"));
        recado.setRemetente(this.rs.getString("remetente"));
        recado.setDestinatario(this.rs.getString("destinatario"));
        recado.setMensagem(this.rs.getString("mensagem"));
        
        return recado;
    }

}
