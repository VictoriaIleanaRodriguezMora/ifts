Algoritmo ejercicio_24
    Definir costoTotal, kwUser, valor30kw, valor90kw, valor80kw, valorsig200kw Como Real
    valor30kw = 6.03
    valor90kw = 6.19
    valor80kw = 6.78
    valorsig200kw = 7.24
    costoTotal = 0
    Escribir "Ingrese los kW consumidos:"
    Leer kwUser
    Si (kwUser <= 30) Entonces
        costoTotal = kwUser * valor30kw
        Escribir "El costo es: $", costoTotal
    SiNo
        Si (kwUser <= 120) Entonces // 30 a 120 kW
            costoTotal = (30 * valor30kw) + ((kwUser - 30) * valor90kw)
            Escribir "El costo es: $", costoTotal
        SiNo
            Si (kwUser <= 200) Entonces // 120 a 200 kW
                costoTotal = (30 * valor30kw) + (90 * valor90kw) + ((kwUser - 120) * valor80kw)
                Escribir "El costo es: $", costoTotal
            SiNo // Más de 200 kW
                costoTotal = (30 * valor30kw) + (90 * valor90kw) + (80 * valor80kw) + ((kwUser - 200) * valorsig200kw)
                Escribir "El costo es: $", costoTotal
            FinSi
        FinSi
    FinSi
FinAlgoritmo
