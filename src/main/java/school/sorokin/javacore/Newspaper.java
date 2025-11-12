package school.sorokin.javacore;

public class Newspaper extends Publication implements Printable{

    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay){
        super(title, author, year);
        this.publicationDay=publicationDay;
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
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
        return "Тип публикации: "+getType()+" | Название: "+getTitle()+" | Издательство: "+getAuthor()+" | Год выпуска: "+getYear()+" | День публикации: "+getPublicationDay();
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj) return true;
        if (obj==null||getClass()!=obj.getClass()) return false;
        Newspaper newspaper=(Newspaper) obj;
        return getYear()==newspaper.getYear()&&
                newspaper.getTitle()!=null ? getTitle().equals(newspaper.getTitle()) : newspaper.getTitle()==null&&
                newspaper.getAuthor() != null ? getAuthor().equals(newspaper.getAuthor()) : newspaper.getAuthor()==null&&
                newspaper.getPublicationDay()!=null ? getPublicationDay().equals(newspaper.getPublicationDay()) : newspaper.publicationDay==null;
    }

    @Override
    public int hashCode(){
        int authorHashCode=getAuthor()!=null ? getAuthor().hashCode() : 0;
        int titleHashCode=getTitle() !=null ? getTitle().hashCode() : 0;
        int publicationDayHashCode= getPublicationDay()!=null ? getPublicationDay().hashCode() : 0;
        return 31*authorHashCode+titleHashCode+publicationDayHashCode+getYear();
    }
}
