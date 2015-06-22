package model.beans;

import java.util.List;

/**
 *
 * @author skuarch-lap
 */
public class Recipient {    
   
    private long id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private List<Secret> secret;
    private byte isSoftDeleted = 0;

    public Recipient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Secret> getSecret() {
        return secret;
    }

    public void setSecret(List<Secret> secret) {
        this.secret = secret;
    }

    public byte getIsSoftDeleted() {
        return isSoftDeleted;
    }

    public void setIsSoftDeleted(byte isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }
    
}
