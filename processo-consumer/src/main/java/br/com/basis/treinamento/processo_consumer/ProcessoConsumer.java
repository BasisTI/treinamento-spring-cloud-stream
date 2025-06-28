package br.com.basis.treinamento.processo_consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ProcessoConsumer implements Consumer<Processo> {

    private static final Logger log =
            LoggerFactory.getLogger(ProcessoConsumer.class);


    @Override
    public void accept(Processo processo) {
        log.info("Processo recebido: ID={}, tipo={}, detalhes={}",
                processo.id(), processo.tipoProcesso(), processo.detalhes());
    }
}
