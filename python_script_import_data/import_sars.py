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
        # with ... as ... : Equivalent à :
        # try:
        #     csvfile = open(r'C:\Users\Guillaume\Desktop\Covid_project\Data\sars_2003_complete_dataset_clean.csv')
        # except:
        #     raise FileNotFoundError
        spamreader = csv.reader(csvfile, delimiter=',')
        next(spamreader)
        # TODO : créer le dictionnaire JSON pour une ligne du fichier
        for row in spamreader:
            # On récupère chaque ligne sous la forme d'une liste
            date, country, cumul_nb_cases, deaths, recovored = row
            
            # On précise le schéma de l'objet json (dictionnaire python) à envoyer avec l'api bulk:
            # il est de la forme : 
            # {
            #   "index" : [nom_de_l_index],
            #   "_source" : [objet_json]
            # }
            yield {
                    "date": datetime.strptime(date, "%Y-%m-%d"),
                    "country": country,
                    "cumul_nb_cases": cumul_nb_cases,
                    "deaths": deaths,
                    "recovored": recovored
            }
        
mydb = client["epidemics"]
mycol = mydb["sars"]

mycol.insert_many(generate_data(r'..\data\SARS\sars_2003_cases_deaths_recov_by_day&country_who.csv'))