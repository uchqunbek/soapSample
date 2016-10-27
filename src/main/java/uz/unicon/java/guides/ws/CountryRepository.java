package uz.unicon.java.guides.ws;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import uz.unicon.java.guides.spring_web_service.Country;
import uz.unicon.java.guides.spring_web_service.Currency;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryRepository {
    private static final List<Country> countries = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.add(spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        countries.add(poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        countries.add(uk);

        Country uz = new Country();
        uz.setName("Uzbekistan");
        uz.setCapital("Tashkent");
        uz.setCurrency(Currency.UZS);
        uz.setPopulation(32000000);

        countries.add(uz);
    }

    public Country findCountry(String name) {
        Assert.notNull(name);

        Country result = null;

        for (Country country : countries) {
            if (name.equals(country.getName())) {
                result = country;
            }
        }

        return result;
    }
}
