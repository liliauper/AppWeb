package ar.org.centro8.curso.java.web.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.java.entities.Cliente;
import ar.org.centro8.java.web.enums.TipoDocumento;
import ar.org.centro8.java.web.repositories.jdbc.ClienteRepository;

/**
 *
 * @author lilia
 */
public class TestClienteRepository {

    public static void main(String[] args) {
        I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
        cr.save(new Cliente("Jorge", "Gordon", 36, "Venesuela 20", "gomez@mail", "222222", TipoDocumento.DNI, 88888888));
        cr.save(new Cliente("Juan", "Gomez", 26, "Rivadavia 133", "perez@mail", "33333333", TipoDocumento.DNI, 88999999));
        cr.save(new Cliente("Sergio", "Lopez", 35, "Rioja", "perez@mail", "33333322", TipoDocumento.DNI, 8899922));
        cr.save(null);
        cr.remove(cr.getById(3));

        Cliente cliente = cr.getById(2);
        if (cliente != null && cliente.getId() != 0) {
            cliente.setTelefono("11111111");
            cr.update(cliente);
        }
        System.out.println("****Lista de todos los clientes****");
        cr.getAll().forEach(System.out::println);
        System.out.println("****Lista de clientes con apellido 'Go...'****");
        cr.getLikeApellido("Go").forEach(System.out::println);
    }

}
