import scrapy

class BrickSetSpider(scrapy.Spider):
    name = "brickset_spider"
    start_urls = ['https://www.who.int/csr/sars/country/table2004_04_21/en/']

    #def parse(self, response):
    #        elt = response.css('td.CenterAlign::text').extract()
    #        yield elt

    def parse(self, response):
        j=1
        while j<=30:
            line = response.xpath('//tbody/tr['+str(j)+']/td/text()').extract()
            print(line)
            
            yield {
                'line'+str(j): line,
            }
            
            j+=1