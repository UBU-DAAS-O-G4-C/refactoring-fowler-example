package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones genéricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

    private static final int NEW_RELEASE_BONUS_DAYS = 1;

    private String _name;
    private List<Rental> _rentals;

    public Customer(String name) {
        _name = name;
        _rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = _rentals.iterator();

        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental rental = rentals.next();

            thisAmount = rental.getCharge();

            frequentRenterPoints = updateFrequentRenterPoints(frequentRenterPoints, rental);

            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";

        return result;
    }

    private int updateFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints++;

        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && rental.getDaysRented() > NEW_RELEASE_BONUS_DAYS) {
            frequentRenterPoints++;
        }

        return frequentRenterPoints;
    }
}