# Import d'elasticsearch
from elasticsearch import Elasticsearch, helpers

# Récupération de la connexion à Elasticsearch
es = Elasticsearch(hosts="elastic:changeme@localhost:9200")

# Import de la bibliothèque csv
import csv


# Déclaration d'une fonction qui renvoie un itérable pour le stockage sur elasticsearch
def generate_data():
    # Ouverture du fichier csv
    with open(r'C:\Workspaces\projet_virus\data\h1n1_2009.csv') as csvfile:
        # with ... as ... : Equivalent à :
        # try:
        #     csvfile = open(r'C:\Users\Guillaume\Desktop\Covid_project\Data\sars_2003_complete_dataset_clean.csv')
        # except:
        #     raise FileNotFoundError
        spamreader = csv.reader(csvfile, delimiter=',')
        # TODO : créer le dictionnaire JSON pour une ligne du fichier
        for row in spamreader:
            # On récupère chaque ligne sous la forme d'une liste
            country, cases, deaths, update_time = row
            # On précise le schéma de l'objet json (dictionnaire python) à envoyer avec l'api bulk:
            # il est de la forme : 
            # {
            #   "index" : [nom_de_l_index],
            #   "_source" : [objet_json]
            # }
            yield {
                "_index": "h1n1_2009",
                "_type": "doc",
                # Si json : juste "_source": json_object
                "_source": {
                    "country": country,
                    "cases": cases,
                    "deaths": deaths,
                    "update_time": update_time
                }
            }


# Envoie des données via l'api bulk sur elasticsearch
helpers.bulk(es, generate_data())
