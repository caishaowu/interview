package com.bettercsw.principle.lsp;

import lombok.Data;

/**正方形
 * @author csw
 * @date 2020/1/6 11:30
 */
@Data
public class Square extends Rectangle{
    private long length;

    @Override
    public long getWidth() {
        return getLength();
    }
    @Override
    public long getHeight() {
        return getLength();
    }
    @Override
    public void setWidth(long width) {
       setLength(width);
    }
    @Override
    public void setHeight(long height) {
        setLength(height);
    }
}
