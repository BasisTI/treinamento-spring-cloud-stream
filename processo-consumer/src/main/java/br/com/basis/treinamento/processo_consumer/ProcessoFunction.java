package br.com.basis.treinamento.processo_consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Function;

@Service
public class ProcessoFunction  implements Function<Processo, Notificacao> {

    private static Logger logger = LoggerFactory.getLogger(ProcessoFunction.class);

    @Override
    public Notificacao apply(Processo processo) {
        logger.info("Processo recebido ID: {}", processo.id());
        String mensagem = String.format("Processo recebido com ID: %s [tipo=%s] Requer atenção máxima!",
                processo.id(), processo.tipoProcesso());
        return new Notificacao(UUID.randomUUID(), mensagem, "RED ALERT!");
    }
}
