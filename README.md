# spring-boot-redis

## Redis

Redis é um banco de dados não relacional, também conhecido por NOSQL. Redis significa REmote DIctionary Server.

Os dados são armazenados na forma de chave-valor, assim como estruturas encontradas em linguagens de programação, por exemplo, o Map do Java.

O Redis é extremamente rápido, tanto para escrita como para leitura dos dados, graças ao fato de armazenar seus dados em memória. Apesar disso, o Redis permite que os dados sejam persistidos fisicamente caso desejado.

Baseado nessas características, o Redis é uma boa opção para cenários que você precisa de alta performance para gravação e/ou leitura de dados baseado em chave-valor, sendo ele muito utilizado para servir como um servidor de cache para a aplicação, pois além de tudo, ele ainda permite que uma chave expire após um determinado período, dessa forma pode ser utilizado para gerenciar sessões de usuário.

## Iniciando o Redis

Iniciar um container docker com o Redis:
```bash
docker run -d --name redis -p 6379:6379 redis:5.0.3
```

Acessar o Redis do container:
```bash
docker exec -it redis redis-cli
```

### Testando o Redis

Inserir um valor: 
```bash
SET chave valor
```

Listar todos os valores:
```bash
KEYS *
```

Acessar um valor:
```bash
GET chave
```

Deletar um valor:
```bash
DEL chave
```

Lista de comandos do Redis: https://redis.io/commands

## Spring boot com Redis

Testar a aplicação com o Redis...

Abrir o curl no windows: 
```bash
C:\Program Files\Git\mingw64\bin\
```

Testar o CRUD pelo curl:

Listar:
```bash
curl -s http://localhost:8080/pessoa
```

Buscar por id:
```bash
curl -s http://localhost:8080/pessoa/1
```

Adicionar:
```bash
curl -s -X POST http://localhost:8080/pessoa -H "Content-Type: application/json" -d "{\"id\": 1, \"nome\":\"Alex\"}"
```

Alterar:
```bash
curl -s -X PUT http://localhost:8080/pessoa -H "Content-Type: application/json" -d "{\"id\": 1, \"nome\":\"Alex Melo\"}"
```

Deletar:
```bash
curl -s -X DELETE http://localhost:8080/pessoa/1
```

## Fontes

- https://emmanuelneri.com.br/2019/04/30/cache-distribuido-com-redis-no-spring-boot/
- http://desenvolvedor.ninja/redis-o-que-e-e-para-que-serve/
- https://imasters.com.br/banco-de-dados/introducao-ao-redis-o-nosql-chave-valor-mais-famoso
- https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#cache