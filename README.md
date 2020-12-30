#Tarea 1
- No se considero que los personajes solo se pueden equipar con algunas armas, se supuso que todos los personajes (sin considerar los enemigos) se equipan con cualquier arma
- Se supuso que una arma es igual a otra si son de la misma clase y ademas todos sus atributos son iguales
- Se supuso que un personaje, tanto comunes como magos, son iguales si su nombre y su tipo son iguales
- Se supuso que dos enemigos son iguales si tienen el mismo peso y el mismo ataque

- La clase abstracta AbstractCharacter implementa la interfaz ICharacter y tiene una subclase abstracta para los personajes que implementa otra interfaz. La clase Enemy tambien es una subclase de la clase Abstract character.
- De la clase PlayerCharacter se extienden 2 clases, una de magos y otra de jugadores comunes. Para los tipos especificos de cada uno de estos se usaron enumeraciones MageType y ComunesType.
- La clase abstracta AbstractWeapon tiene como subclases todas las armas distintas. Todas estas tienen los mismos atributos a excepcion de Staff, a la que se le agrega magicdamage.

#Tarea 2
- Se supuso que si un personaje no se puede equipar con una arma entonces se queda con la que tenia anteriormente. (si no tenia ninguna se queda asi)
- El ataque es igual para todos los personajes, con el damage del arma, y para los enemigos con el damage de estos mismos.
- Solo se puede atacar si estan vivos y un personaje solo puede equiparse si esta vivo.

- El controlador cada vez que crea un personaje lo agrega a la lista que corresponde (enemies o party) y el handler correspondiente.
- El controlador cada vez que crea un arma lo agrega al inventario.
- Si un personaje se equipa la i-esima arma del inventario y logra equiparla esta se borra del inventario, y si el personaje ya tenia un arma la agrega devuelta. 
- Si a un personaje lo atacan y le hacen mas daños que la cantidad de puntos que este tenia, muere y se le avisa el handler correspondiente.

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
- En cualquier momento del juego se pueda apretar el boton "Restart Game" para comenzar el juego denuevo, pero para esto todos los personajes todavia vivos deben estar en la cola, menos el personaje que esta actualmente jugando si esque hay alguno.