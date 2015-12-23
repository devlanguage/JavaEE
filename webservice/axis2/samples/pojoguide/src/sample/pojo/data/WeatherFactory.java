/**
 * 
 */
package sample.pojo.data;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author ygong
 * 
 */
public class WeatherFactory {

    private final static NumberFormat nf1 = NumberFormat.getInstance();
    private final static NumberFormat nf2 = NumberFormat.getInstance();
    private final static WeatherFactory instance = new WeatherFactory();

    private WeatherFactory() {

        nf1.setMaximumFractionDigits(4);
        nf2.setMaximumFractionDigits(0);

    }

    public final static WeatherFactory getInstance() {

        return instance;
    }

    /**
     * @return
     */
    public Weather createWeather() {

        boolean switchFactor = (int) (Math.random() * 10) > 5 ? true : false;

        Weather weather = new Weather();

        weather.setForecast(((int) (Math.random() * 10) > 7 ? true : false) ? "sunny days"
                : "cloudy with showers");
        weather.setHowMuchRain(new BigDecimal(nf1.format(Math.random() * 10)));
        weather.setRain(switchFactor);
        weather.setTemperature(Double.valueOf(nf1.format(Math.random() * 100)));

        Address address = new Address();
        address.setPostCode(nf1.format(Math.random() * 10E6));
        address.setCity(((int) (Math.random() * 10) > 3 ? true : false) ? "Xi'An" : "Lan'Zhou");

        weather.setAddress(address);
        return weather;
    }

    /**
     * @return
     */
    public Weather createWeatherWithHumidiy() {

        boolean switchFactor = (int) (Math.random() * 10) > 5 ? true : false;

        WeatherWithHumidity weather = new WeatherWithHumidity();
        weather.setHumidity(nf2.format(Math.random() * 1000) + "%");

        weather.setForecast(((int) (Math.random() * 10) > 7 ? true : false) ? "sunny days"
                : "cloudy with showers");
        weather.setHowMuchRain(new BigDecimal(nf1.format(Math.random() * 10)));
        weather.setRain(switchFactor);
        weather.setTemperature(Double.valueOf(nf1.format(Math.random() * 100)));

        Address address = new Address();
        address.setPostCode(nf1.format(Math.random() * 10E6));
        address.setCity(((int) (Math.random() * 10) > 3 ? true : false) ? "Xi'An" : "Lan'Zhou");

        weather.setAddress(address);
        return weather;
    }

    /**
     * @return
     */
    public Weather createWeatherMix() {

        boolean switchFactor = (int) (Math.random() * 10) > 5 ? true : false;

        Weather weather = null;
        if (switchFactor) {
            weather = new Weather();
        } else {
            WeatherWithHumidity weatherWithHumidity = new WeatherWithHumidity();
            weatherWithHumidity.setHumidity(nf2.format(Math.random() * 1000) + "%");
            weather = weatherWithHumidity;
        }

        weather.setForecast(((int) (Math.random() * 10) > 7 ? true : false) ? "sunny days"
                : "cloudy with showers");
        weather.setHowMuchRain(new BigDecimal(nf1.format(Math.random() * 10)));
        weather.setRain(switchFactor);
        weather.setTemperature(Double.valueOf(nf1.format(Math.random() * 100)));

        Address address = new Address();
        address.setPostCode(nf1.format(Math.random() * 10E6));
        address.setCity(((int) (Math.random() * 10) > 3 ? true : false) ? "Xi'An" : "Lan'Zhou");

        weather.setAddress(address);
        return weather;
    }
}
