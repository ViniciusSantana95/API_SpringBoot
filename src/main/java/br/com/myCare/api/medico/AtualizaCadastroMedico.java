package br.com.myCare.api.medico;

import br.com.myCare.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record AtualizaCadastroMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
