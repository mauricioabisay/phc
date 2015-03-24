package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.AntecedenteFamiliar;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AntecedenteFamiliarRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(AntecedenteFamiliar antecedente) {
		this.entityManager.persist(antecedente);
	}
	
	@Transactional
	public void update(AntecedenteFamiliar antecedente) {
		this.entityManager.merge(antecedente);
	}
	
	@Transactional
	public void delete(AntecedenteFamiliar antecedente) {
		this.entityManager.remove(antecedente);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM AntecedenteFamiliar a WHERE a.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	
	public AntecedenteFamiliar get(Long id) {
		return this.entityManager.createQuery(
				"SELECT a FROM AntecedenteFamiliar a WHERE a.id = :id", AntecedenteFamiliar.class
				).setParameter("id", id).getSingleResult();
	}
	
	public List<AntecedenteFamiliar> selectAllFromPaciente(Long idPaciente) {
		return this.entityManager.createQuery(
				"SELECT a FROM AntecedenteFamiliar a WHERE a.paciente = :idPaciente", AntecedenteFamiliar.class
				).setParameter("idPaciente", idPaciente).getResultList();
	}
	
	public List<AntecedenteFamiliar> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM AntecedenteFamiliar e " + where, AntecedenteFamiliar.class
				).getResultList();
	}
	
	public List<AntecedenteFamiliar> selectAll() {
		return this.entityManager.createQuery(
				"SELECT a FROM AntecedenteFamiliar a", AntecedenteFamiliar.class
				).getResultList();
	}
}
