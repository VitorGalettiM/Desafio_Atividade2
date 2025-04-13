Endpoints

Personagens

Método        	Endpoint	               Descrição
POST	       api/personagens	        Cria novo personagem
GET       	/api/personagens	        Lista todos personagens
GET	        /api/personagens/{id}	    Busca personagem por ID
PUT       	/api/personagens/{id}	    Atualiza personagem
DELETE	    /api/personagens/{id}	    Remove personagem

Itens Mágicos

Método	      Endpoint	                 Descrição
POST	       /api/itens	            Cria novo item mágico
GET	         /api/itens	            Lista todos itens
GET	         /api/itens/{id}	      Busca item por ID
PUT	         /api/itens/{id}	      Atualiza item
DELETE	     /api/itens/{id}	      Remove item


Pré-requisitos
    -> Java 17+
    -> Maven

Instalação

    git clone https://github.com/RenataCasonii/CrudRPG.git
    cd CrudRPG
    mvn spring-boot:run

Acesse a API
    -> Local: http://localhost:8080
