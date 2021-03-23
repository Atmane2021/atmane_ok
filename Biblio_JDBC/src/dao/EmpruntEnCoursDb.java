package dao;


import domain.EmpruntEnCours;



public class EmpruntEnCoursDb extends EmpruntEnCours{
	private Integer idExemp;
	private Integer idUtil;
	
	

	
	public EmpruntEnCoursDb(Integer idEx, Integer idU) {
		super();
		setIdExemp(idEx);
		setIdUtil(idU);		
	}

	public Integer getIdExemp() {
		return idExemp;
	}

	public void setIdExemp(Integer idExemp) {
		this.idExemp = idExemp;
	}

	public Integer getIdUtil() {
		return idUtil;
	}

	public void setIdUtil(Integer idUtil) {
		this.idUtil = idUtil;
	}
	

}
