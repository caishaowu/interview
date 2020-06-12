package com.bettercsw.unitTest;

import lombok.Data;

import java.util.Date;

/**
 * @author csw
 * @date 2020/1/9 14:46
 */
@Data
public class TicketSeller {
    private Integer inventory;
    private Date closeTime;

    public Integer sell(Integer inventory) throws TicketException {
        this.inventory = this.inventory - inventory;
        if(this.inventory < 0) {
            throw new TicketException();
        }
        return this.inventory;
    }

    public Integer refund(Integer inventory) {
        this.inventory = this.inventory + inventory;
        return this.inventory;
    }
}
