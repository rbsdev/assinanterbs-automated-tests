package br.com.gruporbs.zh.automated.pages

import geb.Page

/**
 *
 * @author Robson_Farias
 */

class AssineZHDigitalCadastroPJPage extends Page {
 
    static url = "/zhdigital/assine-zh-digital-cadastro-pj"
 
    static at = { title == "Assine ZH Digital" }
 
    static content = {
        
        razao_social { $("#ctl00_cphZHDigital_razao") }
        cnpj { $("#ctl00_cphZHDigital_cnpj") }
        inscricao_estadual { $("#ctl00_cphZHDigital_inscricao_estadual") }
        nome_responsavel { $("#ctl00_cphZHDigital_responsavel") }
        ddd { $("#ctl00_cphZHDigital_ddd") }
        telefone { $("#ctl00_cphZHDigital_phone_number") }
        email { $("#ctl00_cphZHDigital_email") }
        usuario {  $("#ctl00_cphZHDigital_username") }
        senha { $("#ctl00_cphZHDigital_password") }
        confirmacao_senha { $("#password_c") }
        termos_de_uso { $("input", class: "checkbox-button") }
        criar_conta_e_continuar { $("#ctl00_cphZHDigital_lkbSubmit") } 
       
    }
}
