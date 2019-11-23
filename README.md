# Mutants
Web Service
Mutantes

1- en todos los casos se admiten solo jsons con arrays de cadenas de NxN y mayores o iguales a 4. Si son menores el servicio devolverá "Forbidden"

2- Reconoce todas las coincidencias que aparezcan de forma horizontal, vertical y oblícuoas (de izquierda a derecha yendo hacia abajo).

Versión WEB

3 -URL de acceso a aplicación via servicios Web (endpoint): http://mutantswebservicev2-env.jp5mbq3wik.sa-east-1.elasticbeanstalk.com/

4- Servicios web implementados:

A-Guardar mutante:
URL: {endpoint}/mutant
HTTP metod: POST
Payload: []dna

B-Obtener stats de mutantes/nomutantes:
URL: {endpoint}/stats
HTTP method: GET

C-Resetear base de datos:
URL: {endpoint}/reboot
HTTP method: GET

5- Para poder ingresar un nuevo array de string y probar si se trata de un mutante llamar al servicio con la dirección: http://mutantswebservicev2-env.jp5mbq3wik.sa-east-1.elasticbeanstalk.com/mutant con método POST y mandar por parámetro la cadena con el formato admitido: Ejemplo: {"dna": ["TTGCA", "TCCCC", "TTTGG", "TATTT", "AATTC"] }

6- Para poder ver el servicio "stats" que permite saber el porcentaje de humanos que resultaron mutantes y el porcentaje que fueron no mutantes, se deberá llamar al servicio con la dirección: http://mutantswebservicev2-env.jp5mbq3wik.sa-east-1.elasticbeanstalk.com/stats con método GET. Y se mostrará un json con los porcentajes.
