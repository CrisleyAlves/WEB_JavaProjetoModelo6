
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@ManagedBean(name = "controleCarro")
@ViewScoped
public class ControleCarro implements Serializable {

    private CarroDAO<Carro> dao;
    private Carro objeto;
    private PessoaDAO<Pessoa> daoPessoa;
    
    public ControleCarro(){
        dao = new CarroDAO<>();
        daoPessoa = new PessoaDAO<>();
    }
    
    public String listar(){
        return "/privado/carro/listar?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new Carro());
    }
    
    public void salvar(){
        boolean persistiu;
        if (getObjeto().getId() == null){
            persistiu = getDao().persist(getObjeto());
        } else {
            persistiu = getDao().merge(getObjeto());
        }
        if (persistiu){
            Util.mensagemInformacao(getDao().getMensagem());
        } else {
            Util.mensagemErro(getDao().getMensagem());
        }
    }
    
    public void editar(Integer id){
        setObjeto(getDao().localizar(id));
    }
    
    public void remover(Integer id){
        setObjeto(getDao().localizar(id));
        if (getDao().remover(getObjeto())){
            Util.mensagemInformacao(getDao().getMensagem());
        } else {
            Util.mensagemErro(getDao().getMensagem());
        }
    }

    public CarroDAO<Carro> getDao() {
        return dao;
    }

    public void setDao(CarroDAO<Carro> dao) {
        this.dao = dao;
    }

    public Carro getObjeto() {
        return objeto;
    }

    public void setObjeto(Carro objeto) {
        this.objeto = objeto;
    }

    public PessoaDAO<Pessoa> getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDAO<Pessoa> daoPessoa) {
        this.daoPessoa = daoPessoa;
    }
    
    
    
}
