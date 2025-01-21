# Introduction

TBD

# Kong Gateway Setup

The first time you run the docker compose file, you will need to migrate database for Kong Gateway.

```
docker run --rm --network=kong-network \
-e "KONG_DATABASE=postgres" \
-e "KONG_PG_HOST=kong-gw-db" \
-e "KONG_PG_USER=kong" \
-e "KONG_PG_PASSWORD=kong" \
kong/kong-gateway:3.9.0.0 kong migrations bootstrap
```
