
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Corretor;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class CorretorDAO<T> extends DAOGenerico<Corretor> implements Serializable {
    
    public CorretorDAO(){
        super();
        super.setClassePersistente(Corretor.class);       
    }
   
}
