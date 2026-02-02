package school.sorokin.javacore;
import java.util.Objects;

public class Book extends Publication implements Printable{ private String isbn;
    public Book(String title, String author, int year, String isbn) {
        super(title, author, year);
        this.isbn=isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws IllegalAccessException {
        if(isbn==null||isbn.isBlank()){
            throw new IllegalAccessException("Некорректный номер ISBN");
        }
            this.isbn = isbn;
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public String toString(){
        return  getType()+" | "+getTitle()+" | "+getAuthor()+" | "+getYear()+" | "+getIsbn();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj==null||getClass()!=obj.getClass()) return false;
        Book book=(Book) obj;
        return (getYear()==book.getYear())&&
                Objects.equals(getTitle(), book.getTitle())&&
                Objects.equals(getAuthor(), book.getAuthor())&&
                Objects.equals(getIsbn(), book.getIsbn());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTitle(), getAuthor(), getYear(), getIsbn());
    }

    @Override
    public void printDetails() {
        System.out.println("Тип публикации: "+getType()+" | Название: "+getTitle()+" | Автор: "+getAuthor()+" | Год выпуска: "+getYear()+" | ISBN: "+getIsbn());
    }
}
