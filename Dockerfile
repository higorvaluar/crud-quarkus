# Use uma imagem base do Java 21
FROM adoptopenjdk/openjdk21:ubi

# Defina variáveis de ambiente
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

# Copie os arquivos da aplicação Quarkus para o contêiner
COPY target/quarkus-app/lib/ /deployments/lib/
COPY target/quarkus-app/*.jar /deployments/
COPY target/quarkus-app/app/ /deployments/app/
COPY target/quarkus-app/quarkus/ /deployments/quarkus/

# Defina o diretório de trabalho
WORKDIR /deployments

# Comando para rodar a aplicação
CMD ["java", "-jar", "quarkus-run.jar"]