package com.infoprice.teste.modules.pessoa.service;

import com.infoprice.teste.modules.comum.exception.ValidacaoException;
import com.infoprice.teste.modules.pessoa.model.Pessoa;
import com.infoprice.teste.modules.pessoa.repository.PessoaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.infoprice.teste.helper.TestsHelper.umaPessoa;
import static com.infoprice.teste.helper.TestsHelper.umaPessoaDadosIncompletos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PessoaServiceTest {

    @Autowired
    private PessoaService service;
    @MockBean
    private PessoaRepository repository;

    @Before
    public void setup() {
        when(repository.save(any(Pessoa.class))).then(AdditionalAnswers.returnsFirstArg());
    }

    @Test
    public void save_deveSalvar_seDadosValidos() {
        assertThat(service.save(umaPessoa()))
                .extracting("id", "nome", "cpf")
                .containsExactly(100, "Fulano", "12343245612");
    }

    @Test
    public void save_naoDeveSalvar_disparaException() {
        assertThatThrownBy(() -> service.save(umaPessoaDadosIncompletos()))
                .isInstanceOf(ValidacaoException.class)
                .hasMessage("Dados incompletos.");
    }

}