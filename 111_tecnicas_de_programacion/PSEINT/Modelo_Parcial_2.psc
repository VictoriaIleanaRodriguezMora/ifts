Algoritmo sin_titulo
	Definir prods_id, N, X Como Entero
	Definir BAND Como L�gico
	X <- 25
	Dimensionar prods_id(10)
	N <- 0
	Para i<-1 Hasta 10 Con Paso 1 Hacer
		prods_id[i] <- azar(50)
		N <- N+1
	FinPara
	Para i<-1 Hasta N Con Paso 1 Hacer
		Escribir prods_id[i]
	FinPara
	Si N>0 Entonces
		Escribir 'N vale: ', N, ' y X vale: ', X
		i <- 1
		BAND <- Falso
		Mientras (BAND==Falso Y i<N) Hacer
			Si prods_id[i]==X Entonces
				Escribir 'El producto se encuentra disponible'
				BAND <- Verdadero
			SiNo
				i <- i+1
			FinSi
		FinMientras
		Si BAND==Falso Entonces
			Escribir 'El producto NO se encuentra disponible.'
		SiNo
			// Ac� va nada, porque si entr� ac� significa que BAND es VERDADERO. 
			// Y el mensaje de VERDADERO YA SE PUSO ARRIBA.
		FinSi
	SiNo
		Escribir 'El arreglo est� vac�o.'
	FinSi
FinAlgoritmo
