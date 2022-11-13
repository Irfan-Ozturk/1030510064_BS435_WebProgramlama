package entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookName",length = 20)
    private String bookName;

    @Column(name = "writerName",length = 25)
    private String writerName;

    @Column(name = "pagesNumber")
    private Integer pagesNumber;

    @ManyToOne
    private  Reader reader;

    @ManyToOne
    private Publisher publisher;

    public Book(){
    }

    public Long getId() {
        return id;
    }

    public String getbookName() {
        return bookName;
    }

    public void setbooktName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public Integer getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(Integer pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}