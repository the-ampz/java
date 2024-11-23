<img src=".github/banner.svg" alt="Ampz" width="100%">

---

Este repositório contém o projeto **Ampz**, desenvolvido como parte da disciplina de Java. O objetivo do projeto é promover o consumo consciente de energia elétrica utilizando um dispositivo IoT e um sistema de gamificação interativo. A solução se destaca por combinar IoT com gamificação, promovendo o uso consciente de energia de forma didática e divertida.

### 📚 Relevância e Inovação

O **Ampz** inova ao abordar um problema crítico: o consumo excessivo e irresponsável de energia elétrica por crianças. Combinando **tecnologia IoT** e **gamificação**, a solução:

- **Promove conscientização**: Integra um sistema educacional que incentiva hábitos sustentáveis através de recompensas e competições.
- **Engaja os usuários**: Torna o consumo de energia um tema interativo e envolvente, transformando dados técnicos em insights acessíveis.
- **Fomenta a sustentabilidade**: Facilita a redução de desperdícios e custos, contribuindo para um futuro mais verde.


### 💡 Viabilidade e Usabilidade

A solução apresenta alta viabilidade técnica e facilidade de uso:

1. **Viabilidade Técnica**:
   - Integração com dispositivos IoT amplamente disponíveis, como Arduino e ESP32.
   - Sistema baseado em Java e Spring Boot, garantindo escalabilidade e robustez.

2. **Usabilidade**:
   - Interface intuitiva, acessível por dispositivos móveis e desktops.
   - Feedback em tempo real sobre o consumo, permitindo ajustes imediatos e conscientes.
   - Gamificação para diferentes públicos, como famílias, escolas e empresas.

---

## 🎥 Pré-visualização do projeto

[Link para o vídeo](https://www.youtube.com/watch?v=XD_s9rMg8LU) apresentando o sistema.

---

## 🚀 Vídeo do Pitch do projeto

[Link para o vídeo](https://www.youtube.com/watch?v=P3Hi4C2hoY4) apresentando a solução, seus benefícios e funcionamento.  

---

## 🛠️ Como Executar o Projeto

Siga as instruções abaixo para configurar e executar o projeto Spring em sua máquina:

### Pré-requisitos

Certifique-se de que os seguintes programas estão instalados no seu sistema:

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 3.8+](https://maven.apache.org/download.cgi)

### Passo a Passo

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/ampz.git
   cd ampz
   ```

2. **Configure o banco de dados**:
   - Edite o arquivo `src/main/resources/application.properties` com as credenciais do seu banco

3. **Compile o projeto**:
   Execute o Maven para baixar as dependências e compilar o projeto:
   ```bash
   mvn clean install
   ```

4. **Inicie a aplicação**:
   Rode o projeto Spring:
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a aplicação**:
   - Acesse a documentação do sistema pelo navegador em [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).


## 👥 Equipe
Este projeto está sendo desenvolvido pelos seguintes membros:

- RM99565 - Erick Nathan Capito Pereira (2TDSPV)
- RM99577 - Guilherme Dias Gomes (2TDSPX)
- RM550889 - Hemily Nara da Silva (2TDSPX)
- RM550841 - Lucas Araujo Oliveira Silva (2TDSPV)
- RM99409 - Michael José Bernardi Da Silva (2TDSPX)
