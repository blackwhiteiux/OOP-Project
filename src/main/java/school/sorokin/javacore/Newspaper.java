package school.sorokin.javacore;
import java.util.Objects;

public class Newspaper extends Publication implements Printable{

    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay){
        super(title, author, year);
        this.publicationDay=publicationDay;
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) throws IllegalAccessException {
        if(publicationDay==null||publicationDay.isBlank()){
            throw new IllegalAccessException("Некорректный день публикации");
        }
        this.publicationDay = publicationDay;
    }

    @Override
    public String getType(){
        return "Газета";
    }

    @Override
    public void printDetails(){
        System.out.println("Тип публикации: "+getType()+" | Название: "+getTitle()+" | Издательство: "+getAuthor()+" | Год выпуска: "+getYear()+" | День публикации: "+getPublicationDay());
    }

    @Override
    public String toString(){
        return getType()+" | "+getTitle()+" | "+getAuthor()+" | "+getYear()+" | "+getPublicationDay();
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj) return true;
        if (obj==null||getClass()!=obj.getClass()) return false;
        Newspaper newspaper=(Newspaper) obj;
        return getYear()==newspaper.getYear()&&
               Objects.equals(getTitle(), newspaper.getTitle())&&
               Objects.equals(getAuthor(), newspaper.getAuthor())&&
               Objects.equals(getPublicationDay(), newspaper.getPublicationDay());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTitle(), getAuthor(), getYear(), getPublicationDay());
    }
}
