package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.Alergia;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlergiaRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(Alergia alergia) {
		this.entityManager.persist(alergia);
	}
	
	@Transactional
	public void update(Alergia alergia) {
		this.entityManager.merge(alergia);
	}
	
	@Transactional
	public void delete(Alergia alergia) {
		this.entityManager.remove(alergia);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM Alergia e WHERE e.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	@Transactional
	public void deleteAllFromPaciente(Long idPaciente) {
		this.entityManager.createQuery(
				"DELETE FROM Alergia a WHERE a.paciente = :idPaciente"
				).setParameter("idPaciente", idPaciente).executeUpdate();
	}
	
	public Alergia get(Long id) {
		return this.entityManager.createQuery(
				"SELECT e FROM Alergia e WHERE e.id = :id", Alergia.class
				).setParameter("id", id).getSingleResult();
	}
	
	public boolean pacienteHasAlergia(Long idPaciente) {
		return !(this.entityManager.createQuery(
				"SELECT e FROM Alergia e WHERE e.paciente = :idPaciente", Alergia.class
				).setParameter("idPaciente", idPaciente).getResultList().isEmpty());
	}
	
	public List<Alergia> selectAllFromPaciente(Long idPaciente) {
		return this.entityManager.createQuery(
				"SELECT a FROM Alergia a WHERE a.paciente = :idPaciente", Alergia.class
				).setParameter("idPaciente", idPaciente).getResultList();
	}
	
	public List<Alergia> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM Alergia e " + where, Alergia.class
				).getResultList();
	}
	
	public List<Alergia> selectAll() {
		return this.entityManager.createQuery(
				"SELECT a FROM Alergia a", Alergia.class
				).getResultList();
	}
}
