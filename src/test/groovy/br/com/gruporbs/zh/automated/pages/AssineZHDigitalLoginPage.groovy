package br.com.gruporbs.zh.automated.pages

import geb.Page

/**
 *
 * @author Robson_Farias
 */

class AssineZHDigitalLoginPage extends Page {
 
    static url = "/zhdigital/assine-zh-digital-login"
 
    static at = { title == "Assine ZH Digital" }
 
    static content = {
        usuario { $("#ctl00_cphZHDigital_username") }
        senha { $("#ctl00_cphZHDigital_password") }
        logar_e_continuar { $("#ctl00_cphZHDigital_lkbSubmitLogin")}
        
    }
}
