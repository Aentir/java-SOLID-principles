Utils/FileSystemPrinter
	Se ha eliminado el constructor y atributo: FileManager fileManager;

PRINCIPIO SEGREGACI�N DE INTERFACES
	La interfaz FileSystem es demasiado grande y adem�s, implementa m�todos que 
	nunca se llegan a utilizar originalmente, como los m�todos de "setPosition"
	y read.

	Se ha creado la interfaz "DirectorySystem", encargada de a�adir ficheros
	y se ha reducido la carga de la interfaz FileSystemItem, encargada de abrir, escribir
	y cerrar los ficheros

PRINCIPIO RESPONSABILIDAD �NICA
	La clase Directory tiene metodos que lanzan excepciones los cuales no les corresponde
	Ocurre lo mismo para la clase File, adem�s de los 2 m�todos de conversi�n que NUNCA se utilizan
	


-Se modifica el tipo de la variable "item" en FileSystemPrinter ya que ahora
esta nueva clase es la que tiene los metodos necesarios
	Se elimina atributo fileManager, no se usa
	Se elimina constructor, no se usa