package br.com.gruporbs.zh.automated.pages

import geb.Page

/**
 *
 * @author Robson_Farias
 */

class AssineZHDigitalCadastroUsuarioAtivadoAssinante extends Page {
 
    static url = "/zhdigital/assine-zh-digital-cadastro-usuario-ativado-assinante"
 
    static at = { 
        title == "Assine ZH Digital" 
        oba.text() == "Identificamos que você já possui uma assinatura e um login" 
    }
 
    static content = { 
        oba { $("p", class: "title-28 center") }
    }
}
