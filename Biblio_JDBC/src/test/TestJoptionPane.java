package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.EmpruntArchiveDao;
import dao.EmpruntEnCoursDao;
import dao.EmpruntEnCoursDb;
import dao.ExemplairesDao;
import dao.UtilisateursDao;
import domain.BiblioException;
import domain.EmpruntArchive;
import domain.EmpruntEnCours;
import domain.Exemplaire;
import domain.PingJdbc;
import domain.Utilisateur;

public class TestJoptionPane {
	
	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, NumberFormatException, BiblioException {
		System.out.println("bonsoir");
		PingJdbc pjdbc = new PingJdbc();
		pjdbc.getConnection("Biblio_JDBC\\bibliothecaire.properties");
		Integer choixFinal;
		do {
		String[] choix = {"Consulter un livre", "Consulter un utilisateur", "Emprunter un livre", "Disponibilité d'un exemplaire","Rendre un livre", "Emprunts en cours","Emprunts Archivés"};
		int option = JOptionPane.showOptionDialog(null, "Choisissez parmi les options suivantes", "Bibliothèque_JDBC", 0, JOptionPane.QUESTION_MESSAGE, null, choix, "Applicatif Bibliothèque");
		
		
		if(option == 0 ) {
			ExemplairesDao exemplaireJOption = new ExemplairesDao(pjdbc);
			String c = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'exemplaire (entre 1 et 8) : ","Consultation d'un exemplaire", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(exemplaireJOption.findByKey(Integer.parseInt(c)));
		} else if(option == 1) {
			UtilisateursDao utilisateurJOption = new UtilisateursDao(pjdbc);
			String d = JOptionPane.showInputDialog(null, "Entrez l'identifiant d'un utilisateur ( Employé = 2, 3 et 6 - Adhérent = 1, 4, 5, 7 et 8) : ","Consultation d'un utilisateur", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(utilisateurJOption.findByKey(Integer.parseInt(d)));
		} else if (option == 2) {
			UtilisateursDao utilisateurJOption = new UtilisateursDao(pjdbc);
			ExemplairesDao exemplaireJOption = new ExemplairesDao(pjdbc);
			String x = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'emprunteur ( Employé = 2, 3 et 6 et  Adhérent = 1, 4, 5, 7 et 8) : ","Réalisation d'un emprunt", JOptionPane.INFORMATION_MESSAGE);
			String y = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'exemplaire à emprunter : ","Réalisation d'un emprunt", JOptionPane.INFORMATION_MESSAGE);
			EmpruntEnCoursDao empruntEnCoursDao = new EmpruntEnCoursDao(pjdbc);
			System.out.println(empruntEnCoursDao.insertEmpruntEnCours(new EmpruntEnCours(utilisateurJOption.findByKey(Integer.parseInt(x)), exemplaireJOption.findByKey(Integer.parseInt(y)))));
		} else if (option == 3) {
			EmpruntEnCoursDao empruntEnCours = new EmpruntEnCoursDao(pjdbc);
			String e = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'exemplaire à rendre ( de 1 à 8 ): ","Retour d'un emprunt", JOptionPane.INFORMATION_MESSAGE);
			empruntEnCours.removeEmpruntEnCours(Integer.parseInt(e));
			//EmpruntArchiveDao empruntArchive = new EmpruntArchiveDao(PingJdbc.getConnectionByProperties());
		} else if (option == 4) {
			ExemplairesDao exemplaireDispoJOption = new ExemplairesDao(pjdbc);
			for(Exemplaire e : exemplaireDispoJOption.findAll())
			System.out.println(e);
		} else if (option == 5) {
			EmpruntArchiveDao empruntArchive = new EmpruntArchiveDao(pjdbc);
			for(EmpruntArchive emp : empruntArchive.findAll())
			System.out.println(emp);
		} else if (option == 6) {
			EmpruntArchiveDao empruntArchive = new EmpruntArchiveDao(pjdbc);
			String f = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'emprunteur (Employé = 2, 3 et 6 ou Adhérent = 1, 4, 5, 7 et 8) : ","Visualisation des archives", JOptionPane.INFORMATION_MESSAGE);
			for(EmpruntArchive emp1 : empruntArchive.findByKey(Integer.parseInt(f)))
			System.out.println(emp1);
		} else if (option == 7) {
			String g = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'emprunteur (Employé = 2, 3 et 6 ou Adhérent = 1, 4, 5, 7 et 8) : ","Visualisation des emprunts en cours", JOptionPane.INFORMATION_MESSAGE);
			EmpruntEnCoursDao eEc = new EmpruntEnCoursDao(pjdbc);
			UtilisateursDao udao = new UtilisateursDao(pjdbc);
			Utilisateur u = udao.findByKey(Integer.parseInt(g));
			for(EmpruntEnCoursDb empCours: eEc.findByUtilisateur(u)) {
				
			System.out.println(empCours);
			}
		} else if (option == 8) {
			String h = JOptionPane.showInputDialog(null, "Entrez l'identifiant de l'emprunteur (Employé = 2,3,6 ou Adhérent = 1,4,5,7,8) : ","Retards dans rendu exemplaires", JOptionPane.INFORMATION_MESSAGE);
			EmpruntEnCoursDao eEc1 = new EmpruntEnCoursDao(pjdbc);
			

		}
		
		  choixFinal = JOptionPane.showConfirmDialog(null, "Voulez-vous continuer ?"); 
		} while (choixFinal==0);
		
	}

}
