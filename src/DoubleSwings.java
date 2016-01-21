public class DoubleSwings extends PlayGround {

	DoubleSwings() {
		super(2);
	}

	float SiteUtil() {

		int UtilPerc;

		if (site.size() == 2)
			UtilPerc = 100;
		else
			UtilPerc = 0;

		return UtilPerc;

	}

}
