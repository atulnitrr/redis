package com.redis.jedis.jedis.model;

import java.io.Serializable;
import java.util.Objects;


public class Programmer implements Serializable {

    private int id;
    private String name;
    private String company;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Programmer that = (Programmer) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(company, that.company);
    }

    @Override public int hashCode() {
        return Objects.hash(id, name, company);
    }
}
