package br.com.gruporbs.zh.automated.pages

import geb.Page

/**
 *
 * @author Robson_Farias
 */
class AssineZHDigitalPagamentoCartaoCreditoPage extends Page {
    static at = { 
        title == "Assine ZH Digital" 
        titulo_pagamento.text() == "Forma de Pagamento"
    }
 
    static content = {
        titulo_pagamento { $("p", class:"payment-type mobile") }
        numero_cc { $("#ctl00_cphZHDigital_creditCardNumber") }
        nome_titular_cc { $("#ctl00_cphZHDigital_creditCardName") }
        mes_validade_cc { $("b", 0, class:"button") }
        selecao_mes_validade_cc { $("ul", 0) }
        ano_validade_cc { $("b", 1, class:"button") }
        selecao_ano_validade_cc { $("ul", 1) }
        aproveitar_meus_30_dias_gratis { $("#ctl00_cphZHDigital_lkbSubmit")  }
    }
}

