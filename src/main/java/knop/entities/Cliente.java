package knop.entities;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Cliente{
	
	@Id
	@GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
	private Long id;	
    private String nome;	
	private String cpf;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Timestamp datanascimento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public Integer getIdade() {
		
		Calendar dataNasc = new GregorianCalendar();
		dataNasc.setTime(this.datanascimento);		
		Calendar dataAtual =Calendar.getInstance();
			
		
		int idade = dataAtual.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);		
		dataNasc.add(Calendar.YEAR, idade);
		if (dataAtual.before(dataNasc)) {
			idade--;
		}
		
		return idade;
	}


		
	

	
	public Timestamp getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Timestamp datanascimento) {
		this.datanascimento = datanascimento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}


