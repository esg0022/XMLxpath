/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package domxpath;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

/**
 *
 * @author Lenovo i7
 */
public class DOMxpath {

    public static void main(String[] args) {

        try {
//Declarar una clases DocumentByilderFactory factoria
            DocumentBuilderFactory factoria = DocumentBuilderFactory.newDefaultInstance();
//Validar el documento con setValidting(true);
            factoria.setValidating(true);
//Ignorar los espacios en blanco con setIgnoringElementContentWhitespace(true);
            factoria.setIgnoringElementContentWhitespace(true);
//Crear el objeto DocumentBuilder builder
            DocumentBuilder builder = factoria.newDocumentBuilder();
//Crear un objeto File fichero, indicándole donde se encuentra nuestro fichero a analizar "XML.xml"
            File fichero = new File("XML.xml");
//Creamos un objeto Document doc en el que almacenamos el árbol de nodos asignándole la salida del método parse (fichero):
            Document doc = builder.parse(fichero);
//Eliminar nodos duplicados o incosistentes
            doc.getDocumentElement().normalize();
//Conastruimos un objeto XPath
            XPath xPath = XPathFactory.newInstance().newXPath();
//Creamos una variable tipo String expression en la que le indicamos el tipo de nodos que vamos a analizar "/class/estudiante";
//Ejecutamos la expresión sobre el documento que contiene el árbol de nodos empleando para obtener una lista de nodos
            NodeList listaNodos = (NodeList) xPath.compile("/class/estudiante").evaluate(doc, XPathConstants.NODESET);
//Contamos el numero de nodos obtenidos y los mostramos por pantalla
            int nNodos = listaNodos.getLength();
//sout
            System.out.println("numero de estudiantes: " + nNodos);
            
            
            
            System.out.println("");
            
//Imprimimos el listado de nodos empleando un bucle y el listaNodos.item(i).getTextContent();
            for (int i = 0; i < nNodos; i++) {
                System.out.println(listaNodos.item(i).getTextContent());
                
            }System.out.println("");
            
// Del mismo modo crear separamos los elementos dentro de estudiante: nombre, apellido1, nota_media y los mostramos por pantalla
//Emplea la expresion "/class/estudiante[nota_media=9]" para obtener cuantos han sacado 9
NodeList listaNodosNombre = (NodeList)xPath.compile("/class/estudiante/nombre").evaluate(doc,XPathConstants.NODESET);
NodeList listaNodosApellido = (NodeList)xPath.compile("/class/estudiante/apellido1").evaluate(doc,XPathConstants.NODESET);
NodeList listaNodosNota_media = (NodeList)xPath.compile("/class/estudiante/nota_media").evaluate(doc,XPathConstants.NODESET);

            for (int i = 0; i < nNodos; i++) {
                System.out.println(listaNodosNombre.item(i).getTextContent() + " " + listaNodosApellido.item(i).getTextContent() + " " + listaNodosNota_media.item(i).getTextContent());
            }

        } catch (Exception e) {
            System.out.println("Error manejo ficheros" + e.getMessage());
        }

    }
}
