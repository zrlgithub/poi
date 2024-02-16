<!-- dashboard.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #333333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #dddddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #4caf50;
            color: white;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />

    <h2>Dashboard</h2>

    <!-- Display Registered Users -->
    <h3>Registered Users</h3>
    <table>
        <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Is Admin</th>
        </tr>
        <c:forEach var="user" items="${registeredUsers}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.username}</td>
                <td>${user.admin ? 'Yes' : 'No'}</td>
            </tr>
        </c:forEach>
    </table>

    <!-- Display Points of Interest -->
    <h3>Points of Interest</h3>
    <table>
        <tr>
            <th>POI ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Location</th>
            <th>Likes</th>
        </tr>
        <c:forEach var="poi" items="${pointsOfInterest}">
            <tr>
                <td>${poi.poiId}</td>
                <td>${poi.name}</td>
                <td>${poi.type}</td>
                <td>${poi.location}</td>
                <td>${poi.likes}</td>
            </tr>
        </c:forEach>
    </table>

    <!-- Display Comments -->
    <h3>Comments</h3>
    <table>
        <tr>
            <th>Comment ID</th>
            <th>User ID</th>
            <th>POI ID</th>
            <th>Comment Text</th>
            <th>Authorized</th>
        </tr>
        <c:forEach var="comment" items="${comments}">
            <tr>
                <td>${comment.commentId}</td>
                <td>${comment.userId}</td>
                <td>${comment.poiId}</td>
                <td>${comment.commentText}</td>
                <td>${comment.authorized ? 'Yes' : 'No'}</td>
            </tr>
        </c:forEach>
    </table>

    <!-- Display Likes -->
    <h3>Likes</h3>
    <table>
        <tr>
            <th>Like ID</th>
            <th>User ID</th>
            <th>POI ID</th>
        </tr>
        <c:forEach var="like" items="${likes}">
            <tr>
                <td>${like.likeId}</td>
                <td>${like.userId}</td>
                <td>${like.poiId}</td>
            </tr>
        </c:forEach>
    </table>

    <!-- Add Points of Interest -->
    <h3>Add Point of Interest</h3>
    <form action="AddPOIServlet" method="post">
      <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="type">Type:</label>
        <input type="text" id="type" name="type" required>

        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required>

        <button type="submit">Add Point of Interest</button>
    </form>
</body>
</html>
