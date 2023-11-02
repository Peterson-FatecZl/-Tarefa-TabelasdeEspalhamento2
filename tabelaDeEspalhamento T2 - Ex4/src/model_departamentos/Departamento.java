package model_departamentos;

public class Departamento {

	public String NomeDepartamento;
	public String Descricao;

	public Departamento() {
		super();
	}

	public Departamento(String nomeDepartamento, String descricao) {
		this.NomeDepartamento = nomeDepartamento;
		this.Descricao = descricao;
	}
	
	public String toString(){
		return "Departamento: "+NomeDepartamento+"\nDescrição: "+Descricao+"\n";	
	}

}
