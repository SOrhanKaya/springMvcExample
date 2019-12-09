package com.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persontb {
    private long personTc;
    private int coordinateX;
    private int coordinateY;

    @Id
    @Column(name = "PersonTc", nullable = false)
    public long getPersonTc() {
        return personTc;
    }

    public void setPersonTc(long personTc) {
        this.personTc = personTc;
    }

    @Basic
    @Column(name = "CoordinateX", nullable = false)
    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    @Basic
    @Column(name = "CoordinateY", nullable = false)
    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persontb persontb = (Persontb) o;

        if (personTc != persontb.personTc) return false;
        if (coordinateX != persontb.coordinateX) return false;
        if (coordinateY != persontb.coordinateY) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personTc ^ (personTc >>> 32));
        result = 31 * result + coordinateX;
        result = 31 * result + coordinateY;
        return result;
    }
}
