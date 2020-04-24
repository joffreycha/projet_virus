# Import d'elasticsearch
from elasticsearch import Elasticsearch, helpers

# Récupération de la connexion à Elasticsearch
es = Elasticsearch(hosts="elastic:changeme@localhost:9200")

# Import de la bibliothèque csv
import csv


# Déclaration d'une fonction qui renvoie un itérable pour le stockage sur elasticsearch
def generate_data():
    # Ouverture du fichier csv
    with open(r'C:\Workspaces\projet_virus\data\MERS\mers_world_2012_2019_weekly_who.csv') as csvfile:
        # with ... as ... : Equivalent à :
        # try:
        #     csvfile = open(r'C:\Users\Guillaume\Desktop\Covid_project\Data\sars_2003_complete_dataset_clean.csv')
        # except:
        #     raise FileNotFoundError
        spamreader = csv.reader(csvfile, delimiter=',')
        # TODO : créer le dictionnaire JSON pour une ligne du fichier
        next(spamreader) # Skip le header
        for row in spamreader:
            # On récupère chaque ligne sous la forme d'une liste
            year, week, region, new_cases = row
            # On précise le schéma de l'objet json (dictionnaire python) à envoyer avec l'api bulk:
            # il est de la forme : 
            # {
            #   "index" : [nom_de_l_index],
            #   "_source" : [objet_json]
            # }
            yield {
                "_index": "mers_world_2012_2019_weekly_who",
                # Pour ancienne version d'Elasticsearch :
                "_type": "doc",
                # Si json : juste "_source": json_object
                "_source" : {
                    "year" : year,
                    "week" : week,
                    "region" : region,
                    "new_cases" : new_cases
                }
            }


# Envoie des données via l'api bulk sur elasticsearch
helpers.bulk(es, generate_data())
