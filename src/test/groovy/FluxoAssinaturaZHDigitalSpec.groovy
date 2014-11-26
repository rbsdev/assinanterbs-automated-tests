
import br.com.gruporbs.zh.automated.utils.*
import br.com.gruporbs.zh.automated.pages.*
import geb.spock.GebSpec
import spock.lang.Ignore

/**
 *
 * @author Robson_Farias
 */
class FluxoAssinaturaZHDigitalSpec extends GebSpec {
    
    
    def "Deveria apresentar a tela de complemento de dados quando uma pessoa física com dados incompletos se autenticasse"() {
        given: "Entrei no cadastro para assinar ZH digital deslogado"
        to AssineZHDigitalCadastroPage
        
        expect: "Estar na página de cadastro do ZH digital"
        at AssineZHDigitalCadastroPage
        
        when: "clicar no link 'Já possuo conta no ZH'"
        ja_possuo_conta_no_zh.click()
        
        then: "deveria ir para pagina de autenticação"
        waitFor { at AssineZHDigitalLoginPage }


        when: "Preencher os dados de autenticação" //TODO: automatizar a criação de um novo usuário ?!
        usuario.value("dados_incompletos")
        senha.value("asdfasdf")
        
        and: "clicar no botão de LogIn"
        logar_e_continuar.click()
        
        then: "estar na página para complemento de dados"
        waitFor { at AssineZHDigitalDadosAdicionaisPage }

        
    }
    
    
    def "Pessoa jurídica que ainda não tem o produto, quando se autenticar não deveria ir para a página de cadastro novamente." () {
        given: "Entrei no cadastro para assinar ZH digital deslogado"
        to AssineZHDigitalCadastroPage
        
        expect: "Estar na página de cadastro do ZH digital"
        at AssineZHDigitalCadastroPage
        
        when: "clicar no link 'Já possuo conta no ZH'"
        ja_possuo_conta_no_zh.click()
        
        then: "deveria ir para pagina de autenticação"
        waitFor { at AssineZHDigitalLoginPage }


        when: "Preencher os dados de autenticação" //TODO: automatizar a criação de um novo usuário ?!
        usuario.value("juan")
        senha.value("asdfasdf")
        
        and: "clicar no botão de LogIn"
        logar_e_continuar.click()
        
        then: "Deveria ir para pagina de pagamento"
        waitFor { at AssineZHDigitalPagamentoCartaoCreditoPage }
 
    }
    
    def "Pessoa física que ainda não tem o produto, quando se autenticar não deveria ir para a página de cadastro novamente." () {
        given: "Entrei no cadastro para assinar ZH digital deslogado"
        to AssineZHDigitalCadastroPage
        
        expect: "Estar na página de cadastro do ZH digital"
        at AssineZHDigitalCadastroPage
        
        when: "clicar no link 'Já possuo conta no ZH'"
        ja_possuo_conta_no_zh.click()
        
        then: "deveria ir para pagina de autenticação"
        waitFor { at AssineZHDigitalLoginPage }


        when: "Preencher os dados de autenticação" //TODO: automatizar a criação de um novo usuário ?!
        usuario.value("guinazu")
        senha.value("asdfasdf")
        
        and: "clicar no botão de LogIn"
        logar_e_continuar.click()
        
        then: "Deveria ir para pagina de pagamento"
        waitFor { at AssineZHDigitalPagamentoCartaoCreditoPage }
 
    }
    
        def "Pessoa física que tem o produto, quando se autenticar, deveria ir para pagina de feedback." () {
        given: "Entrei no cadastro para assinar ZH digital deslogado"
        to AssineZHDigitalCadastroPage
        
        expect: "Estar na página de cadastro do ZH digital"
        at AssineZHDigitalCadastroPage
        
        when: "clicar no link 'Já possuo conta no ZH'"
        ja_possuo_conta_no_zh.click()
        
        then: "deveria ir para pagina de autenticação"
        waitFor { at AssineZHDigitalLoginPage }


        when: "Preencher os dados de autenticação" //TODO: automatizar a criação de um novo usuário ?!
        usuario.value("outrousuario")
        senha.value("asdfasdf")
        
        and: "clicar no botão de LogIn"
        logar_e_continuar.click()
        
        then: "Deveria ir para pagina de feedback"
        waitFor { at AssineZHDigitalCadastroUsuarioAtivadoAssinante }
 
    }

    
    def "Cria cadastro pessoa juridica e compra com cartão de crédito" () {
        given: "Entrei no cadastro para assinar ZH digital como PJ"
        to AssineZHDigitalCadastroPJPage
        
        expect: "Estar na página de cadastro do ZH digital para pessoa jurídica"
        at AssineZHDigitalCadastroPJPage

        when: "Preencher todos os campos corretamente"
        razao_social.value("Geb PJ")
        cnpj.value(new CNPJUtility().generateCNPJ())
        inscricao_estadual.value("1111111111")

        nome_responsavel.value("Geb PJ")
        ddd.value("51")
        telefone.value("92719596")
        email.value("automated_test_pj@gruporbs.com.br")
     
        usuario.value(TestUtility.userNameGenerator( (('A'..'Z')+('0'..'9')).join(), 9 ))
        senha.value("asdfasdf")
        confirmacao_senha.value("asdfasdf")
       
        js.exec("\$('input[id\$=aceito_termos]').val(1);")
       
        and: "Clicar no botão para criar a conta e continuar"
        criar_conta_e_continuar.click()
        
        
        then: "Deveria ir para pagina de pagamento"
        waitFor { at AssineZHDigitalPagamentoCartaoCreditoPage }
 
        when: "Preencher os dados de pagamento"
        numero_cc.value("4790247287200250")
        nome_titular_cc.value("Automated test name")
        mes_validade_cc.click()
        selecao_mes_validade_cc.click()
        ano_validade_cc.click()
        selecao_ano_validade_cc.click()

        and: "clicar no botão 'Aproveitar meus 30 dias grátis'"
        aproveitar_meus_30_dias_gratis.click()

        then: "Compra deve ser concluida com sucesso"
        waitFor { at AssineZHDigitalUsuarioNaoAtivado }
         
    }
    
    
    def "Cria cadastro pessoa fisica e compra com cartão de crédito" () {
        given: "Entrei no cadastro para assinar ZH digital"
        to AssineZHDigitalCadastroPage
        
        expect: "Estar na página de cadastro do ZH digital"
        at AssineZHDigitalCadastroPage

        when: "Preencher todos os campos corretamente"
        nome.value("Geb")
        sobrenome.value("Automated Test")
        email.value("automated_test@gruporbs.com.br")
        cpf.value(new CPFUtility().generateCPF())
        ddd.value("51")
        telefone.value("92719596")
        usuario.value(TestUtility.userNameGenerator( (('A'..'Z')+('0'..'9')).join(), 9 ))
        senha.value("asdfasdf")
        confirmacao_senha.value("asdfasdf")
        data_nascimento.value("13051987")
        termos_de_uso.click()
       
        and: "Clicar no botão para criar a conta e continuar"
        criar_conta_e_continuar.click()
        
        
        then: "Deveria ir para pagina de pagamento"
        waitFor { at AssineZHDigitalPagamentoCartaoCreditoPage }
 
        when: "Preencher os dados de pagamento"
        numero_cc.value("4790247287200250")
        nome_titular_cc.value("Automated test name")
        mes_validade_cc.click()
        selecao_mes_validade_cc.click()
        ano_validade_cc.click()
        selecao_ano_validade_cc.click()

        and: "clicar no botão 'Aproveitar meus 30 dias grátis'"
        aproveitar_meus_30_dias_gratis.click()

        then: "Compra deve ser concluida com sucesso"
        waitFor { at AssineZHDigitalUsuarioNaoAtivado }
         
    }

}