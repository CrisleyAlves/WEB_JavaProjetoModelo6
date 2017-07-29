
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CorretorDAO;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@ManagedBean(name = "controleCorretor")
@SessionScoped
public class ControleCorretor implements Serializable {
    
    private CorretorDAO<Corretor> dao;
    private Corretor objeto;
    
    public ControleCorretor(){
        dao = new CorretorDAO<>();
    }
    
    public String listar(){
        return "/privado/corretor/listar?faces-redirect=true";
    }
    
    public String novo(){
        setObjeto(new Corretor());
        return "formulario";
    }
    
    public String salvar(){
        boolean persistiu;
        if (getObjeto().getId() == null){
            persistiu = getDao().persist(getObjeto());
        } else {
            persistiu = getDao().merge(getObjeto());
        }
        if (persistiu){
            Util.mensagemInformacao(getDao().getMensagem());
            return "listar";
        } else {
            Util.mensagemErro(getDao().getMensagem());
            return "formulario";
        }
    }
    
    public String cancelar(){
        return "listar";
    }
    
    public String editar(Integer id){
        try {
            setObjeto(getDao().localizar(id));
            return "formulario";
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+Util.getMensagemErro(e));
            return "listar";
        }
    }
    
    public void remover(Integer id){
        setObjeto(getDao().localizar(id));
        if (getDao().remover(getObjeto())){
            Util.mensagemInformacao(getDao().getMensagem());
        } else {
            Util.mensagemErro(getDao().getMensagem());
        }
    }

    public CorretorDAO<Corretor> getDao() {
        return dao;
    }

    public void setDao(CorretorDAO<Corretor> dao) {
        this.dao = dao;
    }

    public Corretor getObjeto() {
        return objeto;
    }

    public void setObjeto(Corretor objeto) {
        this.objeto = objeto;
    }
    
    
    

}
