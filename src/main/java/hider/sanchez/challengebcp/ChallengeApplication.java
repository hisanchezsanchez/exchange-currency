package hider.sanchez.challengebcp;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hibernate.annotations.SQLInsert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@Slf4j
@SpringBootApplication
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
        getPrimoAlReves(29);
    }


    /**
     * Escribir un algoritmo que muestre los N números primos de manera inversa. Por ejemplo,
     * si N vale 10 se mostrará en pantalla: 29, 23, 19, 17, 13, 11, 7, 5, 3, 2
     */
    private static void getPrimoAlReves(int numero) {
        try {
            ArrayList<Integer> primos = new ArrayList<>();
            for (int i = numero; i >= 1; i--) {
                if (esPrimo(i)) {
                    primos.add(i);
                }
            }

            val primosAlReves = primos.stream().unordered();
            primosAlReves.forEach(it -> log.info("numero primo {}", it));
        } catch (Exception e) {
            log.error("El numoer es unoperable", e.getMessage());
        }

    }

    private static boolean esPrimo(int numero) {
        if (numero == 0 || numero == 1 || numero == 4) return false;
        val resultado = numero % 2;
        return (resultado != 0);
    }



}
