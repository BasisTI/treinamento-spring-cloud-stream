package br.com.basis.treinamento.processo_consumer;


import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Demonstração de interfaces funcionais
 * Escolhemos criar como testes unitários para facilitar o uso
 * (Só clicar no "play" na IDE)
 */
public class InterfaceFuncionalTest {

    // Criar um Consumer implementando explicitamente a interface
    @Test
    public void testConsumer() {
        Consumer<String> imprimirMensagem = new Consumer<String>() {

            @Override
            public void accept(String mensagem) {
                System.out.println("LOG: " + mensagem.toUpperCase());
            }
        };
    }

    // Criar um Consumer usando Lambda
    @Test
    public void testConsumerLambda() {
        Consumer<String> imprimirMensagem =
                mensagem -> System.out.println("LOG: " + mensagem.toUpperCase());
        // Agora, vamos usar nosso Consumer!
        imprimirMensagem.accept("olá, mundo!");
        imprimirMensagem.accept("spring cloud stream é incrível");
    }

    @Test
    public void testProducer() {
        Supplier<Integer> geradorDeId = () -> new Random().nextInt(1000);
        System.out.println(geradorDeId.get());
        System.out.println(geradorDeId.get());
        System.out.println(geradorDeId.get());
        System.out.println(geradorDeId.get());
    }

    @Test
    public void testFunction() {
        Function<Integer, String> funcionario =
                integer -> "O valor é: " + integer.toString();
        System.out.println(funcionario.apply(150));
    }

}
