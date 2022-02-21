import java.util.Scanner;

public class exer_001{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o caractere * e espaços. A base e altura da escada devem ser iguais ao valor de n. A última linha não deve conter nenhum espaço.");

        System.out.printf("Digite o tamanho da escada: ");

        int n=scan.nextInt();

        String[] cont=new String[n];

        for(int base=0; base<cont.length; base++){

            if(base==0){

                cont[base]="*";
                System.out.printf(cont[base]+"\n");

            }else if(base>0){

                cont[base]=cont[base-1]+"*";   
                System.out.printf(cont[base]+"\n");
                
            }

        }

        System.out.printf("Vamos fazer uma mais moderna?\n");

        System.out.printf("Digite o tamanho da escada: ");

        n=scan.nextInt();

        String[] cont1=new String[n+2];

        for(int base=0; base<n+1; base++){

            for(int index=n+1; index>0; index--){
                
                if(index>=n){
                    cont1[index]=" ";
                }else if(index<n){
                    cont1[index]=cont1[index+1]+" "; 
                }

            }

            if(base!=0){
                System.out.printf(cont1[base]+"- \n");
            }

        }

        System.out.println("Débora se inscreveu em uma rede social para se manter em contato com seus amigos. A página de cadastro exigia o preenchimento dos campos de nome e senha, porém a senha precisa ser forte. O site considera uma senha forte quando ela satisfaz os seguintes critérios:\nPossui no mínimo 6 caracteres.\nContém no mínimo 1 digito.\nContém no mínimo 1 letra em minúsculo.\nContém no mínimo 1 letra em maiúsculo.\nContém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+\nDébora digitou uma string aleatória no campo de senha, porém ela não tem certeza se é uma senha forte. Para ajudar Débora, construa um algoritmo que informe qual é o número mínimo de caracteres que devem ser adicionados para uma string qualquer ser considerada segura.");
        
        System.out.printf("Digite a sua senha: ");

        String senha=scan.next();

        Boolean especiais=false;

        Boolean digitos=false;

        Boolean minusculos=true;

        Boolean maiusculos=true;

        if(senha.length()<6){

            int caracteres_nescessarios=6-senha.length();

            System.out.printf("Sua senha é muito pequena! Digite mais %d caracteres", caracteres_nescessarios);
        }else{

            for(int index=0;index<senha.length();index++){

                if(senha.charAt(index)=='@' || senha.charAt(index)=='#' || senha.charAt(index)=='$' || senha.charAt(index)=='%' || senha.charAt(index)=='^' || senha.charAt(index)=='&' || senha.charAt(index)=='*' || senha.charAt(index)=='(' || senha.charAt(index)==')' || senha.charAt(index)=='-' || senha.charAt(index)=='+'){

                    especiais=true;

                }

                if(senha.charAt(index)=='1' || senha.charAt(index)=='2' || senha.charAt(index)=='3' || senha.charAt(index)=='4' || senha.charAt(index)=='5' || senha.charAt(index)=='6' || senha.charAt(index)=='7' || senha.charAt(index)=='8' || senha.charAt(index)=='9' || senha.charAt(index)=='0'){

                    digitos=true;

                }
                
                if(senha.toLowerCase()==senha){

                    maiusculos=false;

                }

                if(senha.toUpperCase()==senha){

                    minusculos=false;

                }
            }

            if(especiais||digitos||maiusculos||minusculos){

                System.out.printf("Senha criada com sucesso, ja pode usar nossa plataforma!");

            }
            if(!especiais||!digitos||!maiusculos||!minusculos){

                System.out.printf("Sua senha não segue os padrões de segurança, favor digitar uma senha mais forte!");

            }

        }

        System.out.println("Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra podem ser realocadas para formar a outra palavra. Dada uma string qualquer, desenvolva um algoritmo que encontre o número de pares de substrings que são anagramas.");
        
        System.out.println("Então, vamos encontrar anagramas?");

        System.out.printf("Digite uma palavra: ");

        String palavra=scan.next();

        int res=imprimeAnagramas("",palavra);

        System.out.printf("\nNumero de anagramas: %d",res);

    }
    
        public static int imprimeAnagramas(String prefix, String word) {

            int num=0;

            if (word.length() <= 1) {
                num++;
                System.out.println(prefix + word);
            } else {
                for (int i = 0; i < word.length(); i++) {
                    String cur = word.substring(i, i + 1);
                    String before = word.substring(0, i); 
                    String after = word.substring(i + 1); 
                    imprimeAnagramas(prefix + cur, before + after);
                    num++;
                }
            }

            return num;

        }
    
    }