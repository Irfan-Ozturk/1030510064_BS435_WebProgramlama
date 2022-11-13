package entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Table(name="readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "readerName")
    private String readerName;

    @OneToMany(mappedBy = "reader")
    private List<Book> books;


    public Reader(){
    }

    public Long getId() {
        return id;
    }


    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public List<Book> getBooks(){
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books= books;
    }
}