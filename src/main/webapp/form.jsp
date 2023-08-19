<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
   <div class="container">
        <div class="anime-list mt-5">
            <h2>Add Anime</h2>
            <form action="add" method="post">
                <div class="mb-3">
                    <label for="animeName" class="form-label">Anime Name:</label>
                    <input type="text" id="animeName" name="animeName" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-check-label">Status:</label>
                    <div class="form-check">
                        <input type="checkbox" name="watched" class="form-check-input">
                        <label class="form-check-label">Watched</label>
                    </div>
                    <div class="form-check">
                        <input type="checkbox" name="watchLater" class="form-check-input">
                        <label class="form-check-label">Watch Later</label>
                    </div>
                    <div class="form-check">
                        <input type="checkbox" name="completed" class="form-check-input">
                        <label class="form-check-label">Completed</label>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Add Anime</button>
                <a class="btn btn-secondary" href="<%=request.getContextPath()%>/list">Back to List</a>
            </form>
        </div>
    </div>
    <!-- Link Bootstrap JS (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>