package school.sorokin.javacore;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library=new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("-------------");
            System.out.println("1. Добавить новую публикацию");
            System.out.println("2. Вывести список всех публикаций");
            System.out.println("3. Поиск публикации по автору");
            System.out.println("4. Вывести общее количество публикаций");
            System.out.println("0. Выход");

            int choice=validInt(scanner);

            if (choice < 5 && choice >= 0) {
                switch (choice) {
                    case 1:
                        boolean correctCreateChoise = true;

                        while (correctCreateChoise) {
                            System.out.println("Выберите тип публикации: ");
                            System.out.println("1. Книга");
                            System.out.println("2. Газета");
                            System.out.println("3. Журнал");

                            int createChoise =validInt(scanner);

                            if(createChoise>0&&createChoise<4){
                                switch (createChoise){
                                    case 1:
                                        System.out.println("Введите название книги: ");
                                        String createTitleBook=scanner.nextLine();

                                        System.out.println("Введите имя автора: ");
                                        String createAuthorBook=scanner.nextLine();

                                        System.out.println("Введите ISBN: ");
                                        String createIsbn=scanner.nextLine();

                                        System.out.println("Введите год публикации книги: ");
                                        int createYearBook=validInt(scanner);

                                        Publication book=new Book(createTitleBook, createAuthorBook, createYearBook, createIsbn);
                                        library.addPublication(book);

                                        correctCreateChoise=false;
                                        break;
                                    case 2:
                                        System.out.println("Введите название газеты: ");
                                        String createTitleNews=scanner.nextLine();

                                        System.out.println("Введите название издательства: ");
                                        String createAuthorNews=scanner.nextLine();

                                        System.out.println("Введите день недели публикации газеты: ");
                                        String createPublicationDay=scanner.nextLine();

                                        System.out.println("Введите год публикации газеты: ");
                                        int createYearNews=validInt(scanner);

                                        Publication newspaper=new Newspaper(createTitleNews, createAuthorNews, createYearNews, createPublicationDay);
                                        library.addPublication(newspaper);

                                        correctCreateChoise=false;
                                        break;
                                    case 3:
                                        System.out.println("Введите название журанала: ");
                                        String createTitleMagazine=scanner.nextLine();

                                        System.out.println("Введите название издательства: ");
                                        String createAuthorMagazine=scanner.nextLine();

                                        System.out.println("Введите номер выпуска: ");
                                        int createIssueNumber=validInt(scanner);

                                        System.out.println("Введите год публикации: ");
                                        int createYearMagazine=validInt(scanner);

                                        Publication magazine=new Magazine(createTitleMagazine, createAuthorMagazine, createYearMagazine,createIssueNumber);
                                        library.addPublication(magazine);

                                        correctCreateChoise=false;
                                        break;
                                }
                            } else {
                                System.out.println("Некорректный ввод. Попробуйте еще раз.");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Список всех публикаций: ");
                        for(Publication s : library.getPublications()) {
                            s.printDetails();
                        }
                        break;
                    case 3:
                        System.out.println("Введите имя автора: ");
                        String searchAuthor=scanner.nextLine();
                        library.searchByAuthor(searchAuthor);
                        break;
                    case 4:
                        library.getPublicationCounter();
                        break;
                    case 0:
                        System.out.println("До свидания!");
                        return;
                }
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
    }

    //Валидация для числовых значений
    public static int validInt(Scanner scanner){
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Введите число!");
            }
        }
    }
}
