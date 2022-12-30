package br.com.myCare.api.paciente;

import br.com.myCare.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record AtualizaCadastroPaciente(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco){
}
