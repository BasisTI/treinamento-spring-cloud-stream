package br.com.basis.treinamento.processo_consumer;

import java.util.UUID;

public record Notificacao(UUID id, String mensagem, String nivel) {
}
