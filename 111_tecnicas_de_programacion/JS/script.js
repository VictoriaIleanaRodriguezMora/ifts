// Confeccionar un algoritmo que resuelva el siguiente problema: Dada un código alfanumérico, diseñar un algoritmo que valide el código una cantidad de veces que el usuario defina. Si código es correcto en algún intento, mostrar por pantalla: “Logueo Exitoso!!!”. Sino “Verifique su código y vuelva a cargarlo” hasta que agote las veces definidas. En el último intento debe cerrarse el programa mostrando el mensaje “Ha sido bloqueado por superar la cantidad de intentos posibles”. DF – PS

let limiteIntentos = 3; // ingresa el usuario
let cantIntentosUser = 1;
let codUser = prompt("Ingresa tu código");

const codigoCorrecto = "ABC123"; // Código correcto
let intentos = 2;

while (cantIntentosUser < limiteIntentos && codUser != codigoCorrecto) {
  codUser = prompt(`INCORRECTO: Intento ${cantIntentosUser}: Ingresa tu código`);

  cantIntentosUser++;
}

// Si se alcanzan el número máximo de intentos y no acertó
if (cantIntentosUser > limiteIntentos) {
  console.log(
    "Ha sido bloqueado por superar la cantidad de intentos posibles."
  );
}
if (codUser === codigoCorrecto) {
  console.log("Logueo Exitoso!!!")
}