package dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "Film", schema = "dbo", catalog = "Laboratory")
public class FilmEntity {
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

        FilmEntity that = (FilmEntity) o;

        if (filmId != that.filmId) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (iso != null ? !iso.equals(that.iso) : that.iso != null) return false;
        if (shots != null ? !shots.equals(that.shots) : that.shots != null) return false;
        if (developmentMethod != null ? !developmentMethod.equals(that.developmentMethod) : that.developmentMethod != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (iso != null ? iso.hashCode() : 0);
        result = 31 * result + (shots != null ? shots.hashCode() : 0);
        result = 31 * result + (developmentMethod != null ? developmentMethod.hashCode() : 0);
        return result;
    }
}
