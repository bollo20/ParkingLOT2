<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Car">

    <form class="needs-validation" novalidate method="POST"
          action="${pageContext.request.contextPath}/AddCar">

        <div class="row g-3">
            <!-- License Plate - ÎNTREAGA LINIE -->
            <div class="col-md-12">
                <label for="license_plate" class="form-label">License Plate</label>
                <input type="text" class="form-control" id="license_plate"
                       name="license_plate" required>
                <div class="invalid-feedback">
                    License plate is required.
                </div>
            </div>

            <!-- Parking Spot - ÎNTREAGA LINIE -->
            <div class="col-md-12">
                <label for="parking_spot" class="form-label">Parking Spot</label>
                <input type="text" class="form-control" id="parking_spot"
                       name="parking_spot" required>
                <div class="invalid-feedback">
                    Parking spot is required.
                </div>
            </div>

            <!-- Owner - ÎNTREAGA LINIE -->
            <div class="col-md-12">
                <label for="owner_id" class="form-label">Owner</label>
                <select class="form-select" id="owner_id" name="owner_id" required>
                    <option value="">Choose...</option>
                    <c:forEach var="user" items="${users}">
                        <option value="${user.id}">${user.username}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select an owner.
                </div>
            </div>
        </div>

        <hr class="my-4">
        <button class="btn btn-primary btn-lg" type="submit">Save</button>
    </form>

</t:pageTemplate>