package br.com.basis.treinamento.processo_producer;

import java.util.UUID;

public record Processo(UUID id, String tipoProcesso, String detalhes) {
}
