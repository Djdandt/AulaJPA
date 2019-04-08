package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
//		Pessoa p1 = new Pessoa(null, "Carlos", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null, "João", "joao@gmail.com");
//		Pessoa p3 = new Pessoa(null, "Danilo", "danilo@gmail.com");
		
		//Deve ser o mesmo valor do persistence unit no persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Procura no banco de dados com os parametros informados
		//Pessoa p = em.find(Pessoa.class, 2);
		
		//System.out.println(p);
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		//Sempre que for uma alteração que não seja uma consulta precisa ter o transaction
		em.getTransaction().begin();
		//Deleta do banco de dados com os parametros informados, mas apenas se o objeto for monitorado
		em.remove(p);
		
		em.getTransaction().commit();
		
		//Inicia uma transação com o banco de dados
		em.getTransaction().begin();
		
		//Adiciona o p1 ao banco de dados
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
		
		//Confirma as alterações
		em.getTransaction().commit();
		//Fecha o EntityManager e o EntityManagerFactory
		em.close();
		emf.close();
	}

}
