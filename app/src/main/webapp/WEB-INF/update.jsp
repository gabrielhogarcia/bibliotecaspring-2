<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Atualizar Livro</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Atualizar Livro</h1>
            <hr>
            <a href="/livro" class="btn btn-primary">Voltar</a>
            <hr>
            <form action="/update" method="post">
                <input type="hidden" name="id" value="${livro.id}" />
                <div class="form-goup">
                    <label for="titulo">Título</label>
                    <input type="text" name="titulo" class="form-control" value="${livro.titulo}">
                    <br>
                    <label for="titulo">ISBN</label>
                    <input type="text" name="isbn" class="form-control" value="${livro.isbn}">
                </div>
                <br>
                <button type="submit" class="btn btn-success">Salvar</button>
            </form>
        </div>
    </body>
</html>