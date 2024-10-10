// Confeccionar un algoritmo que resuelva el siguiente problema: Dada un código alfanumérico, diseñar un algoritmo que valide el código una cantidad de veces que el usuario defina. Si código es correcto en algún intento, mostrar por pantalla: “Logueo Exitoso!!!”. Sino “Verifique su código y vuelva a cargarlo” hasta que agote las veces definidas. En el último intento debe cerrarse el programa mostrando el mensaje “Ha sido bloqueado por superar la cantidad de intentos posibles”. DF – PS

let limiteIntentos = 2; // ingresa el usuario
let cantIntentosUser = 1;
// let codUser = prompt("Ingresa tu código");

const codigoCorrecto = "ABC123"; // Código correcto
let intentos = 2;

while (cantIntentosUser < limiteIntentos) {
  codUser = prompt(`Intento ${cantIntentosUser}: Ingresa tu código`);

  if (codUser === codAlfanumerico) {
    console.log("Logueo Exitoso!!!");
  } else {
    console.log("Verifique su código y vuelva a intentarlo");
  }
  cantIntentosUser++;

  // Si se alcanzan el número máximo de intentos y no acertó
  if (cantIntentosUser > limiteIntentos) {
    console.log(
      "Ha sido bloqueado por superar la cantidad de intentos posibles."
    );
  }
}

// while (intentos > 0) {
//   const codigoIngresado = prompt("Ingrese el código:"); // Solicita el código

//   if (codigoIngresado === codigoCorrecto) {
//     console.log("Logueo Exitoso!!!"); // Mensaje de éxito
//     break; // Sale del bucle si el código es correcto
//   } else {
//     intentos--; // Reduce intentos
//     console.log("Verifique su código y vuelva a cargarlo");
//     console.log("Intentos restantes: " + intentos); // Muestra intentos restantes
//   }
// }

// if (intentos === 0) {
//   console.log("Ha sido bloqueado por superar la cantidad de intentos posibles"); // Mensaje de bloqueo
// }
