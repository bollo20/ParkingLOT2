<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <a href="${pageContext.request.contextPath}/AddCar" class="btn btn-primary btn-lg mb-3">Add Car</a>

    <c:if test="${not empty cars}">
        <form method="POST" action="${pageContext.request.contextPath}/Cars">
            <button type="submit" class="btn btn-danger mb-3">Delete Selected Cars</button>

            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">
                            <input type="checkbox" id="selectAll" onclick="toggleSelectAll(this)">
                        </th>
                        <th scope="col">License Plate</th>
                        <th scope="col">Parking Spot</th>
                        <th scope="col">Owner</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="car" items="${cars}">
                        <tr>
                            <td>
                                <input type="checkbox" name="car_ids" value="${car.id}">
                            </td>
                            <td>${car.licensePlate}</td>
                            <td>${car.parkingSpot}</td>
                            <td>${car.ownerName}</td>
                            <td>
                                <a class="btn btn-secondary btn-sm"
                                   href="${pageContext.request.contextPath}/EditCar?id=${car.id}">
                                    Edit
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </c:if>

    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>

    <script>
        function toggleSelectAll(checkbox) {
            const checkboxes = document.querySelectorAll('input[name="car_ids"]');
            checkboxes.forEach(cb => cb.checked = checkbox.checked);
        }
    </script>
</t:pageTemplate>