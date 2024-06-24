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

## Tasca 4. Testing

[Nivell 1 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/test/java/tasca4/n1exercici1)

Crea una classe Java que insereixi en una llista ordenada els noms dels mesos de l'any.
Verifica amb jUnit que la llista té 12 posicions, que no és nul·la i que en la seva posició 8 conté el nom 'agost'.

[Nivell 1 - Exercici 2](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/test/java/tasca4/n1exercici2)

Crea una classe anomenada CalculoDni que calculi la lletra del DNI en rebre el número com a paràmetre.
Crea una classe jUnit que verifiqui el seu correcte funcionament, parametritzant-la perquè el test rebi un espectre de dades ampli i validi si el càlcul és correcte per a 10 números de DNI predefinits.

[Nivell 1 - Exercici 3](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/test/java/tasca4/n1exercici3)

Crea una classe amb un mètode que llanci una ArrayIndexOutOfBoundsException.
Verifica el seu correcte funcionament amb un test jUnit.

[Nivell 2 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca4/n2exercici1)

[Test](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/test/java/tasca4/n2exercici1)

Defineix un Matcher personalitzat per a Hamcrest que proporcioni el Matcher de longitud per a un String.
Volem usar la classe ->FeatureMatcher.
Amb FeatureMatcher podem ajustar un Matcher existent, decidir quin camp de l'Objecte prova ha de coincidir i proporcionar un missatge d'error agradable. El constructor de FeatureMatcher té els següents arguments en aquest ordre:
El matcher que volem embolicar.
Una descripció de la funció que provem.
Una descripció del possible mismatch (desajustament).
L'únic mètode que hem de sobreescriure és featureValueOf (T actual), que retorna el valor que es passarà al mètode match () / matchesSafely (). Utilitza el seu comparador personalitzat en una prova per a comprovar si la cadena "Mordor" té una longitud de 8.

## Tasca 5. Java Utils

[Instruccions per compilar i executar](https://github.com/SergiSancho/ITAcademy/blob/master/sprint1/src/main/java/tasca5/README.md)

[Nivell 1 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca5/n1exercici1)

Crea una classe que llisti alfabèticament el contingut d'un directori rebut per paràmetre.

[Nivell 1 - Exercici 2](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca5/n1exercici2)

Afegeix a la classe de l’exercici anterior, la funcionalitat de llistar un arbre de directoris amb el contingut de tots els seus nivells (recursivament) de manera que s'imprimeixin en pantalla en ordre alfabètic dins de cada nivell, indicant a més si és un directori (D) o un fitxer (F), i la seva última data de modificació.

[Nivell 1 - Exercici 3](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca5/n1exercici3)

Modifica l’exercici anterior. Ara, en lloc de mostrar el resultat per la pantalla, guarda el resultat en un fitxer TXT.

[Nivell 1 - Exercici 4](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca5/n1exercici4)

Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu contingut per consola.

[Nivell 1 - Exercici 5](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca5/n1exercici5)

Ara el programa ha de serialitzar un Objecte Java a un fitxer .ser i després l’ha de desserialitzar.

## Tasca 6. Generics

[Nivell 1 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca6/n1exercici1)

Crea una classe anomenada NoGenericMethods que emmagatzemi tres objectes del mateix tipus, juntament amb els mètodes per a emmagatzemar i extreure aquests objectes i un constructor per a inicialitzar els tres. Comprova que els arguments es poden posar en qualsevol posició en la crida al constructor.

[Nivell 1 - Exercici 2](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca6/n1exercici2)

Crea una classe anomenada Persona amb els atributs nom, cognom i edat. Després crea una classe anomenada GenericMethods amb un mètode genèric que accepti tres arguments de tipus genèric. Aquest mètode només ha d’imprimir per pantalla els arguments que ha rebut. Al main() de la classe principal, crida el mètode genèric amb diferents tipus de paràmetres.

[Nivell 2 - Exercici 1](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca6/n2exercici1)

Modifica l'exercici anterior de manera que un dels arguments del mètode genèric no sigui genèric.

[Nivell 2 - Exercici 2](https://github.com/SergiSancho/ITAcademy/tree/master/sprint1/src/main/java/tasca6/n2exercici2)

Modifica l'apartat anterior de manera que els arguments del mètode genèric siguin una llista d'arguments de variable indefinida.


