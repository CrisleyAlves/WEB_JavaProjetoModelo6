
package br.edu.ifsul.dao;

import br.ifsul.edu.modelo.Sinistro;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class SinistroDAO<T> extends DAOGenerico<Sinistro> implements Serializable {
    
    public SinistroDAO(){
        super();
        super.setClassePersistente(Sinistro.class);       
    }
   
}
