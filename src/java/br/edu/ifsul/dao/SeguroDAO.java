
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Seguro;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class SeguroDAO<T> extends DAOGenerico<Seguro> implements Serializable {
    
    public SeguroDAO(){
        super();
        super.setClassePersistente(Seguro.class);       
    }
   
}
