package main.java.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Film", schema = "dbo", catalog = "Laboratory")
public class FilmDAO {
    private int filmId;
    private String manufacturer;
    private Integer iso;
    private Integer shots;
    private String developmentMethod;

    @Id
    @Column(name = "Film_ID", nullable = false)
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "Manufacturer", nullable = true, length = 50)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "ISO", nullable = true)
    public Integer getIso() {
        return iso;
    }

    public void setIso(Integer iso) {
        this.iso = iso;
    }

    @Basic
    @Column(name = "Shots", nullable = true)
    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    @Basic
    @Column(name = "Development_method", nullable = true, length = 20)
    public String getDevelopmentMethod() {
        return developmentMethod;
    }

    public void setDevelopmentMethod(String developmentMethod) {
        this.developmentMethod = developmentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDAO filmDAO = (FilmDAO) o;
        return filmId == filmDAO.filmId &&
                Objects.equals(manufacturer, filmDAO.manufacturer) &&
                Objects.equals(iso, filmDAO.iso) &&
                Objects.equals(shots, filmDAO.shots) &&
                Objects.equals(developmentMethod, filmDAO.developmentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, manufacturer, iso, shots, developmentMethod);
    }
}
