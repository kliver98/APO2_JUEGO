package modelo;

public class ExcepcionNoExiste extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String name;
	
	public ExcepcionNoExiste(String msj, String name) {
		super(msj);
		this.setName(name);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
