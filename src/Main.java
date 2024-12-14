import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Movie[] movies = new Movie[0];
        while (true){
            System.out.println("0 ve yaxud 1 ve yaxud 2 ve yaxud 3 ve yaxud diger reqemler daxil edin");
            int numberbyuser = scanner.nextInt();
            if (numberbyuser==0){
                break;
            }else if(numberbyuser==1){
                int z = movies.length;
                movies = Arrays.copyOf(movies,movies.length+3);
                for (int i=z; i < movies.length; i++) {
                    System.out.println("Write point and name of film"+i);
                    double rateoffilm = scanner.nextDouble();
                    String nameofmovie = scanner.nextLine();
                    Movie film = new Movie(nameofmovie,rateoffilm);
                    movies[i]=film;
                }
            }
            else if(numberbyuser==2){
                for (int i = 0; i < movies.length; i++) {
                    System.out.println("Film name "+movies[i].getName()+" Rate of Film "+movies[i].getRating());
                }
            }else if(numberbyuser==3){
                System.out.println("Ne qeder film elave etmek isterdiniz?");
                int numberoffilm=scanner.nextInt();
                int z = movies.length;
                movies = Arrays.copyOf(movies,movies.length+numberoffilm);
                for (int i = z; i < movies.length ; i++) {
                    System.out.println("Write point and name of film"+i);
                    double rateoffilm = scanner.nextDouble();
                    String nameofmovie = scanner.next();
                    Movie film = new Movie(nameofmovie,rateoffilm);
                    movies[i]=film;
                }

            } else if (numberbyuser==4) {
                double max= 0;
                double min = 10;
                String maxfilm ="";
                String minfilm="";
                double averagerating=0;

                for (int i =0;i<movies.length;i++){
                    Movie film = movies[i];
                    if (max<=film.getRating()){
                        max=film.getRating();
                        maxfilm=film.getName();
                    }
                    if (min>=film.getRating()){
                        min= film.getRating();
                        minfilm=film.getName();
                    }
                    averagerating+=film.getRating();
                }
                System.out.println("Maximum rating film budur "+maxfilm);
                System.out.println("Minimum rating film budur "+minfilm);
                System.out.println("Ortalam film rating "+averagerating/movies.length);

            }else if(numberbyuser==5){
                System.out.println("Film adini daxil edin");
                String filmfinder = scanner.next();
                System.out.println(filmfinder);

                for (Movie film : movies){
                    System.out.println(film.getName());
                    if (Objects.equals(filmfinder,film.getName())){
                        System.out.println(film.getRating());
                    }else {
                        System.out.println("Film Tapilmadi");
                    }
                }
            }else if(numberbyuser==6){
                System.out.println("Ratingini deyismek istediyiniz filmin adini daxil edin");
                String changefilm= scanner.next();
                for (int i = 0;i<movies.length;i++){
                    if (Objects.equals(changefilm,movies[i].getName())){
                        System.out.println("Deyisceyiniz ratingi daxil edin");
                        double changerating = scanner.nextDouble();
                        movies[i].setRating(changerating);
                    }else{
                        System.out.println("Film tapilmadi");
                    }
                }
            } else if (numberbyuser==7) {
                System.out.println("silmek istediyiniz filmi yazin");
                String deletefilm = scanner.next();
                for (int i = 0; i < movies.length-1; i++) {
                    if (Objects.equals(deletefilm,movies[i].getName())){
                        Movie helper = movies[i];
                        movies[i]=movies[i+1];
                        movies[i+1]=helper;
                    }
                }
                movies= Arrays.copyOf(movies,movies.length-1);
            } else if (numberbyuser==8) {
                double[] forsorting= new double[movies.length];
                for (int i = 0; i < movies.length; i++) {
                    forsorting[i]=movies[i].getRating();
                }
                Arrays.sort(forsorting);
                for (int i = 0; i < movies.length; i++) {
                    for(Movie film : movies){
                        if (film.getRating()==forsorting[i]){
                            System.out.println((i+1)+"Film name "+film.getName()+" Film Rating "+ film.getRating());
                        }
                    }
                }
            }

        }
    }
    }
