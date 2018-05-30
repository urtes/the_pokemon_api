# the_pokemon_api
Programming assignment using pokemon data

# Introduction
Placed in this repository is a csv containing a lot of pokemons with some of
their stats and type.

# Assignment
To build one api, which can receive requests and form those requests to json and
place it on different topics on RabbitMQ, where another service that has the
pokemon information can answer the requests. The response should be delivered
through RabbitMQ to the api, which in turn deliver the reponse over HTTP. And of
course both services should be seen as microservices.

The assignment is used as the base for a technical talk, so remember to consider
the design and architecture around the implementation of the system and testing.

A good idea is to timebox the assignment and write your thoughts down on stuff
which have not been implemented or that you want to implement.

## Requests that should be answered
1. All pokemon with a specific type
2. All pokemons with multiple types
3. All legendary pokemons
4. All pokemons where the name contains the search string
5. A list of all the different headers
6. A list of all pokemons that have => in one or more headers.

## Business Requirement
A business requirement is that the services should support a battle system comparing two
pokemons in a battle and output the winner based on stats. The complexity for
the battle systems is up to the programmer, but it is expected that atleast Attack, 
Defence and Speed is taken into account. 

The format for the battle is a 8 turn battle, where each turn the pokemon A with
the highest speed with start attacking and thereby subtract the health of
pokemon B by the pokemon A's attack points minus pokemon B's defence points, the
winner is then the pokemon with the most health after 8 turns.

### Example
- Pokemon A, HP 300, Attack 50, Defence 20, Speed 10
- Pokemon B, HP 200, Attack 30, Defence 10, Speed 5

1. Pokemon A attacks, since 10 > 5
2. Pokemon B health is updated to 200 - (50 - 10) = 160
3. Pokemon B attacks
4. Pokemon A health is updated to 300 - (30 - 20) = 190
5. Finish of round one

## Testing
The expectation is that the code is tested for all the 'business' logic, both
through unittesting and integration testing, especially supporting the business
logic of the battle system.

## Documentation
The solution should be documented with a small drawing showing the different
topics used on RabbitMQ and the endpoints for the api, on top of that the logic
of the battle system. 

## Final remarks
For RabbitMQ you can use docker to spin up a local instance for connecting the
two services, and there is bonus points for placing each of the two service in
docker aswell.

Happy Coding! :-)
