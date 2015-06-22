package model.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author skuarch-lap
 */
public class Transfer implements Serializable {

    private long id;
    private TransferType transferType;
    private BigDecimal amount;
    private Depositor depositor;
    private Recipient recipient;
    private String secretAlphanumeric;
    private String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private byte isSoftDeleted = 0;

    public Transfer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getIsSoftDeleted() {
        return isSoftDeleted;
    }

    public void setIsSoftDeleted(byte isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Depositor getDepositor() {
        return depositor;
    }

    public void setDepositor(Depositor depositor) {
        this.depositor = depositor;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSecretAlphanumeric() {
        return secretAlphanumeric;
    }

    public void setSecretAlphanumeric(String secretAlphanumeric) {
        this.secretAlphanumeric = secretAlphanumeric;
    }

}
