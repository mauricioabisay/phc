package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.Ejercicio;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EjercicioRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(Ejercicio ejercicio) {
		this.entityManager.persist(ejercicio);
	}
	
	@Transactional
	public void update(Ejercicio ejercicio) {
		this.entityManager.merge(ejercicio);
	}
	
	@Transactional
	public void delete(Ejercicio ejercicio) {
		this.entityManager.remove(ejercicio);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM Ejercicio a WHERE a.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	
	public Ejercicio get(Long id) {
		return this.entityManager.createQuery(
				"SELECT a FROM Ejercicio a WHERE a.id = :id", Ejercicio.class
				).setParameter("id", id).getSingleResult();
	}
	
	public List<Ejercicio> selectAllFromPaciente(Long idPaciente) {
		return this.entityManager.createQuery(
				"SELECT a FROM Ejercicio a WHERE a.paciente = :idPaciente", Ejercicio.class
				).setParameter("idPaciente", idPaciente).getResultList();
	}
	
	public List<Ejercicio> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM Ejercicio e " + where, Ejercicio.class
				).getResultList();
	}
	
	public List<Ejercicio> selectAll() {
		return this.entityManager.createQuery(
				"SELECT a FROM Ejercicio a", Ejercicio.class
				).getResultList();
	}
}
