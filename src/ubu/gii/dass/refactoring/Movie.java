package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		set_priceCode(priceCode);
	}

	public int getPriceCode() {
		return get_priceCode();
	}

	public void setPriceCode(int arg) {
		set_priceCode(arg);
	}

	public String getTitle() {
		return _title;
	}

	/**
	 * @param rental TODO
	 * @return
	 */
	double calculateCharge(Rental rental) {
		double thisAmount = 0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (rental.getDaysRented() > 2)
				thisAmount += (rental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (rental.getDaysRented() > 3)
				thisAmount += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	/**
	 * @return the _priceCode
	 */
	private int get_priceCode() {
		return _priceCode;
	}

	/**
	 * @param _priceCode the _priceCode to set
	 */
	private void set_priceCode(int _priceCode) {
		this._priceCode = _priceCode;
	}
}
