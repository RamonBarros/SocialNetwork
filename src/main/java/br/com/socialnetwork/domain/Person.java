package br.com.socialnetwork.domain;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person implements Serializable {
    
    private static final long serialVersionUID = -21814600569383020L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="person_id")
    private Long idPerson;
    
    @Column(name = "person_name")
    private String name;
    
    @Column(name = "peron_address_image")
    private String addressImage;
    
    @Column(name = "person_image", nullable=false, columnDefinition="mediumblob")
    private byte[] image;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressImage == null) ? 0 : addressImage.hashCode());
        result = prime * result + ((idPerson == null) ? 0 : idPerson.hashCode());
        result = prime * result + Arrays.hashCode(image);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (addressImage == null) {
            if (other.addressImage != null)
                return false;
        } else if (!addressImage.equals(other.addressImage))
            return false;
        if (idPerson == null) {
            if (other.idPerson != null)
                return false;
        } else if (!idPerson.equals(other.idPerson))
            return false;
        if (!Arrays.equals(image, other.image))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Person [idPerson=" + idPerson + ", name=" + name + ", addressImage=" + addressImage + ", image="
                + Arrays.toString(image) + "]";
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressImage() {
        return addressImage;
    }

    public void setAddressImage(String addressImage) {
        this.addressImage = addressImage;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
