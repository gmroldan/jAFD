package automatafinitodeterminista;

import javax.swing.JOptionPane;


public class Configuracion {
    private Alfabeto alfabeto;
    private String palabra;    
    private int posicionCabezal;
    
    public Configuracion(Alfabeto alfabeto){
        this.alfabeto=alfabeto;        
    }
    
    public void ingresarPalabra(String palabra){        
        if(!perteneceAlfabeto(palabra))
            JOptionPane.showMessageDialog(null, "Verifique la cadena ingresada", "ERROR", JOptionPane.ERROR_MESSAGE);                    
        else
            setPalabra(palabra);                        
    }
    
    public boolean perteneceAlfabeto(String palabra){
        boolean resultado=true;
        for(int i=0;i<palabra.length();i++){
            if(!getAlfabeto().pertenece(palabra.charAt(i))){
                resultado=false;
                break;
            }
        }
        return resultado;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public int getPosicionCabezal() {
        return posicionCabezal;
    }

    public void setPosicionCabezal(int posicionCabezal) {
        this.posicionCabezal = posicionCabezal;
    }    
}
