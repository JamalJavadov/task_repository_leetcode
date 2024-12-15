import com.sun.jdi.VMOutOfMemoryException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Movie[] movies = new Movie[0];
        while (true){
            System.out.println("0 yazin programi sonlandirmaq ucun");
            System.out.println("1 yazin 3 eded film elave etmek ucun");
            System.out.println("2 yazin filmeri ve onun ratingini cap etmek ucun");
            System.out.println("3 yazin istediyiniz sayda film elave ede bilmek ucun");
            System.out.println("4 yazin max min filmlerini ve average ratingi ekrana cixarmaq ucun");
            System.out.println("5 yazin film adi daxil edib ratingini tapmaq ucun");
            System.out.println("6 yazin ratingini deyismek istediyiniz film ucun");
            System.out.println("7 yazin silmek istediyiniz film ucun");
            System.out.println("8 yazin filmleri artan sira ile ekrana cixarmaq ucn");
            int numberbyuser = scanner.nextInt();
            if (numberbyuser==0){
                break;
            }
            switch (numberbyuser) {
                case 1:
                    int z = movies.length;
                    movies = Arrays.copyOf(movies, movies.length + 3);
                    for (int i = z; i < movies.length; i++) {
                        System.out.println("Write point and name of film" + i);
                        double rateoffilm = scanner.nextDouble();
                        String nameofmovie = scanner.next();
                        Movie film = new Movie(nameofmovie, rateoffilm);
                        movies[i] = film;
                    }
                    break;
                case 2:
                    for (int i = 0; i < movies.length; i++) {
                        System.out.println("Film name " + movies[i].getName() + " Rate of Film " + movies[i].getRating());
                    }
                    break;
                case 3:
                    System.out.println("Ne qeder film elave etmek isterdiniz?");
                    int numberoffilm = scanner.nextInt();
                    int y = movies.length;
                    movies = Arrays.copyOf(movies, movies.length + numberoffilm);
                    for (int i = y; i < movies.length; i++) {
                        System.out.println("Write point and name of film" + i);
                        double rateoffilm = scanner.nextDouble();
                        String nameofmovie = scanner.next();
                        Movie film = new Movie(nameofmovie, rateoffilm);
                        movies[i] = film;
                    }
                    break;
                case 4:
                    double max = movies[0].getRating();
                    double min = movies[0].getRating();
                    String maxfilm = movies[0].getName();
                    String minfilm = movies[0].getName();
                    double averagerating = movies[0].getRating();

                    for (int i = 1; i < movies.length; i++) {
                        Movie film = movies[i];
                        if (max <= film.getRating()) {
                            max = film.getRating();
                            maxfilm = film.getName();
                        }
                        if (min >= film.getRating()) {
                            min = film.getRating();
                            minfilm = film.getName();
                        }
                        averagerating += film.getRating();
                    }
                    System.out.println("Maximum rating film budur " + maxfilm);
                    System.out.println("Minimum rating film budur " + minfilm);
                    System.out.println("Ortalam film rating " + averagerating / movies.length);
                    break;
                case 5:
                    System.out.println("Film adini daxil edin");
                    String filmfinder = scanner.next();

                    boolean lamp = true;
                    for (Movie film : movies) {
                        if (Objects.equals(filmfinder, film.getName())) {
                            System.out.println(film.getRating());
                            lamp=false;
                            break;
                        }
                    }
                    if (lamp){
                        System.out.println("axtardiginiz film burada yoxdur");
                    }
                    break;
                case 6:
                    System.out.println("Ratingini deyismek istediyiniz filmin adini daxil edin");
                    String changefilm = scanner.next();
                    boolean lamp2 = true;
                    for (int i = 0; i < movies.length; i++) {
                        if (Objects.equals(changefilm, movies[i].getName())) {
                            System.out.println("Deyisceyiniz ratingi daxil edin");
                            double changerating = scanner.nextDouble();
                            movies[i].setRating(changerating);
                            lamp2=false;
                            break;
                        }
                    }
                    if (lamp2){
                        System.out.println("yazdiginiz film burada yoxdur");
                    }
                    break;
                case 7:
                    boolean lamp3 = false;
                    System.out.println("silmek istediyiniz filmi yazin");
                    String deletefilm = scanner.next();
                    for (int i = 0; i < movies.length; i++) {
                        if (Objects.equals(deletefilm, movies[i].getName())) {
                            Movie helper = movies[i];
                            if (i+1<movies.length){
                                movies[i] = movies[i + 1];
                                movies[i + 1] = helper;
                            }

                            lamp3=true;
                        }
                    }
                    if (lamp3){
                        movies = Arrays.copyOf(movies, movies.length - 1);
                    }else {
                        System.out.println("silmek istediyiniz film burada yoxdur");
                    }

                    break;
                case 8:
                    double[] helperarray = new double[movies.length];
                    double[] reslutarray = new double[movies.length];


                    for (int p = 0; p < movies.length; p++) {
                        helperarray[p]=movies[p].getRating();
                    }
                    for (int k = 0; k < movies.length; k++) {
                        int index=0;
                        //help array siyahisinin icerrisini ratingler ile dolduraq
                        double minrate = helperarray[0];
                        //ilk once siyahinin icindeki en kicik ratingi tapaq
                        for (int i = 1; i < helperarray.length; i++) {
                            if (minrate>=helperarray[i]){
                                minrate=helperarray[i];
                                index = i;
                            }


                        }
                        reslutarray[k]=minrate;

                        //burda ise min i silmek islemini heyata kecirek
                        for (int i = index; i < helperarray.length-1 ; i++) {
                            double help  = helperarray[index];
                            helperarray[i]=helperarray[i+1];
                            helperarray[i+1]=help;
                        }
                        helperarray= Arrays.copyOf(helperarray,helperarray.length-1);


                    }
                    //burda cixanda resultarray icerisinde artiq siralanmis ratingler olur

                    // burda filmrateofmovies ona gore yaratdimki asagidaki forun icerisinde rate -1 elemek lazim
                    // gelende moviesin icindeki obyektleri deyismesin cunki 8 den sonra 2 yazanda hamisi -1 cixxir
                    // bunu elemeyimede sebeb odurki meselen iki film eyni ratingde olanda yalniz sirada qabaqda gelen
                    // filmin adini cixarmasin
                    double[] filmrateofmovies=new double[movies.length];
                    for (int i = 0; i < movies.length; i++) {
                        filmrateofmovies[i]=movies[i].getRating();
                    }
                    for (int i = 0; i < movies.length; i++) {
                        for (int j = 0; j < movies.length; j++) {
                            if (filmrateofmovies[j]==reslutarray[i]){
                                System.out.println(movies[j].getName()+" "+movies[j].getRating());
                                filmrateofmovies[j]=-1;
                                break;
                            }
                        }
                    }




                    break;
            }
        }
    }}