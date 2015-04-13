package atividade05_maykondeykon;

import atividade05_maykondeykon.models.Recado;
import java.util.List;
import atividade05_maykondeykon.services.RecadoDAO;

/**
 *
 * @author maykon
 */
public class Main
{

    public static void main(String[] args)
    {
        insertTeste();
        findAllTeste();
//        findTeste(6);
//        deleteTeste(6);

    }

    static void insertTeste()
    {
        Recado recado = new Recado();
        recado.setDestinatario("Maykon");
        recado.setRemetente("Deykon");
        recado.setMensagem("teste");

        RecadoDAO dao = new RecadoDAO();
        recado = dao.insert(recado);
        System.out.println("Recado inserido: "+recado.toString());

    }

    static void findTeste(Integer id)
    {
        RecadoDAO dao = new RecadoDAO();
        Recado recado = dao.find(id);
        System.out.println(recado.toString());
    }

    static void findAllTeste()
    {
        RecadoDAO dao = new RecadoDAO();
        List<Recado> recados = dao.findAll();

        for (Recado recado : recados) {
            System.out.println(recado.toString());
        }
    }
    
    static void deleteTeste(Integer id)
    {
        RecadoDAO dao = new RecadoDAO();
        Integer result = dao.delete(id);
        System.out.println(result);
    }

}
