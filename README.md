# REST Assured Cookie Utils

Biblioteca utilitária em Java 8+ para simplificar a criação, gerenciamento, validação e injeção de cookies em testes de API automatizados com **REST Assured**.

---

## 🛠️ Tecnologias e Ferramentas

- **Linguagem:** Java 8+
- **Gerenciador de Dependências:** Maven
- **Core:** REST Assured
- **Distribuição:** JitPack

---

## 📦 Instalação

Como o projeto está hospedado no JitPack, é necessário adicionar o repositório do JitPack e a dependência do utilitário no arquivo `pom.xml` do seu projeto Maven.

### 1. Adicione o Repositório JitPack

Inclua o repositório no seu `pom.xml` dentro da tag `<repositories>`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>[https://jitpack.io](https://jitpack.io)</url>
    </repository>
</repositories>

```

### 2. Adicione a Dependência

Adicione a dependência da biblioteca dentro da tag `<dependencies>`:

```xml
<dependencies>
    <dependency>
        <groupId>com.github.VMDubeux</groupId>
        <artifactId>restassured-cookie-utils</artifactId>
        <version>1.0.1</version>
    </dependency>
</dependencies>

```

---

## 🚀 Como Usar

A principal funcionalidade da biblioteca é disponibilizada através da classe **`CookieManagement`**, criada para gerenciar os cookies de forma segura, garantindo a validação de duplicidade e facilitando a extração de atributos e conversão direta para uso no REST Assured.

```java
import io.github.VMDubeux.restassured.CookieManagement;
import io.github.VMDubeux.restassured.CookieManagement.Attribute;
import io.restassured.http.Cookies;
import static io.restassured.RestAssured.given;

public class CookieTest {
    public void exemploUso() {
        // Instancia o gerenciador de cookies
        CookieManagement cookieManager = new CookieManagement();

        // 1. Criando e adicionando cookies
        cookieManager.create("sessionId", "abc123xyz", "exemplo.com", "/");
        cookieManager.create("authToken", "bearer-token-123");

        // 2. Visualizando os cookies cadastrados (com IDs únicos gerados)
        System.out.println(cookieManager.reviewList());

        // 3. Exportando a lista completa no formato io.restassured.http.Cookies
        Cookies cookiesList = cookieManager.useList();

        // 4. Injetando diretamente em uma requisição REST Assured
        given()
            .cookies(cookiesList)
        .when()
            .get("[https://api.exemplo.com/v1/resource](https://api.exemplo.com/v1/resource)")
        .then()
            .statusCode(200);
    }
}

```

---

## ⚙️ Funcionalidades Principais

* **Criação Flexível (`create`):** Sobrecargas de métodos para instanciar cookies rapidamente informando chave/valor, domínio, caminho e comentários.
* **Validação Anti-Duplicidade (`add`):** Previne automaticamente o cadastro de cookies conflitantes com mesma combinação de Nome, Domínio e Caminho.
* **Inspeção de Atributos (`getAttribute`):** Permite extrair rapidamente valores específicos como `NAME`, `VALUE`, `DOMAIN`, `PATH` ou `COMMENT`.
* **Listagem e Leitura (`reviewList`):** Gera uma visão detalhada dos cookies gerenciados acompanhados de identificadores únicos (`UUID`).
* **Integração Nativa (`useList`):** Retorna a lista tratada pronta como um objeto `Cookies` nativo do REST Assured.

---

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo [LICENSE](https://www.google.com/search?q=LICENSE) para obter mais detalhes.

```

<ElicitationsGroup message="Deseja realizar mais alguma atualização no repositório?">
  <Elicitation label="Criar o comando git para aplicar a tag 1.0.1 e subir" query="Qual a sequência de comandos git para criar a tag 1.0.1 e enviá-la para o repositório remoto?"/>
  <Elicitation label="Atualizar Javadoc ou exemplos de teste" query="Poderia gerar exemplos de testes unitários com TestNG para testar a classe CookieManagement?"/>
</ElicitationsGroup>

```