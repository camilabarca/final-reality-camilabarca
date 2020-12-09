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
