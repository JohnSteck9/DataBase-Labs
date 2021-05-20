package com.pizza.view;

import com.pizza.controller.impl.*;
import com.pizza.model.entity.*;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

  private static final Scanner SCANNER = new Scanner(System.in);
  private final Map<String, Printable> menu = new LinkedHashMap<>();

  private final CourierController courierController = new CourierController();
  private final CourierStatusController courierStatusController = new CourierStatusController();
  private final CustomerController customerController = new CustomerController();
  private final DeliveryAreaController deliveryAreaController = new DeliveryAreaController();
  private final OrderInfoController orderInfoController = new OrderInfoController();
  private final OrderStatusController orderStatusController = new OrderStatusController();


  public View() {

    menu.put("11", this::getAllCourier);
    menu.put("12", this::getCourierById);
    menu.put("13", this::createCourier);
    menu.put("14", this::updateCourier);
    menu.put("15", this::deleteCourier);

    menu.put("21", this::getAllCourierStatus);
    menu.put("22", this::getCourierStatusById);
    menu.put("23", this::createCourierStatus);
    menu.put("24", this::updateCourierStatus);
    menu.put("25", this::deleteCourierStatus);

    menu.put("31", this::getAllCustomer);
    menu.put("32", this::getCustomerById);
    menu.put("33", this::createCustomer);
    menu.put("34", this::updateCustomer);
    menu.put("35", this::deleteCustomer);

    menu.put("41", this::getAllDeliveryArea);
    menu.put("42", this::getDeliveryAreaById);
    menu.put("43", this::createDeliveryArea);
    menu.put("44", this::updateDeliveryArea);
    menu.put("45", this::deleteDeliveryArea);

    menu.put("51", this::getAllOrderInfo);
    menu.put("52", this::getOrderInfoById);
    menu.put("53", this::createOrderInfo);
    menu.put("54", this::updateOrderInfo);
    menu.put("55", this::deleteOrderInfo);

    menu.put("61", this::getAllOrderStatus);
    menu.put("62", this::getOrderStatusById);
    menu.put("63", this::createOrderStatus);
    menu.put("64", this::updateOrderStatus);
    menu.put("65", this::deleteOrderStatus);

  }


  public final void show() {
    String input;
    Menu showMenu = new Menu();
    showMenu.displayMenu();
    System.out.println("\nWrite your command here:\n");
    do {
      try {
        input = SCANNER.next();
        menu.get(input).print();
      } catch (Exception ignored) {
      }
    } while (SCANNER.hasNext());
  }

//  ==================== COURIER ======================

  private void getAllCourier() throws SQLException {
    System.out.println("\n[COURIER / GET]");
    System.out.println(courierController.findAll() + "\n");
  }

  private void getCourierById() throws SQLException {
    System.out.println("\n[COURIER / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(courierController.findOne(id) + "\n");
  }

  private CourierEntity getCourierInputs() throws SQLException {
    System.out.println("\nEnter firstname: ");
    String firstname = SCANNER.next();
    System.out.println("Enter lastname: ");
    String lastname = SCANNER.next();
    System.out.println("Enter phone: ");
    String phone = SCANNER.next();
    System.out.println("Enter email: ");
    String email = SCANNER.next();
    System.out.println("Enter courierStatusId: ");
    Integer courierStatusId = SCANNER.nextInt();
    CourierStatusEntity courierStatus = courierStatusController.findOne(courierStatusId);
    return new CourierEntity(firstname, lastname, phone, email, courierStatus);
  }

  private void createCourier() throws SQLException {
    System.out.println("\n[COURIER / CREATE]");
    CourierEntity courier = getCourierInputs();
    courierController.create(courier);
    System.out.println("Courier successfully created\n");
  }

  private void updateCourier() throws SQLException {
    System.out.println("\n[COURIER / UPDATE] Enter ID: ");
    int id = SCANNER.nextInt();
    CourierEntity courier = getCourierInputs();
    courier.setId(id);
    courierController.update(courier.getId(), courier);
    System.out.println("COURIER with ID=" + id + " successfully updated\n");
  }

  private void deleteCourier() throws SQLException {
    System.out.println("\n[COURIER / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();
    courierController.delete(id);
    System.out.println("Courier with ID=" + id + " successfully deleted\n");
  }

  //  ==================== COURIER STATUS ======================
  private void getAllCourierStatus() throws SQLException {
    System.out.println("\n[COURIER STATUS / GET]");
    System.out.println(courierStatusController.findAll() + "\n");
  }

  private void getCourierStatusById() throws SQLException {
    System.out.println("\n[COURIER STATUS / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(courierStatusController.findOne(id) + "\n");
  }

  private CourierStatusEntity getCourierStatusInputs() {
    System.out.println("Enter status: ");
    String courierStatus = SCANNER.next();
    return new CourierStatusEntity(courierStatus);
  }

  private void createCourierStatus() throws SQLException {
    System.out.println("\n[COURIER STATUS / CREATE]");
    CourierStatusEntity courierStatus = getCourierStatusInputs();
    courierStatusController.create(courierStatus);
    System.out.println("CourierStatus successfully created\n");
  }

  private void updateCourierStatus() throws SQLException {
    System.out.println("\n[COURIER STATUS / UPDATE] Enter ID: ");
    int id = SCANNER.nextInt();
    CourierStatusEntity courierStatus = getCourierStatusInputs();
    courierStatus.setId(id);

    courierStatusController.update(courierStatus.getId(), courierStatus);
    System.out.println("CourierStatus with ID=" + id + " successfully updated\n");
  }

  private void deleteCourierStatus() throws SQLException {
    System.out.println("\n[COURIER STATUS / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    courierStatusController.delete(id);
    System.out.println("CourierStatus with ID=" + id + " successfully deleted\n");
  }

  //  ==================== CUSTOMER ======================
  private void getAllCustomer() throws SQLException {
    System.out.println("\n[CUSTOMER / GET]");
    System.out.println(customerController.findAll() + "\n");
  }

  private void getCustomerById() throws SQLException {
    System.out.println("\n[CUSTOMER / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(customerController.findOne(id) + "\n");
  }

  private CustomerEntity getCustomerInputs() {
    System.out.println("Enter first name: ");
    String firstname = SCANNER.next();
    System.out.println("Enter last name: ");
    String lastname = SCANNER.next();
    System.out.println("Enter phone: ");
    String phone = SCANNER.next();
    System.out.println("Enter email: ");
    String email = SCANNER.next();

    return new CustomerEntity(firstname, lastname, phone, email);
  }

  private void createCustomer() throws SQLException {
    System.out.println("\n[CUSTOMER / CREATE]");
    CustomerEntity customer = getCustomerInputs();
    customerController.create(customer);
    System.out.println("Customer successfully created\n");
  }

  private void updateCustomer() throws SQLException {
    System.out.println("\n[CUSTOMER / UPDATE] Enter ID: ");
    int id = SCANNER.nextInt();
    CustomerEntity customer = getCustomerInputs();
    customer.setId(id);
    customerController.update(customer.getId(), customer);
    System.out.println("Customer with ID=" + id + " successfully updated\n");
  }

  private void deleteCustomer() throws SQLException {
    System.out.println("\n[CUSTOMER / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();
    customerController.delete(id);
    System.out.println("Customer with ID=" + id + " successfully deleted\n");
  }

  //  ==================== DELIVERY AREA ======================
  private void getAllDeliveryArea() throws SQLException {
    System.out.println("\n[DELIVERY AREA / GET]");
    System.out.println(deliveryAreaController.findAll() + "\n");
  }

  private void getDeliveryAreaById() throws SQLException {
    System.out.println("\n[DELIVERY AREA / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(deliveryAreaController.findOne(id) + "\n");
  }

  private DeliveryAreaEntity getDeliveryAreaInputs() {
    System.out.println("\nEnter zone: ");
    String zone = SCANNER.next();
//    System.out.println("\nEnter time: ");
//    String time = SCANNER.next();
    return new DeliveryAreaEntity(zone);
  }

  private void createDeliveryArea() throws SQLException {
    System.out.println("\n[DELIVERY AREA / CREATE]");
    DeliveryAreaEntity deliveryArea = getDeliveryAreaInputs();
    deliveryAreaController.create(deliveryArea);
    System.out.println("DeliveryArea successfully created\n");
  }

  private void updateDeliveryArea() throws SQLException {
    System.out.println("\n[DELIVERY AREA / UPDATE] Enter ID: ");
    int id = SCANNER.nextInt();
    DeliveryAreaEntity deliveryArea = getDeliveryAreaInputs();
    deliveryArea.setId(id);

    deliveryAreaController.update(deliveryArea.getId(), deliveryArea);
    System.out.println("DeliveryArea with ID=" + id + " successfully updated\n");
  }

  private void deleteDeliveryArea() throws SQLException {
    System.out.println("\n[DELIVERY AREA / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    deliveryAreaController.delete(id);
    System.out.println("DeliveryArea with ID=" + id + " successfully deleted\n");
  }

  //  ==================== ORDER INFO ======================
  private void getAllOrderInfo() throws SQLException {
    System.out.println("\n[ORDER INFO / GET]");
    System.out.println(orderInfoController.findAll() + "\n");
  }

  private void getOrderInfoById() throws SQLException {
    System.out.println("\n[ORDER INFO / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(orderInfoController.findOne(id) + "\n");
  }

  private OrderInfoEntity getOrderInfoInputs() {
    System.out.println("\nEnter comment: ");
    String comment = SCANNER.next();
    System.out.println("\nEnter price product: ");
    Double priceProduct = SCANNER.nextDouble();
    System.out.println("\nEnter price delivery: ");
    Double priceDelivery = SCANNER.nextDouble();
    System.out.println("\nEnter expectedTime: ");
    String expectedTime = SCANNER.next();
    System.out.println("\nEnter actualTime: ");
    String actualTime = SCANNER.next();
    System.out.println("\nEnter deliveryAreaId: ");
    Integer deliveryAreaId = SCANNER.nextInt();
    System.out.println("\nEnter orderStatusId: ");
    Integer orderStatusId = SCANNER.nextInt();
    System.out.println("\nEnter customerId: ");
    Integer customerId = SCANNER.nextInt();
    System.out.println("\nEnter courierId: ");
    Integer courierId = SCANNER.nextInt();

    return new OrderInfoEntity(comment, priceProduct, priceDelivery, expectedTime, actualTime,
            deliveryAreaId, orderStatusId, customerId, courierId);
  }

  private void createOrderInfo() throws SQLException {
    System.out.println("\n[ORDER INFO / CREATE]");
    OrderInfoEntity orderInfo = getOrderInfoInputs();
    orderInfoController.create(orderInfo);
    System.out.println("OrderInfo successfully created\n");
  }

  private void updateOrderInfo() throws SQLException {
    System.out.println("\n[ORDER INFO / UPDATE] Enter ID: ");
    int id = SCANNER.nextInt();
    OrderInfoEntity orderInfo = getOrderInfoInputs();
    orderInfo.setId(id);

    orderInfoController.update(orderInfo.getId(), orderInfo);
    System.out.println("OrderInfo with ID=" + id + " successfully updated\n");
  }

  private void deleteOrderInfo() throws SQLException {
    System.out.println("\n[ORDER INFO / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    orderInfoController.delete(id);
    System.out.println("OrderInfo with ID=" + id + " successfully deleted\n");
  }
  //  ==================== ORDER STATUS ======================

  private void getAllOrderStatus() throws SQLException {
    System.out.println("\n[ORDER STATUS / GET]");
    System.out.println(orderStatusController.findAll() + "\n");
  }

  private void getOrderStatusById() throws SQLException {
    System.out.println("\n[ORDER STATUS / GET] Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(orderStatusController.findOne(id) + "\n");
  }

  private OrderStatusEntity getOrderStatusInputs() {
    System.out.println("\nEnter status: ");
    String status = SCANNER.next();

    return new OrderStatusEntity(status);
  }

  private void createOrderStatus() throws SQLException {
    System.out.println("[ORDER STATUS / CREATE]");
    OrderStatusEntity orderStatus = getOrderStatusInputs();
    orderStatusController.create(orderStatus);
    System.out.println("OrderStatus successfully created\n");
  }

  private void updateOrderStatus() throws SQLException {
    System.out.println("\n[ORDER STATUS / UPDATE] Enter ID: ");
    int id = SCANNER.nextInt();
    OrderStatusEntity orderStatus = getOrderStatusInputs();
    orderStatus.setId(id);

    orderStatusController.update(orderStatus.getId(), orderStatus);
    System.out.println("OrderStatus with ID=" + id + " successfully updated\n");
  }

  private void deleteOrderStatus() throws SQLException {
    System.out.println("\n[ORDER STATUS / DELETE] Enter ID: ");
    int id = SCANNER.nextInt();

    orderStatusController.delete(id);
    System.out.println("OrderStatus with ID=" + id + " successfully deleted\n");
  }

}
