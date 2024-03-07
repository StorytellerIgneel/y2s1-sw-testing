import requests
import json
from bs4 import BeautifulSoup

url = "https://www.gsc.com.my/movies"

#use the requests library to get HTML content of the BBC News Homepage
response = requests.get(url)

#Parse the HTML content using BeautifulSoup:
soup = BeautifulSoup(response.content, "html.parser")

#Find all the HTML elements that contain article titles
movie_titles = soup.find_all(class_='font-l fw-bold')
movie_genres = soup.find_all(class_= 'nav navbar-nav')

json_list = []
#use the 'find_all' method of the soup object to find all the HTML elements with the tag 
#name may vary depending on the webpage and how it is structured

for title in movie_genres:
    genre = []
    movie = {}
    movie["title"] = movie_titles[movie_genres.index(title)].text
    genre_time = title.text.split('\n')[0].split(' ')
    movie["duration"] = {}
    for stuff in genre_time: #find for hr
        if stuff == "hr":
            index = genre_time.index(stuff)
            movie["duration"]["hours"] = int(genre_time[index -1])
            movie["duration"]["minutes"] = int(genre_time[index + 1])
            index -= 2
            for i in range(index):
                genre.insert(0, genre_time[index - i])
    if movie["duration"] == {}: #hr not found
        movie["duration"]["hours"] = 0
        movie["duration"]["minutes"] = 0
        try:
            index = genre_time.index("N/A") - 1
            for i in range(index):
                genre.insert(0, genre_time[index - i])
        except:
            genre = ["N/A"]
    movie["genre"] = "/".join(genre)
    movie["languages"] = [language for language in title.text.split('\n')[1].split(' ') if language != ""]
    for language in movie["languages"]:
        if "," in language:
            language_split = language.split(',')
            for splitted_language in language_split:
                movie["languages"].append(splitted_language)
            movie["languages"].remove(language)
    if len(movie["languages"]) == 0:
        movie["languages"] = ["N/A"]
    print(json.dumps(movie))