<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Atualizar Genero</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Atualizar Genero</h1>
            <hr>
            <a href="/generoGenero" class="btn btn-primary">Voltar</a>
            <hr>
            <form action="/update" method="post">
                <input type="hidden" name="id" value="${genero.id}" />
                <div class="form-goup">
                    <label for="nome">Nome</label>
                    <input type="text" name="titulo" class="form-control" value="${genero.nome}">
                </div>
                <br>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>