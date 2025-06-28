package br.com.basis.treinamento.processo_producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProcessoResource {

    private final StreamBridge streamBridge;
    private static final Logger log = LoggerFactory.getLogger(ProcessoResource.class);
    public ProcessoResource(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping("/processos")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void enviaProcesso(@RequestBody ProcessoRequest processo){
        Processo novoProcesso = new Processo(UUID.randomUUID(),
                processo.tipoProcesso(), processo.detalhes());
        log.info("Enviando processo: {}", novoProcesso);
        streamBridge.send("processoProducer-out-0", novoProcesso);
    }
}
