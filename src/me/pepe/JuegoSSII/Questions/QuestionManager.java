package me.pepe.JuegoSSII.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import me.pepe.GameAPI.Utils.Utils;

public class QuestionManager {
	private HashMap<Integer, Question> questions = new HashMap<Integer, Question>();
	public QuestionManager() {
		registerQuestion(new Question("�Cuales de las siguientes fases forman el ciclo de instruccion?", Arrays.asList("Fase de desarrollo y fase de b�queda", "Fase de b�squeda y fase de ejecuci�n", "Fase de creaci�n y fase de desarrollo", "Fase de creaci�n y fase de ejecuci�n"), "Fase de b�squeda y fase de ejecuci�n", 30));
		registerQuestion(new Question("La memoria principal es conocida como la memoria central o memoria RAM", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("�De que tipo es una red de conexi�n de bluetooth?", Arrays.asList("PAN", "WAN", "LAN", "MAN"), "PAN", 15));
		registerQuestion(new Question("El mapa l�gico de la red nos mostrar� una representaci�n gr�fica real de la situaci�n de los componentes de la red dentro de un determinado espacio.", Arrays.asList("Verdadero", "Falso"), "Falso", 15));
		registerQuestion(new Question("�Cu�les de las siguientes opciones son funciones que desempe�a un sistema operativo?", Arrays.asList("Administraci�n de procesos, administraci�n de recursos, administraci�n de la memoria y\r\n recuperaci�n de errores.", "Administraci�n de procesos, administraci�n de recursos, administraci�n de la memoria y\r\n.gesti�n de la alimentaci�n de los componentes.", "Administraci�n del cableado de los discos, administraci�n de recursos, administraci�n de la\r\nmemoria y gesti�n de la alimentaci�n de los componentes.", "Ninguna de las opciones es correcta."), "Administraci�n de procesos, administraci�n de recursos, administraci�n de la memoria y\\r\\n recuperaci�n de errores.", 15));
		registerQuestion(new Question("�Qu� tipos de licencias se pueden adquirir de forma gratuita y con permisos para su\r\nredistribuci�n?", Arrays.asList("Shareware y freeware", "Comercial y shareware", "Software libre y comercial", "Freeware y software libre"), "Freeware y software libre", 15));
		registerQuestion(new Question("Las m�quinas virtuales nos permiten incrementar el hardware instalado en una m�quina de\r\n"
				+ "forma que podremos mejorar las prestaciones de un sistema inform�tico e instalar m�s\r\n"
				+ "sistemas operativos en este.", Arrays.asList("Verdadero", "Falso"), "Falso", 15));
		registerQuestion(new Question("�En qu� tipo de partici�n instalaremos un sistema operativo?", Arrays.asList("Primaria", "Extendida", "Secundaria", "Esclava"), "Primaria", 15));
		registerQuestion(new Question("Tener el sistema operativo actualizado a sus �ltimas versiones mejorar� y perfilar� sus\r\n"
				+ "funcionalidades y nos ofrecer� una mayor seguridad.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("Para un funcionamiento �ptimo de los registros, debemos realizar regularmente un\r\n"
				+ "mantenimiento y limpieza de estos.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("En un sistema Linux, podemos representar los diferentes permisos con 9 caracteres que se\r\n"
				+ "dividen en grupos de tres caracteres. �A qu� hace referencia el primer grupo de tres caracteres\r\n"
				+ "(empezando por la izquierda)?", Arrays.asList("El propietario de fichero", "El grupo de usuarios", "Todos los usuarios", "Ninguna de las respuestas es correcta"), "El propietario del fichero", 15));
		registerQuestion(new Question("En las cuentas de usuario de administrador, la seguridad en las contrase�as es muy\r\n"
				+ "importante. �Qu� caracter�sticas deber�amos aplicar en las contrase�as para ofrecer una\r\n"
				+ "mayor seguridad?", Arrays.asList("Utilizar t�rminos conocidos para evitar olvidar la contrase�a, 4 caracteres como m�ximo y\r\n"
						+ "mantener siempre la misma contrase�a.", "Usar 8 caracteres como m�nimo, no usar t�rminos obvios, renovar la contrase�a\r\n"
								+ "peri�dicamente y usar diferentes s�mbolos.", "Permitir modificar la contrase�a solo al usuario Administrador y que esta no sufra cambios.", "Solo utilizar caracteres num�ricos y 8 caracteres como m�ximo."), "Usar 8 caracteres como m�nimo, no usar t�rminos obvios, renovar la contrase�a\r\n"
										+ "peri�dicamente y usar diferentes s�mbolos.", 15));
		registerQuestion(new Question("�Qu� clase de red tiene como mascara el valor 255.255.0.0?", Arrays.asList("Clase A", "Clase B", "Clase C", "Clase D"), "Clase B", 15));
		registerQuestion(new Question("En las direcciones de clase B, �cu�ntos bloques de enteros de 4 bytes dedicaremos a identificar\r\n"
				+ "los equipos?", Arrays.asList("4", "2", "1", "3"), "3", 15));
		registerQuestion(new Question("�En qu� directorio de Linux encontraremos la configuraci�n de la red?", Arrays.asList("etc/network/interfaces", "dev/network/config", "bin/network/interfaces", "etc/config/network"), "etc/network/interfaces", 15));
		registerQuestion(new Question("�Qu� informaci�n muestra el comando �dir� en Windows?", Arrays.asList("Mostrar el contenido del directorio.", "Analiza el disco principal del sistema.", "Muestra una lista con las tareas programadas del sistema.", "Muestra una lista de los procesos activos en el sistema."), "Mostrar el contenido del directorio.", 15));
		registerQuestion(new Question("�Qu� acci�n realiza la palabra reservada �ls� en una sentencia de comandos en Linux?", Arrays.asList("Mostrar el contenido del directorio.", "Nos ofrece un editor de texto para crear ficheros.", "Devuelve informaci�n detallada de la red.", "Eleva los privilegios a root para poder lanzar el comando."), "Mostrar el contenido del directorio.", 15));
		registerQuestion(new Question("�Qu� sistema de archivos utiliza Windows 10?", Arrays.asList("Fat32", "NTFS", "Ext3", "Ext2"), "NTFS", 15));
		registerQuestion(new Question("Los directorios o tambi�n conocidos como ficheros son conjuntos de datos ordenados en los\r\n"
				+ "que almacenamos informaci�n.", Arrays.asList("Verdadero", "Falso"), "Falso", 15));
		registerQuestion(new Question("�Cu�l de las siguientes opciones es utilizada como comando para desplazarnos por los\r\n"
				+ "directorios del sistema?", Arrays.asList("dir", "cd", "ls -s", "md"), "cd", 15));
		registerQuestion(new Question("�En qu� carpeta del sistema almacena un sistema operativo Windows la instalaci�n de los\r\n"
				+ "programas que tenga instalados?", Arrays.asList("etc", "Archivos de programas", "Documents and settings", "bin"), "Archivos de programas", 15));
		registerQuestion(new Question("�Cu�l de las siguientes opciones re�ne herramientas que nos brinda el sistema operativo\r\n"
				+ "Windows?", Arrays.asList("Administraci�n de equipos, administrador de discos y programador de tareas.", "Generador de eventos, programador de tareas y referenciador de registros.", "Publicador de contenido, administrador de equipos y administrador de discos.", "Referenciador de registros, administrador de discos y generador de eventos."), "Administraci�n de equipos, administrador de discos y programador de tareas.", 15));
		registerQuestion(new Question("El monitor de rendimiento de Windows permite generar informes a partir de los cuales es\r\n"
				+ "posible elaborar estad�sticas.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("Una unidad f�sica de disco no se puede dividir en varias particiones, sino que siempre se ver�\r\n"
				+ "como una sola partici�n completa y para obtener m�s particiones necesitaremos m�s discos.", Arrays.asList("Verdadero", "Falso"), "Falso", 15));
		registerQuestion(new Question("Los sistemas de ficheros est�n sometidos a constantes procesos de creaci�n, borrado y\r\n"
				+ "modificaci�n de archivos que, a la larga, provocar� que los ficheros se fragmenten y surjan\r\n"
				+ "huecos sin informaci�n en nuestras particiones.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("�En una estructura clienteservidor qui�n proporciona los servicios?", Arrays.asList("El cliente", "El servidor", "El segundo equipo cliente del que dispone la estructura", "En este tipo de estructuras no se proporcionan servicios"), "El servidor", 15));
		registerQuestion(new Question("�Cu�l de las siguientes opciones agrupa las caracter�sticas que nos ofrece el protocolo\r\n"
				+ "LDAP?", Arrays.asList("Acreditaci�n de usuarios, b�squeda de datos, centralizaci�n de la informaci�n y posibilidad\r\n"
						+ "de replicar la base de datos.", "Asignaci�n de velocidad de transmisi�n, b�squeda de datos y mayor protecci�n en\r\n"
								+ "transmisi�n de datos por USB.", "Mayor protecci�n en transmisiones de datos por USB, acreditaci�n de usuarios y posibilidad\r\n"
										+ "de replicar la base de datos.", "Necesita de una memoria RAM superior a 4GB."), "Acreditaci�n de usuarios, b�squeda de datos, centralizaci�n de la informaci�n y posibilidad\r\n"
												+ "de replicar la base de datos.", 15));
		registerQuestion(new Question("�Qu� son las unidades organizativas en Active Directory?", Arrays.asList("Contenedores de objetos que permiten organizarlos jer�rquicamente en subgrupos dentro\r\n"
				+ "del dominio.", "Un m�todo de comunicaci�n entre dominios, �rboles y bosques.", "Son conjuntos de dominios que poseen una ra�z com�n.", "Un repositorio en que se guarda la informaci�n referente a los usuarios, grupos, recursos,\r\n"
						+ "etc."), "Contenedores de objetos que permiten organizarlos jer�rquicamente en subgrupos dentro\r\n"
								+ "del dominio.", 15));
		registerQuestion(new Question("En servicios de administraci�n de usuarios como Active Directory de Windows, podemos\r\n"
				+ "generar diferentes usuarios para un dominio y asignarles diferentes permisos y roles de\r\n"
				+ "usuarios para obtener un mayor control dentro de la red.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("Las variables de entorno nos permiten definir caracter�sticas comunes que podremos aplicar a\r\n"
				+ "diferentes usuarios.", Arrays.asList("Verdadero", "Falso"), "Verdadero", 15));
		registerQuestion(new Question("�Cu�l de las siguientes opciones son variables de entorno (por defecto) en un sistema\r\n"
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
