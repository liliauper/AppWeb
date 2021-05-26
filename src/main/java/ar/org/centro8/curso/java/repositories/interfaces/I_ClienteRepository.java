
package ar.org.centro8.curso.java.repositories.interfaces;

import ar.org.centro8.java.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author lilia
 */
public interface I_ClienteRepository {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente>getAll();
    default Cliente getById(int id){
        return getAll()
                .stream()
                .filter(a->a.getId()==id)
                .findAny()
                .orElse(new Cliente());
    }
    default Cliente getByNumeroDocumento(int numeroDocumento){
        return getAll()
                .stream()
                .filter(a->a.getNumeroDocumento()==numeroDocumento)
                .findAny()
                .orElse(new Cliente());
    }
    default List<Cliente>getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList<Cliente>();
        return getAll()
                .stream()
                .filter(a->a!=null && a.getApellido()!=null &&
                        a.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
    
}
