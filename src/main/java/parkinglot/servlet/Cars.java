package parkinglot.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import parkinglot.ejb.CarsBean;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "Cars", value = "/Cars")
public class Cars extends HttpServlet {

    @Inject
    private CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cars", carsBean.findAllCars());
        request.setAttribute("numberOfFreeParkingSpots", carsBean.countFreeParkingSpots());
        request.getRequestDispatcher("/WEB-INF/pages/cars.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String[] carIdsAsString = request.getParameterValues("car_ids");

        if (carIdsAsString != null) {
            List<Long> carIds = Arrays.stream(carIdsAsString)
                    .map(Long::parseLong)
                    .collect(Collectors.toList());

            carsBean.deleteCarsByIds(carIds);
        }

        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}