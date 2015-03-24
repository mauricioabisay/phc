package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.Interrogatorio;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InterrogatorioRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(Interrogatorio entity) {
		this.entityManager.persist(entity);
	}
	
	@Transactional
	public void update(Interrogatorio entity) {
		this.entityManager.merge(entity);
	}
	
	@Transactional
	public void delete(Interrogatorio entity) {
		this.entityManager.remove(entity);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM Interrogatorio i WHERE i.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	public Interrogatorio get(Long id) {
		return this.entityManager.createQuery(
				"SELECT i FROM Interrogatorio i WHERE i.id = :id", Interrogatorio.class
				).setParameter("id", id).getSingleResult();
	}
	
	public List<Interrogatorio> selectAllFromPaciente(Long id) {
		return this.entityManager.createQuery(
				"SELECT i FROM Interrogatorio i WHERE i.paciente = :idPaciente", Interrogatorio.class
				).setParameter("idPaciente", id).getResultList();
	}

	public List<Interrogatorio> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM Interrogatorio e " + where, Interrogatorio.class
				).getResultList();
	}

	public List<Interrogatorio> selectAll() {
		return this.entityManager.createQuery(
				"SELECT e FROM Interrogatorio e", Interrogatorio.class
				).getResultList();
	}

}
