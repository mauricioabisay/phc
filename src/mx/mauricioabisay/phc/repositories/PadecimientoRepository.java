package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.Padecimiento;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PadecimientoRepository {
	@PersistenceContext EntityManager entityManager;
	
	@Transactional
	public void add(Padecimiento entity) {
		this.entityManager.persist(entity);
	}
	
	@Transactional
	public void update(Padecimiento entity) {
		this.entityManager.merge(entity);
	}
	
	@Transactional
	public void delete(Padecimiento entity) {
		this.entityManager.remove(entity);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM Padecimiento p WHERE p.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	public Padecimiento get(Long id) {
		return this.entityManager.createQuery(
				"SELECT p FROM Padecimiento p WHERE p.id = :id", Padecimiento.class
				).setParameter("id", id).getSingleResult();
	}
	
	public List<Padecimiento> selectAllFromPaciente(Long id) {
		return this.entityManager.createQuery(
				"SELECT p FROM Padecimiento p WHERE p.paciente = :idPaciente", Padecimiento.class
				).setParameter("idPaciente", id).getResultList();
	}

	public List<Padecimiento> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM Padecimiento e " + where, Padecimiento.class
				).getResultList();
	}

	public List<Padecimiento> selectAll() {
		return this.entityManager.createQuery(
				"SELECT e FROM Padecimiento e", Padecimiento.class
				).getResultList();
	}

}
