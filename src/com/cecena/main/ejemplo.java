package com.cecena.main;

import com.cecena.lista.Lista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejemplo {
    public static void main(String[] args) {


//        lista.addInicio(10);
//        lista.addInicio(12);
//        lista.addInicio(13);
//        lista.addInicio(8);
//        lista.addInicio(2);
//        lista.addInicio(25);
//
//
//        lista.imprimirLista();
//        System.out.println(lista.numNodos());
//        if(lista.isEmpty()){
//            System.out.println("Esta vacia");
//        } else {
//            System.out.println("Tiene algo");
//        }
//        System.out.println(lista.getPos(13));
//        System.out.println(lista.numNodos());
//        System.out.println();
//        lista.delNodo();
//        lista.imprimirLista();
//        lista.delNodo(8);
//        lista.imprimirLista();
//        lista.imprimirMayoresA(10);

        int opc = -1;
        Scanner s = new Scanner(System.in);
        Lista lista = null;
        while (opc != 0){
            System.out.println("Ingrese el numero de accion que quiera realizar: ");
            System.out.println("1.-Crear una lista");
            System.out.println("2.-La lista sera ordenada?");
            System.out.println("3.-Agregar un nodo");
            System.out.println("4.-Preguntar si la lista esta vacia");
            System.out.println("5.-Eliminar nodos de la lista");
            System.out.println("6.-Numeros de nodos de la lista");
            System.out.println("7.-Impimir la lista");
            System.out.println("8.-Mostrar posicion de un nodo");
            System.out.println("9.-Mostrar los nodos que superen un valor dado");

            try {
                opc = s.nextInt();
                if (opc > 9 || opc < 0 ){throw new Exception("\nIngrese un valor dentro del rango\n");}
                switch (opc){
                    case 1:
                        if(lista == null){
                            lista = new Lista();
                            System.out.println("\nLista creada con exito!\n");
                        } else {
                            System.out.println("\nYa hay una lista creada\n");
                        }
                        break;
                    case 3:
                        if(lista != null){
                            System.out.print("Ingrese el dato del nodo a agregar: ");
                            lista.addInicio(s.nextInt());
                            System.out.println("\nNodo añadido con exito!\n");
                        } else {
                            System.out.println("--No hay una lista creada--\n");
                        }
                        break;
                    case 4:
                        if(lista != null){
                            System.out.println(lista.isEmpty() ? "\nLa lista esta vacia\n" : "\nLa lista no esta vacia\n");
                        } else {
                            System.out.println("--No hay una lista creada--\n");
                        }
                        break;
                    case 5:
                        if(lista != null){
                            int o;
                            System.out.println("Si quiere eliminar el primero o el ultimo ingrese 1, si quiere eliminar" +
                                    "\n otro nodo ingrese 0, despues la posicion a partir del 0 del nodo en cuestion:");
                            o = s.nextInt();
                            if(o == 0){
                                System.out.println("Ingrese la posicion del nodo ");
                                lista.delNodo(s.nextInt());
                            } else if(o == 1){
                                int v;
                                System.out.println("Si quiere el ultimo ingrese 1 si quiere el primero ingrese 0");
                                v = s.nextInt();
                                if(v == 0){
                                    lista.delNodo();
                                } else if(v == 1) {
                                    lista.delNodo(lista.numNodos()-1);
                                } else {
                                    throw new Exception("Dato incorrecto");
                                }
                            }
                        } else {
                            System.out.println("--No hay una lista creada--\n");
                        }
                        break;
                    case 6:
                        if (lista != null) {
                            System.out.println("\nLa lista tiene " + lista.numNodos() + " nodos\n");
                        } else {
                            System.out.println("--No hay una lista creada--\n");
                        }
                        break;
                    case 7:
                        if(lista != null){
                            System.out.println();
                            lista.imprimirLista();
                            System.out.println();
                        } else {
                            System.out.println("--No hay una lista creada--\n");
                        }
                        break;
                    case 8:
                        if(lista != null){
                            System.out.println("Ingrese el nodo el cual quiere mostrar su posicion: ");
                            int ans = lista.getPos(s.nextInt());
                            if(ans != -1){
                                System.out.println("El nodo esta en la posicion " + ans);
                            } else {
                                System.out.println("El nodo no existe");
                            }
                        } else {
                            System.out.println("--No hay una lista creada--\n");
                        }
                        break;
                    case 9:
                        if(lista != null ) {
                            System.out.print("Ingresa el valor que se desea que sea mayor cada nodo: ");
                            lista.imprimirMayoresA(s.nextInt());
                            System.out.println();
                            System.out.println("\n");
                        } else {
                            System.out.println("--No hay una lista creada--\n");
                        }
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("\nIngrese un valor valido y reinicie el programa\n");
                break;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println("\nPrograma cerrado con exito!");
    }
}
