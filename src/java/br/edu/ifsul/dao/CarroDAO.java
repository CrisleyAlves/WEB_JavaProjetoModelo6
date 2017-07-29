
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Carro;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class CarroDAO<T> extends DAOGenerico<Carro> implements Serializable {
    
    public CarroDAO(){
        super();
        super.setClassePersistente(Carro.class);       
    }
   
}
