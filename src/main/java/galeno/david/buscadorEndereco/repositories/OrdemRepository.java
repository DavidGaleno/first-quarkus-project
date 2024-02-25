package galeno.david.buscadorEndereco.repositories;

import galeno.david.buscadorEndereco.Models.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdemRepository  implements PanacheRepository<Ordem>  {

}
