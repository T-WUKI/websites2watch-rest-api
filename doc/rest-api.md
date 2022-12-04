- Pfad
- Query Parameter
- Http Verb: GET, POST, PUT, DELETE
- Request Body
 
REST: Ressourcen
Websites,...

Lade alle Webseiten
GET /api/websites

Filter über alle Webseiten (Bsp. tag, region, ...)
GET /api/websites?filter1={filter1}&filter2={filter2}...

Lade eine bestimmte Webseite
GET /api/websites/{idName}

Erzeuge neue Webseite
POST /api/websites/{idName}

Lösche eine Webseite
DELETE /api/websites/{idName}

Aktualisiere eine Webseite
PUT /api/websites/{idName}

Aktualisiere tags einer Webseite
PUT /api/websites/{idName}/tags

Aktualisiere regions einer Webseite
PUT /api/websites/{idName}/regions

Aktualisiere actions einer Webseite
PUT /api/websites/{idName}/actions

