package org.elsys.ip.rest.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.List;

@JsonSerialize
public class Item {
    /*Name
            Description
    Discount (ако си намалил цената и колко процента си я смъкнал спрямо първоначалната)
    Color(възможност да избереш custom от някакви опции)
    Brand (ако има някаква марка(ако е дреха, кола, или нещо такова))
    Publish Date
    Price
    Score (колко пъти хората са гласували за този айтем)
    Tags (пример: печка, кола, джанти, etc.)
    Availability (колко има от този продукт в наличност)
    City (Градът на потребитял, който е лист-нал продукта)*/

    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private String color;
    private Integer discount;
    private String brand;
    @JsonIgnore
    private Date publishDate;
    private Integer score;
    private String tags;
    private Integer availability;
    private String city;

    public Item() {}

    public Item(Integer id, String name, Integer price, String description, String color, Integer discount, String brand, Date publishDate, Integer score, String tags, Integer availability, String city) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.color = color;
        this.discount = discount;
        this.brand = brand;
        this.publishDate = publishDate;
        this.score = score;
        this.tags = tags;
        this.availability = availability;
        this.city = city;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (getId() != null ? !getId().equals(item.getId()) : item.getId() != null) return false;
        if (getName() != null ? !getName().equals(item.getName()) : item.getName() != null) return false;
        if (getPrice() != null ? !getPrice().equals(item.getPrice()) : item.getPrice() != null) return false;
        if (getDescription() != null ? !getDescription().equals(item.getDescription()) : item.getDescription() != null)
            return false;
        if (getColor() != null ? !getColor().equals(item.getColor()) : item.getColor() != null) return false;
        if (getDiscount() != null ? !getDiscount().equals(item.getDiscount()) : item.getDiscount() != null)
            return false;
        if (getBrand() != null ? !getBrand().equals(item.getBrand()) : item.getBrand() != null) return false;
        if (getPublishDate() != null ? !getPublishDate().equals(item.getPublishDate()) : item.getPublishDate() != null)
            return false;
        if (getScore() != null ? !getScore().equals(item.getScore()) : item.getScore() != null) return false;
        if (getTags() != null ? !getTags().equals(item.getTags()) : item.getTags() != null) return false;
        if (getAvailability() != null ? !getAvailability().equals(item.getAvailability()) : item.getAvailability() != null)
            return false;
        return getCity() != null ? getCity().equals(item.getCity()) : item.getCity() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + (getDiscount() != null ? getDiscount().hashCode() : 0);
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        result = 31 * result + (getPublishDate() != null ? getPublishDate().hashCode() : 0);
        result = 31 * result + (getScore() != null ? getScore().hashCode() : 0);
        result = 31 * result + (getTags() != null ? getTags().hashCode() : 0);
        result = 31 * result + (getAvailability() != null ? getAvailability().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        return result;
    }
}
