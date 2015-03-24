package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.Laboratorio;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LaboratorioRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(Laboratorio laboratorio) {
		this.entityManager.persist(laboratorio);
	}
	
	@Transactional
	public void update(Laboratorio laboratorio) {
		this.entityManager.merge(laboratorio);
	}
	
	@Transactional
	public void delete(Laboratorio laboratorio) {
		this.entityManager.remove(laboratorio);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM Laboratorio e WHERE e.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	@Transactional
	public void deleteAllFromPaciente(Long idPaciente) {
		this.entityManager.createQuery(
				"DELETE FROM Laboratorio a WHERE a.paciente = :idPaciente"
				).setParameter("idPaciente", idPaciente).executeUpdate();
	}
	
	public Laboratorio get(Long id) {
		return this.entityManager.createQuery(
				"SELECT e FROM Laboratorio e WHERE e.id = :id", Laboratorio.class
				).setParameter("id", id).getSingleResult();
	}
	
	public boolean pacienteHasLaboratorio(Long idPaciente) {
		return !(this.entityManager.createQuery(
				"SELECT e FROM Laboratorio e WHERE e.paciente = :idPaciente", Laboratorio.class
				).setParameter("idPaciente", idPaciente).getResultList().isEmpty());
	}
	
	public List<Laboratorio> selectAllFromPaciente(Long idPaciente) {
		return this.entityManager.createQuery(
				"SELECT a FROM Laboratorio a WHERE a.paciente = :idPaciente", Laboratorio.class
				).setParameter("idPaciente", idPaciente).getResultList();
	}
	
	public List<Laboratorio> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM Laboratorio e " + where, Laboratorio.class
				).getResultList();
	}
	
	public List<Laboratorio> selectAll() {
		return this.entityManager.createQuery(
				"SELECT a FROM Laboratorio a", Laboratorio.class
				).getResultList();
	}
}
