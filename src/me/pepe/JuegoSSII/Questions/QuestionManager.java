package me.pepe.JuegoSSII.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.pepe.GameAPI.Utils.Utils;

public class QuestionManager {
	private HashMap<Integer, Question> questions = new HashMap<Integer, Question>();
	public QuestionManager() {
		registerQuestion(new Question("¿Cuales de las siguientes fases forman el ciclo de instruccion?", Arrays.asList("Fase de desarrollo y fase de búqueda", "Fase de búsqueda y fase de ejecución", "Fase de creación y fase de desarrollo", "Fase de creación y fase de ejecución"), "Fase de búsqueda y fase de ejecución", 30));
		registerQuestion(new Question("La memoria principal es conocida como la memoria central o memoria RAM", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("¿De que tipo es una red de conexión de bluetooth?", Arrays.asList("PAN", "WAN", "LAN", "MAN"), "PAN", 15));
		registerQuestion(new Question("El mapa lógico de la red nos mostrará una representación gráfica real de la situación de los componentes de la red dentro de un determinado espacio.", Arrays.asList("Verdadero", "Falso"), "Falso", 15));
		registerQuestion(new Question("¿Cuáles de las siguientes opciones son funciones que desempeña un sistema operativo?", Arrays.asList("Administración de procesos, administración de recursos, administración de la memoria y\r\n recuperación de errores.", "Administración de procesos, administración de recursos, administración de la memoria y\r\n.gestión de la alimentación de los componentes.", "Administración del cableado de los discos, administración de recursos, administración de la\r\nmemoria y gestión de la alimentación de los componentes.", "Ninguna de las opciones es correcta."), "Administración de procesos, administración de recursos, administración de la memoria y\\r\\n recuperación de errores.", 15));
		registerQuestion(new Question("¿Qué tipos de licencias se pueden adquirir de forma gratuita y con permisos para su\r\nredistribución?", Arrays.asList("Shareware y freeware", "Comercial y shareware", "Software libre y comercial", "Freeware y software libre"), "Freeware y software libre", 15));
		registerQuestion(new Question("Las máquinas virtuales nos permiten incrementar el hardware instalado en una máquina de\r\n"
				+ "forma que podremos mejorar las prestaciones de un sistema informático e instalar más\r\n"
				+ "sistemas operativos en este.", Arrays.asList("Verdadero", "Falso"), "Falso", 15));
		registerQuestion(new Question("¿En qué tipo de partición instalaremos un sistema operativo?", Arrays.asList("Primaria", "Extendida", "Secundaria", "Esclava"), "Primaria", 15));
		registerQuestion(new Question("Tener el sistema operativo actualizado a sus últimas versiones mejorará y perfilará sus\r\n"
				+ "funcionalidades y nos ofrecerá una mayor seguridad.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("Para un funcionamiento óptimo de los registros, debemos realizar regularmente un\r\n"
				+ "mantenimiento y limpieza de estos.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("En un sistema Linux, podemos representar los diferentes permisos con 9 caracteres que se\r\n"
				+ "dividen en grupos de tres caracteres. ¿A qué hace referencia el primer grupo de tres caracteres\r\n"
				+ "(empezando por la izquierda)?", Arrays.asList("El propietario de fichero", "El grupo de usuarios", "Todos los usuarios", "Ninguna de las respuestas es correcta"), "El propietario del fichero", 15));
		registerQuestion(new Question("En las cuentas de usuario de administrador, la seguridad en las contraseñas es muy\r\n"
				+ "importante. ¿Qué características deberíamos aplicar en las contraseñas para ofrecer una\r\n"
				+ "mayor seguridad?", Arrays.asList("Utilizar términos conocidos para evitar olvidar la contraseña, 4 caracteres como máximo y\r\n"
						+ "mantener siempre la misma contraseña.", "Usar 8 caracteres como mínimo, no usar términos obvios, renovar la contraseña\r\n"
								+ "periódicamente y usar diferentes símbolos.", "Permitir modificar la contraseña solo al usuario Administrador y que esta no sufra cambios.", "Solo utilizar caracteres numéricos y 8 caracteres como máximo."), "Usar 8 caracteres como mínimo, no usar términos obvios, renovar la contraseña\r\n"
										+ "periódicamente y usar diferentes símbolos.", 15));
		registerQuestion(new Question("¿Qué clase de red tiene como mascara el valor 255.255.0.0?", Arrays.asList("Clase A", "Clase B", "Clase C", "Clase D"), "Clase B", 15));
		registerQuestion(new Question("En las direcciones de clase B, ¿cuántos bloques de enteros de 4 bytes dedicaremos a identificar\r\n"
				+ "los equipos?", Arrays.asList("4", "2", "1", "3"), "3", 15));
		registerQuestion(new Question("¿En qué directorio de Linux encontraremos la configuración de la red?", Arrays.asList("etc/network/interfaces", "dev/network/config", "bin/network/interfaces", "etc/config/network"), "etc/network/interfaces", 15));
		registerQuestion(new Question("¿Qué información muestra el comando “dir” en Windows?", Arrays.asList("Mostrar el contenido del directorio.", "Analiza el disco principal del sistema.", "Muestra una lista con las tareas programadas del sistema.", "Muestra una lista de los procesos activos en el sistema."), "Mostrar el contenido del directorio.", 15));
		registerQuestion(new Question("¿Qué acción realiza la palabra reservada “ls” en una sentencia de comandos en Linux?", Arrays.asList("Mostrar el contenido del directorio.", "Nos ofrece un editor de texto para crear ficheros.", "Devuelve información detallada de la red.", "Eleva los privilegios a root para poder lanzar el comando."), "Mostrar el contenido del directorio.", 15));
		registerQuestion(new Question("¿Qué sistema de archivos utiliza Windows 10?", Arrays.asList("Fat32", "NTFS", "Ext3", "Ext2"), "NTFS", 15));
		registerQuestion(new Question("Los directorios o también conocidos como ficheros son conjuntos de datos ordenados en los\r\n"
				+ "que almacenamos información.", Arrays.asList("Verdadero", "Falso"), "Falso", 15));
		registerQuestion(new Question("¿Cuál de las siguientes opciones es utilizada como comando para desplazarnos por los\r\n"
				+ "directorios del sistema?", Arrays.asList("dir", "cd", "ls -s", "md"), "cd", 15));
		registerQuestion(new Question("¿En qué carpeta del sistema almacena un sistema operativo Windows la instalación de los\r\n"
				+ "programas que tenga instalados?", Arrays.asList("etc", "Archivos de programas", "Documents and settings", "bin"), "Archivos de programas", 15));
		registerQuestion(new Question("¿Cuál de las siguientes opciones reúne herramientas que nos brinda el sistema operativo\r\n"
				+ "Windows?", Arrays.asList("Administración de equipos, administrador de discos y programador de tareas.", "Generador de eventos, programador de tareas y referenciador de registros.", "Publicador de contenido, administrador de equipos y administrador de discos.", "Referenciador de registros, administrador de discos y generador de eventos."), "Administración de equipos, administrador de discos y programador de tareas.", 15));
		registerQuestion(new Question("El monitor de rendimiento de Windows permite generar informes a partir de los cuales es\r\n"
				+ "posible elaborar estadísticas.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("Una unidad física de disco no se puede dividir en varias particiones, sino que siempre se verá\r\n"
				+ "como una sola partición completa y para obtener más particiones necesitaremos más discos.", Arrays.asList("Verdadero", "Falso"), "Falso", 15));
		registerQuestion(new Question("Los sistemas de ficheros están sometidos a constantes procesos de creación, borrado y\r\n"
				+ "modificación de archivos que, a la larga, provocará que los ficheros se fragmenten y surjan\r\n"
				+ "huecos sin información en nuestras particiones.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("¿En una estructura clienteservidor quién proporciona los servicios?", Arrays.asList("El cliente", "El servidor", "El segundo equipo cliente del que dispone la estructura", "En este tipo de estructuras no se proporcionan servicios"), "El servidor", 15));
		registerQuestion(new Question("¿Cuál de las siguientes opciones agrupa las características que nos ofrece el protocolo\r\n"
				+ "LDAP?", Arrays.asList("Acreditación de usuarios, búsqueda de datos, centralización de la información y posibilidad\r\n"
						+ "de replicar la base de datos.", "Asignación de velocidad de transmisión, búsqueda de datos y mayor protección en\r\n"
								+ "transmisión de datos por USB.", "Mayor protección en transmisiones de datos por USB, acreditación de usuarios y posibilidad\r\n"
										+ "de replicar la base de datos.", "Necesita de una memoria RAM superior a 4GB."), "Acreditación de usuarios, búsqueda de datos, centralización de la información y posibilidad\r\n"
												+ "de replicar la base de datos.", 15));
		registerQuestion(new Question("¿Qué son las unidades organizativas en Active Directory?", Arrays.asList("Contenedores de objetos que permiten organizarlos jerárquicamente en subgrupos dentro\r\n"
				+ "del dominio.", "Un método de comunicación entre dominios, árboles y bosques.", "Son conjuntos de dominios que poseen una raíz común.", "Un repositorio en que se guarda la información referente a los usuarios, grupos, recursos,\r\n"
						+ "etc."), "Contenedores de objetos que permiten organizarlos jerárquicamente en subgrupos dentro\r\n"
								+ "del dominio.", 15));
		registerQuestion(new Question("En servicios de administración de usuarios como Active Directory de Windows, podemos\r\n"
				+ "generar diferentes usuarios para un dominio y asignarles diferentes permisos y roles de\r\n"
				+ "usuarios para obtener un mayor control dentro de la red.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("Las variables de entorno nos permiten definir características comunes que podremos aplicar a\r\n"
				+ "diferentes usuarios.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("¿Cuál de las siguientes opciones son variables de entorno (por defecto) en un sistema\r\n"
				+ "operativo Windows?", Arrays.asList("%TMP%", "%Windows%", "%Documentos%", "%C:%"), "%TMP%", 15));
	}
	private void registerQuestion(Question question) {
		questions.put(questions.size() + 1, question);
	}
	public Question getQuestion(int id) {
		return questions.get(id);
	}
	public List<Question> getQuestions() {
		List<Question> sol = new ArrayList<Question>();
		for (Question q : questions.values()) {
			sol.add(q);
		}
		return sol;
	}
	public Question getRandomQuestion() {
		int random = Utils.random.nextInt(questions.size())+1;
		System.out.println(random);
		return questions.get(random);
	}
}
