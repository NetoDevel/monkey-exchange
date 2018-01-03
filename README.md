# monkey-exchange

[Repositório de configs](https://github.com/NetoDevel/monkey-configs)

#### POST 
URL: http://localhost:8080/api/persons/v1/persons

Body
```json
{
  "email": "josevieira.dev@gmail.com",
  "name": "netinho",
  "telefone": "82988592726"
}
```

#### Response:

(Link de exemplo)
http://localhost:8080/api/token/register?url_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIn0.zOujVUbNf7z4Vfuuz6sKCUCJS7lL-DL3-VTfbcbfcrXchka3J5H0M-WlLGMRZotOCAMraGs_lbpuwUB9QwTGlQ

Acesse a url de resposta onde a api gateway vai rederecionar para o service de token e buscar informações no microservice de pessoa.


