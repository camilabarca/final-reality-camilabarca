#Tarea 1
- No se considero que los personajes solo se pueden equipar con algunas armas, se supuso que todos los personajes (sin considerar los enemigos) se equipan con cualquier arma
- Se supuso que una arma es igual a otra si son de la misma clase y ademas todos sus atributos son iguales
- Se supuso que un personaje, tanto comunes como magos, son iguales si su nombre y su tipo son iguales
- Se supuso que dos enemigos son iguales si tienen el mismo peso y el mismo ataque

- La clase abstracta AbstractCharacter implementa la interfaz ICharacter y tiene una subclase abstracta para los personajes que implementa otra interfaz. La clase Enemy tambien es una subclase de la clase Abstract character.
- De la clase PlayerCharacter se extienden 2 clases, una de magos y otra de jugadores comunes. Para los tipos especificos de cada uno de estos se usaron enumeraciones MageType y ComunesType.
- La clase abstracta AbstractWeapon tiene como subclases todas las armas distintas. Todas estas tienen los mismos atributos a excepcion de Staff, a la que se le agrega magicdamage.

#Tarea 2
- Se implemento el equipamiento con double dispatch y se supuso que si un personaje no puede equiparse con un arma se queda con el arma anterior (si no tiene ningun arma se queda sin arma)

- Se asumio que el ataque puede ser entre cualquier par de personajes, aunque sean del mismo equipo
- Para el ataque tambien se uso double dispatch
- El ataque de un enemigo es con su damage y el ataque de un personaje es con el damage de su arma actual

#Tarea 3
- El flujo del juego corresponde a 4 fases distintas. Se asumio que al crear los personajes estos se aregan inmediatamente a la cola, por lo que esta partira llena. 
- La primera fase, en la cual comienza el juego corresponde a "Poll Phase" que es la fase en la que se saca un personaje de la cola.
- Luego, dependiendo de si es un jugador o un enemigo, se pasa a "Play Character Phase" o a "Play Enemy Phase". En la fase de los personajes se puede equipar un arma y atacar, pero luego de atacar se cambia inmediatamente de fase. En la fase de los enemigos solo se puede atacar y tambien se cambia de fase cuando esto ocurre.
- Al atacar se cambia a "Poll Phase" si hay alguien en la cola y si esta esta vacia se pasa a "Wait Queue Phase".
- En "Wait Queue Phase" solo se espera a que alguien se agregue a la cola y cuando esto ocurre se vuelve a pasar a "Poll Phase".
##Interfaz Grafica

- Al comenzar en juego se parte con un boton que dice "Poll Character". Para jugar hay que apretar este boton, con el que se sacara al primer personaje de la cola.
- Si el personaje que se saca es un enemigo lo unico que se hace es apretar el boton "Attack Player" para que este haga su ataque automatico.
- Si el personaje es un personaje del jugador se tiene que apretar el boton "Equip" para elegir la arma a equipar y cuando el label que dice "Actual Weapon" tiene algo distinto de "None" se apreta "Attack" para elegir a que enemigo atacar.
- Si luego de que un personaje ataca la cola esta vacia se tiene que esperar, y una vez que la cola vuelva a tener un personaje se puede apretar "Next" para volver a sacar un personaje de la cola. Si la cola no esta vacia se volvera directamente a sacar un personaje de la cola.
- Al ganar o perder aparecera un mensaje que lo indique.