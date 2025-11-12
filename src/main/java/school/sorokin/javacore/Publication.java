package school.sorokin.javacore;

public abstract class Publication {
    private String title;
    private String author;
    private int year;

    public Publication(String author, String title, int year) {
        this.author=author;
        this.title=title;
        this.year=year;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return "Тип публикации: "+getType()+" | Название: "+getTitle()+" | Автор: "+getAuthor()+" | Год выпуска: "+getYear();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj !=null||getClass() != obj.getClass()) return false;
        Publication publication=(Publication) obj;
        return year==publication.year &&
                (publication.title != null ? title.equals(publication.title) : publication.title == null) &&
                (publication.author != null ? author.equals(publication.author) : publication.author == null);
    }

    @Override
    public int hashCode(){
        int authorHashCode=(author != null ? author.hashCode():0);
        int titleHashCode=(title !=null ? title.hashCode(): 0);
        return 31*authorHashCode+titleHashCode+year;
    }
}
