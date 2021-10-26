package client.demo.model;

public class Weather {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.id
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.county
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String county;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.country
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.max_temperature
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String maxTemperature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.max_weather
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String maxWeather;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.max_wind_direction
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String maxWindDirection;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.max_wind_power
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String maxWindPower;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.min_temperature
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String minTemperature;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.min_weather
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String minWeather;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.min_wind_direction
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String minWindDirection;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.min_wind_power
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String minWindPower;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.latitude
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.longitude
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.code
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_weather.time
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    private String time;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.id
     *
     * @return the value of t_weather.id
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.id
     *
     * @param id the value for t_weather.id
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.county
     *
     * @return the value of t_weather.county
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getCounty() {
        return county;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.county
     *
     * @param county the value for t_weather.county
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.country
     *
     * @return the value of t_weather.country
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.country
     *
     * @param country the value for t_weather.country
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.max_temperature
     *
     * @return the value of t_weather.max_temperature
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.max_temperature
     *
     * @param maxTemperature the value for t_weather.max_temperature
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature == null ? null : maxTemperature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.max_weather
     *
     * @return the value of t_weather.max_weather
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getMaxWeather() {
        return maxWeather;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.max_weather
     *
     * @param maxWeather the value for t_weather.max_weather
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setMaxWeather(String maxWeather) {
        this.maxWeather = maxWeather == null ? null : maxWeather.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.max_wind_direction
     *
     * @return the value of t_weather.max_wind_direction
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getMaxWindDirection() {
        return maxWindDirection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.max_wind_direction
     *
     * @param maxWindDirection the value for t_weather.max_wind_direction
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setMaxWindDirection(String maxWindDirection) {
        this.maxWindDirection = maxWindDirection == null ? null : maxWindDirection.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.max_wind_power
     *
     * @return the value of t_weather.max_wind_power
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getMaxWindPower() {
        return maxWindPower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.max_wind_power
     *
     * @param maxWindPower the value for t_weather.max_wind_power
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setMaxWindPower(String maxWindPower) {
        this.maxWindPower = maxWindPower == null ? null : maxWindPower.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.min_temperature
     *
     * @return the value of t_weather.min_temperature
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getMinTemperature() {
        return minTemperature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.min_temperature
     *
     * @param minTemperature the value for t_weather.min_temperature
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature == null ? null : minTemperature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.min_weather
     *
     * @return the value of t_weather.min_weather
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getMinWeather() {
        return minWeather;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.min_weather
     *
     * @param minWeather the value for t_weather.min_weather
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setMinWeather(String minWeather) {
        this.minWeather = minWeather == null ? null : minWeather.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.min_wind_direction
     *
     * @return the value of t_weather.min_wind_direction
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getMinWindDirection() {
        return minWindDirection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.min_wind_direction
     *
     * @param minWindDirection the value for t_weather.min_wind_direction
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setMinWindDirection(String minWindDirection) {
        this.minWindDirection = minWindDirection == null ? null : minWindDirection.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.min_wind_power
     *
     * @return the value of t_weather.min_wind_power
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getMinWindPower() {
        return minWindPower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.min_wind_power
     *
     * @param minWindPower the value for t_weather.min_wind_power
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setMinWindPower(String minWindPower) {
        this.minWindPower = minWindPower == null ? null : minWindPower.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.latitude
     *
     * @return the value of t_weather.latitude
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.latitude
     *
     * @param latitude the value for t_weather.latitude
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.longitude
     *
     * @return the value of t_weather.longitude
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.longitude
     *
     * @param longitude the value for t_weather.longitude
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.code
     *
     * @return the value of t_weather.code
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.code
     *
     * @param code the value for t_weather.code
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_weather.time
     *
     * @return the value of t_weather.time
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public String getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_weather.time
     *
     * @param time the value for t_weather.time
     *
     * @mbggenerated Tue Oct 26 13:49:44 CST 2021
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}