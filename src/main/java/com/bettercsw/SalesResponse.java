package com.bettercsw;

import lombok.Data;
import lombok.ToString;

/**
 * @author csw
 * @date 2022/5/29 22:33
 */
@Data
@ToString
public class SalesResponse {

    private String id;

    // private PoapToken token;

    private String seller;

    private String amount;

    private String price;

    // private String currency;

    private String block;

    private String timestamp;

    // private String secondaryFees;

    // private String fee;

    // private String tokenType;

    // private String tokenAddress;

    private String tokenId;

    // private String bps;

    private String uri;


    // private List<String> likes;

    // private String likeCount;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SalesResponse) {
            SalesResponse response = (SalesResponse) obj;
            return this.tokenId.equals(response.getTokenId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.tokenId.hashCode();
    }
}
