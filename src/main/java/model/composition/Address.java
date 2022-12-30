package model.composition;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetAddress;
    private String complement;

    public String getStreetAddress() { return streetAddress; }

    public void setStreetAddress(final String streetAddress) { this.streetAddress = streetAddress; }

    public String getComplement() { return complement; }

    public void setComplement(final String complement) { this.complement = complement; }
}
