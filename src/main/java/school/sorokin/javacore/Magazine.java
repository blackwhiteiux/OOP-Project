package school.sorokin.javacore;
import java.util.Objects;

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
        if(issueNumber<=0){
            System.out.println("Введите корректное значение.");
        }
            try {
                this.issueNumber = issueNumber;
            } catch (NumberFormatException e){
                System.out.println("Введите число.");
            }
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
        return getType()+" | "+getTitle()+" | "+getAuthor()+" | "+getYear()+" | "+getIssueNumber();
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj ==null||getClass()!=obj.getClass()) return false;
        Magazine magazine=(Magazine) obj;
        return this.getIssueNumber()==magazine.getIssueNumber()&&
                getYear()==magazine.getYear()&&
                Objects.equals(getTitle(), magazine.getTitle())&&
                Objects.equals(getAuthor(), magazine.getAuthor())&&
                getIssueNumber()==magazine.getIssueNumber();
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTitle(), getAuthor(), getYear(), getIssueNumber());
    }
}
