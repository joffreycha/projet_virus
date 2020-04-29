# Import mongo
from pymongo import MongoClient

# Connexion à Mongo
client = MongoClient("mongodb://localhost:27017/")

# Import de la bibliothèque csv
import csv

#Conversion string en date
from datetime import datetime

#Import pour récupérer les fichiers de la grippe
import os.path

# Déclaration d'une fonction qui renvoie un itérable pour le stockage 
def generate_data(nom_fichier):
    
    # Ouverture du fichier csv
    with open(nom_fichier) as csvfile:
        spamreader = csv.reader(csvfile, delimiter=',')
        next(spamreader)
        # TODO : créer le dictionnaire JSON pour une ligne du fichier
        for row in spamreader:
            # On récupère chaque ligne sous la forme d'une liste
            country, cases, deaths, update_time = row
            if not deaths :
                deaths = 0
            
            # On précise le schéma de l'objet json (dictionnaire python) à envoyer avec l'api bulk:
            # il est de la forme : 
            # {
            #   "index" : [nom_de_l_index],
            #   "_source" : [objet_json]
            # }
            yield {
                    "country": country,
                    "cases": cases,
                    "deaths": int(deaths),
                    "update_time": datetime.strptime(update_time, "%m/%d/%Y %H:%M")
            }
        
mydb = client["epidemics"]
mycol = mydb["h1n1_days"]

mycol.insert_many(generate_data(r'..\data\h1n1\h1n1_2009_who.csv'))