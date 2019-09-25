<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <ul class="sidebar navbar-nav"> 
    <li class="nav-item dropdown">
          <c:if test="${roleId.equals('ADMIN') }">
			<li class="nav-item active"><a class="nav-link" href="loadallrole"><i class="fas fa-folder"></i>List
				of Roles</a></li>
			<li class="nav-item active"><a class="nav-link" href="userList"><i class="fas fa-folder"></i>List
				of Users</a></li>
			<li class="nav-item active"><a class="nav-link" href="courseList"><i class="fas fa-folder"></i>List
				of Courses</a></li>
			<li class="nav-item active"><a class="nav-link" href="teacherList"><i class="fas fa-folder"></i>List
				of Teachers</a></li>
			<li class="nav-item active"><a class="nav-link" href="enrolmentList"><i class="fas fa-folder"></i>List
				of Enrolments</a></li>
				
				</c:if>
		  <c:if test="${!roleId.equals('ADMIN')}">
			<li class="nav-item active"><a class="nav-link" href="teachers"><i class="fas fa-folder"></i>List
				of Teachers</a></li>
			<li class="nav-item active"><a class="nav-link" href="enrolments"><i class="fas fa-folder"></i>List
				of Enrolments</a></li>
			<li class="nav-item active"><a class="nav-link" href="courses"><i class="fas fa-folder"></i>List
				of Courses</a></li>
		</c:if> 
			</li>
		 </ul>  