package school.sorokin.javacore;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Publication> publications = new ArrayList<>();

    //1. Добавление публикации
    public void addPublication(Publication pub){
        publications.add(pub);
        Publication.incrementCounter();
        System.out.println("Публикация успешно добавлена!");
    }

    public List<Publication> getPublications(){
        return new ArrayList<>(publications);
    }

    //3. Поиск публикации по автору
    public void searchByAuthor(String searchAuthor){
       boolean found=false;
       System.out.println("Найденные публикации автора: ");
       for(Publication s: publications){
          if(searchAuthor.equalsIgnoreCase(s.getAuthor())){
            s.printDetails();
            found=true;
         }
       } if(!found){
            System.out.println("Публикации данного автора не найдены.");
    }
}

    //4. Вывод количества публикаций
    public void getPublicationCounter() {
        System.out.println("Количество публикаций: "+Publication.getPublicationCounter());
    }
}

