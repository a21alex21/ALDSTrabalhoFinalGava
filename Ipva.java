package entidadesCarros;

public class Ipva {
	private Integer id;
	private Integer ano;
	private Integer comIPVA = 0;
	private Integer semIPVA = 0;
	private Integer cont = 0;
	
	
	public Ipva() {
		super();

	}


	public Integer getId() {
		return id;
	}


	public Integer getAno() {
		return ano;
	}

	
	public Integer verificacao(Integer valor) {
		this.cont++;
		if(valor <= this.ano) {
			return this.semIPVA++;
		} else {
			return this.comIPVA++;
		}
	}
	
}
