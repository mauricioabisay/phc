package mx.mauricioabisay.phc.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.mauricioabisay.phc.entities.Paciente;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PacienteRepository {
	@PersistenceContext EntityManager entityManager;
	
	
	@Transactional
	public void add(Paciente paciente) {
		this.entityManager.persist(paciente);
	}
	
	@Transactional
	public void update(Paciente paciente) {
		this.entityManager.merge(paciente);
	}
	
	@Transactional
	public void delete(Paciente paciente) {
		this.entityManager.remove(paciente);
	}
	
	@Transactional
	public void deleteById(Long id) {
		this.entityManager.createQuery(
				"DELETE FROM Paciente p WHERE p.id = :id"
				).setParameter("id", id).executeUpdate();
	}
	
	
	public Paciente get(Long id) {
		return this.entityManager.createQuery(
				"SELECT p FROM Paciente p WHERE p.id = :id", Paciente.class
				).setParameter("id", id).getSingleResult();
	}
	
	public List<Paciente> selectAll() {
		return this.entityManager.createQuery(
				"SELECT p FROM Paciente p", Paciente.class
				).getResultList();
	}
	
	public List<Paciente> selectAllWhere(String where) {
		return this.entityManager.createQuery(
				"SELECT e FROM Paciente e " + where , Paciente.class
				).getResultList();
	}
	
	public List<Paciente> selectAllFromPaciente(Long id){
		return this.selectAll();
	}
	
	public List<Paciente> search(String param) {
		return this.entityManager.createQuery(
				"SELECT p FROM Paciente p " + 
				"WHERE p.nombre LIKE '" + param + "%' " + 
				"OR p.apellidoPaterno LIKE '" + param + "%' " +
				"OR p.apellidoMaterno LIKE '" + param + "%' " , Paciente.class
				).getResultList();
	}
}
