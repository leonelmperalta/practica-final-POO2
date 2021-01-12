# "Práctica Final"

## Las condiciones de entrega

- Utilizar para la resolución los temas vistos en la materia: Principios SOLID, Patrones de diseño, clean code, Test Unitario, Mocks 
- El código debe compilar
- Tiene que haber buena covertura de test (no solo un test con el casos exitosos, probar todos los flujos posibles)
- Los tests tiene que correr

## Parte I

El Diablo no da más con el lío de demonios que tiene a su cargo y nos contrató para desarrollar un sistema que lo ayude a organizar sus cosas, que según sus propias palabras “son un infierno”.
Obviamente, nuestras pobres almas no opusieron resistencia a fin de evitar arder por toda la eternidad.

Nos cuenta que tiene distintos tipos de demonios: 
los hay de `fuego`, también de `hielo` (eternos rivales entre sí) y otros de `sombras`. Todos ellos con innumerables tareas a realizar, pero cuya tarea más *importante* es la de `cazar` almas, y es ésta la que el Diablo quiere que modelemos.

Cada `alma` tiene un determinado nivel de bondad y de valor. Tambien sabemos si el alma es friolenta o no.
El Diablo, eventualmente, da la orden a un demonio para que vaya a cazar almas a un determinado `lugar`. Los lugares tienen un nombre y un conjunto de almas que lo habitan.

Cuando un demonio sale a cazar a un `lugar`, para cada alma del lugar pueden ocurrir dos cosas: 
* que el demonio logre *cazarla*
* o bien que el demonio no logre su objetivo, en cuyo caso se desquita *atormentándola*.

Para poder cazar a un alma determinada tienen que darse *siempre* dos condiciones (para cualquier tipo de demonio) :

1. que el nivel de maldad del demonio, el cual se conoce para cada demonio, sea superior al nivel de bondad del alma
2. una condición propia de cada tipo de demonio:
* para el demonio de `sombras`, que el nivel de valor del alma esté por debajo de un límite dado, que es de 50.
* para los demonios de `hielo`, que el alma sea friolenta.
* para los demonios de `fuego`, que el alma NO sea friolenta.

Cuando un demonio no es capaz de cazar un alma, se dice que es un alma jodida para este demonio. Las almas jodidas son las que terminan siendo atormentadas cuando el demonio sale a cazar.
Cuando un demonio caza a un alma, la misma deja de habitar el lugar y pasa a estar en poder del demonio.

Las almas no cazadas (las jodidas), como se dijo, son `atormentadas` por el demonio. Cuando esto ocurre:
1. el nivel de bondad del alma se reduce en 5
2. dependiendo del tipo de demonio:
* Si el que atormenta es un demonio de fuego, entonces el alma atormentada deja de ser friolenta
* si es un demonio de hielo, entonces convierte al alma atormentada en friolenta
* los demonios de sombras disminuyen adicionalmente el nivel de valor a la mitad para mejorar las probabilidades de éxito en un ataque futuro.

Finalmente, cuando un demonio sale a cazar a un lugar aumenta su nivel de maldad en un número igual a la suma de la cantidad de almas atormentadas más el doble de las almas cazadas en ese lugar (no tener en cuenta las ya cazadas).

El Diablo quiere que modelemos la situación planteada de forma de lograr representar:

- Saber si un demonio puede cazar a un alma dada, porque cumple tanto las condiciones generales como las particulares según cada demonio.

- Que un demonio atormente a un alma en particular.

- Hacer que un demonio salga de caza a un lugar, cazando las almas que pueda y atormentando al resto. El lugar debe quedar sin las almas capturadas por el demonio.

## Parte II

Las `almas` pueden entrenar y aprender distintas técnicas para defenderse y evitar ser cazadas y/o atormentadas por los demonios. Las técnicas son las siguientes y un alma puede aprender mas de 1 técnica.

* Lucha marcial demoníaca: si un `almas` es entrenada en estas artes marcialaes, se duplica se duplica su `valor`.
* Supervivencia extrema en el infierno: si realiza esta supervivencia, el `almas` nunca puede ser friolenta.
* Cruz roja:  si se une a la cruz roja, el `almas` siempre va a tener como mínimo 100 de bondad.

- En este caso, el Diablo necesita poder entrenar un alma en particular en alguna técnica

## Parte III

El Diablo quiere que podamos obtener:
- todas las almas cazadas por todos sus demonios
- de todas las almas cazadas, quiere obtener la mas valiente
- obtener el demonio que mas almas cazó

## Parte IV

**Escondites** 

Las almas están cansadas de ser cazadas por los demonios y desarrollan una habilidad que les permite, momentos antes de ser cazadas por uno, esconderse dentro del lugar al que pertenece y de esa forma evitar se cazadas.

Existen lugares más seguros donde las almas pueden esconderse de forma fácil y lugares más inseguros.
Cuando un demonio intenta cazar en un lugar, las almas corren a esconderse. Dependiendo las condiciones del lugar, un alma puede lograrlo o no. Si el alma logró esconderse el demonio no logra cazarla pero SI puede atormentarla.

Existen distintos lugares, algunos mas seguros que otros, pero en todos hay escondites en donde las almas pueden esconderse, eso si, todos los lugares tienen un límite de almas para esconder. Si llegó al límite, no se aceptan mas almas.
Por otro lado, por esconderse un alma debe pagar un penalidad que depende del lugar.

Por último, Cuándo salen las almas del escondite?, salen ni bien un demonio termina de cazar en ese lugar.

**Lugares**

`Paraíso`
- Tiene 10 lugares para esconderse
- Lugar muy seguro para las almas, si hay lugar y el alma tiene `bondad` > 0, puede esconderse
- Solo se la penaliza descontando 1 en su `bondad`

`Purgatorio`
- Tiene 5 lugares para esconderse
- Si hay lugar , el alma tiene `bondad` > 10 y un `valor` > 5, puede esconderse
- Se la penaliza descontando 5 en su `bondad` y 1 en 

`Infierno`
- Tiene 2 lugares para esconderse
- Si hay lugar, el alma NO es friolenta y  su `bondad` es igual a su `valor`, puede esconderse
- Se la penaliza conviertiendola en `friolanta`

**Batallas**

El diablo a veces se aburre y para buscar algo de entretenimiento, organizó un torneo de batallas entre Demonios.
Para esto, cada demonio cuento con un conjunto de armas que le otorgan determinada energia.

Cada batalla consiste en la lucha entre 2 y gana el demonio que tiene mas poder. 
El poder de un demonio se calcula de la siguiente manera:

- poder: energia (provista por el arma) * nivel de maldad * cantidad de almas cazadas

Las batallas permiten que haya empates, en caso de empate.

*Premios y castigos*

Luego de terminada una batalla, el diablo premia al ganadores y castiga al perdedor. Los premios y castigos dependen del humor del diablo, si está `contento` al ganador le otorna 10 puntos extras en su nivel de maldad y al perdedor solo le quita 2 almas cazadas. En cambio, si el diablo esta `triste` al ganador solo le otorga 1 punto extra en su nivel de maldad y al perdedor le quita todas las almas cazadas.

*Armas*

Las almas disponibles para los demonios son las siguientes:
- Espada: Entrega 20 de poder
- Ballesta: Entrega 15 de poder
- Arco y flecha: Entrega 5 de poder
