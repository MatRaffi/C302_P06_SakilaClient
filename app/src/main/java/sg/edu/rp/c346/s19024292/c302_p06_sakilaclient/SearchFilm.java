package sg.edu.rp.c346.s19024292.c302_p06_sakilaclient;

import java.io.Serializable;

public class SearchFilm implements Serializable {

    private String title;
    private int year;
    private String rating;
    private String desc;
    private String country;
    private String address;
    private String city;
    private int id;

    public SearchFilm(String title, int year, String rating, String desc, String country, String address, String city, int id) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.desc = desc;
        this.country = country;
        this.address = address;
        this.city = city;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SearchFilm{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", rating='" + rating + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
