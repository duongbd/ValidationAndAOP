package model;

import CustomExecption.OutOfBooks;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer total;
    @Column
    @Min(value = 0, message = "Out of books")
    private Integer remain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public void incrementRemain() {
        this.remain++;
    }

    public void decrementRemain() throws OutOfBooks {
        if (this.remain - 1 < 0)
            throw new OutOfBooks();
        else this.remain--;
    }

    public Integer getId() {
        return id;
    }
}
