# the_pokemon_api

![picture](pikachu.jpg)

The_pokemon_api is an application that receives and answers two types of requests about pokemons: 
1. requests about different pokemons available, with the resulting answer being all the pokemons that 
qualify the request
2. requests to select two pokemons to fight against each other, with a resulting answer being the 
winner pokemon

The application consists of two services. The first of two services receives HTTP requests from the 
client, forms them to JSON and places them on one of two queues, according to the type of request. 
Second service, that has the pokemon information, receives requests from the queues, implements the 
logic, forms answers to JSON and sends them back through different queues to the first service, which 
then delivers and answer to the client.

Both services are developed in Java, using Spring Boot, Gradle and RabbitMQ.

## Installation

To run the application RabbitMQ server has to be installed and running. When starting the application, Tomcat will start on ports 8070 and 8090 by default.

## Usage

#### Requests about different pokemons available
To get all the pokemons available go to http://localhost:8090/pokemons.
To filter pokemons according to specific features additionally use query string. Available request 
parameters of the query string are these:
1. `specificType` - string, specifying the type of pokemons that will satisfy the request
2. `multipleTypes` - boolean, if true meaning that only pokemons with multiple types will satisfy 
request
3. `legendary` - boolean, if true meaning that only legendary pokemons will satisfy the request
4. `name` - string, specifying the name of the pokemon that will satisfy the request
e.g. http://localhost:8090/pokemons?specificType=Grass&legendary=true will return only legendary 
pokemons of type Grass.

#### Requests to select pokemons to fight
To specify two pokemons to fight go to http://localhost:8090/pokemons-battle with request parameters 
`pokemonA` and `pokemonB`, entering names of pokemons as their values.
e.g. http://localhost:8090/pokemons-battle?pokemonA=Bulbasaur&pokemonB=Ivysaur will return the winner 
pokemon.