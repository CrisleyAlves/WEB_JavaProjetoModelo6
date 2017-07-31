
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Crisley Alves
 * @email crisleyalvesphx@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@ManagedBean(name = "controlePessoa")
@SessionScoped
public class ControlePessoa implements Serializable {
    
    private PessoaDAO<Pessoa> dao;
    private Pessoa objeto;
    
    public ControlePessoa(){
        dao = new PessoaDAO<>();
    }
    
    public String listar(){
        return "/privado/pessoa/listar?faces-redirect=true";
    }
    
    public String novo(){
        setObjeto(new Pessoa());
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

    public PessoaDAO<Pessoa> getDao() {
        return dao;
    }

    public void setDao(PessoaDAO<Pessoa> dao) {
        this.dao = dao;
    }

    public Pessoa getObjeto() {
        return objeto;
    }

    public void setObjeto(Pessoa objeto) {
        this.objeto = objeto;
    }

}
