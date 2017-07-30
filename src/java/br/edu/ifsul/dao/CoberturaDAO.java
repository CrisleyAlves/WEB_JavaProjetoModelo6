
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cobertura;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class CoberturaDAO<T> extends DAOGenerico<Cobertura> implements Serializable {
    
    public CoberturaDAO(){
        super();
        super.setClassePersistente(Cobertura.class);       
    }
   
}
