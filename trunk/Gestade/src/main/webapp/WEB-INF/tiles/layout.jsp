<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <!-- Basic -->
        <meta charset="utf-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
       <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Theme CSS -->
        <link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet" media="screen">
        <!-- Responsive CSS -->
        <link href='<c:url value="/resources/css/theme-responsive.css"/>' rel="stylesheet" media="screen">
        <!-- Skins Theme -->
        <link href="#" rel="stylesheet" media="screen" class="skin">

        <!-- Favicons -->
        <link rel="shortcut icon" href='<c:url value="/resources/img/icons/favicon.ico"/>'>
        <link rel="apple-touch-icon" href='<c:url value="/resources/img/icons/apple-touch-icon.png"/>'>
        <link rel="apple-touch-icon" sizes="72x72" href='<c:url value="/resources/img/icons/apple-touch-icon-72x72.png"/>'>
        <link rel="apple-touch-icon" sizes="114x114" href='<c:url value="/resources/img/icons/apple-touch-icon-114x114.png"/>'>  

        <!-- Head Libs -->
        <script src='<c:url value="/resources/js/modernizr.js"/>'></script>

        <!--[if IE]>
            <link rel="stylesheet" href='<c:url value="/resources/css/ie/ie.css"/>'>
        <![endif]-->

        <!--[if lte IE 8]>
            <script src='<c:url value="/resources/js/responsive/html5shiv.js"/>'></script>
            <script src='<c:url value="/resources/js/responsive/respond.js"/>'></script>
        <![endif]-->

        <!-- Skins Changer-->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
         <!-- ======================= JQuery libs =========================== -->
        <!-- jQuery local--> 
        <script src='<c:url value="/resources/js/jquery.js"/>'></script>                
        <!--Nav-->
        <script type="text/javascript" src='<c:url value="/resources/js/nav/tinynav.js"/>'></script> 
        <script type="text/javascript" src='<c:url value="/resources/js/nav/hoverIntent.js"/>'></script>   
        <script type="text/javascript" src='<c:url value="/resources/js/nav/superfish.js"/>'></script> 
        <script src='<c:url value="/resources/js/nav/jquery.sticky.js"/>' type="text/javascript"></script>    
        <!--Totop-->
        <script type="text/javascript" src='<c:url value="/resources/js/totop/jquery.ui.totop.js"/>' ></script>  
         <!--Accorodion-->
        <script type="text/javascript" src='<c:url value="/resources/js/accordion/accordion.js"/>' ></script>  
        <!--Slide-->
        <script type="text/javascript" src='<c:url value="/resources/js/slide/camera.js"/>' ></script>      
        <script type='text/javascript' src='<c:url value="/resources/js/slide/jquery.easing.1.3.min.js"/>'></script>   
        <!-- Maps -->
        <script src='<c:url value="/resources/js/maps/gmap3.js"/>'></script>            
        <!--Ligbox--> 
        <script type="text/javascript" src='<c:url value="/resources/js/fancybox/jquery.fancybox.js"/>'></script> 
        <!-- carousel.js-->
        <script src='<c:url value="/resources/js/carousel/carousel.js"/>'></script>
        <!-- Filter -->
        <script src='<c:url value="/resources/js/filters/jquery.isotope.js"/>' type="text/javascript"></script>
        <!-- Counter -->
        <script src='<c:url value="/resources/js/counter/jquery.countdown.js"/>'></script>      
        <!--Theme Options-->
        <script type="text/javascript" src='<c:url value="/resources/js/theme-options/theme-options.js"/>'></script>
        <script type="text/javascript" src='<c:url value="/resources/js/theme-options/jquery.cookies.js"/>'></script> 
        <!-- Bootstrap.js-->
        <script type="text/javascript" src='<c:url value="/resources/js/bootstrap/bootstrap.js"/>'></script> 
        <!--MAIN FUNCTIONS-->
        <script type="text/javascript" src='<c:url value="/resources/js/main.js"/>'></script>
        <!-- ======================= End JQuery libs =========================== -->
	<script>
	$(document).ready(function() {
		 $('#slide').camera({        
			    height: 'auto'
			  });  
	});
	</script> 
    </head>

    <body>
        
        <!-- layout-->
        <div id="layout">
            <!-- Header-->
            <header>
                <!-- End headerbox-->
                <tiles:insertAttribute name="header" />
                <!-- End headerbox-->  

                <!-- mainmenu-->
                <tiles:insertAttribute name="menu" />
                <!-- End mainmenu-->
            </header>
            <!-- End Header-->
            
            <!-- Slide -->           
           <tiles:insertAttribute name="slidepartie" />
            
            <!-- End Slide --> 

            <!-- Section Area - Content Central -->
            <section class="content-info">
                <div class="semiboxshadow text-center">
                    <img src='<c:url value="/resources/img/img-theme/shp.png"/>' class="img-responsive" alt="">
                </div>
                
                <!-- Dark Home -->
                <div class="bg-dark dark-home">
                    <div class="row">
                        <!-- Left Content - Tabs and Carousel -->
                        <tiles:insertAttribute name="carousel" />
                        <!-- Left Content - Tabs and Carousel -->    

                        <!-- Right Content - Content Counter -->
                        <tiles:insertAttribute name="counter" />
                        <!-- End Right Content - Content Counter -->
                    </div>
                </div>   
                <!-- Dark Home -->

                <!-- Content Central -->
                <div class="container padding-top">
                    <div class="row">
                        <tiles:insertAttribute name="body" />
                        
                    </div>                     
                </div>  
                <!-- End Content Central -->

                <!-- Newsletter -->
                <tiles:insertAttribute name="sponsor" />
                <!-- End Newsletter -->  
            </section>
            <!-- End Section Area -  Content Central -->
      
            <!-- footer-->
		 <tiles:insertAttribute name="footer" />
            <!-- End footer-->
            <!-- footer Down-->
		<tiles:insertAttribute name="footerdown" />
            <!-- footer Down-->

        </div>
        <!-- End layout-->

   
    </body>
</html>