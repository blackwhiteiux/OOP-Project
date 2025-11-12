package school.sorokin.javacore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Library {
    private List<Publication> publications=new ArrayList<>();

    Scanner scanner=new Scanner(System.in);

    private static int publicationCounter = 0;

    public void createPublications(){

        boolean correctCreateChoise=true;

        while (correctCreateChoise) {
            System.out.println("Выберите тип публикации: ");
            System.out.println("1. Книга");
            System.out.println("2. Газета");
            System.out.println("3. Журнал");

            int createChoise =validInt();

            if(createChoise>0&&createChoise<4){
                switch (createChoise){
                    case 1:
                        createBook();
                        correctCreateChoise=false;
                        break;
                    case 2:
                        createNewspaper();
                        correctCreateChoise=false;
                        break;
                    case 3:
                        createMagazine();
                        correctCreateChoise=false;
                        break;
                }
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
    }

    //1. Добавление публикации
    public void addPublication(Publication pub){
        publications.add(pub);
        publicationCounter ++;
        System.out.println("Публикация успешно добавлена!");
    }

    public  void createBook(){
        System.out.println("Введите название книги: ");
        String createTitle=scanner.nextLine();

        System.out.println("Введите имя автора: ");
        String createAuthor=scanner.nextLine();

        System.out.println("Введите ISBN: ");
        String createIsbn=scanner.nextLine();

        System.out.println("Введите год публикации книги: ");
        int createYear=validInt();

        Publication book=new Book(createAuthor, createTitle, createYear, createIsbn);

        addPublication(book);
    }

    public void createNewspaper(){
        System.out.println("Введите название газеты: ");
        String createTitle=scanner.nextLine();

        System.out.println("Введите название издательства: ");
        String createAuthor=scanner.nextLine();

        System.out.println("Введите день недели публикации газеты: ");
        String createPublicationDay=scanner.nextLine();

        System.out.println("Введите год публикации газеты: ");
        int createYear=validInt();

        Publication newspaper=new Newspaper(createAuthor,createTitle, createYear, createPublicationDay);

        addPublication(newspaper);
    }

    public void createMagazine(){
        System.out.println("Введите название журанала: ");
        String createTitle=scanner.nextLine();

        System.out.println("Введите название издательства: ");
        String createAuthor=scanner.nextLine();

        System.out.println("Введите номер выпуска: ");
        int createIssueNumber=validInt();


        System.out.println("Введите год публикации: ");
        int createYear=validInt();

        Publication magazine=new Magazine(createAuthor,createTitle, createYear, createIssueNumber);

        addPublication(magazine);
    }

    //2. Вывод всех публикаций
    public void listPublications(){
        System.out.println("Список всех публикаций: ");
        for(Publication s :publications) {
            System.out.println(s.toString());
        }
    }

    //3. Поиск публикации по автору
    public void searchByAuthor(){
        System.out.println("Введите имя автора: ");
        String searchAuthor=scanner.nextLine();
        System.out.println("Найденные публикации автора: ");
        for(Publication s: publications){
            if(searchAuthor.equalsIgnoreCase(s.getAuthor())){
                System.out.println(s);
            } else if(!searchAuthor.equalsIgnoreCase(s.getAuthor())){
                continue;
            } else {
                System.out.println("Публикации данного автора не найдены.");
            }
        }
    }

    //4. Вывод количества публикаций
    public void getPublicationCounter() {
        System.out.println("Количество публикаций: "+publicationCounter);
    }

    //Валидация для числовых значений
    public int validInt(){
        while (true){
            try {
                int validInt=Integer.parseInt(scanner.nextLine());
                return validInt;
            } catch (NumberFormatException e){
                System.out.println("Введите число!");
            }
        }
    }
}
