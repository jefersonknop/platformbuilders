package knop.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import knop.entities.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {	
	
	List<Cliente> findAllByCpfAndNome (String cpf, String nome);
	
	
}
