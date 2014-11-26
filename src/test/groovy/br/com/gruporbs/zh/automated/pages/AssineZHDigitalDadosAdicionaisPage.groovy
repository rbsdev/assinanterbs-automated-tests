package br.com.gruporbs.zh.automated.pages

import geb.Page

/**
 *
 * @author Robson_Farias
 */

class AssineZHDigitalDadosAdicionaisPage extends Page {
 
    static url = "/zhdigital/assine-zh-digital-dados-adicionais"
 
    static at = { $("p", class: "create-account complementary mobile").text() == "Dados Adicionais" }
 

}
