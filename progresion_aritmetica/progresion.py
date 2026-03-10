import pandas as pd
import tkinter as tk
from tkinter import messagebox


# Clase que revisa si una lista sigue una progresión aritmética
class ProgresionAritmetica:

    def __init__(self, lista_numeros):
        self.lista = lista_numeros  # guardamos la lista de números

    def es_progresion(self):

        # si hay menos de dos números no se puede analizar
        if len(self.lista) < 2:
            return False

        diferencia = self.lista[1] - self.lista[0]

        # revisa que todas las diferencias sean iguales
        for i in range(1, len(self.lista)):
            if self.lista[i] - self.lista[i - 1] != diferencia:
                return False

        return True

    # devuelve la diferencia entre números
    def obtener_diferencia(self):
        if len(self.lista) >= 2:
            return self.lista[1] - self.lista[0]
        return None


# función que se ejecuta al presionar el botón
def analizar_lista():

    entrada = caja_texto.get()

    try:
        numeros = [float(x) for x in entrada.split(",")]

        df = pd.DataFrame(numeros, columns=["Numeros"])

        pa = ProgresionAritmetica(numeros)

        if pa.es_progresion():
            resultado = f"SI es progresión aritmética\nDiferencia: {pa.obtener_diferencia()}"
        else:
            resultado = "NO es progresión aritmética"

        etiqueta_resultado.config(text=resultado)

    except:
        messagebox.showerror("Error", "Ingrese números separados por coma. Ejemplo: 2,4,6,8")

# Para saber si es una progresión aritmética se calcula la diferencia entre los primeros dos números
# y luego se revisa que todos los números consecutivos tengan exactamente esa misma diferencia.
# Si en algún punto la diferencia cambia, entonces la lista NO es una progresión aritmética.

# --------VENTANA----------------------------------------------------------------------

ventana = tk.Tk()
ventana.title("Verificador de Progresión Aritmética")
ventana.geometry("420x250")
ventana.config(bg="#f2f2f2")

titulo = tk.Label(
    ventana,
    text="Verificador de Progresión Aritmética",
    font=("Arial", 14, "bold"),
    bg="#f2f2f2"
)
titulo.pack(pady=10)

instruccion = tk.Label(
    ventana,
    text="Ingrese números separados por coma",
    bg="#f2f2f2"
)
instruccion.pack()

caja_texto = tk.Entry(
    ventana,
    width=35,
    font=("Arial", 12)
)
caja_texto.pack(pady=10)

boton = tk.Button(
    ventana,
    text="Analizar",
    command=analizar_lista,
    bg="#4CAF50",
    fg="white",
    font=("Arial", 11)
)
boton.pack(pady=5)

etiqueta_resultado = tk.Label(
    ventana,
    text="",
    font=("Arial", 12),
    bg="#f2f2f2"
)
etiqueta_resultado.pack(pady=20)

ventana.mainloop()