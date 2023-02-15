package com.cecena.lista;

public class Lista {
    Nodo inicio,fin;
    int c;
    int p;
    public Lista(){
        this.inicio = null;
        this.fin    = null;
    }

    public boolean isEmpty(){
        return (inicio == null);
    }

    public void addInicio(int dato){
        c++;
        if(isEmpty()){
            this.inicio = new Nodo(dato, this.inicio,this.p);
            this.fin = this.inicio;
            p++;
        } else {
            this.inicio = new Nodo(dato, this.inicio, this.p);
            p++;
        }
    }

    public int numNodos(){
        return c;
    }

    public int getPos(int numNodo){
        int ans = -1;
        Nodo aux = this.inicio;
        while (aux != null){
            if(aux.dato == numNodo ){
                ans = aux.pos;
            }
            aux = aux.siguiente;
        }
        return ans;
    }

    public void ordAsc(){
        Nodo aux = this.inicio;
        int auxD;
        if(!isEmpty()){
            for(int i = 0; i < this.c;i++){
                while (aux != null){
                    if(aux.siguiente != null){
                        if(aux.dato > aux.siguiente.dato){
                            auxD = aux.siguiente.dato;
                            aux.siguiente.dato = aux.dato;
                            aux.dato = auxD;
                        }
                    } else {break;}
                    aux = aux.siguiente;
                }
            }
        }
    }

    public void delNodo(){
        Nodo aux = this.inicio;
        if(!isEmpty()){
            while(aux != null ){
                if( aux.pos == 1 && c != 1 ){
                    aux.siguiente = null;
                } else if (aux.pos == 0 && c == 1 ) {
                    this.inicio = null;
                    this.fin    = null;
                }
                aux = aux.siguiente;
            }
        }
        c--;
    }
    public void delNodo(int posNodo){
        if(posNodo > this.c || posNodo < 0){
            System.out.println("No existe ese nodo");
            return;
        }
        Nodo aux = this.inicio;
        if(!isEmpty()){
            if(posNodo == this.c - 1){
                if (aux.pos == this.c-1) {
                    this.inicio = aux.siguiente;
                }
            } else if(posNodo == 0) {
                delNodo();
            } else {
                Nodo aux2 = getNodoByPos(posNodo - 1 );
                while (aux != null){
                    if(aux.pos == posNodo + 1){
                        aux.siguiente = aux2;
                        break;
                    }
                    aux = aux.siguiente;
                }
            }
        }
    }

    private Nodo getNodoByPos(int nodoPos){
     Nodo aux = this.inicio;
     while ( aux != null){
         if(aux.pos == nodoPos){
            break;
         }
         aux = aux.siguiente;
     }
     return aux;
    }
    public void imprimirMayoresA(int numEvaluar){
        Nodo aux = this.inicio;
        while (aux != null){
            if(aux.dato > numEvaluar){
                System.out.print("["+aux.dato+"]-->");
            }
            aux = aux.siguiente;
        }
        System.out.print("null");
    }

    public void imprimirLista(){
        Nodo aux = this.inicio;
        while (aux != null){
            System.out.print("["+aux.dato+"] --> ");
            aux = aux.siguiente;
        }
        System.out.println("null");
    }

}
