#Use a imagem do OpenJDK 17 como base
FROM openjdk:17-jdk-alpine

#Defina o diretório de trabalho no contêiner
WORKDIR /app

#Copie o código-fonte da sua aplicação para o contêiner
COPY . .

#Instale o Maven
RUN apk add --no-cache maven

#Comando para compilar e executar a aplicação Spring Boot quando o contêiner for iniciado
CMD ["mvn", "spring-boot:run"]