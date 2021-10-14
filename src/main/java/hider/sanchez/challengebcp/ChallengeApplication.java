package hider.sanchez.challengebcp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
        primos(29);
    }


    /**
     * Escribir un algoritmo que muestre los N números primos de manera inversa. Por ejemplo,
     * si N vale 10 se mostrará en pantalla: 29, 23, 19, 17, 13, 11, 7, 5, 3, 2
     */
    public static void primos(int numero){
        List<String> myList = new ArrayList<String>();
        int c = 1;
        int p = 2;
        int d = 2;
        while (c <= numero) {
            if (p % d == 0) {
                if (p == d) {
                    myList.add(String.valueOf(p));
                    c++;
                }
                d = 2;
                p++;
            }
            else
                d++;
        }
        for (int i=myList.size()-1;i >= 0;i--) {
            System.out.print(myList.get(i) + ",");
        }
    }


}
