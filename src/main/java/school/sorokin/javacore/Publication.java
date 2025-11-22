package school.sorokin.javacore;
import java.util.Objects;

public abstract class Publication implements Printable{
    private String title;
    private String author;
    private int year;

    public Publication(String title, String author, int year) {
        this.title=title;
        this.author=author;
        this.year=year;
    }

    private static int publicationCounter = 0;

    public static void incrementCounter(){
        publicationCounter ++;
    }

    public static int getPublicationCounter(){
        return publicationCounter;
    }

    public abstract String getType();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) throws IllegalAccessException {
        if(title==null||title.isBlank()){
            throw new IllegalAccessException("Некорректное название публикации.");
        }
        this.title = title;
    }

    public void setAuthor(String author) throws IllegalAccessException {
        if(author==null||author.isBlank()){
            throw new IllegalAccessException("Некореектно введен автор публикации");
        }
        this.author = author;
    }

    public void setYear(int year) {
        if(year<=0){
            System.out.println("Некорректно введен год публикации.");
        } try {
                this.year = year;
            } catch (NumberFormatException e){
                System.out.println("Некорректно введен год публикации. ");
        }
    }

    @Override
    public String toString(){
        return getType()+" | "+getTitle()+" | "+getAuthor()+" | "+getYear();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj ==null||getClass() != obj.getClass()) return false;
        Publication publication=(Publication) obj;
        return year==publication.year &&
                Objects.equals(getTitle(), publication.getTitle()) &&
                Objects.equals(getAuthor(), publication.getAuthor());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTitle(), getAuthor(), getYear());
    }
}
