/**
 * 
 */
package sample.pojo.data;

/**
 * @author ygong
 * 
 */
public class WeatherWithHumidity extends Weather {

    private String humidity = "23.3";

    @Override
    public String toString() {

        return new StringBuffer(this.getClass().getName()).append(":[humidity=").append(
                this.humidity).append(", forecast=").append(this.forecast).append(", temperature=")
                .append(this.temperature).append(", howMuchRain=").append(this.howMuchRain).append(
                        ", rain=").append(this.rain).append(", address=").append(this.address)
                .append("]").toString();
    }

    /**
     * @return the humidity
     */
    public String getHumidity() {

        return humidity;
    }

    /**
     * @param humidity
     *            the humidity to set
     */
    public void setHumidity(String humidity) {

        this.humidity = humidity;
    }
}
