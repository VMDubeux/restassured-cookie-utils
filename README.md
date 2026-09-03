# REST Assured Cookie Utils

Biblioteca utilitária desenvolvida por mim, em Java 8, para facilitar o gerenciamento, extração e manipulação de cookies através da classe **`CookieMap`** em testes de API automatizados com REST Assured.

---

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java
* **Gerenciador de Dependências:** Maven
* **Core:** REST Assured
* **Testes:** TestNG
* **Distribuição:** JitPack

---

## 📦 Instalação

Como o projeto está hospedado no JitPack, é necessário adicionar o repositório do JitPack e a dependência do utilitário no arquivo `pom.xml` do seu projeto Maven.

### 1. Adicione o Repositório JitPack

Inclua o repositório no seu `pom.xml` dentro da tag `<repositories>`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
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
        <version>1.0.0</version>
    </dependency>
</dependencies>

```

---

## 🚀 Como Usar

A principal funcionalidade da biblioteca é disponibilizada através da classe **`CookieMap`**, criada para simplificar a passagem e validação de cookies nas requisições do REST Assured.

```java
import com.github.VMDubeux.restassured.CookieMap;
import io.restassured.RestAssured;

// Exemplo simples de uso
CookieMap cookieMap = new CookieMap();
// Utilize a instância para manipular e passar cookies diretamente nas requisições do REST Assured

```

---

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo [LICENSE](https://www.google.com/search?q=LICENSE) para obter mais detalhes.
