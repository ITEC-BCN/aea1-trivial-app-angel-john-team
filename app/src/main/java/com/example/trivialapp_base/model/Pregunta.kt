package com.example.trivialapp_base.model

// Definición de la clase de datos Pregunta según requisitos
data class Pregunta(
    val pregunta: String,
    val categoria: String,
    val dificultad: String, // "Facil", "Medio", "Dificil"
    val respuesta1: String,
    val respuesta2: String,
    val respuesta3: String,
    val respuesta4: String,
    val respuestaCorrecta: String // Debe coincidir con una de las anteriores
)

// Objeto para simular la base de datos local (Hardcoded)
object ProveedorPreguntas {
    fun obtenerPreguntas(): MutableList<Pregunta> {
        return mutableListOf(
            Pregunta("¿Capital de Francia?", "Geografía", "Facil", "Madrid", "París", "Berlin", "Roma", "París"),
            Pregunta("¿Fórmula del agua?", "Ciencia", "Facil", "H2O", "CO2", "O2", "H2O2", "H2O"),
            Pregunta("¿Quién pintó la Mona Lisa?", "Arte", "Medio", "Picasso", "Van Gogh", "Da Vinci", "Dalí", "Da Vinci"),
            Pregunta("¿Planeta más grande?", "Ciencia", "Medio", "Tierra", "Marte", "Júpiter", "Saturno", "Júpiter"),
            Pregunta("¿Año descubrimiento América?", "Historia", "Medio", "1492", "1500", "1485", "1992", "1492"),
            Pregunta("¿Elemento químico Au?", "Química", "Dificil", "Plata", "Oro", "Cobre", "Aluminio", "Oro"),
            Pregunta("¿Autor del Quijote?", "Literatura", "Facil", "Cervantes", "Quevedo", "Lope", "Góngora", "Cervantes"),
            Pregunta("¿Velocidad de la luz?", "Física", "Dificil", "300.000 km/s", "150.000 km/s", "1000 km/s", "Mach 1", "300.000 km/s"),
            Pregunta("¿Moneda de Japón?", "Economía", "Medio", "Yuan", "Won", "Yen", "Dólar", "Yen"),
            Pregunta("¿Campeón mundial fútbol 2010?", "Deportes", "Facil", "Brasil", "Alemania", "España", "Italia", "España"),
            Pregunta("¿Rey de los dioses griegos?", "Mitología", "Facil", "Zeus", "Hades", "Poseidón", "Ares", "Zeus"),
            Pregunta("¿Hueso más largo del cuerpo?", "Anatomía", "Medio", "Fémur", "Tibia", "Húmero", "Radio", "Fémur"),
            Pregunta("¿Pokémon más compatible?", "Anatomía", "Facil", "Gardevoir", "Lopunny", "Vaporeon", "Likitung", "Vaporeon"),
            Pregunta("¿Cuál es el fontanero más famoso de los videojuegos?", "Videojuegos", "Facil", "Mario", "Luigi", "Sonic", "Link", "Mario"),
            Pregunta("¿En qué videojuego aparece el personaje Link?", "Videojuegos", "Facil", "Zelda", "Final Fantasy", "Dark Souls", "Metroid", "Zelda"),
            Pregunta("¿Qué empresa desarrolló la consola PlayStation?", "Videojuegos", "Medio", "Nintendo", "Sega", "Sony", "Microsoft", "Sony"),
            Pregunta("¿Cuál es el objetivo principal en Minecraft?", "Videojuegos", "Medio", "Derrotar al Ender Dragon", "Rescatar a la princesa", "Esclavismo", "Completar misiones lineales", "Derrotar al Ender Dragon"),
            Pregunta("¿Cómo se llama el protagonista de Halo?", "Videojuegos", "Medio", "Master Chief", "Doom Slayer", "Samus", "Kratos", "Master Chief"),
            Pregunta("¿Qué género pertenece League of Legends?", "Videojuegos", "Medio", "Tortura", "MOBA", "RPG", "Plataformas", "MOBA"),
            Pregunta("¿En qué videojuego se utiliza la Trifuerza?", "Videojuegos", "Dificil", "Pokémon", "God of War", "Skyrim", "Zelda", "Zelda"),
            Pregunta("¿Qué compañía creó el videojuego Sonic?", "Videojuegos", "Facil", "Nintendo", "Capcom", "Sega", "Konami", "Sega"),
            Pregunta("¿En qué juego aparece el personaje Kratos?", "Videojuegos", "Medio", "God of War", "Assassin's Creed", "Dark Souls", "Diablo", "God of War"),
            Pregunta("¿Qué comunidad filtro documentos confidenciales militares?", "Videojuegos", "Dificil", "Call of Duty", "Battlefield", "War Thunder", "Super Mario 64", "War Thunder"),
            Pregunta("¿Qué videojuego trata sobre esclavizar animales?", "Videojuegos", "Facil", "Palworld", "Digimon", "Monster Hunter", "Pokémon", "Pokémon"),
            Pregunta("¿Cómo se llama el mundo principal de Dark Souls?", "Videojuegos", "Dificil", "Yharnam", "Lordran", "Drangleic", "Lothric", "Lordran"),
            Pregunta("¿Qué estudio desarrolló The Witcher 3?", "Videojuegos", "Dificil", "Bethesda", "CD Projekt Red", "BioWare", "Ubisoft", "CD Projekt Red"),
            Pregunta("¿Cuál fue la primera consola de sobremesa de Nintendo?", "Videojuegos", "Dificil", "Nintendo 64", "SNES", "GameCube", "NES", "NES"),
            Pregunta("¿En qué año se lanzó el videojuego Half-Life?", "Videojuegos", "Dificil", "1996", "2000", "1998", "2002", "1998"),
            Pregunta("¿Cómo se llama la inteligencia artificial antagonista en Portal?", "Videojuegos", "Dificil", "Cortana", "SHODAN", "GLaDOS", "HAL 9000", "GLaDOS"),
            Pregunta("¿Qué personaje es el protagonista de Metal Gear Solid 3?", "Videojuegos", "Dificil", "Solid Snake", "Big Boss", "Liquid Snake", "Venom Snake", "Big Boss"),
            Pregunta("¿Qué personaje come fantasmas en un laberinto?", "Videojuegos", "Facil", "Pac-Man", "Mario", "Kirby", "Bomberman", "Pac-Man"),
            Pregunta("¿En qué juego aparecen las Poké Balls?", "Videojuegos", "Facil", "Digimon", "Pokémon", "Temtem", "Monster Rancher", "Pokémon"),
            Pregunta("¿Qué color tiene Sonic?", "Videojuegos", "Facil", "Rojo", "Verde", "Azul", "Amarillo", "Azul"),
            Pregunta("¿Cuál es el género de FIFA?", "Videojuegos", "Facil", "Carreras", "Deportes", "RPG", "Estrategia", "Deportes"),
            Pregunta("¿Qué consola es portátil?", "Videojuegos", "Facil", "PlayStation 5", "Xbox Series X", "Nintendo Switch", "PlayStation 4", "Nintendo Switch"),
            Pregunta("¿Cómo se llama la princesa que suele rescatar Mario?", "Videojuegos", "Medio", "Zelda", "Estela", "Daisy", "Peach", "Peach"),
            Pregunta("¿Qué juego popularizó el género battle royale?", "Videojuegos", "Medio", "PUBG", "Call of Duty", "Apex Legends", "Battlefield", "PUBG"),
            Pregunta("¿En qué videojuego aparece Ryu?", "Videojuegos", "Medio", "Street Fighter", "Tekken", "Mortal Kombat", "King of Fighters", "Street Fighter"),
            Pregunta("¿Qué empresa creó la Xbox?", "Videojuegos", "Medio", "Sony", "Nintendo", "Microsoft", "Sega", "Microsoft"),
            Pregunta("¿Cuál es el villano principal de The Legend of Zelda?", "Videojuegos", "Medio", "Bowser", "Sephiroth", "Ridley", "Ganon", "Ganon"),
            Pregunta("¿Cómo se llama la ciudad de GTA: Vice City?", "Videojuegos", "Dificil", "Liberty City", "Los Santos", "Vice City", "San Fierro", "Vice City"),
            Pregunta("¿Qué arma icónica usa Cloud Strife?", "Videojuegos", "Dificil", "Katana", "Buster Sword", "Gunblade", "Claymore", "Buster Sword"),
            Pregunta("¿En qué juego aparece el reino de Hyrule por primera vez?", "Videojuegos", "Dificil", "Zelda II", "A Link to the Past", "The Legend of Zelda", "Ocarina of Time", "The Legend of Zelda"),
            Pregunta("¿Qué compañía desarrolló Bloodborne?", "Videojuegos", "Dificil", "Capcom", "Konami", "Square Enix", "FromSoftware", "FromSoftware"),
            Pregunta("¿Cuál es el nombre real de Bowser?", "Videojuegos", "Dificil", "King Koopa", "Bowser Jr.", "Lord Koopa", "Dry Bowser", "King Koopa")
        )
    }
}