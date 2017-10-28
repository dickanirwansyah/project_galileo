<!--ACCORDION MENU-->
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li class="text-center">
                <img src="${image}/find_user.png" class="user-image img-responsive"/>
            </li>
            <c:forEach var="menuAccordion" items="${accordion}">
                <li>
                    <a href="${menuAccordion.link}">
                        <i class="glyphicon glyphicon-transfer">${menuAccordion.name}</i>
                        <span class="fa arrow"></span>
                    </a>
                        <ul class="nav nav-second-level">
                            <c:if test="${menuAccordion.subMenus.size() !=0}">
                                <c:forEach var="menuAccor" items="${menuAccordion.subMenus}">
                                    <li>
                                        <a href="${menuAccor.link}">${menuAccor.name}</a>
                                    </li>
                                </c:forEach>
                            </c:if>
                        </ul>
                </li>
            </c:forEach>
            <li>
                <a href="#"><i class="glyphicon glyphicon-ban-circle"></i>
                    Multilevel
                    <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#">Second Level Link</a>
                    </li>
                    <li>
                        <a href="#">Second Level Link</a>
                    </li>
                    <li>
                        <a href="#">Second Level Link<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>  	
        </ul>
    </div>
</nav>  
<!--ACCORDION 