package assignment2.commons;

import java.util.ArrayList;
import java.util.List;

/**
 * You should create the child class of this class
 * Do not change this class.
 */
public class Organization {

    protected String name;
    String description;

    boolean legal = true;

    List<Person> members = new ArrayList<>();

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public void addMember(Person p) {
        members.add(p);
    }

    public boolean removeMember(Person p) {
        return members.remove(p);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }
}
