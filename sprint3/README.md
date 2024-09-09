# Patrones de Diseño en Java

En aquesta pràctica aprendrem a identificar i construir programes emprant patrons de disseny. La utilització de patrons és fonamental en la construcció d'un software extensible i reutilitzable. El llenguatge Java, així com tots els frameworks de software, estan fets d'acord amb els patrons més importants del software.

## Nivell 1: [Singleton](https://github.com/SergiSancho/ITAcademy/tree/master/sprint3/src/main/java/tasca1/n1)
En tots els exercicis, crea un projecte amb una classe Main que demostri l'ús del patró (amb les invocacions necessàries).

### Exercici: Singleton

- Crea una classe que repliqui el funcionament del comando 'Undo'. Aquesta classe serà utilitzada per la classe Main, que permetrà introduir opcions per consola.
- La classe 'Undo' ha de guardar les últimes comandes introduïdes. Ha de permetre afegir o eliminar comandes, així com llistar les últimes comandes introduïdes (semblant a la comanda 'history' en Linux).
- La classe 'Undo' ha d'implementar imprescindiblement un patró Singleton.

## Nivell 2: [Abstract Factory](https://github.com/SergiSancho/ITAcademy/tree/master/sprint3/src/main/java/tasca1/n2)
### Exercici: Abstract Factory

- Crea un petit gestor de direccions i números de telèfon internacionals.
- L'aplicació ha de permetre afegir a l'agenda, adreces i números de telèfon internacionals. Tenint en compte els diferents formats dels diferents països, construeix l'agenda, les adreces i els telèfons implementant un patró Abstract Factory.

## Nivell 3: [Command](https://github.com/SergiSancho/ITAcademy/tree/master/sprint3/src/main/java/tasca1/n3)
### Exercici: Command

- Dissenya un pàrquing de 4 vehicles: un cotxe, una bicicleta, un avió i un vaixell.
- Mostra com funciona el patró Command que implementa els mètodes arrencar, accelerar i frenar per a cada tipus de vehicle.

---

## Enllaços als mòduls
- [Nivell 1 - Singleton](ruta/al/modulo/singleton)
- [Nivell 2 - Abstract Factory](ruta/al/modulo/abstract-factory)
- [Nivell 3 - Command](ruta/al/modulo/command)
