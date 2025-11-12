package school.sorokin.javacore;

public class Main {
    public static void main(String[] args) {
        Library library=new Library();

        boolean correctChoise=true;

        while (correctChoise) {
            System.out.println("Выберите действие:");
            System.out.println("-------------");
            System.out.println("1. Добавить новую публикацию");
            System.out.println("2. Вывести список всех публикаций");
            System.out.println("3. Поиск публикации по автору");
            System.out.println("4. Вывести общее количество публикаций");
            System.out.println("0. Выход");

            int choice=library.validInt();

            if (choice < 5 && choice >= 0) {
                switch (choice) {
                    case 1:
                        library.createPublications();
                        break;
                    case 2:
                        library.listPublications();
                        break;
                    case 3:
                        library.searchByAuthor();
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
}
