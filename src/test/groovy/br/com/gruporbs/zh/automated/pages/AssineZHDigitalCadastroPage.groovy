package br.com.gruporbs.zh.automated.pages

import geb.Page

/**
 *
 * @author Robson_Farias
 */

class AssineZHDigitalCadastroPage extends Page {
 
    static url = "/zhdigital/assine-zh-digital-cadastro"
 
    static at = { title == "Assine ZH Digital" }
 
    static content = {
        
        nome { $("#ctl00_cphZHDigital_name") }
        sobrenome { $("#ctl00_cphZHDigital_last") }
        email { $("#ctl00_cphZHDigital_email") }
        cpf { $("#ctl00_cphZHDigital_cpf") }
        ddd { $("#ctl00_cphZHDigital_ddd") }
        telefone { $("#ctl00_cphZHDigital_phone_number") }
        usuario {  $("#ctl00_cphZHDigital_username") }
        senha { $("#ctl00_cphZHDigital_password") }
        confirmacao_senha { $("#ctl00_cphZHDigital_password_c") }
        data_nascimento { $("#ctl00_cphZHDigital_date") }
        termos_de_uso { $("#aceito-validacao")[0] }
        criar_conta_e_continuar { $("#ctl00_cphZHDigital_lkbSubmit") } 
        ja_possuo_conta_no_zh { $("a", class: "has-account") }
       
    }
}
