# Import d'elasticsearch
#from elasticsearch import Elasticsearch, helpers

# Import mongo
from pymongo import MongoClient

# Récupération de la connexion à Elasticsearch
#es = Elasticsearch(hosts="elastic:changeme@localhost:9200")

# Connexion à Mongo
client = MongoClient("mongodb://localhost:27017/")

# Import de la bibliothèque csv
import csv

#Conversion string en date
from datetime import datetime

#Import pour récupérer les fichiers de la grippe
import os.path

# Déclaration d'une fonction qui renvoie un itérable pour le stockage sur elasticsearch
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
            country, who_region, region, year, week, dateds, datefs, collected, processed, type_A_H1, type_A_H1N1, type_A_H3, type_A_H5, type_A_NS, type_A_total, type_B_Yamata, type_B_Victoria, type_B_ND, type_B_total, total_positives, total_negatives, ILI = row
            if not collected :
                collected = 0
            if not processed :
                processed = 0
            if not type_A_H1 :
                type_A_H1 = 0
            if not type_A_H1N1 :
                type_A_H1N1 = 0
            if not type_A_H3 :
                type_A_H3 = 0
            if not type_A_H1 :
                type_A_H1 = 0
            if not type_A_H5 :
                type_A_H5 = 0
            if not type_A_NS :
                type_A_NS = 0
            if not type_A_total :
                type_A_total = 0
            if not type_B_Yamata :
                type_B_Yamata = 0
            if not type_B_Victoria :
                type_B_Victoria = 0
            if not type_B_ND :
                type_B_ND = 0
            if not type_B_total :
                type_B_total = 0
            if not total_negatives :
                total_negatives = 0
            if not total_positives :
                total_positives = 0
            
            # On précise le schéma de l'objet json (dictionnaire python) à envoyer avec l'api bulk:
            # il est de la forme : 
            # {
            #   "index" : [nom_de_l_index],
            #   "_source" : [objet_json]
            # }
            yield {
                "_index": "influenza",
                "_type": "doc",
                # Si json : juste "_source": json_object
                "_source": {
                    "country": country,
                    "who_region": who_region,
                    "region": region,
                    "year": year,
                    "week": week,
                    "dateds": dateds,
                    "datefs": datefs,
                    "collected": collected,
                    "processed":processed,
                    "type_A_H1": int(type_A_H1),
                    "type_A_H1N1": int(type_A_H1N1),
                    "type_A_H3": int(type_A_H3),
                    "type_A_H5": int(type_A_H5),
                    "type_A_NS": int(type_A_NS),
                    "type_A_total": int(type_A_total),
                    "type_B_Yamata": int(type_B_Yamata),
                    "type_B_Victoria": int(type_B_Victoria),
                    "type_B_ND": int(type_B_ND),
                    "type_B_total": int(type_B_total),
                    "total_positives": int(total_positives),
                    "total_negatives": int(total_negatives),
                    "ILI": ILI
                }
            }
        

def listdirectory(path): 
    fichier=[] 
    for root, dirs, files in os.walk(path): 
        for i in files: 
            fichier.append(os.path.join(root, i)) 
    return fichier

liste_fichier = listdirectory(r'..\data\Influenza')

mydb = client["epidemics"]
mycol = mydb["influenza"]

for nom_fichier in liste_fichier:
    mycol.insert_many(generate_data(nom_fichier))

# Envoie des données via l'api bulk sur elasticsearch
#Liste pour récupérer tout les fichiers de la grippe
 #   helpers.bulk(es, generate_data(nom_fichier))