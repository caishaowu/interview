package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author csw
 * @date 2022/3/23 14:56
 */
@Data
@AllArgsConstructor
// @EqualsAndHashCode(callSuper = true)
public class Dog extends Animal {

    private String food;

    private String type;

    public Dog(Integer id, String name, String food, String type) {
        super(id, name);
        this.food = food;
        this.type = type;
    }
}
