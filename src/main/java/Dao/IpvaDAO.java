package Dao;

import entidadesCarros.Carro;

public class IpvaDAO {
	private Integer id;
	private Integer ano;
	private Integer comIPVA = 0;
	private Integer semIPVA = 0;
	private Integer cont = 0;
	
	
	public IpvaDAO() {
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


	public void addUser(Carro user) {
		// TODO Auto-generated method stub
		
	}


	public Object getListUser() {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer buscarUser(Integer id1) {
		// TODO Auto-generated method stub
		this.cont++;
		if(ano <= this.ano) {
			return this.semIPVA++;
		} else {
			return this.comIPVA++;
		}
	}
	
	
	public void updateUser(Carro user1) {
		// TODO Auto-generated method stub
		
	}


	
	
}


