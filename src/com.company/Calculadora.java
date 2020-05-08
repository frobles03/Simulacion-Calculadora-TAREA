package com.company;

import java.util.Scanner;

public class Calculadora {
    public static Scanner teclado = new Scanner(System.in);
    private double num1;
    private double num2;
    private double resultado;
    private double elevado;
    public void menu() {
        System.out.println("=========================================");
        System.out.println("==============|Calculadora|==============");
        System.out.println("=========================================");


        String[] simbolos = { " * ", " elevado a ", " Modificar Los Numeros ", " Salir "};
        System.out.println(">>>>>>Seleccione la opcion deseada<<<<<<");
        for (int i = 0; i < simbolos.length; i++) {
            System.out.print("(" + (i + 1) + ") ");
            if (i <= 4) {
                System.out.println(num1 + simbolos[i] + num2 + " = ?");
            } else {
                System.out.println(simbolos[i]);
            }


        }
        int opcion = (int) ingresarUnNumero("Ingrese una opcion");
        switch (opcion) {

            case 1: /*Multiplicacion
                    (Fernando Robles)
                    */
                resultado = multiplicacion();
                System.out.println(num1 + "*" + num2 + "=" + resultado);
                break;

            case 2: /* Potencia
                    (Fernando Robles)
                    Utilice el metodo de  "Math.pow" haciendo que la variable "num1" sea la base y "num2" el exponente.
                    */
                if(num1==0 && num2==0) {
                    System.out.println("Se indefine,ya que la base y el exponente son 0");
                }else{
                    resultado=potencia();
                    System.out.println(num1 + "^" + num2 + "=" + resultado);
                    }
                break;

            case 3: //Ingresar los Numeros
                ingresarLosNumeros();
                break;
            case 4: //Salir
                System.out.println("Hasta la proxima!");
                return; //Se rompe la recursividad
            default://En caso que el usuario ingrese una opcion invalida
                System.out.println("Error, la opcion ingresada es incorrecta, intentelo Nuevamente");
                menu();

            }
            menu();
        }




    private double multiplicacion(){
        /*Fernando Robles*/
        return num1 * num2;

    }

    private double potencia() {

        double elevado = Math.pow(num1, num2);
        return elevado;

    }

    public void ingresarLosNumeros() {
        //(Lucas Palminio)
        //Metodo para modificar los atributos num1 y num2
        //que mas tarde se utilizara para realizar operaciones aritmeticas

        num1 = ingresarUnNumero("Ingrese el primer Numero");
        num2 = ingresarUnNumero("Ingrese el segundo Numero");
    }

    //
    private double ingresarUnNumero(String mensaje) {
        //(Lucas Palminio)
        //Este metodo retorna un numero de tipo Double ingresado por teclado,
        //Primero muestra un pantalla al usuario que numero debe ingresar y luego
        //esta entrada es validada para que se ingrese solamente un valor numerico.


        while (true) {
            try {

                System.out.print(mensaje + ": ");
                return teclado.nextDouble();
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage() + ", porfavor intentelo nuevamente");
                teclado.nextLine();
            }

        }


    }
}
