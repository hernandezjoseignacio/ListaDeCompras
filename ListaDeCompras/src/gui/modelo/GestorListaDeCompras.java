/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelo;

import gui.interfaces.IGestorListaDeCompras;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HERNANDEZ
 */
public class GestorListaDeCompras implements IGestorListaDeCompras{
    List<Compra> listaDeCompras = new ArrayList<>();
    public static final String ARCHIVO = "./ListaDeCompras.txt";
    public static final char SEPARADOR = ';';

    //-------------------------PatronÚnico||PatronSingle-----------------------------
    private static GestorListaDeCompras gestor;
    
    private GestorListaDeCompras() {
        this.leerArchivo();
    }
   
    public static GestorListaDeCompras instanciar() {
        if (gestor == null)
            gestor = new GestorListaDeCompras();
        return gestor;
    }
    //-------------------------PatronÚnico||PatronSingle-----------------------------

    //+++++++++++++++++++++++++++Leer/EscribirArchivo++++++++++++++++++++++++++++++++++++++++
    public void leerArchivo(){
        File archivoListaDeCompras = new File(ARCHIVO);
        if (archivoListaDeCompras.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivoListaDeCompras))){
                String cadena;
                while((cadena = br.readLine()) != null) {
                    String[] vector = cadena.split(Character.toString(SEPARADOR));
                    Compra unaCompra = new Compra(vector[0], vector[1], Float.parseFloat(vector[2]));
                    if(!this.listaDeCompras.contains(unaCompra))
                        this.listaDeCompras.add(unaCompra);
                }
            }
            catch (IOException ioe) {
                System.out.println("Error al leer del archivo " + ARCHIVO);
            }
        }
    }
    
    public void escribirArchivo() {
        try(FileWriter archivoListaDeCompras = new FileWriter(new File(ARCHIVO))) {     
            for(Compra i : this.listaDeCompras) {
                String cadena = i.getUnaCompra() + SEPARADOR + i.getAnotaciones() + SEPARADOR + i.getPrecio();
                archivoListaDeCompras.write(cadena);
                archivoListaDeCompras.write("\n");
            }
        } 
        catch (IOException ioe) {
            System.out.println("Error al escribir en el archivo " + ARCHIVO);
        }
    }
    //+++++++++++++++++++++++++++Leer/EscribirArchivo++++++++++++++++++++++++++++++++++++++++
    
    @Override
    public String nuevaCompra(String compra, String unaAnotacion, float unPrecio) {
        if(compra!=null&&!compra.isEmpty()&&unaAnotacion!=null&&!unaAnotacion.isEmpty()&&unPrecio!=0.0){
            Compra unaCompra = new Compra(compra, unaAnotacion, unPrecio);
            if(!this.listaDeCompras.contains(unaCompra)){
                this.listaDeCompras.add(unaCompra);
                this.escribirArchivo();
            return "EXITO";
            }
        return "DUPLICADOS";
        }
    return "ERROR";
    }
    
    @Override
    public Compra dameUnaCompra(String compra) {
        if(compra!=null&&!compra.isEmpty()){
            for(Compra i: this.listaDeCompras){
                if(i.getUnaCompra().contains(compra))
                    return i;
            }
        }
    return null;
    }

    @Override
    public List<Compra> buscarUnaCompra(String compra) {
        if(compra!=null){
            List<Compra> lista = new ArrayList<>();
            for(Compra i: this.listaDeCompras){
                if(i.getUnaCompra().toLowerCase().contains(compra))
                   lista.add(i);
            }
        return lista;
        }
    return this.listaDeCompras;
    }

    @Override
    public String borrarUnaCompra(Compra unaCompra) {
        if(unaCompra!=null){
            if(this.listaDeCompras.contains(unaCompra)){
                this.listaDeCompras.remove(unaCompra);
                this.escribirArchivo();
            return "La Compra se pudo eliminar satisfactoriamente!";
            }
        return "La Compra no existe!";
        }
    return "La Compra que desea eliminar no es valida!";
    }

    @Override
    public String modificarUnaCompra(Compra unaCompra, String compra, String unaAnotacion, float unPrecio){
        if(unaCompra!=null&&compra!=null&&!compra.isEmpty()){
            for(Compra i:this.listaDeCompras){
                if(i.equals(unaCompra)){
                    i.setUnaCompra(compra);
                    i.setAnotaciones(unaAnotacion);
                    i.setPrecio(unPrecio);
                    this.escribirArchivo();
                    return "EXITO";
                }
            }
        return "Compra no encontrada!";
        }
    return "FRACASO";
    }

    @Override
    public int obtenerPosicion(Compra unaCompra) {
        return this.listaDeCompras.indexOf(unaCompra);
    }
    

}
