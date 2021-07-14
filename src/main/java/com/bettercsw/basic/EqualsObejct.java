package com.bettercsw.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author csw
 * @date 2019/12/10 10:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EqualsObejct implements Serializable {
    private String name;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsObejct that = (EqualsObejct) o;
        return this.id == that.getId() &&
                this.name.equals(that.getName());
    }


// @Override
    // public int hashCode() {
    //
    //     return Objects.hash(name, id);
    // }
}
