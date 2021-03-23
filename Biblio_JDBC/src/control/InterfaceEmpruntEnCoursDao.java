package control;

import java.sql.SQLException;
import java.util.List;

import dao.EmpruntEnCoursDb;
import domain.EmpruntEnCours;
import domain.Utilisateur;

public interface InterfaceEmpruntEnCoursDao {

	boolean insertEmpruntEnCours(EmpruntEnCours emprunt) throws SQLException;

	EmpruntEnCoursDb findByKey(int idExemplaire);

	List<EmpruntEnCoursDb> findByUtilisateur(Utilisateur u) throws SQLException;

	void removeEmpruntEnCours(int idExemplaire) throws SQLException;

}