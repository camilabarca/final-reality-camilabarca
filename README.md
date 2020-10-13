#Tarea 1
- No se considero que los personajes solo se pueden equipar con algunas armas, se supuso que todos los personajes (sin considerar los enemigos) se equipan con cualquier arma
- Se supuso que una arma es igual a otra si son de la misma clase y ademas todos sus atributos son iguales
- Se supuso que un personaje, tanto comunes como magos, son iguales si su nombre y su tipo son iguales
- Se supuso que dos enemigos son iguales si tienen el mismo peso y el mismo ataque

- La clase abstracta AbstractCharacter implementa la interfaz ICharacter y tiene una subclase abstracta para los personajes que implementa otra interfaz. La clase Enemy tambien es una subclase de la clase Abstract character.
- De la clase PlayerCharacter se extienden 2 clases, una de magos y otra de jugadores comunes. Para los tipos especificos de cada uno de estos se usaron enumeraciones MageType y ComunesType.
- La clase abstracta AbstractWeapon tiene como subclases todas las armas distintas. Todas estas tienen los mismos atributos a excepcion de Staff, a la que se le agrega magicdamage.
