USE bdAlmaAstrologia;

INSERT INTO usuario VALUES(NULL,"Galileo","1111");

INSERT INTO tipoDePlaneta VALUES(NULL,"Planeta");
INSERT INTO tipoDePlaneta VALUES(NULL,"Planeta Enano");

INSERT INTO tipoDeCuerpoMenor VALUES(NULL,"Asteroide");
INSERT INTO tipoDeCuerpoMenor VALUES(NULL,"Cometa");
INSERT INTO tipoDeCuerpoMenor VALUES(NULL,"Meteoroide");

SELECT * FROM usuario;
SELECT * FROM tipoDePlaneta;
SELECT * FROM tipoDeCuerpoMenor;
SELECT * FROM planeta;