/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.DepartamentsDAO;
import dao.EmpleatsDAO;
import dto.Departament;
import dto.Empleat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author jmas
 */
public class Main {

    public static void main(String[] args) {
        List<Empleat> empleados = EmpleatsDAO.getEmpleats();
        List<Departament> departamentos = DepartamentsDAO.getDepartaments();
        // 1.- Imprimeix el primer empleat trobat amb més de 50 anys
        System.out.println("EJERCICIO 1");
        empleados.stream()
                .filter(e -> e.getEdat()>50)
                .findFirst().ifPresent(System.out::println);
             
        // 2. Imprimeix true si tots els empleats son majors d'edat i false en cas contrari
        System.out.println("--EJERCICIO 2");
        System.out.println(empleados.stream()
                .allMatch(p -> p.getEdat()>=18));
        
        // 3. Imprimeix true si hi ha algun empleat major de 65 anys i false en cas contrari
        System.out.println("--EJERCICIO 3");
        System.out.println(empleados.stream()
                .anyMatch(p -> p.getEdat()>65));
            
        // 4. Imprimeix el número d'empleats que tenen més de 50 anys
            System.out.println("--EJERCICIO 4--");
            System.out.println(empleados.stream()
                .filter(p -> p.getEdat() > 50)
                .count());
            
        // 5. Imprimeix el nom dels empleats del departament d'informàtica, en majúscules.
            System.out.println("--EJERCICIO 5--");
            empleados.stream()
                    .filter(p -> p.getDepartament().equals(DepartamentsDAO.getDepartaments().get(3)))
                    .map(p -> p.getNom().toUpperCase())
                    .forEach(System.out::println);
        
        // 6. Imprimeix la quantitat de lletres de l'empleat d'informàtica amb el nom més llarg.

            System.out.println("--EJERCICIO 6--");
            empleados.stream()
                    .max((p1, p2) -> p1.getNom().length() - p2.getNom().length())
                    .ifPresent(p -> System.out.println(p.getNom().length()));
                   
        // 7. Imprimeix el nom dels departaments que comencen per C
        
            System.out.println("--EJERCICIO 7--");
            departamentos.stream()
                     .filter(p -> p.getNom().startsWith("C"))
                     .map(Departament::getNom)
                     .forEach(System.out::println);
        
        // 8. Imprimeix la suma de totes les edats dels empleats

            System.out.println("--EJERCICIO 8--");
            System.out.println(empleados.stream()
                    .mapToInt(Empleat::getEdat)
                    .sum());                 
                    
        // 9 UTILITZA EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)
        // Imprimeix la quantitat d'empleats de cada departament

            System.out.println("--EJERCICIO 9--");
            Map<String,Long> dep = departamentos.stream()
                    .collect(Collectors.toMap(d -> d.getNom(), d -> d.getEmpleats().stream().count()));
            dep.forEach((k,v) -> System.out.println(k+": "+v));
                        
        // 10. UTILITZANT EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)
        // Imprimeix la llista de noms dels empleats del departament comercial i de comptatilitat (una única llista d'String)
            
            System.out.println("--EJERCICIO 10--");
            departamentos.stream()
                    .filter(p -> p.getNom().equals(DepartamentsDAO.getDepartaments().get(1).getNom()) || p.getNom().equals(DepartamentsDAO.getDepartaments().get(2).getNom()))
                    .flatMap(p -> p.getEmpleats().stream())
                    .map(Empleat::getNom)
                    .forEach(System.out::println);
                
        // 11. El mateix d'abans però mostra els noms ordenats alfabèticament.
        
            System.out.println("--EJERCICIO 11--");
            empleados.stream()
                    .filter(p -> p.getDepartament().getNom().equals(DepartamentsDAO.getDepartaments().get(1).getNom()) || p.getDepartament().getNom().equals(DepartamentsDAO.getDepartaments().get(2).getNom()))
                    .map(Empleat::getNom)
                    .sorted()
                    .forEach(System.out::println);
                    
                                          
        // 12. Mostra la mitjana d'edat dels empleats del departament d'informàtica.

            System.out.println("--EJERCICIO 12--");
            empleados.stream()
                    .filter(p -> p.getDepartament().getNom().equals(DepartamentsDAO.getDepartaments().get(3).getNom()))
                    .mapToInt(Empleat::getEdat)
                    .average().ifPresent(System.out::println);
                    
        // 13. Mostra un String que serà el resultat de concatenar la primera lletra de cada departament.

            System.out.println("--EJERCICIO 13");
            System.out.println(departamentos.stream()
                    .map(p -> p.getNom().charAt(0))
                    .map(String::valueOf)
                    .reduce("",(i,p) -> i + p));
            
        // 14. Mostra el número de telèfon més alt dels departaments.

        // 15. Mostra el departament complet amb el número de telèfon més alt.

        // 16. Sense fer ús del mètode "getEmpleats". Dels departament que tenen treballadors, mostrar el nom del departament i el nombre de treballadors que hi treballen.

        // 17A. Guarda en un Map un registre per a cada Departament (que tinga treballadors) que tinga associat com a valor la llista d'empleats d'eixe departament

        // 17B. Igual que l'anterior pero la llista no serà d'empleats sino del nom dels empleats

        // 17C. Igual que l'anterior pero amb els empleats ordenats alfabèticament
        
        // 18A. Obtín un Map que continga per a cada departament una llista d'enters grans (BigInteger) que es corresponguen amb les edats dels empleats d'eixe departament
       
        // 18B. El mateix que abans però en comptes de l'edat, el probable següent número primer

        // 19. Obtín un Map que continga per a cada departament l'empleat més jove.

        // 20. Obtín un String que continga el mateix que abans, amb el format "Departament1:Empleat1, Departament2:Empleat2 ..."

        // 21. Obtín un Map que conté com a clau el DNI dels empleats i com a valor el nom d'eixe empleat

        // 21. Obtín una llista d'Strings que continga DNI dels empleats i el nom d'eixe empleat amb el format DNI - Nom. Llista ordenada per DNI

        // 22A. Donat un array bidimensional d'Integer transformar-lo en un array unidimensional amb els mateixos valors:
        Integer[][] matriuInteger = {{3, 2, 5}, {0, -8, 7}, {9, 9, 6}};

        // 22B. Versió amb int[] en comptes d'Integer[]
              
        // 23. Guarda una llista amb els noms dels estudis de tots els empleats (de forma única), ordenats alfabèticament.

        // 24. Imprimeix per pantalla aquells empleats que tinguen un CFGS

        // 25. Mostra un empleat qualsevol que tinga una llicenciatura

        // 26. Mostra per a cada nom d'empleat la suma de les lletres dels seus titols

        // 27. Mostra el total de lletres dels titols (incloent duplicats) dels empleats
        
        // 28. Mostra l'empleat amb major quantitat de títols

        // 29A. Obtín una llista que continga 5 aleatoris entre 0 i 9 en format String

        // 29B. El mateix d'abans, però ara sense valors repetits.

        // 30. Crea un stream amb tots els números positius divisibles entre 3. Després filtra aquells que siguen quadrats perfectes. 
        // Després descarta els 5 primers valors obtinguts. Finalment mostra els 10 següents valors obtinguts

        // 31. A partir dels cognoms dels empleats imprimeix amb una operació intermèdia els cognoms sense transformar i després transformats en majúscules.
        // Finalment retorna el nombre d'empleats.

        // 32. Imprimeix el cognom dels empleats ordenats en ordre alfabètic invers.

        // 33. Obtín la suma dels títols de tots els empleats

        // 34. Obtín un String amb la concatenació dels títols d'aquells empleats que tinguen menys de 30 anys, separats per espais (sense duplicats)

        // 35A. Mostra el cognom del primer dels empleats trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"
        // ¿I si proves per a menors de 40?

        // 35B. Mostra el primer dels empleats (complet) trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"
        // ¿I si proves per a menors de 40?
       
        // 36. Obtín un LinkedHashSet dels títols que tenen tots els empleats.

        // 37. Obtín un Map amb dos claus, la primera tindrá com a valors una llista dels empleats amb el títol de CFGS i l'altra clau tindrá una llista amb els que no el tenen.

        // 38. A partir d'una llista d'String retorna la mateixa llista pero sense cadenes buides
        List<String> elementsOriginals = List.of("aigua", "", "llet", "oli", "", "  ", "lletuga");

        // 39. Obtín una cadena separada per comes basada en una llista determinada d'enters. 
        // Cada element ha d'anar precedit de la lletra 'p' si el nombre és parell i precedit de la lletra 'i' si el nombre és imparell. 
        // Per exemple, si la llista d'entrada és (3,44), la eixida hauria de ser 'i3, p44'.
        List<Integer> llistaEnters = List.of(9,23,4,15);
        
        // 40.A partir dels empleats. Obtín un mapa que tinga com a clau el nom del departament i com a valor un altre mapa
        // Este segon mapa tindrà com a clau el cognom de l'empleat y com a valor la llista de títols que té.
        
        // EXTRA A: A partir d'un String retorna les lletres distintes que conté, separades per comes (només lletres, no espais ni números ni altres caracters)
        String frase1 = "Tinc un 8 en PROG";
        
        // EXTRA B: A partir d'un String retorna la quantitat de lletres distintes que conté (només lletres, no espais ni números ni altres caracters)
        
        // EXTRA C: Obtín un mapa que mostre com a clau cada lletra distinta del String, i com a valor la quantitat de vegades que apareix.
                
        // EXTRA D: Mostra la lletra amb major freqüencia d'aparicions, i el nombre d'aparicions d'eixa lletra.
       

    }

}
