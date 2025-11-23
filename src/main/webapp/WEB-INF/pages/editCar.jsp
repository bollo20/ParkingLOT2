<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Car">

    <form class="needs-validation" novalidate method="POST"
          action="${pageContext.request.contextPath}/EditCar">

        <!-- Hidden field pentru ID -->
        <input type="hidden" name="car_id" value="${car.id}">

        <div class="row g-3">
            <!-- License Plate -->
            <div class="col-md-12">
                <label for="license_plate" class="form-label">License Plate</label>
                <input type="text" class="form-control" id="license_plate"
                       name="license_plate" value="${car.licensePlate}" required>
                <div class="invalid-feedback">
                    License plate is required.
                </div>
            </div>

            <!-- Parking Spot -->
            <div class="col-md-12">
                <label for="parking_spot" class="form-label">Parking Spot</label>
                <input type="text" class="form-control" id="parking_spot"
                       name="parking_spot" value="${car.parkingSpot}" required>
                <div class="invalid-feedback">
                    Parking spot is required.
                </div>
            </div>

            <!-- Owner -->
            <div class="col-md-12">
                <label for="owner_id" class="form-label">Owner</label>
                <select class="form-select" id="owner_id" name="owner_id" required>
                    <option value="">Choose...</option>
                    <c:forEach var="user" items="${users}">
                        <option value="${user.id}"
                            ${user.username eq car.ownerName ? 'selected' : ''}>
                                ${user.username}
                        </option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select an owner.
                </div>
            </div>
        </div>

        <hr class="my-4">
        <button class="btn btn-primary btn-lg" type="submit">Save Changes</button>
        <a href="${pageContext.request.contextPath}/Cars" class="btn btn-secondary btn-lg">Cancel</a>
    </form>

</t:pageTemplate>