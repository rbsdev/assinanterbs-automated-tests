package br.com.gruporbs.zh.automated.pages

import geb.Page

/**
 *
 * @author Robson_Farias
 */
class AssineZHDigitalUsuarioNaoAtivado extends Page {
    
    static at = {
        texto_agradecimento.text() == "Obrigado!"
        tipo_pagamento.text() == "Cartão de Crédito"
    }
    
    static content = { 
        texto_agradecimento { $("p", class:"title-65 center txt-color-blue") }
        tipo_pagamento { $("div", class:"forma").find('span') } 
    }
}

