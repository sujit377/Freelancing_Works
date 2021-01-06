import mysql.connector as mc
from urllib.request import urlopen,Request
from bs4 import BeautifulSoup as bf
import requests
import time
import json
from datetime import datetime as dt

while(True):
    t = mc.connect(host = "localhost",
                  user="root",
                  password= "jaf123",
                  database="scraped_data")
    cursor = t.cursor()
    sql = "SELECT * from main_table"
    cursor.execute(sql)
    records = cursor.fetchall()
    bbb=[]
    ypage=[]
    for row in records:
        if(row[2]==0):
            bbb.append(row[1])
            ypage.append(row[0])

    t.close()



    emp = []
    for k in ypage:
        try:
            r = urlopen(k)
            soup = bf(r,'lxml')
        except:
            continue;
        result = soup.find(class_ = "pagination").find('p').text[8:-7]
        page_count = int(int(result)/30)
        if(not (int(int(result)%30)==0)):
            page_count= page_count+1

        durl = k.replace('+','%20') +'&page='
        for i in range(1,page_count+1):
            try:
                url = durl+str(i)
                r = urlopen(url)
                soup = bf(r,'lxml')
            except:
                continue;
            d = soup.find(class_ = "search-results organic")
            e =d.findAll(class_="result")
            for j in range(len(e)):
                e1 = []
                e1.append(e[j].find(class_ = "business-name").get_text())
                e1.append(e[j].find(class_ = "phones phone primary").get_text())
                address = ""

                try:
                    address = address+str(e[j].find(class_ = "street-address").get_text()+" "+e[j].find(class_ = "locality").get_text())
                except:
                    pass;
                try:
                    address = address + str(e[j].find(class_ = "adr").get_text())
                except:
                    address = "NA"
                if(address.strip()==""):
                    address = "NA"
                e1.append(address)
                e1.append("www.yellowpages.com")
                emp.append(e1)

    for k in bbb:
        try:
            r = urlopen(k)
            soup = bf(r,'lxml')
        except:
            continue;
        result = int(soup.find(class_ = "SubTitle-sc-1i5hw45-0 jbdTMG search-heading__subtitle").find('strong').text)
        if(result > 210):
            page_count = 15
        else:
            page_count = int(result/15)
            if(not result%15==0):
                page_count+=1
        print(page_count)
        for i in range(1,page_count+1):
            url = k.replace("page=1","page="+str(i))
            try:
                r = urlopen(url)
                soup = bf(r,'lxml')
            except:
                print("Error in page"+i)
                continue;
            e =soup.findAll(class_ = "MuiPaper-root MuiCard-root styles__ResultItem-sc-7wrkzl-0 yheMW result-item MuiPaper-elevation1 MuiPaper-rounded")
            for j in range(len(e)):
                e1 = []
                try:
                    e1.append(e[j].find(class_="MuiTypography-root Name-sc-1srnbh5-0 lfDNIb result-item__name MuiTypography-h4").find('a').get_text())
                except:
                    e1.append("NA")
                try:
                    e1.append(e[j].find(class_ = "MuiTypography-root Phone-sc-418jiw-0 blBqyQ result-item__phone MuiTypography-body1").get_text())
                except:
                    e1.append("NA")
                try:
                    e1.append(e[j].find(class_ = "MuiTypography-root Address-ee3ajc-0 fpMHTB result-item__address MuiTypography-body1").get_text())
                except:
                    e1.append("NA")
                e1.append("www.bbb.org")
                emp.append(e1)
    print("done")

    if(len(bbb)>0 or len(ypage)>0):
        t = mc.connect(host = "localhost",
                       user="root",
                       password= "####",
                       database="####")
        cursor = t.cursor()
        cursor.execute("truncate table vendor_data")
        for i in emp:
            sql = "INSERT INTO vendor_data (name,NUMBER,ADDRESS,Data_Address,Data_Site) VALUES (%s,%s,%s,%s,%s)" #vendor_data
            val = [i[0],i[1],i[2],"-",i[3]]
            cursor.execute(sql,val)
        t.commit()
        t.close()