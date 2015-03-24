package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.ExploracionFisica;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ExploracionFisicaRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(ExploracionFisica exploracion) {
		this.entityManager.persist(exploracion);
	}
	
	@Transactional
	public void update(ExploracionFisica exploracion) {
		this.entityManager.merge(exploracion);
	}
	
	@Transactional
	public void delete(ExploracionFisica exploracion) {
		this.entityManager.remove(exploracion);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM ExploracionFisica e WHERE e.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	
	public ExploracionFisica get(Long id) {
		return this.entityManager.createQuery(
				"SELECT e FROM ExploracionFisica e WHERE e.id = :id", ExploracionFisica.class
				).setParameter("id", id).getSingleResult();
	}
	
	public boolean pacienteHasExploracion(Long idPaciente) {
		return !(this.entityManager.createQuery(
				"SELECT e FROM ExploracionFisica e WHERE e.paciente = :idPaciente", ExploracionFisica.class
				).setParameter("idPaciente", idPaciente).getResultList().isEmpty());
	}
	
	public List<ExploracionFisica> selectAllFromPaciente(Long idPaciente) {
		return this.entityManager.createQuery(
				"SELECT a FROM ExploracionFisica a WHERE a.paciente = :idPaciente", ExploracionFisica.class
				).setParameter("idPaciente", idPaciente).getResultList();
	}
	
	public List<ExploracionFisica> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM ExploracionFisica e " + where, ExploracionFisica.class
				).getResultList();
	}
	
	public List<ExploracionFisica> selectAll() {
		return this.entityManager.createQuery(
				"SELECT a FROM ExploracionFisica a", ExploracionFisica.class
				).getResultList();
	}
}
