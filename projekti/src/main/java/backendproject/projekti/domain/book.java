package backendproject.projekti.domain;


public class book {
    private String title, author;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public long getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(long publicationYear) {
        this.publicationYear = publicationYear;
    }
    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public book(String title, String author, long publicationYear, long isbn, long price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }
    private long publicationYear, isbn, price;
    public book(){
        super();
    }
   
}
