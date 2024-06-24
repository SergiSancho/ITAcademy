# ITAcademy
# Sprint 1
## Tasca 1. Herència i polimorfisme

[Nivell 1 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca1/n1exercici1)

En un grup de música hi ha diferents tipus d’instruments musicals. Hi ha instruments de vent, de corda i de percussió.
Tots els instruments tenen com a atributs el seu nom, i el seu preu. A més, tenen un mètode anomenat tocar(). Aquest, és abstracte a la classe instrument i, 
per tant, s’ha d’implementar a les classes filles. Si s’està tocant un instrument de vent, el mètode ha de mostrar per consola: "Està sonant un instrument de vent", 
si s’està tocant un instrument de corda: “Està sonant un instrument de corda” i si s’està tocant un instrument de percussió: “Està sonant un instrument de percussió”.
El procés de càrrega d'una classe només té lloc una vegada. Demostra que la càrrega pot ser provocada per la creació de la primera instància d'aquesta classe 
o per l'accés a un membre estàtic d'aquesta. 
Cerca informació sobre els blocs d'inicialització i blocs estàtics en Java.

[Nivell 1- Exercici 2](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca1/n1exercici2)

Crea una classe "Cotxe" amb els atributs: marca, model i potència. La marca ha de ser estàtic final, el model estàtic i la potència final. 
Demostra la diferència entre els tres. N’hi ha algun que es pugui inicialitzar al constructor de la classe?
Afegeix dos mètodes a la classe "Cotxe". Un mètode estàtic anomenat frenar() i un altre no estàtic anomenat accelerar(). El mètode accelerar ha de 
mostrar per consola: “El vehicle està accelerant” i el mètode frenar() ha de mostrar: “El vehicle està frenant”. 
Demostra com invocar el mètode estàtic i el no estàtic des del main() de la classe principal.

[Nivell 2 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca1/n2exercici1)

Crea una classe anomenada "Telèfon" amb els atributs marca i model, i el mètode trucar(). Aquest mètode ha de rebre un String amb un número de telèfon. 
El mètode ha de mostrar per consola un missatge dient que s’està trucant al número rebut per paràmetre. 
Crea una interfície anomenada "Camera" amb el mètode fotografiar(), i una altra interfície anomenada Rellotge amb el mètode alarma().
Crea una classe anomenada "Smartphone" que sigui subclasse de "Telèfon" i que a la vegada implementi les interfícies "Camera" i "Rellotge".
El mètode fotografiar() ha de mostrar per consola: “S’està fent una foto” i el mètode alarma() ha de mostrar: “Està sonant l’alarma”.
Des del main() de l’aplicació, crea un objecte Smartphone i crida als mètodes anteriors.

## Tasca 2. Exceptions

[Nivell 1 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca2/n1exercici1)

Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra classe anomenada "Venda". Aquesta classe té com a atributs una col·lecció de productes i el preu total de la venda.
La classe "Venda", té un mètode anomenat calcularTotal() que llança l’excepció personalitzada VendaBuidaException i mostra per pantalla “Per fer una venda primer has d’afegir productes” si la col·lecció de productes està buida. Si la col·lecció té productes, llavors ha de recórrer la col·lecció i guardar la suma de tots els preus dels productes a l’atribut preu total de la venda.
L’excepció personalitzada VendaBuidaException ha de ser filla de la classe Exception. Al seu constructor li hem de passar el missatge  “Per fer una venda primer has d’afegir productes” i quan capturem l’excepció, l’hem de mostrar per pantalla amb el mètode getMessage() de l’excepció.
Escriu el codi necessari per a generar i capturar una excepció de tipus ArrayIndexOutOfBoundsException.

[Nivell 2- Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca2/n2exercici1)

Crea una classe anomenada "Entrada". Aquesta classe ha de servir per controlar les diferents excepcions que poden aparèixer en Java a l’hora d’introduir dades per teclat utilitzant la classe Scanner.
El primer que s’ha de fer és instanciar un objecte de la classe Scanner i a partir d’aquí, crear mètodes estàtics per llegir els diferents tipus de dades des del teclat. 
Tots els mètodes reben un String amb el missatge que es vol mostrar a l’usuari/ària, per exemple: “Introdueix la teva edat”, i retornen la dada oportuna introduïda per l’usuari/ària en cada mètode, per exemple: un byte amb l’edat de l’usuari/ària.
Mètodes a implantar capturant l’excepció de la classe InputMismatchException:
public static byte llegirByte(String missatge);
public static int llegirInt(String missatge);
public static float llegirFloat(String missatge);
public static double llegirDouble(String missatge);
Mètodes a implantar capturant l’excepció de la classe Exception:
public static char llegirChar(String missatge);
public static String llegirString(String missatge);
public static boolean llegirSiNo(String missatge), si l’usuari/ària introdueix “s”, retorna “true”, si l’usuari introdueix “n”, retorna “false”.

## Tasca 3. Java Collections

[Nivell 1 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca3/n1exercici1)

Crea una classe anomenada Month amb un atribut "name" (que emmagatzemarà el nom del mes de l'any). Afegeix 11 objectes Month (cadascun amb el seu atribut diferent) en un ArrayList, a excepció de l'objecte amb atribut "Agost". Després, efectua la inserció en el lloc que correspon a aquest mes i demostra que l’ArrayList manté l'ordre correcte.
Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats.
Recorre la llista amb un for i amb un iterador.

[Nivell 1 - Exercici 2](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca3/n1exercici2)

Crea i emplena un List<Integer>. 
Crea un segon List<Integer> i insereix a la segona llista els elements de la primera en ordre invers. 
Empra els objectes ListIterator per a llegir els elements de la primera llista i inserir-los en la segona.

[Nivell 1 - Exercici 3](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca3/n1exercici3)
Donat el fitxer countrties.txt (revisa l'apartat recursos) que conté països i capitals. El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>. El programa demana el nom de l’usuari/ària, i després ha de mostrar un país de forma aleatòria, guardat en el HashMap. Es tracta de què l’usuari/ària ha d’escriure el nom de la capital del país en qüestió. Si l’encerta se li suma un punt. Aquesta acció es repeteix 10 vegades. Un cop demanades les capitals de 10 països de forma aleatòria, llavors s’ha de guardar en un fitxer anomenat classificacio.txt, el nom de l’usuari/ària i la seva puntuació.

[Nivell 2 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca3/n2exercici1)

Crea una classe anomenada Restaurant amb dos atributs: nom(String) i puntuació(int). Implementa els mètodes necessaris perquè no es puguin introduir objectes Restaurant amb el mateix nom i la mateixa puntuació en un HashSet creat en el main() de l’aplicació.

[Nivell 2 - Exercici 2](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca3/n2exercici2)

Utilitzant la classe del programa anterior, crea la implementació necessària perquè els objectes de la classe Restaurant estiguin ordenats per nom i per puntuació en ordre ascendent. 

