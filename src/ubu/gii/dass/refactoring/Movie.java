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

    private static final double REGULAR_BASE_PRICE = 2.0;
    private static final int REGULAR_BASE_DAYS = 2;
    private static final double EXTRA_DAY_PRICE = 1.5;
    private static final double NEW_RELEASE_DAILY_PRICE = 3.0;
    private static final double CHILDRENS_BASE_PRICE = 1.5;
    private static final int CHILDRENS_BASE_DAYS = 3;

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

    double calculateCharge(Rental rental) {
        double thisAmount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += REGULAR_BASE_PRICE;

                if (rental.getDaysRented() > REGULAR_BASE_DAYS) {
                    thisAmount += (rental.getDaysRented() - REGULAR_BASE_DAYS) * EXTRA_DAY_PRICE;
                }

                break;

            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * NEW_RELEASE_DAILY_PRICE;

                break;

            case Movie.CHILDRENS:
                thisAmount += CHILDRENS_BASE_PRICE;

                if (rental.getDaysRented() > CHILDRENS_BASE_DAYS) {
                    thisAmount += (rental.getDaysRented() - CHILDRENS_BASE_DAYS) * EXTRA_DAY_PRICE;
                }

                break;
        }

        return thisAmount;
    }

    private int get_priceCode() {
        return _priceCode;
    }

    private void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }
}