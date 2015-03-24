package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.mauricioabisay.phc.entities.Tratamiento;

@Repository
public class TratamientoRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(Tratamiento entity) {
		this.entityManager.persist(entity);
	}
	
	@Transactional
	public void update(Tratamiento entity) {
		this.entityManager.merge(entity);
	}
	
	@Transactional
	public void delete(Tratamiento entity) {
		this.entityManager.remove(entity);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM Tratamiento t WHERE t.id_tratamiento = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	@Transactional
	public void deleteByPadecimiento(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM Tratamiento t WHERE t.padecimiento = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	public Tratamiento get(Long id) {
		return this.entityManager.createQuery(
				"SELECT t FROM Tratamiento t WHERE t.id = :id", Tratamiento.class
				).setParameter("id", id).getSingleResult();
	}
	
	public List<Tratamiento> selectAllFromPaciente(Long id) {
		return null;
	}
	
	public List<Tratamiento> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM Tratamiento e " + where, Tratamiento.class
				).getResultList();
	}

	public List<Tratamiento> selectAll() {
		return this.entityManager.createQuery(
				"SELECT t FROM Tratamiento t", Tratamiento.class
				).getResultList();
	}
	
	public List<Tratamiento> selectAllFromPadecimiento(Long id) {
		return this.entityManager.createQuery(
				"SELECT t FROM Tratamiento t WHERE t.padecimiento = :id", Tratamiento.class
				).setParameter("id", id).getResultList();
	}
}
