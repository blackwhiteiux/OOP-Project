package school.sorokin.javacore;

public class Book extends Publication implements Printable{



    private String isbn;

    public Book(String author, String title, int year, String isbn) {
        super(author, title, year);
        this.isbn=isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public String toString(){
        return  "Тип публикации: "+getType()+" | Название: "+getTitle()+" | Автор: "+getAuthor()+" | Год выпуска: "+getYear()+" | ISBN: "+getIsbn();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj==null||getClass()!=obj.getClass()) return false;
        Book book=(Book) obj;
        return (getYear()==book.getYear())&&
                (book.getTitle() != null ? getTitle().equals(book.getTitle()) : book.getTitle() == null)&&
                (book.getAuthor()!=null ? getAuthor().equals(book.getAuthor()): book.getAuthor()==null)&&
                (book.getIsbn() !=null ? getIsbn().equals(book.getIsbn()): book.getIsbn()==null);
    }

    @Override
    public int hashCode(){
        int authorHashCode=(getAuthor() != null ? getAuthor().hashCode() : 0);
        int titleHashCode=(getTitle() != null ? getTitle().hashCode() : 0);
        int isbnHashCode=(getIsbn()!= null ? getIsbn().hashCode(): 0);
        return 31*authorHashCode+titleHashCode+isbnHashCode+getYear();
    }

    @Override
    public void printDetails() {
        System.out.println("Тип публикации: "+getType()+" | Название: "+getTitle()+" | Автор: "+getAuthor()+" | Год выпуска: "+getYear()+" | ISBN: "+getIsbn());
    }
}
