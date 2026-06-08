package ubu.gii.dass.refactoring;

public class RegularPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}
}