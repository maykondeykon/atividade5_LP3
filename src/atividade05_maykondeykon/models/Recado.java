package atividade05_maykondeykon.models;

import java.util.Calendar;
import java.sql.Date;


/**
 *
 * @author maykon
 */
public class Recado 
{
    private Integer id;
    private String remetente;
    private String destinatario;
    private String mensagem;
    private Date data;

    public Recado()
    {
        this.data = new Date(Calendar.getInstance().getTimeInMillis());
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getRemetente()
    {
        return remetente;
    }

    public void setRemetente(String remetente)
    {
        this.remetente = remetente;
    }

    public String getDestinatario()
    {
        return destinatario;
    }

    public void setDestinatario(String destinatario)
    {
        this.destinatario = destinatario;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }
    
    public String getdataFormatada()
    {
        Calendar c = Calendar.getInstance();
        c.setTime(this.data);
        return c.get(Calendar.DAY_OF_MONTH)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR);
    }
    
    @Override
    public String toString()
    {
        return "Remetente: "+this.remetente+"; Destinatário: "+this.destinatario+
                "; Mensagem: "+this.mensagem+"; Data: "+this.getdataFormatada();
        
    }
            
    
    

}
