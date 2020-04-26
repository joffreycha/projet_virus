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
            GHO_code, hospital_beds, GHO_url, publishState_code, publishState, publishState_url, year_code, year, year_url, region_code, region, region_url, country_code, country, country_url, nb, nb_numeric, low, high, StdErr, StdDev, comments = row
            if not publishState_url :
                publishState_url = 0
            if not year_url :
                year_url = 0
            if not region_code :
                region_code = 'null'
            if not region :
                region = 'null'
            if not region_url :
                region_url = 0
            if not country_url :
                country_url = 0
            if not low :
                low = 0
            if not high :
                high = 0
            if not StdErr :
                StdErr = 0
            if not StdDev :
                StdDev = 0
            if not comments :
                comments = 'null'
            
            # On précise le schéma de l'objet json (dictionnaire python) à envoyer avec l'api bulk:
            # il est de la forme : 
            # {
            #   "index" : [nom_de_l_index],
            #   "_source" : [objet_json]
            # }
            yield {
                "_index": "hospital_beds_per_10000",
                "_type": "doc",
                # Si json : juste "_source": json_object
                "_source": {
                    "year": year,
                    "region": region,
                    "country": country,
                    "nb": int(nb),
                    "comments": comments
                }
            }
        
mydb = client["epidemics"]
mycol = mydb["hospital_beds"]

mycol.insert_many(generate_data(r'C:\Workspaces\projet_virus\data\health_indicators\Hospital_bed.csv'))