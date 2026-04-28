# pip install pandas

import pandas as pd

peliculas = {
 'nombre': ['Peli A', 'Peli B', 'Peli C', 'Peli D', 'Peli E'],
 'director': ['Dir A', 'Dir B', 'Dir C', 'Dir D', 'Dir E',],
 'año': [1997, 2003, 1999, 1972, 2009],
 'género': ['drama', 'acción', 'ciencia ficción', 'drama', 'acción',],
 'puntaje': [8.6, None, 6.9, 7.5, 9.1,]
 }

df = pd.DataFrame(peliculas)
print(df.groupby('género')['puntaje'].sum())