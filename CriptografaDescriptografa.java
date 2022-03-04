package CodificationDecodification;

import java.util.Random;

public class CriptografaDescriptografa {

    private int quantidadeDeLixoPoQuadrante = -1;
    
    private int sinalParaOCalculo;
    private int numeroDoCalculo;

    private String palavraCodificada = "";
    private String textoDecodificado = "";

    //147 caracteres
    /**
     * Atributo criado para ser utiizado como base para os calculos da criptografia
     */
    private char listaDeCaracteres[] = new char[]{'\"','&','{','<','!','(','°','%','z','*',
            'J','§','u','n','E','T','6','\'','ï','?',
            'ë','4','Ä','y','/',':',' ','G','5','S',
            '$','8','´','a','ì','Ã','o','2','R','i',
            'g','Ò','0','K','D','b','ý',')','Ñ','û',
            'ã','Z','j','}','Q','s','3','+','H','V',
            'Ô','C','1','[','I','X','B','q','è','\\',
            'N','9','A','É','¨','î','U','ÿ',']','>',
            'Á','h','Y','7','e','t','d','ê','¬','F',
            'Í','v','`','È','Ý','º','Ù','Â','M','x',
            'Ê','í','ö','à','ú','|','m','f','ñ','.',
            'Ë','ô','c','À','r','Ï','P',',','L','õ',
            ';','ó','â','=','p','k','Ú','é','ä','ù',
            'á','Ó','l','ò','Ü','-','O','#','Ì','ü',
            'Î','Û','ª','Õ','Ö','_','ç'};

    public String DecodificaTexto(String textoCodificado){

        String textoDecodificadoo;

        int lixoPasso = PosicaoDoCaracterNoVetor(textoCodificado.charAt(0));

        int sinal = 0;
        int NumeroCalculo = 0;

        if(lixoPasso == 2){
            sinal = PosicaoDoCaracterNoVetor(textoCodificado.charAt(3));
            NumeroCalculo = PosicaoDoCaracterNoVetor(textoCodificado.charAt(6));
        }

        else if(lixoPasso == 3){
            sinal = PosicaoDoCaracterNoVetor(textoCodificado.charAt(4));
            NumeroCalculo = PosicaoDoCaracterNoVetor(textoCodificado.charAt(8));
        }

        else if(lixoPasso == 4){
            sinal = PosicaoDoCaracterNoVetor(textoCodificado.charAt(5));
            NumeroCalculo = PosicaoDoCaracterNoVetor(textoCodificado.charAt(10));
        }

        else if(lixoPasso == 5){
            sinal = PosicaoDoCaracterNoVetor(textoCodificado.charAt(6));
            NumeroCalculo = PosicaoDoCaracterNoVetor(textoCodificado.charAt(12));
        }

        textoDecodificadoo = this.VerificaPalavraPelaChave(lixoPasso, sinal, NumeroCalculo, textoCodificado);
        return textoDecodificadoo;
    }

    /**
     *  METODO Criado para chamas os processos fragmentados em outro metodos
     *  onde recebe como parametro @param textoParaCriptografar um texto para criptografar
     *  e retorna a frase já codificada @return
     */
    public String CodificaTexto(String textoParaCriptografar){

        /**
         * Quantidade de lixo, serve para setar o passo, ou salto de caracteres
         */
        int quantidadeDeLixoQuadrante = this.VerificaQuadranteESetaQauntidadeDeLixo(this.PosicaoDoCaracterNoVetor(textoParaCriptografar.charAt(0)));

        /**
         * Sinal Para o Calculo, atravez dele saberá se soma ou subtrai
         */
        int sinalDoCalculo = SetaSinalENumero(textoParaCriptografar);

        int valorCalculado = this.numeroDoCalculo;

        int calculaChaveTamanhoTotal = ( 1 + quantidadeDeLixoQuadrante) * 3;

        char recebeCaractere;

        this.palavraCodificada = "";
        int controladorLoopFor1;
        int controladorLoopFor2;
        int controladorLoopFor3;
        int controladorLoopFor4;

        /**
         * For criado para criação da chave apenas
         */
        for (controladorLoopFor1 = 0; controladorLoopFor1 <calculaChaveTamanhoTotal; controladorLoopFor1++){

            if(controladorLoopFor1 == 0){
                this.palavraCodificada = this.palavraCodificada + listaDeCaracteres[quantidadeDeLixoQuadrante];
            }
            else {

                if( (calculaChaveTamanhoTotal == 9) && (controladorLoopFor1 == 3) ) {
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[sinalDoCalculo];
                }
                else if( (calculaChaveTamanhoTotal == 9) && (controladorLoopFor1 == 6) ) {
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[valorCalculado];
                }
                else if( (calculaChaveTamanhoTotal == 12) && (controladorLoopFor1 == 4) ) {
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[sinalDoCalculo];
                }
                else if( (calculaChaveTamanhoTotal == 12) && (controladorLoopFor1 == 8) ) {
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[valorCalculado];
                }
                else if( (calculaChaveTamanhoTotal == 15) && (controladorLoopFor1 == 5) ) {
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[sinalDoCalculo];
                }
                else if( (calculaChaveTamanhoTotal == 15) && (controladorLoopFor1 == 10) ) {
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[valorCalculado];
                }
                else if( (calculaChaveTamanhoTotal == 18) && (controladorLoopFor1 == 6) ) {
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[sinalDoCalculo];
                }
                else if( (calculaChaveTamanhoTotal == 18) && (controladorLoopFor1 == 12) ) {
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[valorCalculado];
                }
                else{
                    this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[this.SetaCaracterOuNumeroAleatorio(147, 0)];
                }
            }
        }

        /**
         * For para criptografar a palavra
         */
        for (controladorLoopFor2 = 0; controladorLoopFor2 < textoParaCriptografar.length(); controladorLoopFor2++) {

            recebeCaractere = textoParaCriptografar.charAt(controladorLoopFor2);

            for (controladorLoopFor3 = 0; controladorLoopFor3 < this.listaDeCaracteres.length; controladorLoopFor3++) {

                if (recebeCaractere == this.listaDeCaracteres[controladorLoopFor3]){

                    if (((sinalDoCalculo >= 0) && (sinalDoCalculo <= 32) ) || ((sinalDoCalculo >= 73) && (sinalDoCalculo <= 104)) ) {

                        this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[controladorLoopFor3 + valorCalculado];

                        for (controladorLoopFor4 = 0; controladorLoopFor4 < quantidadeDeLixoQuadrante; controladorLoopFor4++) {

                            int valorAleatorio = this.SetaCaracterOuNumeroAleatorio(147, 0);
                            this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[valorAleatorio];
                        }
                    }
                    else if (((sinalDoCalculo > 32) && (sinalDoCalculo < 73)) || ((sinalDoCalculo > 104) && (sinalDoCalculo < listaDeCaracteres.length))) {

                        this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[controladorLoopFor3 - valorCalculado];

                        for (controladorLoopFor4 = 0; controladorLoopFor4 < quantidadeDeLixoQuadrante; controladorLoopFor4++) {

                            int valorAleatorio = this.SetaCaracterOuNumeroAleatorio(147, 0);
                            this.palavraCodificada = this.palavraCodificada + this.listaDeCaracteres[valorAleatorio];
                        }
                    }
                }
            }
        }
        return this.palavraCodificada;
    }

    private String VerificaPalavraPelaChave(int lixo, int sinal, int NumeroBase, String texoCodificado) {

        int calculaInicioDoPrimeiroLoop = (1 + lixo) * 3;
        int controladorLoop;
        char caractereParaAnalise;

        int controleLoopFor;
        int salto = lixo + 1;

        for (controladorLoop = calculaInicioDoPrimeiroLoop; controladorLoop < texoCodificado.length() ; controladorLoop += salto )  {

            caractereParaAnalise = texoCodificado.charAt(controladorLoop);

            for(controleLoopFor = 0; controleLoopFor < this.listaDeCaracteres.length; controleLoopFor ++){

                if (caractereParaAnalise == this.listaDeCaracteres[controleLoopFor]) {

                    if (((sinal >= 0) && (sinal <= 32)) || ((sinal >= 73) && (sinal <= 104))) {

                        this.textoDecodificado += this.listaDeCaracteres[controleLoopFor - NumeroBase];
                    }
                    else if (((sinal > 32) && (sinal < 73)) || ((sinal > 104) && (sinal <= 146))) {

                        this.textoDecodificado += this.listaDeCaracteres[controleLoopFor + NumeroBase];
                    }

                    controleLoopFor = 2000;
                }
            }

        }

        //System.out.println("\n\n\nTEXTO DECODIFICADO : " + this.textoDecodificado);
        return this.textoDecodificado;
    }

    /**
     *   Metodo responsavel em escolher um numero ramdomico, que servirá para geralmente para acrescentar
     *   lixo .
     * @param Min
     * @param soma
     * @return
     */
    private int SetaCaracterOuNumeroAleatorio(int Min, int soma){

        Random aleatorio = new Random();
        int recebeAleatorio = aleatorio.nextInt(Min) + soma;

        return recebeAleatorio;
    }

    /**
     *     Verifica a posicao do caractere dentro do vetor de caracteres listados como base
     * @param charASerVerificada
     * @return
     */
    private int PosicaoDoCaracterNoVetor(char charASerVerificada){

        int controleLoop;
        int posicaoDoCaractere = -1;

        for(controleLoop = 0; controleLoop <= this.listaDeCaracteres.length; controleLoop++){
            if(charASerVerificada == listaDeCaracteres[controleLoop]){
                posicaoDoCaractere = controleLoop;
                controleLoop = 200;
            }
        }
        return posicaoDoCaractere;
    }

    /**
     *     Seta a quantidade de lixo baseado na primeira letra da palavra verificada, e retorna a quantidade
     * @param posicaoDoCharNoVetor
     * @return
     */
    private int VerificaQuadranteESetaQauntidadeDeLixo (int posicaoDoCharNoVetor){

        if((posicaoDoCharNoVetor >= 0) && (posicaoDoCharNoVetor <= 32)){
            this.quantidadeDeLixoPoQuadrante = 3;
        }
        else if((posicaoDoCharNoVetor > 32) && (posicaoDoCharNoVetor <= 73)){
            this.quantidadeDeLixoPoQuadrante = 5;
        }
        else if((posicaoDoCharNoVetor > 73) && (posicaoDoCharNoVetor <= 104)){
            this.quantidadeDeLixoPoQuadrante = 2;
        }
        else if((posicaoDoCharNoVetor > 73) && (posicaoDoCharNoVetor <= 146)){
            this.quantidadeDeLixoPoQuadrante = 4;
        }

        return this.quantidadeDeLixoPoQuadrante;
    }

    /**
     *      Responsavel em setar o sinal e nuemro de base para o calculo
     * @param verificaPalavra
     * @return
     */
    private int SetaSinalENumero (String verificaPalavra) {

        boolean verificado = false;

        int controlaLoopPalavra;
        int controlaLoopVetor;

        char receceLetraDaPalavra;

        int recebeAleatorioSinal;
        int recebeAleatorioNumero;

        /**
         * entra no while para pelo menos uma verificação
         */
        while (verificado == false){

            /**
             * Dois numero recebido de forma aleatoria, o primeiro é para o calculo
             * o segundo como sinal
             */
            recebeAleatorioNumero = this.SetaCaracterOuNumeroAleatorio(14, 1);
            recebeAleatorioSinal = this.SetaCaracterOuNumeroAleatorio(147, 0);



            //For na quantidade da palavra recebida como parametro
            for (controlaLoopPalavra = 0; controlaLoopPalavra < verificaPalavra.length(); controlaLoopPalavra++) {

                //recebe caractere por caractere para ser analizado
                receceLetraDaPalavra = verificaPalavra.charAt(controlaLoopPalavra);

                //for pela quantidade de caractere da lista de verificação
                for (controlaLoopVetor = 0; controlaLoopVetor < this.listaDeCaracteres.length; controlaLoopVetor++) {

                    //Se a letra for igual a da list na posicao do loop entr aqui
                    if (receceLetraDaPalavra == this.listaDeCaracteres[controlaLoopVetor]) {

                        /**
                         * Aqui funciona da seguinte forma, se o valor aleatorio for menor que 0 ou maior do que a quantidade de elemento da
                         * lista de base, se for, ele reinicia todo o processo de verificação dos caracteres
                         */
                        if ( ( (controlaLoopVetor + recebeAleatorioNumero) > this.listaDeCaracteres.length) || ( (controlaLoopVetor - recebeAleatorioNumero) < 0) ) {

                            controlaLoopVetor = 2000;
                            controlaLoopPalavra = 2000;
                            this.sinalParaOCalculo = 5000;
                            this.numeroDoCalculo = 5000;
                        }
                        else if( ( (controlaLoopVetor + recebeAleatorioNumero) < this.listaDeCaracteres.length) && ( (controlaLoopVetor - recebeAleatorioNumero) >= 0 ) ){

                            this.sinalParaOCalculo = recebeAleatorioSinal;
                            this.numeroDoCalculo = recebeAleatorioNumero;
                            controlaLoopVetor = 2000;

                        }
                    }
                }
            }
            if((this.sinalParaOCalculo == 5000) || (this.numeroDoCalculo == 5000)){
                verificado = false;
            }
            else if((this.sinalParaOCalculo != 5000) && (this.numeroDoCalculo != 5000)) {
                verificado = true;
            }
        }
        return this.sinalParaOCalculo;
    }
}
