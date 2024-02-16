<!-- header.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #333;
        padding: 10px;
        color: white;
        text-align: center;
    }

    nav {
        display: flex;
        justify-content: space-around;
        background-color: #555;
        padding: 10px;
    }

    nav a {
        color: white;
        text-decoration: none;
        padding: 10px;
        border-radius: 4px;
    }

    nav a:hover {
        background-color: #777;
    }
</style>

<header>
    <h1>Points of Interest</h1>
</header>

<nav>
    <a href="index.jsp">Home</a>
    <a href="Login.jsp">Login</a>
    <a href="Register.jsp">Register</a>
    <a href="Dashboard.jsp">Dashboard</a>
</nav>
