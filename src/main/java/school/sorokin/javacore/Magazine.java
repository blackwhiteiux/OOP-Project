package school.sorokin.javacore;

public class Magazine extends Publication implements Printable{
    private int  issueNumber;

    public Magazine(String title, String author, int year, int issueNumber){
        super(title, author, year);
        this.issueNumber=issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType(){
        return "Журнал";
    }

    @Override
    public void printDetails(){
        System.out.println("Тип публикации: "+getType()+" | Название: "+getTitle()+" | Издательство: "+getAuthor()+" | Год выпуска: "+getYear()+" | Номер выпуска: "+getIssueNumber());
    }

    @Override
    public String toString(){
        return "Тип публикации: "+getType()+" | Название: "+getTitle()+" | Издательство: "+getAuthor()+" | Год выпуска: "+getYear()+" | Номер выпуска: "+getIssueNumber();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj ==null||getClass()!=obj.getClass()) return false;
        Magazine magazine=(Magazine) obj;
        return this.getIssueNumber()==magazine.getIssueNumber()&&
                getYear()==magazine.getYear()&&
                magazine.getTitle()!=null ? getTitle().equals(magazine.getTitle()) : magazine.getTitle()==null&&
                magazine.getAuthor()!=null ? getAuthor().equals(magazine.getAuthor()) : magazine.getAuthor()==null;

    }

    @Override
    public int hashCode(){
        int titleHashCode=getTitle()!=null ? getTitle().hashCode() : 0;
        int authorHashCode=getAuthor()!=null ? getAuthor().hashCode() : 0;
        return 31*titleHashCode+authorHashCode+getYear()+getIssueNumber();
    }
}
