package br.com.gruporbs.zh.automated.utils;


/**
 * Utilitário para CNPJ.
 * 
 * @author Marlon Silva Carvalho
 * @since 06/05/2010
 */
public final class CNPJUtility {

        private CNPJUtility() {}
        
        /**
         * Gerar um número de CNPJ válido.<br>
         * Um número de CNPJ que é vélido não significa que exista.
         * 
         * @return CNPJ gerado.
         */
        public static String generateCNPJ() {
                StringBuilder iniciais = new StringBuilder();
                Integer numero;
                for (int i = 0; i < 12; i++) {
                        numero = Integer.valueOf((int) (Math.random() * 10));
                        iniciais.append(numero.toString());
                }
                return iniciais.toString() + gerarDigitoVerificador(iniciais.toString());
        }

        /**
         * Dado um conjunto de 12 números, gerar um dígito verificador.
         * 
         * @param cnpj CNPJ com 12 números.
         * @return Dígito verificador.
         */
        public static String gerarDigitoVerificador(String cnpj) {
                return Modulo11.obterDVBase10(cnpj, false, 2);
        }
}