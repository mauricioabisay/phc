package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.AntecedentePersonal;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AntecedentePersonalRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(AntecedentePersonal antecedente) {
		this.entityManager.persist(antecedente);
	}
	
	@Transactional
	public void update(AntecedentePersonal antecedente) {
		this.entityManager.merge(antecedente);
	}
	
	@Transactional
	public void delete(AntecedentePersonal antecedente) {
		this.entityManager.remove(antecedente);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM AntecedentePersonal a WHERE a.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	
	public AntecedentePersonal get(Long id) {
		return this.entityManager.createQuery(
				"SELECT a FROM AntecedentePersonal a WHERE a.id = :id", AntecedentePersonal.class
				).setParameter("id", id).getSingleResult();
	}
	
	public boolean pacienteHasAntecedente(Long idPaciente) {
		return !(this.entityManager.createQuery(
				"SELECT a FROM AntecedentePersonal a WHERE a.paciente = :idPaciente", AntecedentePersonal.class
				).setParameter("idPaciente", idPaciente).getResultList().isEmpty());
	}
	
	public List<AntecedentePersonal> selectAllFromPaciente(Long idPaciente) {
		return this.entityManager.createQuery(
				"SELECT a FROM AntecedentePersonal a WHERE a.paciente = :idPaciente", AntecedentePersonal.class
				).setParameter("idPaciente", idPaciente).getResultList();
	}
	
	public List<AntecedentePersonal> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM AntecedentePersonal e " + where, AntecedentePersonal.class
				).getResultList();
	}
	
	public List<AntecedentePersonal> selectAll() {
		return this.entityManager.createQuery(
				"SELECT a FROM AntecedentePersonal a", AntecedentePersonal.class
				).getResultList();
	}
}
