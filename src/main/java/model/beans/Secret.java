package model.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author skuarch-lap
 */
public class Secret implements Serializable {
    
    private long id;
    private String secretAlphanumeric;
    private SecretStatus secretStatus;
    private BigDecimal value;
    private String generationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());    
    private String consumedDate;
    private String expiryDate = LocalDateTime.now().plusDays(90).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    public Secret() {         
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSecretAlphanumeric() {
        return secretAlphanumeric;
    }

    public void setSecretAlphanumeric(String secretAlphanumeric) {
        this.secretAlphanumeric = secretAlphanumeric;
    }

    public SecretStatus getSecretStatus() {
        return secretStatus;
    }

    public void setSecretStatus(SecretStatus secretStatus) {
        this.secretStatus = secretStatus;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }

    public String getConsumedDate() {
        return consumedDate;
    }

    public void setConsumedDate(String consumedDate) {
        this.consumedDate = consumedDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    
    
}
