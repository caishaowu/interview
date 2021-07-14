package com.bettercsw;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author csw
 * @date 2021/4/26 11:40
 */
public class TestVo implements Serializable {
    public TestVo(){}

    public TestVo(String name, Long value) {
        this.name = name;
        this.value = value;
    }
    /**
     * 行业名称
     */
    private String name;


    /**
     * 销量
     */
    private Long value;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestVo testVo = (TestVo) o;
        return Objects.equals(name, testVo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
