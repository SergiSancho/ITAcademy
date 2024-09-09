# Patrones de Diseño en Java - Módulo

En aquesta pràctica aprendrem a identificar i construir programes emprant patrons de disseny. La utilització de patrons és fonamental en la construcció d'un software extensible i reutilitzable. El llenguatge Java, així com tots els frameworks de software, estan fets d'acord amb els patrons més importants del software.

## Nivell 1: [Observer](https://github.com/SergiSancho/ITAcademy/tree/master/Sprint3.2/src/main/java/n1)

- Dissenya un sistema en el qual un **Agent de Borsa** (Observable) notifica a diverses **agències de Borsa** (Observers) canvis quan la Borsa puja o baixa.
- És necessari que l'objecte **Observable** mantingui referències als **Observers**.

## Nivell 2: [Callback](https://github.com/SergiSancho/ITAcademy/tree/master/Sprint3.2/src/main/java/n2)

- Simula una passarel·la de pagament que rebi un objecte encapsulador del mètode de pagament a efectuar: targeta de crèdit, Paypal o deute en compte bancari.
- La passarel·la invocarà el pagament sense conèixer la forma i retornant el control a la classe d'origen.
- La classe que invoca la passarel·la de pagament serà una **botiga de sabates**.

## Nivell 3: [Converter](https://github.com/SergiSancho/ITAcademy/tree/master/Sprint3.2/src/main/java/n3)

- En aquest nivell es treballa amb un patró **Converter** que permet transformar entitats d'un format a un altre. Implementa una classe que converteixi objectes d'una classe a una altra, mostrant com funciona el patró.
---
