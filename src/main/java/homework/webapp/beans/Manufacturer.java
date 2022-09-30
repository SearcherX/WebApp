package homework.webapp.beans;

import java.io.Serializable;

public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String countryName;
    private String logo;
    private int employeesNumber;
    private String briefInformation;

    public Manufacturer(){ }

    public Manufacturer(String name, String countryName, String logo, int employeesNumber,
                        String briefInformation) {
        this.name = name;
        this.countryName = countryName;
        this.logo = logo;
        this.employeesNumber = employeesNumber;
        this.briefInformation = briefInformation;
    }

    public Manufacturer(int id, String name, String countryName, String logo, int employeesNumber,
                        String briefInformation) {
        this.id = id;
        this.name = name;
        this.countryName = countryName;
        this.logo = logo;
        this.employeesNumber = employeesNumber;
        this.briefInformation = briefInformation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String getBriefInformation() {
        return briefInformation;
    }

    public void setBriefInformation(String briefInformation) {
        this.briefInformation = briefInformation;
    }

}
