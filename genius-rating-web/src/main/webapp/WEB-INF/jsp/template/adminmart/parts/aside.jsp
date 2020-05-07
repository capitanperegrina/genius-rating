<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/includes/include.jsp" %>

            <!-- Sidebar scroll-->
            <div class="scroll-sidebar" data-sidebarbg="skin6">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li class="sidebar-item">
                            <a class="sidebar-link sidebar-link" href="main.do" aria-expanded="false"><i class="fas fa-home"></i><span class="hide-menu">Home</span></a></li>
                        <li class="list-divider"></li>
                        <li class="nav-small-cap">
                            <span class="hide-menu">Menu</span>
                        </li>
                        <li class="sidebar-item"><a class="sidebar-link" href="boatList.do" aria-expanded="false"><i class="fas fa-book"></i><span class="hide-menu">Boat List</span></a></li>
<c:if test="${request_simpleUserManagementLogged != null}">
                        <li class="sidebar-item"><a class="sidebar-link" href="myBoats.do" aria-expanded="false"><i class="fas fa-book"></i><span class="hide-menu">My Boats</span></a></li>
                        <li class="sidebar-item"><a class="sidebar-link sidebar-link" href="#" aria-expanded="false" id="menuLink_logout"><i class="fas fa-key"></i><span class="hide-menu">Logout</span></a></li>
</c:if>
<c:if test="${request_simpleUserManagementLogged == null}">
                        <li class="sidebar-item"><a class="sidebar-link sidebar-link" href="login.do" aria-expanded="false"><i class="fas fa-key"></i><span class="hide-menu">Login</span></a></li>
                        <li class="sidebar-item"><a class="sidebar-link sidebar-link" href="register.do" aria-expanded="false"><i class="fas fa-edit"></i><span class="hide-menu">Sign up</span></a></li>
</c:if>                        
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->