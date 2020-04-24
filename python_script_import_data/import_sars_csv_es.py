# Import d'elasticsearch
from elasticsearch import Elasticsearch, helpers

# Récupération de la connexion à Elasticsearch
es = Elasticsearch(hosts="elastic:changeme@localhost:9200")

# Import de la bibliothèque csv
import csv


# Déclaration d'une fonction qui renvoie un itérable pour le stockage sur elasticsearch
def generate_data():
    # Ouverture du fichier csv
    with open(r'C:\Workspaces\projet_virus\data\SARS\sars_2003_cases_deaths_by_day_who.csv') as csvfile:
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
            date, cases, deaths, url = row
            # On précise le schéma de l'objet json (dictionnaire python) à envoyer avec l'api bulk:
            # il est de la forme : 
            # {
            #   "index" : [nom_de_l_index],
            #   "_source" : [objet_json]
            # }
            yield {
                "_index": "sars_2003_cases_deaths_by_day_who",
                # Pour ancienne version d'Elasticsearch :
                "_type": "doc",
                # Si json : juste "_source": json_object
                "_source": {
                    "date": date,
                    "cases": cases,
                    "deaths": deaths,
                    "url": url
                }
            }


# Déclaration d'une fonction qui renvoie un itérable pour le stockage sur elasticsearch
def generate_data2():
    # Ouverture du fichier csv
    with open(r'C:\Workspaces\projet_virus\data\SARS\sars_2003_cases_deaths_recov_by_day&country_who.csv') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=',')
        next(spamreader) # Skip le header
        for row in spamreader:
            # On récupère chaque ligne sous la forme d'une liste
            date, country, cumulative_number_of_cases, deaths, recovered = row

            yield {
                "_index": "sars_2003_cases_deaths_recov_by_day&country_who",
                # Pour ancienne version d'Elasticsearch :
                "_type": "doc",
                "_source": {
                    "date": date,
                    "country": country,
                    "cumulative_number_of_cases": cumulative_number_of_cases,
                    "deaths": deaths,
                    "recovered": recovered
                }
            }

# Envoie des données via l'api bulk sur elasticsearch
helpers.bulk(es, generate_data())
helpers.bulk(es, generate_data2())
