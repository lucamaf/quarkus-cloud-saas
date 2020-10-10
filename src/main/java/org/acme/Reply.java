package org.acme;

import javax.validation.constraints.NotNull;

public class Reply {

    @NotNull
    private String id;

    @NotNull
    private String trackingcode;

    @NotNull
    private String timestamp;

    public Reply() {
    }

    public Reply(String id, String trackingcode, String timestamp) {
        this.id = id;
        this.trackingcode = trackingcode;
        this.timestamp = timestamp;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrackingcode() {
        return this.trackingcode;
    }

    public void setTrackingcode(String trackingcode) {
        this.trackingcode = trackingcode;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", trackingcode='" + getTrackingcode() + "'" +
            ", timestamp='" + getTimestamp() + "'" +
            "}";
    }

    
}
