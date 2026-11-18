#!/usr/bin/env bash

curl -i http://localhost:8080/ping

curl -i -X POST http://localhost:8080/ping

curl -X POST http://localhost:8080/tournaments \
  -H "Content-Type: application/json" \
  -d '{"type":"NOOB", "name":"For Beginners", "minExp":0}'

curl -X POST http://localhost:8080/players \
  -H "Content-Type: application/json" \
  -d '{"name":"Ivan", "type":"NOOB"}'

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":1, "playerId":1}'

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":1, "playerId":1}'

curl -X POST http://localhost:8080/tournaments \
  -H "Content-Type: application/json" \
  -d '{"type":"PRO", "name":"Pro League", "minExp":100}'

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":2, "playerId":1}'

curl -i "http://localhost:8080/players?type=NOOB"
curl -i "http://localhost:8080/tournaments?type=PRO"

curl -X POST http://localhost:8080/tournaments \
  -H "Content-Type: application/json" \
  -d '{"type":"NOOB", "name":"Noob Cup 2", "minExp":0, "minPlayers":1}'

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":3, "playerId":1}'

curl -X POST http://localhost:8080/tournaments \
  -H "Content-Type: application/json" \
  -d '{"type":"NOOB", "name":"Noob Cup 3", "minExp":0, "minPlayers":1}'

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":4, "playerId":1}'

curl -i -X POST http://localhost:8080/tournaments/3/status
curl -i -X POST http://localhost:8080/tournaments/3/status

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":4, "playerId":1}'

curl -X POST http://localhost:8080/players \
  -H "Content-Type: application/json" \
  -d '{"name":"Petr", "type":"NOOB"}'

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":2, "playerId":2}'

curl -i -X POST http://localhost:8080/players/2/exp \
  -H "Content-Type: application/json" \
  -d '{"amount":100}'

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":2, "playerId":2}'

curl -i -X POST http://localhost:8080/players/2/exp \
  -H "Content-Type: application/json" \
  -d '{"amount":-5}'

curl -X POST http://localhost:8080/tournaments \
  -H "Content-Type: application/json" \
  -d '{"type":"NOOB", "name":"Too Few Players", "minExp":0, "minPlayers":3}'

curl -i -X POST http://localhost:8080/tournaments/5/status

curl -X POST http://localhost:8080/tournaments \
  -H "Content-Type: application/json" \
  -d '{"type":"NOOB", "name":"Closed Cup", "minExp":0, "minPlayers":0}'

curl -i -X POST http://localhost:8080/tournaments/6/status

curl -i -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":6, "playerId":1}'

curl -X POST http://localhost:8080/tournaments \
  -H "Content-Type: application/json" \
  -d '{"type":"NOOB", "name":"Cascade Test", "minExp":0, "minPlayers":1}'

curl -X POST http://localhost:8080/players \
  -H "Content-Type: application/json" \
  -d '{"name":"Cascade Player", "type":"NOOB"}'

curl -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":7, "playerId":3}'

curl -i -X DELETE http://localhost:8080/tournaments/7

curl -i http://localhost:8080/registrations

curl -X POST http://localhost:8080/tournaments \
  -H "Content-Type: application/json" \
  -d '{"type":"NOOB", "name":"Cascade Test 2", "minExp":0, "minPlayers":1}'

curl -X POST http://localhost:8080/registrations \
  -H "Content-Type: application/json" \
  -d '{"tournamentId":8, "playerId":3}'

curl -i -X DELETE http://localhost:8080/players/3

curl -i http://localhost:8080/registrations