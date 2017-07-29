
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class PessoaDAO<T> extends DAOGenerico<Pessoa> implements Serializable {
    
    public PessoaDAO(){
        super();
        super.setClassePersistente(Pessoa.class);       
    }
   
}
