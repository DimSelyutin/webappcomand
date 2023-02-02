<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


    <!DOCTYPE html>

    <head>
      <fmt:setLocale value="${sessionScope.local}" />
      <fmt:setBundle basename="localization.local" var="loc" />
      <fmt:message bundle="${loc}" key="local.message" var="deletenews" />
      <title>Page not found</title>
      <link href="./css/404.css" rel="stylesheet">
    </head>
    <a href="/index.jsp" target="_blank">
      <header class="top-header">
      </header>

      <!--dust particel-->
      <div>
        <div class="starsec"></div>
        <div class="starthird"></div>
        <div class="starfourth"></div>
        <div class="starfifth"></div>
      </div>
      <!--Dust particle end--->


      <div class="lamp__wrap">
        <div class="lamp">
          <div class="cable"></div>
          <div class="cover"></div>
          <div class="in-cover">
            <div class="bulb"></div>
          </div>
          <div class="light"></div>
        </div>
      </div>
      <!-- END Lamp -->
      <section class="error">
        <!-- Content -->
        <div class="error__content">
          <div class="error__message message">
            <h1 class="message__title">Page Not Found</h1>
            <p class="message__text">We're sorry, the page you were looking for isn't found here.
              Please try again, or take a look at our.</p>
          </div>
          <div class="error__nav e-nav">
            <a href="/grot" target="_blanck" class="e-nav__link"></a>
          </div>
        </div>
        <!-- END Content -->

      </section>

    </a>

    </html>