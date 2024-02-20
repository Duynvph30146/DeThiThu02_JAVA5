<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<h1 class="text-center">QUẢN LÝ KHÁCH HÀNG</h1>
<form:form method="get" modelAttribute="search">
    <p>
        Tên khách hàng/Số điện thoại:
        <form:input path="keyword"/>
    </p>
    <p>
        Tên hạng:
        <form:select path="tenhang">
            <form:options items="${dsHang}" itemValue="tenhang" itemLabel="tenhang"/>

        </form:select>
    </p>
    <button class="btn btn-primary">Search</button>
</form:form>

<form:form method="post" modelAttribute="kh">
    <p>Mã hạng:
        <form:select path="hangkhachhang.mahang">
            <form:options items="${dsHang}" itemValue="mahang" itemLabel="mahang"/>
        </form:select>
    </p>
    <p>Tên khách hàng:
        <form:input path="tenkhachhang"/>
    </p>
    <p>Số điện thoại:
        <form:input path="sodienthoai"/>
    </p>
    <p class="text-danger">${sdt}</p>
    <p>Giới tính:
        <form:radiobutton path="gioitinh" value="true" label="Nam"/>
        <form:radiobutton path="gioitinh" value="false" label="Nữ"/>
    </p>
    <button formaction="/khach-hang/add" class="btn btn-primary">add</button>
    <button formaction="/khach-hang/update/${kh.makhachhang}" class="btn btn-warning">Update</button>
</form:form>
<table class="table table-bordered table-hover">
    <tr class="table-primary">
        <th>Tên khách hàng</th>
        <th>SĐT</th>
        <th>Giới Tính</th>
        <th>Tên hạng</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${page.content}" var="p">
        <tr>
            <td>${p.tenkhachhang}</td>
            <td>${p.sodienthoai}</td>
            <td>${p.gioitinh?"Nam":"Nữ"}</td>
            <td>${p.hangkhachhang.tenhang}</td>
            <td>
                <a href="/khach-hang/update/${p.makhachhang}" class="btn btn-warning">Update</a>
                <a href="/khach-hang/delete/${p.makhachhang}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="text-center">
    <a href="/khach-hang/hien-thi">
        <button class="btn btn-primary">First</button>
    </a>
    <a href="/khach-hang/hien-thi?p=${page.number-1}">
        <button class="btn btn-primary">Prev</button>
    </a>
    <a href="/khach-hang/hien-thi?p=${page.number+1}">
        <button class="btn btn-primary">Next</button>
    </a>
    <a href="/khach-hang/hien-thi?p=${page.totalPages-1}">
        <button class="btn btn-primary">Last</button>
    </a>
</div>
