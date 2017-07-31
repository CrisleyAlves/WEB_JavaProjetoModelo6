package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.dao.CoberturaDAO;
import br.edu.ifsul.dao.CorretorDAO;
import br.edu.ifsul.dao.SeguroDAO;
import br.edu.ifsul.dao.SinistroDAO;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.util.Util;
import br.ifsul.edu.modelo.Sinistro;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Crisley Alves
 * @email crisleyalvesphx@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@ManagedBean(name = "controleSeguro")
@SessionScoped
public class ControleSeguro implements Serializable{
    
    private SeguroDAO<SeguroDAO> dao;
    private Seguro objeto;
    
    private CarroDAO<Carro> daoCarro;
    private CorretorDAO<Corretor> daoCorretor;
    
    private Boolean novoDado;
    private Cobertura cobertura;
    private CoberturaDAO<Cobertura> daoCobertura;
    
    private Boolean novoDado2;
    private Sinistro sinistro;
    private SinistroDAO<Sinistro> daoSinistro;
    
    public ControleSeguro(){
        dao = new SeguroDAO<>();
        daoCarro = new CarroDAO<>();
        daoCorretor = new CorretorDAO<>();
        daoCobertura = new CoberturaDAO<>();
        daoSinistro = new SinistroDAO<>();
    }
    
    public void adicionarCobertura(){
        if(getCobertura() != null){
                getCobertura().setSeguro(getObjeto());
                getObjeto().getListaCoberturas().add(getCobertura());
                Util.mensagemInformacao("Cobertura adicionado com sucesso");
        }else{
            System.out.println("Caiu aqui");
        }
    }
    
     public void novaCobertura(){
        setCobertura(new Cobertura());
        System.out.println("nova cobertura instanciada");
        novoDado = true;
    }
    
    public void alterarCobertura(int index){
        setCobertura(getObjeto().getListaCoberturas().get(index));
        getObjeto().removerCobertura(index);
        novoDado = false;
    }
    
    public void removerCobertura(int index){
        getObjeto().getListaCoberturas().remove(index);
        Util.mensagemInformacao("A cobertura foi removido com sucesso");
    }
    
    public String listar(){
        return "/privado/seguro/listar?faces-redirect=true";
    }
    
    public String novo(){
        setObjeto(new Seguro());
        return "formulario";
    }
    
    public String salvar(){
        boolean persistiu;
        
        if(getObjeto().getId() == null){
            persistiu = getDao().persist(getObjeto());
        }else{
            persistiu = getDao().merge(getObjeto());
        }
        
        if(persistiu){
            Util.mensagemInformacao(getDao().getMensagem());
            return "listar";
        }else{
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
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+Util.getMensagemErro(e));
            return "listar";
        }
    }
    
    public void remover(Integer id){
        setObjeto(getDao().localizar(id));
        if(getDao().remover(getObjeto())){
            Util.mensagemInformacao(getDao().getMensagem());
        }else{
            Util.mensagemErro(getDao().getMensagem());
        }
    }

    public Boolean getNovoDado() {
        return novoDado;
    }

    public void setNovoDado(Boolean novoDado) {
        this.novoDado = novoDado;
    }

    public SeguroDAO<SeguroDAO> getDao() {
        return dao;
    }

    public void setDao(SeguroDAO<SeguroDAO> dao) {
        this.dao = dao;
    }

    public Seguro getObjeto() {
        return objeto;
    }

    public void setObjeto(Seguro objeto) {
        this.objeto = objeto;
    }

    public CarroDAO<Carro> getDaoCarro() {
        return daoCarro;
    }

    public void setDaoCarro(CarroDAO<Carro> daoCarro) {
        this.daoCarro = daoCarro;
    }

    public CorretorDAO<Corretor> getDaoCorretor() {
        return daoCorretor;
    }

    public void setDaoCorretor(CorretorDAO<Corretor> daoCorretor) {
        this.daoCorretor = daoCorretor;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    public CoberturaDAO<Cobertura> getDaoCobertura() {
        return daoCobertura;
    }

    public void setDaoCobertura(CoberturaDAO<Cobertura> daoCobertura) {
        this.daoCobertura = daoCobertura;
    }
    
    
    
    
    
    
    
    public void adicionarSinistro(){
        if(getSinistro()!= null){
                getSinistro().setSeguro(getObjeto());
                getObjeto().getListaSinistro().add(getSinistro());
                Util.mensagemInformacao("Sinistro adicionado com sucesso");
        }else{
            System.out.println("Caiu aqui");
        }
    }
    
     public void novaSinistro(){
        setSinistro(new Sinistro());
        System.out.println("novo sinistro instanciada");
        setNovoDado2((Boolean) true);
    }
    
    public void alterarSinistro(int index){
        setSinistro(getObjeto().getListaSinistro().get(index));
        getObjeto().removerSinistro(index);
        setNovoDado2((Boolean) false);
    }
    
    public void removerSinistro(int index){
        getObjeto().getListaSinistro().remove(index);
        Util.mensagemInformacao("O sinistro foi removido com sucesso");
    }

    public Boolean getNovoDado2() {
        return novoDado2;
    }

    public void setNovoDado2(Boolean novoDado2) {
        this.novoDado2 = novoDado2;
    }

    public Sinistro getSinistro() {
        return sinistro;
    }

    public void setSinistro(Sinistro sinistro) {
        this.sinistro = sinistro;
    }

    public SinistroDAO<Sinistro> getDaoSinistro() {
        return daoSinistro;
    }

    public void setDaoSinistro(SinistroDAO<Sinistro> daoSinistro) {
        this.daoSinistro = daoSinistro;
    }
    
}
