package assignment2.organizations.gallery;

import assignment2.commons.Organization;
import assignment2.commons.Contactable;
import java.util.ArrayList;
import java.util.List;

public class ArtGallery extends Organization implements Contactable {
    private String email, address, phoneNumber;
    private List<Exhibition> exhibitions = new ArrayList<>();

    public ArtGallery(String name) {
        this.name = name;
    }

    public void addExhibition(Exhibition exhibition) {
        exhibitions.add(exhibition);
    }

    public boolean removeExhibition(Exhibition exhibition) {
        return exhibitions.remove(exhibition);
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}